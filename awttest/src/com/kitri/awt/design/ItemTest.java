package com.kitri.awt.design;

import java.awt.*;

public class ItemTest extends Frame {

	Panel pN = new Panel();
	Panel pS = new Panel();

	Checkbox app = new Checkbox("���",true);
	Checkbox bana = new Checkbox("�ٳ���");
	Checkbox bery = new Checkbox("����");
	CheckboxGroup cg = new CheckboxGroup();
//	Checkbox mor = new Checkbox("��ħ", cg, true);
//	Checkbox aft = new Checkbox("����", cg, false);
//	Checkbox eve = new Checkbox("����", cg, false);
	

	TextField tf = new TextField();
	TextArea ta = new TextArea();

	Choice ch = new Choice();
	Button exit = new Button("����");

	public ItemTest() {
		super("Item Test !!!");

		pN.setLayout(new GridLayout(2, 3));
		pN.add(app);
		pN.add(bana);
		pN.add(bery);
		pN.add(new Checkbox("��ħ", cg, true));
		pN.add(new Checkbox("����", cg, false));
		pN.add(new Checkbox("����", cg, false));
//		pN.add(mor);
//		pN.add(aft);
//		pN.add(eve);
		
		


		pS.setLayout(new BorderLayout(10, 10));
		ch.add("��ħ");
		ch.add("����");
		ch.add("����");
		pS.add(exit, "East");
		pS.add(ch, "Center");
		
		
		
		setLayout(new BorderLayout(10, 0));
		add(pN, "North");
		add(ta, "Center");
		add(pS, BorderLayout.SOUTH);

		setBounds(300, 200, 300, 500);
		setVisible(true);

	}

	public static void main(String[] args) {

		new ItemTest();

	}

}
