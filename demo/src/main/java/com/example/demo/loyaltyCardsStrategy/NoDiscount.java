package com.example.demo.loyaltyCardsStrategy;

public class NoDiscount implements ApplyDiscount{

	public double productDiscount() {
		
		return 0;
	}
}