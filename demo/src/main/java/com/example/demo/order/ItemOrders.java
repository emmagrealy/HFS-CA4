package com.example.demo.order;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.example.demo.item.StockItem;

@Entity
public class ItemOrders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	private double totalPrice;
	
	@ManyToMany(targetEntity=StockItem.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<StockItem> products = new HashSet<StockItem>();
	
	public ItemOrders() {
		
	}
	
	public ItemOrders(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Set<StockItem> getProducts() {
		return products;
	}

	public void setProducts(Set<StockItem> products) {
		this.products = products;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	
	
	
}