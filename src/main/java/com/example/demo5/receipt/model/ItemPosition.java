package com.example.demo5.receipt.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

/**
 * Позиция товара в корзине
 */
@ApiModel(description = "Позиция товара в корзине")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-27T12:37:29.120+03:00")

public class ItemPosition {
  @JsonProperty("itemId")
  private String itemId = null;

  @JsonProperty("quantity")
  private Integer quantity = null;

  public ItemPosition itemId(String itemId) {
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

  public ItemPosition quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Количество товара в позиции
   * 
   * @return quantity
   **/
  @ApiModelProperty(value = "Количество товара в позиции")


  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ItemPosition itemPosition = (ItemPosition) o;
    return Objects.equals(this.itemId, itemPosition.itemId) &&
        Objects.equals(this.quantity, itemPosition.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(itemId, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ItemPosition {\n");

    sb.append("    itemId: ").append(toIndentedString(itemId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
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

