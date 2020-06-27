package com.example.demo5.promo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Параметры скидки формата \&quot;N+k\&quot; (N+k единиц товара по цене N единиц)
 */
@ApiModel(description = "Параметры скидки формата \"N+k\" (N+k единиц товара по цене N единиц)")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-27T12:37:29.120+03:00")

public class ItemCountRule {
  @JsonProperty("bonusQuantity")
  private Integer bonusQuantity = null;

  @JsonProperty("itemId")
  private String itemId = null;

  @JsonProperty("shopId")
  private Integer shopId = null;

  @JsonProperty("triggerQuantity")
  private Integer triggerQuantity = null;

  public ItemCountRule bonusQuantity(Integer bonusQuantity) {
    this.bonusQuantity = bonusQuantity;
    return this;
  }

  /**
   * Количество единиц товара в подарок
   * 
   * @return bonusQuantity
   **/
  @ApiModelProperty(value = "Количество единиц товара в подарок")


  public Integer getBonusQuantity() {
    return bonusQuantity;
  }

  public void setBonusQuantity(Integer bonusQuantity) {
    this.bonusQuantity = bonusQuantity;
  }

  public ItemCountRule itemId(String itemId) {
    this.itemId = itemId;
    return this;
  }

  /**
   * ID товара
   * 
   * @return itemId
   **/
  @ApiModelProperty(value = "ID товара")


  public String getItemId() {
    return itemId;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
  }

  public ItemCountRule shopId(Integer shopId) {
    this.shopId = shopId;
    return this;
  }

  /**
   * Номер магазина, -1 для акции сети
   * 
   * @return shopId
   **/
  @ApiModelProperty(value = "Номер магазина, -1 для акции сети")


  public Integer getShopId() {
    return shopId;
  }

  public void setShopId(Integer shopId) {
    this.shopId = shopId;
  }

  public ItemCountRule triggerQuantity(Integer triggerQuantity) {
    this.triggerQuantity = triggerQuantity;
    return this;
  }

  /**
   * Количество единиц для применения скидки
   * 
   * @return triggerQuantity
   **/
  @ApiModelProperty(value = "Количество единиц для применения скидки")


  public Integer getTriggerQuantity() {
    return triggerQuantity;
  }

  public void setTriggerQuantity(Integer triggerQuantity) {
    this.triggerQuantity = triggerQuantity;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemCountRule itemCountRule = (ItemCountRule) o;
    return Objects.equals(this.bonusQuantity, itemCountRule.bonusQuantity) &&
        Objects.equals(this.itemId, itemCountRule.itemId) &&
        Objects.equals(this.shopId, itemCountRule.shopId) &&
        Objects.equals(this.triggerQuantity, itemCountRule.triggerQuantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bonusQuantity, itemId, shopId, triggerQuantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemCountRule {\n");

    sb.append("    bonusQuantity: ").append(toIndentedString(bonusQuantity)).append("\n");
    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    shopId: ").append(toIndentedString(shopId)).append("\n");
    sb.append("    triggerQuantity: ").append(toIndentedString(triggerQuantity)).append("\n");
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

