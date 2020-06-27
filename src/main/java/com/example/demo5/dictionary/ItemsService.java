package com.example.demo5.dictionary;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.example.demo5.dictionary.model.Group;
import com.example.demo5.dictionary.model.Item;

// who loads data from csv in 2020?! =)
@Service
public class ItemsService {
  private Map<String, Item> itemMap;
  private Map<String, Group> groupMap;

  @PostConstruct
  public void loadData() {
    final List<Group> groups = new CsvLoader().loadObjectList(Group.class, "groups.csv");
    final List<Item> items = new CsvLoader().loadObjectList(Item.class, "items.csv");
    itemMap = items.stream().collect(Collectors.toMap(Item::getId, Function.identity()));
    groupMap = groups.stream().collect(Collectors.toMap(Group::getId, Function.identity()));
  }

  public Map<String, Group> getGroups() {
    return groupMap;
  }

  public Map<String, Item> getItems() {
    return itemMap;
  }
  public Item getItem(String itemId) {
    return itemMap.get(itemId);
  }
}
