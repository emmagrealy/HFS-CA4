package com.example.demo.item;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.reviews.Reviews;

@Entity
public class StockItem {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int itemId;
	private String title;
	private String manufacturer;
	private double price;
	private String category;
	private String image;
	private int quantity;
	private boolean state;
	
	@OneToMany(targetEntity=Reviews.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Reviews> reviews = new HashSet<Reviews>();
	
	public StockItem() {
		
	}

	public StockItem(String title, String manufacturer, double price, String category, String image,
			int quantity, boolean state) {
		this.title = title;
		this.manufacturer = manufacturer;
		this.price = price;
		this.category = category;
		this.image = image;
		this.quantity = quantity;
		this.state = state;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
	public Set<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Reviews> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "StockItem [itemId=" + itemId + ", title=" + title + ", manufacturer=" + manufacturer + ", price="
				+ price + ", category=" + category + ", image=" + image + ", quantity=" + quantity + "]";
	}
		
	
}
