package com.example.demo.loyaltyCardsStrategy;

public class BasicCard extends LoyaltyCard {

	public BasicCard() {

		super();

		setCardName("Basic Loyalty Card");

		theDiscount = new DiscountFive();
	}

}
