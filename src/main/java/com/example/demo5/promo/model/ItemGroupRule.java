package com.example.demo5.promo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Параметры скидки при покупке связанных товаров
 */
@ApiModel(description = "Параметры скидки при покупке связанных товаров")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-27T12:37:29.120+03:00")

public class ItemGroupRule {
  @JsonProperty("discount")
  private Double discount = null;

  @JsonProperty("groupId")
  private String groupId = null;

  @JsonProperty("shopId")
  private Integer shopId = null;

  public ItemGroupRule discount(Double discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Коэффициент скидки (сидка = цена * discount)
   * 
   * @return discount
   **/
  @ApiModelProperty(value = "Коэффициент скидки (сидка = цена * discount)")


  public Double getDiscount() {
    return discount;
  }

  public void setDiscount(Double discount) {
    this.discount = discount;
  }

  public ItemGroupRule groupId(String groupId) {
    this.groupId = groupId;
    return this;
  }

  /**
   * ID группы связанных товаров
   * 
   * @return groupId
   **/
  @ApiModelProperty(value = "ID группы связанных товаров")


  public String getGroupId() {
    return groupId;
  }

  public void setGroupId(String groupId) {
    this.groupId = groupId;
  }

  public ItemGroupRule shopId(Integer shopId) {
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


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemGroupRule itemGroupRule = (ItemGroupRule) o;
    return Objects.equals(this.discount, itemGroupRule.discount) &&
        Objects.equals(this.groupId, itemGroupRule.groupId) &&
        Objects.equals(this.shopId, itemGroupRule.shopId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(discount, groupId, shopId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemGroupRule {\n");

    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
    sb.append("    groupId: ").append(toIndentedString(groupId)).append("\n");
    sb.append("    shopId: ").append(toIndentedString(shopId)).append("\n");
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

