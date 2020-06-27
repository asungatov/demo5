package com.example.demo5.promo.model;

public class ShopItemKey {
  private Integer shopId;
  private String itemId;

  public ShopItemKey(final Integer shopId, final String itemId) {
    this.shopId = shopId;
    this.itemId = itemId;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    final ShopItemKey that = (ShopItemKey) o;

    if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;
    return itemId != null ? itemId.equals(that.itemId) : that.itemId == null;
  }

  @Override
  public int hashCode() {
    int result = shopId != null ? shopId.hashCode() : 0;
    result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ShopItemKey{" +
        "shopId=" + shopId +
        ", itemId='" + itemId + '\'' +
        '}';
  }
}
