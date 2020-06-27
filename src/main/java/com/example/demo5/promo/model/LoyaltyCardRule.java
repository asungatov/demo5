package com.example.demo5.promo.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Параметры скидки при предъявлении пенсионного удостоверения или социальной карты
 */
@ApiModel(
    description = "Параметры скидки при предъявлении пенсионного удостоверения или социальной карты")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-27T12:37:29.120+03:00")

public class LoyaltyCardRule {
  @JsonProperty("discount")
  private Double discount = null;

  @JsonProperty("shopId")
  private Integer shopId = null;

  public LoyaltyCardRule discount(Double discount) {
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

  public LoyaltyCardRule shopId(Integer shopId) {
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
    LoyaltyCardRule loyaltyCardRule = (LoyaltyCardRule) o;
    return Objects.equals(this.discount, loyaltyCardRule.discount) &&
        Objects.equals(this.shopId, loyaltyCardRule.shopId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(discount, shopId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoyaltyCardRule {\n");

    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
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

