package com.kitri.awt.event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener {

	Calculator calculator;
	CalculatorService calculatorService;
	
	public CalculatorController(Calculator calculator) {
		this.calculator = calculator;
		calculatorService = new CalculatorService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		
	 if(ob == calculator.bS) {
		 calculatorService.exit();
		
		}else if(ob == calculator.tf) {
			calculatorService.Field();
		}
	}


}