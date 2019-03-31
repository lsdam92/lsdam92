package com.kitri.awt.event;

import java.awt.*;

public class CalculatorService {

	CalculatorController calculatorController;
	private Calculator dd;
	double ans;
	double ans2;
	int count = 0;
	String save = "";
	boolean tb = true;

	public CalculatorService(CalculatorController calculatorController) {
		this.calculatorController = calculatorController;
		dd = calculatorController.calculator;

	}

	public void calcM(Object ob) {
		Button but = (Button) ob;
		String getLabel = but.getLabel();

		char butLabel = but.getLabel().charAt(0);
		if (Character.isDigit(butLabel)) {
			numLabel(getLabel);
		} else if (getLabel.equals("C")) {
			clear();
		} else {
			function(getLabel);
		}
	}

	public void clear() {
		ans = 0;
		ans2 = 0;
		dd.suut.setText("");
		dd.giho.setText("");
		save = "";
		tb = true;
	}
	

	public void numLabel(String getLabel) {

		if (count > 0) {
			dd.suut.setText("");
		}
		if (count == 2) {
			ans2 = 0;
			save = "";
			dd.giho.setText("");
		}

		String suutSave = dd.suut.getText();
		dd.suut.setText(suutSave + getLabel);
		count = 0;
	}

	private void giho2(String save) {
	
		switch (save.charAt(0)) {
		case '+':
			ans2 += ans;
			break;
		case '-':
			ans2 -= ans;
			break;
		case '*':
			ans2 *= ans;
			break;
		case '/':
			ans2 /= ans;
			break;
		
		}
		
	}

	public void function(String g) {
		if (count == 0) {
			ans = Integer.parseInt(dd.suut.getText());
			String gap = this.save;

			if (g.charAt(0) == '=') {
				if (!tb) {
					giho2(this.save);
					dd.suut.setText(Double.toString(ans2));
					dd.giho.setText("");
					count++;
				}
			} else if (!tb) {
				giho2(gap);
				dd.suut.setText(Double.toString(ans2));
			} else {
				giho2(g);
				this.save = g;
				dd.giho.setText(g);
				tb = false;
			}
		}
		if (tb) {
			dd.suut.setText(Double.toString(ans));
		}
		count++;
	}

	public void exit() {
		System.exit(0);
	}

}

//asdl;nkflasnflasdnflasndflkansdflk흐아아ㅣㅏㄹ나ㅣ라날
