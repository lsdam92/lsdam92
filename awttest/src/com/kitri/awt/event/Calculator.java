//	troment2@nate.com
//	claculator_이소담.zip
//	제목 : kitri_ 이름_한자리/두자리
//	내용 자바파일 이름_내용
//	일요일 6시까지

package com.kitri.awt.event;

import java.awt.*;

public class Calculator extends Frame {

	Panel pN = new Panel();

	Panel pC = new Panel();

	Label suut = new Label("", Label.RIGHT);
	Label giho = new Label("", Label.CENTER);

	Button exit = new Button("종료");
	Button bC[] = new Button[16];

	String num[] = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "C", "=", "/" };

	CalculatorController calculatorController;

	Font f = new Font("굴림", Font.BOLD, 20);
	int gameLength;

	public Calculator() {

		pN.setLayout(new BorderLayout(10, 20));
		pN.add(suut, "Center");
		pN.add(giho, "East");

		pC.setLayout(new GridLayout(4, 4, 10, 10));

		gameLength = bC.length;

		giho.setBackground(Color.gray);
		suut.setBackground(Color.gray);
		
		int c = 20;
		for (int i = 0; i < gameLength; i++) {
			bC[i] = new Button();
			bC[i].setLabel(num[i]);
			bC[i].setBackground(new Color(70 + c, 20 + c, 10 + c));
			pC.add(bC[i]);
			bC[i].setFont(f);
			c += 8;
		}

		setLayout(new BorderLayout(20, 20));
		add(pN, "North");
		add(pC, "Center");
		add(exit, "South");
		setBackground(new Color(150, 20, 20));

		setBounds(300, 200, 300, 400);
		setVisible(true);

		calculatorController = new CalculatorController(this);

		for (int i = 0; i < gameLength; i++) {
			bC[i].addActionListener(calculatorController);
		}
		exit.addActionListener(calculatorController);

	}

	public static void main(String[] args) {
		new Calculator();

	}

}