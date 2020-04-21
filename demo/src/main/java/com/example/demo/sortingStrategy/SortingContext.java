package com.example.demo.sortingStrategy;

import java.util.ArrayList;

import com.example.demo.item.StockItem;

public class SortingContext {
	
		private SortingStrategy strategy;
		
		public void setSortingMethod(SortingStrategy strategy) {
			this.strategy = strategy;
		}
		
		public SortingStrategy getStrategy() {
			return strategy;
		}
		
		public ArrayList<StockItem> sortAscending(ArrayList<StockItem> p){
			return strategy.ascendingOrder(p);	
		}
	
		public ArrayList<StockItem> sortDescending(ArrayList<StockItem> p){
			return strategy.descendingOrder(p);	
		}
}
