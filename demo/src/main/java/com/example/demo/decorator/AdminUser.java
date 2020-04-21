package com.example.demo.decorator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AdminUser implements UserType{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int adminId;
	private String username;
	private String password;
		
	public AdminUser() {
	}	
	
	public AdminUser(String username, String password) {
		this.username = username;
		this.password = password;
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

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Override
	public String login() {
		return "adminSuccess";
	}
	
	
}
