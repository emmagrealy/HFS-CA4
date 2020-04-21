package com.example.demo.decorator;

public class AdminUser implements UserType{

	String username;
	String password;
		
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

	@Override
	public String login() {
		return "adminSuccess";
	}
	
	
}
