package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;

public class ItemTest extends Frame{

	Panel pN = new Panel();
	Panel pS = new Panel();

	Checkbox app = new Checkbox("사과",true);
	Checkbox bana = new Checkbox("바나나");
	Checkbox bery = new Checkbox("딸기");
	CheckboxGroup cg = new CheckboxGroup();
	Checkbox mor = new Checkbox("아침", cg, true);
	Checkbox aft = new Checkbox("점심", cg, false);
	Checkbox eve = new Checkbox("저녁", cg, false);
	

	TextField tf = new TextField();
	TextArea ta = new TextArea();

	Choice ch = new Choice();
	Button exit = new Button("종료");
	
	ItemLogic itemLogic;

	public ItemTest() {
		super("Item Test !!!");

		pN.setLayout(new GridLayout(2, 3));
		pN.add(mor);
		pN.add(aft);
		pN.add(eve);
		pN.add(app);
		pN.add(bana);
		pN.add(bery);
//		pN.add(new Checkbox("아침", cg, true));
//		pN.add(new Checkbox("점심", cg, false));
//		pN.add(new Checkbox("저녁", cg, false));
		
		


		pS.setLayout(new BorderLayout(10, 10));
		ch.add("아침");
		ch.add("점심");
		ch.add("저녁");
		pS.add(exit, "East");
		pS.add(ch, "Center");
		
		
		
		setLayout(new BorderLayout(10, 0));
		add(pN, "North");
		add(ta, "Center");
		add(pS, BorderLayout.SOUTH);

		setBounds(300, 200, 300, 500);
		setVisible(true);
		
		
		itemLogic = new ItemLogic(this);
		
		exit.addActionListener(itemLogic);

		mor.addItemListener(itemLogic);
		aft.addItemListener(itemLogic);
		eve.addItemListener(itemLogic);
		app.addItemListener(itemLogic);
		bana.addItemListener(itemLogic);
		bery.addItemListener(itemLogic);
		ch.addItemListener(itemLogic);
		
	}

	public static void main(String[] args) {

		new ItemTest();

	}

	
	
	
	
	

}
