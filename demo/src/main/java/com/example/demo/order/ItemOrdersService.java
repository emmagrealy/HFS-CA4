package com.example.demo.order;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemOrdersService {
	
	@Autowired
	private ItemOrdersRepository orderRepo;
	
	public List<ItemOrders> getAllOrders(){
		List<ItemOrders> allOrders = new ArrayList<ItemOrders>();
		for(ItemOrders orderHistory: orderRepo.findAll()) {
			allOrders.add(orderHistory);
		}
		return allOrders;
	}
	
	public ItemOrders getOrderById(int id) {
		return orderRepo.findOne(id);
	}
	
	public void addOrder(ItemOrders item) {
		orderRepo.save(item);
	}
	
	public void updateOrder(int id, ItemOrders item) {
		orderRepo.save(item);
	}
	
	public void deleteOrder(int id) {
		orderRepo.delete(id);
	}
}