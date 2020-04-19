package com.example.demo.userType;

import com.example.demo.user.Customer;

public interface UserFactory {

	public Customer createCustomer(Customer c);
}