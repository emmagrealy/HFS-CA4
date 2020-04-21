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

import com.example.demo.decorator.UserType;
import com.example.demo.order.ItemOrders;
import com.example.demo.reviews.Reviews;

@Entity
public class Customer implements UserType{
	
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
	private String loyaltyCard;
	
	@OneToMany(targetEntity=ItemOrders.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<ItemOrders> userOrders = new HashSet<ItemOrders>();
	
	@OneToMany(targetEntity=Reviews.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Reviews> reviews = new HashSet<Reviews>();
	
	public Customer() {
		
	}
	
	public Customer(int id, String firstName, String lastName) {
		this.userId = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Customer(String firstName, String lastName, String dob, String username, String password,
			String shippingAddress, String paymentMethod, String loyaltyCard) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.username = username;
		this.password = password;
		this.shippingAddress = shippingAddress;
		this.paymentMethod = paymentMethod;
		this.loyaltyCard = loyaltyCard;
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

	public String getLoyaltyCard() {
		return loyaltyCard;
	}

	public void setLoyaltyCard(String loyaltyCard) {
		this.loyaltyCard = loyaltyCard;
	}

	public Set<Reviews> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Reviews> reviews) {
		this.reviews = reviews;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", username=" + username + ", password=" + password + ", shippingAddress=" + shippingAddress
				+ ", paymentMethod=" + paymentMethod + ", loyaltyCard=" + loyaltyCard + "]";
	}

	@Override
	public String login() {
		
		return "successPage";
	}
	
	
	
}