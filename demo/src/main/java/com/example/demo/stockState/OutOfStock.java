package com.example.demo.stockState;

public class OutOfStock implements StockState{

	public boolean stateOfStock() {
		return false;
	}

}