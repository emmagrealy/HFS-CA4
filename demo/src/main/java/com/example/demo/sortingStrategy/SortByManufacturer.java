package com.example.demo.sortingStrategy;

import java.util.ArrayList;
import java.util.Collections;

import com.example.demo.item.StockItem;

public class SortByManufacturer implements SortingStrategy {

	@Override
	public ArrayList<StockItem> ascendingOrder(ArrayList<StockItem> products) {
		Collections.sort(products, (o1, o2) -> o1.getManufacturer().compareTo(o2.getManufacturer()));

		return products;
	}

	@Override
	public ArrayList<StockItem> descendingOrder(ArrayList<StockItem> products) {
		Collections.sort(products, (o1, o2) -> o1.getManufacturer().compareTo(o2.getManufacturer()));
		Collections.reverse(products);
		
		return products;
	}

}
