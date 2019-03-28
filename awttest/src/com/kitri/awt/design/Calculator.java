package com.kitri.awt.design;

import java.awt.*;

public class Calculator extends Frame {

	Panel pN = new Panel();
	Panel pS = new Panel();
	Panel pC = new Panel();

	TextField tf = new TextField();

	Label bN = new Label();
	Button bS = new Button("Á¾·á");

	Button bC[] = new Button[16];

	String num[] = { "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3", "*", "0", "C", "=", "/" };

	public Calculator() {

		Font f = new Font("±¼¸²", Font.BOLD, 20);
		bN.setBackground(Color.gray);

		pN.setLayout(new BorderLayout(10, 20));
		pN.add(tf, "Center");
		pN.add(bN, "East");

		pC.setLayout(new GridLayout(4, 4, 20, 20));
		int len = bC.length;
		int c = 20;
		for (int i = 0; i < len; i++) {
			
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

		setBounds(300, 200, 300, 350);
		setVisible(true);

	}

	public static void main(String[] args) {
		new Calculator();

	}

}
