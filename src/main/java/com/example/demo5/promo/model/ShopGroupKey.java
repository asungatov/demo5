package com.example.demo5.promo.model;

public class ShopGroupKey {
  private Integer shopId;
  private String groupId;

  public ShopGroupKey(final Integer shopId, final String groupId) {
    this.shopId = shopId;
    this.groupId = groupId;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    final ShopGroupKey that = (ShopGroupKey) o;

    if (shopId != null ? !shopId.equals(that.shopId) : that.shopId != null) return false;
    return groupId != null ? groupId.equals(that.groupId) : that.groupId == null;
  }

  @Override
  public int hashCode() {
    int result = shopId != null ? shopId.hashCode() : 0;
    result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ShopItemKey{" +
        "shopId=" + shopId +
        ", itemId='" + groupId + '\'' +
        '}';
  }
}
