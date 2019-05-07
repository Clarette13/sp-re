package service;

import java.util.List;

import pojo.Item;

public interface ItemService {
	List<Item> getItems(Integer orderId);
	void decreaseNumbers(List<Item> list);
}
