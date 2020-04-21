package com.example.demo.sortingStrategy;

import java.util.ArrayList;

import com.example.demo.item.StockItem;

public interface SortingStrategy {
	
	public ArrayList<StockItem> ascendingOrder(ArrayList<StockItem> products);
	public ArrayList<StockItem> descendingOrder(ArrayList<StockItem> products);
	

}
