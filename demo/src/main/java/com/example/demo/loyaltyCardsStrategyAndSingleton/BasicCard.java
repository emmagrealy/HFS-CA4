package com.example.demo.loyaltyCardsStrategyAndSingleton;

public class BasicCard extends LoyaltyCard {

	private static BasicCard instance = new BasicCard();

    public static BasicCard getInstance(){
	      return instance;
	}
    
	private BasicCard() {

		super();

		setCardName("Basic Loyalty Card");

		theDiscount = new DiscountFive();
	}

}
