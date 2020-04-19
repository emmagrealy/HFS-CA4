package com.example.demo.loyaltyCardsStrategy;

public class PremiumCard extends LoyaltyCard {
	
	public PremiumCard() {

		super();

		setCardName("Premium Loyalty Card");

		theDiscount = new DiscountTen();
	}

}