package com.example.demo.user;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer>{

	public Customer findByUsernameAndPassword(String username, String password);
}