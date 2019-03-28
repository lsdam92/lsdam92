package com.kitri.awt.design;

import java.awt.*;

public class BaseBall extends Frame {

	Panel pE = new Panel();
	Panel pS = new Panel();
	Panel pC = new Panel();

	TextArea ta = new TextArea();
	TextField tf = new TextField();
	Label d = new Label("입력", Label.CENTER);

	Button newG = new Button("새게임");
	Button clear = new Button("지우기");
	Button dap = new Button("정답");
	Button fontC = new Button("글자색");
	Button exit = new Button("종료");

	public BaseBall() {
		super("BaseBall Test !!!");

		pE.setLayout(new GridLayout(5, 1, 10, 10));
		pE.add(newG);
		pE.add(clear);
		pE.add(dap);
		pE.add(fontC);
		pE.add(exit);
		
		
		pS.setLayout(new BorderLayout(10, 0));
		pS.add(tf, "Center");
		pS.add(d, "West");

		pC.setLayout(new BorderLayout(10, 0));
		pC.add(ta, "Center");
		pC.add(pS, "South");
		
		
		setLayout(new BorderLayout(10, 0));
		add(pE, "East");
		add(pC, "Center");
		
		
		setBounds(300, 200, 300, 500);
		setVisible(true);

	}

	public static void main(String[] args) {

		new BaseBall();

	}

}
