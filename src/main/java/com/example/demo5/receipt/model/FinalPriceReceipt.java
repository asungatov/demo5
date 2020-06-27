package com.example.demo5.receipt.model;

import java.util.Objects;

import com.example.demo5.receipt.PaddedSerializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.NumberFormat;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * Результат расчета корзины
 */
@ApiModel(description = "Результат расчета корзины")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen",
    date = "2020-06-27T12:37:29.120+03:00")

public class FinalPriceReceipt {
  @JsonProperty("discount")
  @JsonSerialize(using = PaddedSerializer.class)
  private BigDecimal discount = BigDecimal.ZERO;

  @JsonProperty("positions")
  @Valid
  private List<FinalPricePosition> positions = null;

  @JsonProperty("total")
  @JsonSerialize(using = PaddedSerializer.class)
  private BigDecimal total = BigDecimal.ZERO;

  public FinalPriceReceipt discount(BigDecimal discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Полная сумма скидки
   * 
   * @return discount
   **/
  @ApiModelProperty(value = "Полная сумма скидки")

  @Valid

  public BigDecimal getDiscount() {
    return discount;
  }

  public void setDiscount(BigDecimal discount) {
    this.discount = discount;
  }

  public FinalPriceReceipt positions(List<FinalPricePosition> positions) {
    this.positions = positions;
    return this;
  }

  public FinalPriceReceipt addPositionsItem(FinalPricePosition positionsItem) {
    if (this.positions == null) {
      this.positions = new ArrayList<>();
    }
    this.positions.add(positionsItem);
    return this;
  }

  /**
   * Результат расчета цен по позициям
   * 
   * @return positions
   **/
  @ApiModelProperty(value = "Результат расчета цен по позициям")

  @Valid

  public List<FinalPricePosition> getPositions() {
    return positions;
  }

  public void setPositions(List<FinalPricePosition> positions) {
    this.positions = positions;
  }

  public FinalPriceReceipt total(BigDecimal total) {
    this.total = total;
    return this;
  }

  /**
   * Полная сумма чека с применением скидок
   * 
   * @return total
   **/
  @ApiModelProperty(value = "Полная сумма чека с применением скидок")

  @Valid

  public BigDecimal getTotal() {
    return total;
  }

  public void setTotal(BigDecimal total) {
    this.total = total;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FinalPriceReceipt finalPriceReceipt = (FinalPriceReceipt) o;
    return Objects.equals(this.discount, finalPriceReceipt.discount) &&
        Objects.equals(this.positions, finalPriceReceipt.positions) &&
        Objects.equals(this.total, finalPriceReceipt.total);
  }

  @Override
  public int hashCode() {
    return Objects.hash(discount, positions, total);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinalPriceReceipt {\n");

    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
    sb.append("    positions: ").append(toIndentedString(positions)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

