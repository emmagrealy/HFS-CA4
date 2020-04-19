package com.example.demo.user;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.example.demo.order.ItemOrders;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	private String firstName;
	private String lastName;
	private String dob;
	private String username;
	private String password;
	private String shippingAddress;
	private String paymentMethod;
	
	@OneToMany(targetEntity=ItemOrders.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<ItemOrders> userOrders = new HashSet<ItemOrders>();
	
	public Customer() {
		
	}

	public Customer(String firstName, String lastName, String dob, String username, String password,
			String shippingAddress, String paymentMethod) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.username = username;
		this.password = password;
		this.shippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Set<ItemOrders> getUserOrders() {
		return userOrders;
	}

	public void setUserOrders(Set<ItemOrders> userOrders) {
		this.userOrders = userOrders;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
			
	
}