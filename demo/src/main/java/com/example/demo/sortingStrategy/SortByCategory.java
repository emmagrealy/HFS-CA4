package com.example.demo.sortingStrategy;

import java.util.ArrayList;
import java.util.Collections;

import com.example.demo.item.StockItem;

public class SortByCategory implements SortingStrategy {

	@Override
	public ArrayList<StockItem> ascendingOrder(ArrayList<StockItem> products) {
		Collections.sort(products, (o1, o2) -> o1.getCategory().compareTo(o2.getCategory()));

		return products;
	}

	@Override
	public ArrayList<StockItem> descendingOrder(ArrayList<StockItem> products) {
		Collections.sort(products, (o1, o2) -> o1.getCategory().compareTo(o2.getCategory()));
		Collections.reverse(products);
	
		return products;
	}

}
