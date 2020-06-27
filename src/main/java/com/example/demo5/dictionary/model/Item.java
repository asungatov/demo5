package com.example.demo5.dictionary.model;

import java.math.BigDecimal;

public class Item {
  private String id;
  private String name;
  private String groupId;
  private BigDecimal price;

  public Item() {
  }

  public Item(final String id, final String name, final String groupId, final BigDecimal price) {
    this.id = id;
    this.name = name;
    this.groupId = groupId;
    this.price = price;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getGroupId() {
    return groupId;
  }

  public BigDecimal getPrice() {
    return price;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    final Item item = (Item) o;

    if (id != null ? !id.equals(item.id) : item.id != null) return false;
    if (name != null ? !name.equals(item.name) : item.name != null) return false;
    if (groupId != null ? !groupId.equals(item.groupId) : item.groupId != null) return false;
    return price != null ? price.equals(item.price) : item.price == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    result = 31 * result + (groupId != null ? groupId.hashCode() : 0);
    result = 31 * result + (price != null ? price.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", groupId='" + groupId + '\'' +
        ", price=" + price +
        '}';
  }
}
