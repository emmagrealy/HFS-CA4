package com.example.demo.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
		
	public List<Customer> getAllCustomers(){
		List<Customer> customers = new ArrayList<Customer>();
		for(Customer c: customerRepository.findAll()) {
			customers.add(c);
		}
		return customers;
	}
	
	public Customer getCustomerById(int id) {
		return customerRepository.findOne(id);
	}
	
	public Customer getUserByUsernameAndPassword(String username, String password) {
		Customer c = customerRepository.findByUsernameAndPassword(username, password);
		return c;
	}
	
	public void addCustomer(Customer c) {
		customerRepository.save(c);
	}
	
	public void updateCustomer(int id, Customer c) {
		customerRepository.save(c);
	}
	
	public void deleteCustomer(int id) {
		customerRepository.delete(id);
	}

}