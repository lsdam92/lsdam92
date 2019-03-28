package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;

public class ItemTest extends Frame implements ItemListener, ActionListener{

	Panel pN = new Panel();
	Panel pS = new Panel();

	Checkbox app = new Checkbox("���",true);
	Checkbox bana = new Checkbox("�ٳ���");
	Checkbox bery = new Checkbox("����");
	CheckboxGroup cg = new CheckboxGroup();
	Checkbox mor = new Checkbox("��ħ", cg, true);
	Checkbox aft = new Checkbox("����", cg, false);
	Checkbox eve = new Checkbox("����", cg, false);
	

	TextField tf = new TextField();
	TextArea ta = new TextArea();

	Choice ch = new Choice();
	Button exit = new Button("����");

	public ItemTest() {
		super("Item Test !!!");

		pN.setLayout(new GridLayout(2, 3));
		pN.add(mor);
		pN.add(aft);
		pN.add(eve);
		pN.add(app);
		pN.add(bana);
		pN.add(bery);
//		pN.add(new Checkbox("��ħ", cg, true));
//		pN.add(new Checkbox("����", cg, false));
//		pN.add(new Checkbox("����", cg, false));
		
		


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
		
		exit.addActionListener(this);

		mor.addItemListener(this);
		aft.addItemListener(this);
		eve.addItemListener(this);
		app.addItemListener(this);
		bana.addItemListener(this);
		bery.addItemListener(this);
		ch.addItemListener(this);
		
	}

	public static void main(String[] args) {

		new ItemTest();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
		
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object ob = e.getSource();
		if(ob == ch) {
			String str = ch.getSelectedItem();
			if(str.equals("��ħ")){
				mor.setState(true);
			}else if(str.equals("����")) {
				aft.setState(true);
			}else {
				eve.setState(true);
			}
		}
		Checkbox sel = cg.getSelectedCheckbox();
		String selStr = sel.getLabel();
//		System.out.println(selStr);
		ta.setText("--- " + selStr + " ---\n");
//		ta.append("1. ��� : " + (app.getState() == true ? "�Ծ���" : "�ȸԾ���") + "\n");
//		ta.append("2. �ٳ��� : "+ (bana.getState() == true ? "�Ծ���" : "�ȸԾ���") + "\n");
//		ta.append("3. ���� : " + (bery.getState() == true ? "�Ծ���" : "�ȸԾ���")+ "\n");
		ta.append("1. ��� : " + eat(app.getState()) + "\n)");
		ta.append("2. �ٳ��� : "+ eat(bana.getState()) + "\n");
		ta.append("3. ���� : " + eat(bery.getState())+ "\n");
		ch.select(selStr);
	
	}
	
	private String eat(boolean flag) {
		return flag? "�Ծ���" : "�ȸԾ���";
	}

}
