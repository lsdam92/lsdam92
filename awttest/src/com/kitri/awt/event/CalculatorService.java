package com.kitri.awt.event;

import java.awt.*;

public class CalculatorService {

	CalculatorController calculatorController;
	private Calculator dd;
	
	
	
	int gameLength;
	
	public CalculatorService(CalculatorController calculatorController) {
		this.calculatorController = calculatorController;
		dd = calculatorController.calculator;
	
	}

	
	public void Field() {
		String myNumStr = dd.tf.getText().trim();
		dd.tf.setText("");
		
		if(isNumber(myNumStr)) {
			dd.tf.setText(myNumStr);
		}else {
			return;
		}
	}

	public void exit() {
		System.exit(0);
	}

	private boolean isNumber(String str) {
		boolean flag = true;		
		
		return flag;
	}
	

	

	
}
