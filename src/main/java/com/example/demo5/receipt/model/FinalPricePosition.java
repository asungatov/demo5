package com.example.demo5.receipt.model;

import java.util.Objects;

import com.example.demo5.receipt.PaddedSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Результат расчета цены для одной позиции
 */
@ApiModel(description = "Результат расчета цены для одной позиции")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-27T12:37:29.120+03:00")

public class FinalPricePosition {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("price")
  @JsonSerialize(using = PaddedSerializer.class)
  private BigDecimal price = null;

  @JsonProperty("regularPrice")
  @JsonSerialize(using = PaddedSerializer.class)
  private BigDecimal regularPrice = null;

  public FinalPricePosition id(String id) {
    this.id = id;
    return this;
  }

  /**
   * ID товара
   * 
   * @return id
   **/
  @ApiModelProperty(value = "ID товара")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FinalPricePosition name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Наименование товара
   * 
   * @return name
   **/
  @ApiModelProperty(value = "Наименование товара")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FinalPricePosition price(BigDecimal price) {
    this.price = price;
    return this;
  }

  /**
   * Цена после применения скидки
   * 
   * @return price
   **/
  @ApiModelProperty(value = "Цена после применения скидки")

  @Valid

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  public FinalPricePosition regularPrice(BigDecimal regularPrice) {
    this.regularPrice = regularPrice;
    return this;
  }

  /**
   * Цена до применения скидки
   * 
   * @return regularPrice
   **/
  @ApiModelProperty(value = "Цена до применения скидки")

  @Valid

  public BigDecimal getRegularPrice() {
    return regularPrice;
  }

  public void setRegularPrice(BigDecimal regularPrice) {
    this.regularPrice = regularPrice;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FinalPricePosition finalPricePosition = (FinalPricePosition) o;
    return Objects.equals(this.id, finalPricePosition.id) &&
        Objects.equals(this.name, finalPricePosition.name) &&
        Objects.equals(this.price, finalPricePosition.price) &&
        Objects.equals(this.regularPrice, finalPricePosition.regularPrice);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price, regularPrice);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinalPricePosition {\n");

    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    regularPrice: ").append(toIndentedString(regularPrice)).append("\n");
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

