package com.example.demo.loyaltyCardsStrategyAndSingleton;

public class LoyaltyCard {

	private String cardName;
	public ApplyDiscount theDiscount;
	
	
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	
	 public double applyTheDiscount(){
	     return theDiscount.productDiscount();
	 }
	
     public void setTheDiscount(ApplyDiscount newDiscount){
    	 theDiscount = newDiscount;
     }

}
