package com.example.demo5.dictionary.model;

public class Group {
  private String id;
  private String name;

  public Group() {
  }

  public Group(final String id, final String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    final Group group = (Group) o;

    if (id != null ? !id.equals(group.id) : group.id != null) return false;
    return name != null ? name.equals(group.name) : group.name == null;
  }

  @Override
  public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (name != null ? name.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Group{" +
        "id='" + id + '\'' +
        ", name='" + name + '\'' +
        '}';
  }
}
