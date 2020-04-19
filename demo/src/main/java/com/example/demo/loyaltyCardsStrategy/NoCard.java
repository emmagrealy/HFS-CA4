package com.example.demo.loyaltyCardsStrategy;

public class NoCard extends LoyaltyCard {

	public NoCard() {

		super();

		setCardName("No Loyalty Card Chosen");

		theDiscount = new NoDiscount();
	}

}