package com.example.demo.decorator;

public abstract class UserDecorator implements UserType {
	protected UserType decoratedUser;

	public UserDecorator(UserType decoratedUser) {
		this.decoratedUser = decoratedUser;
	}

	public String login() {
		return decoratedUser.login();
	}
}
