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
		
		
		
		if(ob == calculator.tf) {
			calculatorService.tf();
		}else if(ob == calculator.bS) {
			calculatorService.exit();
		}for(int i = 0; i < 15; i++) {
		 if(ob == calculator.bC[i]) {
			 calculatorService.button(i+1);
			
		}
		 if(ob == calculator.bC[3]) {
			calculatorService.plus();
		}else if(ob == calculator.bC[7]) {
			calculatorService.mius();
		}else if(ob == calculator.bC[11]) {
			calculatorService.ggob();
		}else if(ob == calculator.bC[13]) {
			calculatorService.clear();
		}else if(ob == calculator.bC[14]) {
			calculatorService.result();
		}else if(ob == calculator.bC[15]) {
			calculatorService.nbbang();
		}
	}

}
}