package com.example.demo.loyaltyCardsStrategyAndSingleton;

public class NoCard extends LoyaltyCard {
	
	private static NoCard instance = new NoCard();

    public static NoCard getInstance(){
	      return instance;
	}

	private NoCard() {

		super();

		setCardName("No Loyalty Card Chosen");

		theDiscount = new NoDiscount();
	}

}
