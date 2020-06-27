package com.example.demo5.promo;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo5.promo.model.ItemCountRule;
import com.example.demo5.promo.model.ItemGroupRule;
import com.example.demo5.promo.model.LoyaltyCardRule;
import com.example.demo5.promo.model.PromoMatrix;
import com.example.demo5.promo.model.ShopGroupKey;
import com.example.demo5.promo.model.ShopItemKey;

@Service
public class PromoMatrixService {
  private PromoMatrix promoMatrix;

  private final Integer globalChainKey = -1;

  private final double defaultLoyaltyDiscountValue = 0.0;
  private final double defaultGroupDiscountValue = 0.0;
  private final ItemCountRule defaultItemCountRule =
      new ItemCountRule().shopId(null).itemId("").triggerQuantity(1).bonusQuantity(0);
  private Map<Integer, Double> loyaltyDiscountMap = Collections.emptyMap();
  private Map<ShopItemKey, ItemCountRule> itemCountRuleMap = Collections.emptyMap();
  private Map<ShopGroupKey, Double> groupRuleMap = Collections.emptyMap();

  public void store(final PromoMatrix promoMatrix) {
    this.promoMatrix = promoMatrix;
    initializeMaps();
    if (promoMatrix.getLoyaltyCardRules() != null) {
      loyaltyDiscountMap = promoMatrix.getLoyaltyCardRules().stream()
          .collect(Collectors.toMap(LoyaltyCardRule::getShopId, LoyaltyCardRule::getDiscount));
    } 

    if (promoMatrix.getItemCountRules() != null) {
      itemCountRuleMap = promoMatrix.getItemCountRules().stream()
          .collect(Collectors.toMap(
              itemCountRule -> new ShopItemKey(itemCountRule.getShopId(),
                  itemCountRule.getItemId()),
              Function.identity()));
    }
    
    if (promoMatrix.getItemGroupRules() != null) {
      groupRuleMap = promoMatrix.getItemGroupRules().stream().collect(Collectors.toMap(
          itemGroupRule -> new ShopGroupKey(itemGroupRule.getShopId(),
              itemGroupRule.getGroupId()),
          ItemGroupRule::getDiscount));
    } 
  }

  public PromoMatrix getPromoMatrix() {
    return promoMatrix;
  }

  public Double getLoyaltyByShop(final Integer shopId) {
    return loyaltyDiscountMap.get(shopId);
  }
  public Double getLoyaltyGlobal() {
    return loyaltyDiscountMap.get(globalChainKey);
  }
  public Double getLoyaltyDefault() {
    return defaultLoyaltyDiscountValue;
  }

  public ItemCountRule getItemCountRuleByShop(final Integer shopId, final String itemId) {
   return itemCountRuleMap.get(new ShopItemKey(shopId, itemId));
  }

  public ItemCountRule getItemCountRuleGlobal(final String itemId) {
    return itemCountRuleMap.get(new ShopItemKey(globalChainKey, itemId));
  }

  public ItemCountRule getItemCountRuleDefault() {
    return defaultItemCountRule;
  }

  public Double getGroupByShop(final Integer shopId, final String groupId) {
    return groupRuleMap.get(new ShopItemKey(shopId, groupId));
  }


  public Double getGroupGlobal(final String groupId) {
    return groupRuleMap.get(new ShopItemKey(globalChainKey, groupId));
  }


  public Double getGroupDefault() {
    return defaultGroupDiscountValue;
  }

  private void initializeMaps() {
    loyaltyDiscountMap = Collections.emptyMap();
    itemCountRuleMap = Collections.emptyMap();
    groupRuleMap = Collections.emptyMap();
  }
}
