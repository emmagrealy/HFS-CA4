package com.example.demo.cardValidationTemplateMethod;

import com.example.demo.controller.AppController;

public class VisaValidation extends AbstractCardValidator {

	public VisaValidation(AppController app, String cardName, String cardNumber, int expiryDateMonth,
			int expiryDateYear, String cvv) {

		super(app, cardName, cardNumber, expiryDateMonth, expiryDateYear, cvv);

	}

	/* Overridden method */

	protected boolean validateCardNumberFormat() {

		/* Check number is in correct format for Visa */

		boolean errorInFormat = false;

		if (cardNumber.charAt(0) != '4') {

			//JOptionPane.showMessageDialog(app, "Card format incorrect");
			errorInFormat = true;									

		}
		else {


		}

		return !errorInFormat;

	}

}
