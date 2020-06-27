package com.example.demo5.receipt.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Данные о магазине и товарах в корзине
 */
@ApiModel(description = "Данные о магазине и товарах в корзине")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-27T12:37:29.120+03:00")

public class ShoppingCart {
  @JsonProperty("loyaltyCard")
  private Boolean loyaltyCard = null;

  @JsonProperty("positions")
  @Valid
  private List<ItemPosition> positions = null;

  @JsonProperty("shopId")
  private Integer shopId = null;

  public ShoppingCart loyaltyCard(Boolean loyaltyCard) {
    this.loyaltyCard = loyaltyCard;
    return this;
  }

  /**
   * Признак предоставленния карты лояльности
   * 
   * @return loyaltyCard
   **/
  @ApiModelProperty(value = "Признак предоставленния карты лояльности")


  public Boolean isLoyaltyCard() {
    return loyaltyCard;
  }

  public void setLoyaltyCard(Boolean loyaltyCard) {
    this.loyaltyCard = loyaltyCard;
  }

  public ShoppingCart positions(List<ItemPosition> positions) {
    this.positions = positions;
    return this;
  }

  public ShoppingCart addPositionsItem(ItemPosition positionsItem) {
    if (this.positions == null) {
      this.positions = new ArrayList<>();
    }
    this.positions.add(positionsItem);
    return this;
  }

  /**
   * Позиции с товарами в корзине
   * 
   * @return positions
   **/
  @ApiModelProperty(value = "Позиции с товарами в корзине")

  @Valid

  public List<ItemPosition> getPositions() {
    return positions;
  }

  public void setPositions(List<ItemPosition> positions) {
    this.positions = positions;
  }

  public ShoppingCart shopId(Integer shopId) {
    this.shopId = shopId;
    return this;
  }

  /**
   * Номер магазина
   * 
   * @return shopId
   **/
  @ApiModelProperty(value = "Номер магазина")


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
    ShoppingCart shoppingCart = (ShoppingCart) o;
    return Objects.equals(this.loyaltyCard, shoppingCart.loyaltyCard) &&
        Objects.equals(this.positions, shoppingCart.positions) &&
        Objects.equals(this.shopId, shoppingCart.shopId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(loyaltyCard, positions, shopId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ShoppingCart {\n");

    sb.append("    loyaltyCard: ").append(toIndentedString(loyaltyCard)).append("\n");
    sb.append("    positions: ").append(toIndentedString(positions)).append("\n");
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

