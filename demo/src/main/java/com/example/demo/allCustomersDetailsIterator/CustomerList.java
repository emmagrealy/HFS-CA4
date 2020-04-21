package com.example.demo.allCustomersDetailsIterator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.Customer;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.user.Customer;



public class CustomerList implements Container {
	
	public ArrayList<Customer> customers;
	
	 public CustomerList(ArrayList<Customer> customersList) {
		  customers = customersList;
	 }
	 
	 
	public Iterator getIterator() {
		return new CustomerIterator();
	}
	

	private class CustomerIterator implements Iterator {
		int index;

		public boolean hasNext() {
			if (index < customers.size()) {
				return true;
			}
			return false;
		}

		public Object next() {
			if (this.hasNext()) {
				return customers.get(index++);
			}
			return null;
		}
	}

}