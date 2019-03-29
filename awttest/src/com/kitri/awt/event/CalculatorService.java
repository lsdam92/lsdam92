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

	public void tf() {
		String myNumStr = dd.tf.getText().trim();
		dd.tf.setText("");
		
	}

	public void exit() {
		System.exit(0);
	}

	public void button(int i) {
		
		String a = Integer.toString(i);
		
		calculatorController.calculator.tf.setText(a);
	}
	public void clear() {
		calculatorController.calculator.tf.setText(" ");
		
	}
		
	public void plus() {
		
		
	}

	public void ggob() {

		
	}

	public void mius() {
		
		
	}

	public void result() {
		
		
	}

	public void nbbang() {
		
		
	}

	

	

	
}
