package com.kitri.awt.design;

import java.awt.*;

public class BaseBall extends Frame {

	Panel pE = new Panel();
	Panel pS = new Panel();
	Panel pC = new Panel();

	TextArea ta = new TextArea();
	TextField tf = new TextField();
	Label d = new Label("�Է�", Label.CENTER);

	Button newG = new Button("������");
	Button clear = new Button("�����");
	Button dap = new Button("����");
	Button fontC = new Button("���ڻ�");
	Button exit = new Button("����");

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
