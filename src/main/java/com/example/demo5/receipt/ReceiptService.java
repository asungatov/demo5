package com.example.demo5.receipt;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo5.dictionary.ItemsService;
import com.example.demo5.dictionary.model.Item;
import com.example.demo5.promo.PromoMatrixService;
import com.example.demo5.promo.model.ItemCountRule;
import com.example.demo5.receipt.model.FinalPricePosition;
import com.example.demo5.receipt.model.FinalPriceReceipt;
import com.example.demo5.receipt.model.ItemPosition;
import com.example.demo5.receipt.model.ShoppingCart;

@Service
public class ReceiptService {
  private PromoMatrixService promoService;
  private ItemsService itemsService;
  private MathContext mathContext = new MathContext(2, RoundingMode.HALF_EVEN);

  @Autowired
  public ReceiptService(final PromoMatrixService promoService, ItemsService itemsService) {
    this.promoService = promoService;
    this.itemsService = itemsService;
  }

  public FinalPriceReceipt applyDiscount(ShoppingCart shoppingCart) {
    final FinalPriceReceipt result = new FinalPriceReceipt();


    final Integer shopId = shoppingCart.getShopId();
    BigDecimal total = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
    BigDecimal totalDiscount = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
    shoppingCart.getPositions();
    for (ItemPosition itemPosition : shoppingCart.getPositions()) {
      final String itemId = itemPosition.getItemId();
      Item item = itemsService.getItem(itemId);
      final BigDecimal itemPrice = item.getPrice();
      final Integer quantity = itemPosition.getQuantity();
      BigDecimal itemTotal =
          itemPrice.multiply(new BigDecimal(quantity)).setScale(2, RoundingMode.HALF_EVEN);
      total = total.add(itemTotal);

      BigDecimal discount;

      discount = getByShopDiscount(shopId, itemId, item, itemPrice, quantity, itemTotal);
      if (discount.compareTo(BigDecimal.ZERO) == 0) {
        discount = getByGlobalDiscount(itemId, item, itemPrice, quantity, itemTotal);
      }

      totalDiscount = totalDiscount.add(discount);

      final FinalPricePosition finalPricePosition = new FinalPricePosition().id(itemId)
          .name(item.getName())
          .regularPrice(itemTotal)
          .price(itemTotal.subtract(discount));
      result.addPositionsItem(finalPricePosition);

    }

    result.discount(totalDiscount).total(total);

    return result;
  }

  private BigDecimal getByShopDiscount(final Integer shopId, final String itemId, final Item item,
      final BigDecimal itemPrice, final Integer quantity, final BigDecimal itemTotal) {
    final BigDecimal result;
    final Double loyaltyByShop = promoService.getLoyaltyByShop(shopId);
    final ItemCountRule itemCountRuleByShop = promoService.getItemCountRuleByShop(shopId, itemId);
    final Double groupByShop = promoService.getGroupByShop(shopId, item.getGroupId());

    return computeDiscount(itemPrice, quantity, itemTotal, loyaltyByShop, itemCountRuleByShop,
        groupByShop);
  }

  private BigDecimal getByGlobalDiscount(final String itemId, final Item item,
      final BigDecimal itemPrice, final Integer quantity, final BigDecimal itemTotal) {
    final BigDecimal result;
    final Double loyalty = promoService.getLoyaltyGlobal();
    final ItemCountRule itemCountRule = promoService.getItemCountRuleGlobal(itemId);
    final Double group = promoService.getGroupGlobal(item.getGroupId());

    return computeDiscount(itemPrice, quantity, itemTotal, loyalty, itemCountRule, group);
  }

  private BigDecimal computeDiscount(final BigDecimal itemPrice, final Integer quantity,
      final BigDecimal itemTotal, final Double loyalty,
      final ItemCountRule itemCountRule, final Double group) {
    final BigDecimal result;

    final BigDecimal loyaltyDiscountByShop =
        loyalty != null ? itemTotal.multiply(new BigDecimal(loyalty)).setScale(2,
            RoundingMode.HALF_EVEN) : BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
    final BigDecimal groupDiscountByShop = group != null
        ? itemTotal.multiply(new BigDecimal(group)).setScale(2, RoundingMode.HALF_EVEN)
        : BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
    final BigDecimal itemRuleDiscount;
    if(itemCountRule!=null) {
      final BigDecimal itemRulePrice = getItemRulePrice(itemPrice, quantity, itemCountRule);
      itemRuleDiscount = itemTotal.subtract(itemRulePrice);
    } else {
      itemRuleDiscount = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_EVEN);
    }

    result = loyaltyDiscountByShop.max(groupDiscountByShop).max(itemRuleDiscount);
    return result;
  }



  private BigDecimal getItemRulePrice(final BigDecimal itemPrice, final Integer quantity,
      final ItemCountRule itemCountRuleByShop) {
    final int trigger = itemCountRuleByShop.getTriggerQuantity();
    final int bonus = itemCountRuleByShop.getBonusQuantity();
    final int remainder = quantity % (trigger + bonus);

    final BigDecimal remainderPrice;
    if (remainder > trigger) {
      remainderPrice = itemPrice.multiply(new BigDecimal(trigger));
    } else {
      remainderPrice = itemPrice.multiply(new BigDecimal(remainder));
    }
    return itemPrice.multiply(new BigDecimal(quantity / (trigger + bonus) * trigger))
        .add(remainderPrice).setScale(2, RoundingMode.HALF_EVEN);
  }

}
