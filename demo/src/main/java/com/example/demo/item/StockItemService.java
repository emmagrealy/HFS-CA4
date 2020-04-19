package com.example.demo.item;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockItemService {

	@Autowired
	private StockItemRepository stockItemRepository;
		
	public List<StockItem> getAllItems(){
		List<StockItem> items = new ArrayList<StockItem>();
		for(StockItem stock: stockItemRepository.findAll()) {
			items.add(stock);
		}
		return items;
	}
	
	public StockItem getItemById(int id) {
		return stockItemRepository.findOne(id);
	}
	
	
	public void addItem(StockItem item) {
		stockItemRepository.save(item);
	}
	
	public void updateItem(int id, StockItem item) {
		stockItemRepository.save(item);
	}
	
	public void deleteItem(int id) {
		stockItemRepository.delete(id);
	}

}