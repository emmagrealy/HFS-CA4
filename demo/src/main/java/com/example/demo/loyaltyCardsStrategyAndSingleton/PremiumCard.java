package com.example.demo.loyaltyCardsStrategyAndSingleton;

public class PremiumCard extends LoyaltyCard {
	
	private static PremiumCard instance = new PremiumCard();

    public static PremiumCard getInstance(){
	      return instance;
	}
    
	private PremiumCard() {

		super();

		setCardName("Premium Loyalty Card");

		theDiscount = new DiscountTen();
	}

}
