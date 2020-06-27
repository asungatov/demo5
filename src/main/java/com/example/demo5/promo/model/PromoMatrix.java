package com.example.demo5.promo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Матрица промо-механик
 */
@ApiModel(description = "Матрица промо-механик")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-27T12:37:29.120+03:00")

public class PromoMatrix {
  @JsonProperty("itemCountRules")
  @Valid
  private List<ItemCountRule> itemCountRules = null;

  @JsonProperty("itemGroupRules")
  @Valid
  private List<ItemGroupRule> itemGroupRules = null;

  @JsonProperty("loyaltyCardRules")
  @Valid
  private List<LoyaltyCardRule> loyaltyCardRules = null;

  public PromoMatrix itemCountRules(List<ItemCountRule> itemCountRules) {
    this.itemCountRules = itemCountRules;
    return this;
  }

  public PromoMatrix addItemCountRulesItem(ItemCountRule itemCountRulesItem) {
    if (this.itemCountRules == null) {
      this.itemCountRules = new ArrayList<>();
    }
    this.itemCountRules.add(itemCountRulesItem);
    return this;
  }

  /**
   * Список правил при покупке определенного количества единиц конкретного товара
   * 
   * @return itemCountRules
   **/
  @ApiModelProperty(
      value = "Список правил при покупке определенного количества единиц конкретного товара")

  @Valid

  public List<ItemCountRule> getItemCountRules() {
    return itemCountRules;
  }

  public void setItemCountRules(List<ItemCountRule> itemCountRules) {
    this.itemCountRules = itemCountRules;
  }

  public PromoMatrix itemGroupRules(List<ItemGroupRule> itemGroupRules) {
    this.itemGroupRules = itemGroupRules;
    return this;
  }

  public PromoMatrix addItemGroupRulesItem(ItemGroupRule itemGroupRulesItem) {
    if (this.itemGroupRules == null) {
      this.itemGroupRules = new ArrayList<>();
    }
    this.itemGroupRules.add(itemGroupRulesItem);
    return this;
  }

  /**
   * Список правил при покупке связанных товаров
   * 
   * @return itemGroupRules
   **/
  @ApiModelProperty(value = "Список правил при покупке связанных товаров")

  @Valid

  public List<ItemGroupRule> getItemGroupRules() {
    return itemGroupRules;
  }

  public void setItemGroupRules(List<ItemGroupRule> itemGroupRules) {
    this.itemGroupRules = itemGroupRules;
  }

  public PromoMatrix loyaltyCardRules(List<LoyaltyCardRule> loyaltyCardRules) {
    this.loyaltyCardRules = loyaltyCardRules;
    return this;
  }

  public PromoMatrix addLoyaltyCardRulesItem(LoyaltyCardRule loyaltyCardRulesItem) {
    if (this.loyaltyCardRules == null) {
      this.loyaltyCardRules = new ArrayList<>();
    }
    this.loyaltyCardRules.add(loyaltyCardRulesItem);
    return this;
  }

  /**
   * Список правил скидки при предъявлении пенсионного удостоверения или социальной карты
   * 
   * @return loyaltyCardRules
   **/
  @ApiModelProperty(
      value = "Список правил скидки при предъявлении пенсионного удостоверения или социальной карты")

  @Valid

  public List<LoyaltyCardRule> getLoyaltyCardRules() {
    return loyaltyCardRules;
  }

  public void setLoyaltyCardRules(List<LoyaltyCardRule> loyaltyCardRules) {
    this.loyaltyCardRules = loyaltyCardRules;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PromoMatrix promoMatrix = (PromoMatrix) o;
    return Objects.equals(this.itemCountRules, promoMatrix.itemCountRules) &&
        Objects.equals(this.itemGroupRules, promoMatrix.itemGroupRules) &&
        Objects.equals(this.loyaltyCardRules, promoMatrix.loyaltyCardRules);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemCountRules, itemGroupRules, loyaltyCardRules);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PromoMatrix {\n");

    sb.append("    itemCountRules: ").append(toIndentedString(itemCountRules)).append("\n");
    sb.append("    itemGroupRules: ").append(toIndentedString(itemGroupRules)).append("\n");
    sb.append("    loyaltyCardRules: ").append(toIndentedString(loyaltyCardRules)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

