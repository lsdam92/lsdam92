//	troment2@nate.com
//	claculator_이소담.zip
//	제목 : kitri_ 이름_한자리/두자리
//	내용 자바파일 이름_내용
//	일요일 6시까지

package com.kitri.awt.event;

import java.awt.*;

public class Calculator extends Frame {

	Panel pN = new Panel();
	Panel pS = new Panel();
	Panel pC = new Panel();

	TextField tf = new TextField();

	Label bN = new Label();
	Button bS = new Button("종료");

	Button bC[] = new Button[16];
	
	String num[] = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "C", "=", "/" };
	
	CalculatorController calculatorController;
	
	Font f = new Font("굴림", Font.BOLD, 20);
	int gameLength;
	public Calculator() {
		
		

		pN.setLayout(new BorderLayout(10, 20));
		pN.add(tf, "Center");
		pN.add(bN, "East");

		pC.setLayout(new GridLayout(4, 4, 10, 10));
		bN.setBackground(Color.gray);
		
		gameLength = bC.length;
		int c = 20;
		for (int i = 0; i < gameLength; i++) {
			bC[i] = new Button();
			bC[i].setLabel(num[i]);
			bC[i].setBackground(new Color(70 + c, 20 + c, 10 + c));
			pC.add(bC[i]);
			bC[i].setFont(f);
			c += 8;
		}

		pS.setLayout(new BorderLayout(10, 10));
		pS.add(bS, "Center");

		setLayout(new BorderLayout(20, 20));
		add(pN, "North");
		add(pC, "Center");
		add(pS, "South");
		setBackground(new Color(150, 20, 20));

		setBounds(300, 200, 300, 400);
		setVisible(true);
		
		calculatorController = new CalculatorController(this);
		
		
		for(int i =0; i <gameLength; i++) {
			bC[i].addActionListener(calculatorController);
		}
		tf.addActionListener(calculatorController);
		bS.addActionListener(calculatorController);
		
		
	}

	public static void main(String[] args) {
		new Calculator();

	}
	
}
