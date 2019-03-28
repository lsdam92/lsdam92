package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.*;

public class ItemTest extends Frame implements ItemListener, ActionListener{

	Panel pN = new Panel();
	Panel pS = new Panel();

	Checkbox app = new Checkbox("»ç°ú",true);
	Checkbox bana = new Checkbox("¹Ù³ª³ª");
	Checkbox bery = new Checkbox("µþ±â");
	CheckboxGroup cg = new CheckboxGroup();
	Checkbox mor = new Checkbox("¾ÆÄ§", cg, true);
	Checkbox aft = new Checkbox("Á¡½É", cg, false);
	Checkbox eve = new Checkbox("Àú³á", cg, false);
	

	TextField tf = new TextField();
	TextArea ta = new TextArea();

	Choice ch = new Choice();
	Button exit = new Button("Á¾·á");

	public ItemTest() {
		super("Item Test !!!");

		pN.setLayout(new GridLayout(2, 3));
		pN.add(mor);
		pN.add(aft);
		pN.add(eve);
		pN.add(app);
		pN.add(bana);
		pN.add(bery);
//		pN.add(new Checkbox("¾ÆÄ§", cg, true));
//		pN.add(new Checkbox("Á¡½É", cg, false));
//		pN.add(new Checkbox("Àú³á", cg, false));
		
		


		pS.setLayout(new BorderLayout(10, 10));
		ch.add("¾ÆÄ§");
		ch.add("Á¡½É");
		ch.add("Àú³á");
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
			if(str.equals("¾ÆÄ§")){
				mor.setState(true);
			}else if(str.equals("Á¡½É")) {
				aft.setState(true);
			}else {
				eve.setState(true);
			}
		}
		Checkbox sel = cg.getSelectedCheckbox();
		String selStr = sel.getLabel();
//		System.out.println(selStr);
		ta.setText("--- " + selStr + " ---\n");
//		ta.append("1. »ç°ú : " + (app.getState() == true ? "¸Ô¾ú´Ù" : "¾È¸Ô¾ú´Ù") + "\n");
//		ta.append("2. ¹Ù³ª³ª : "+ (bana.getState() == true ? "¸Ô¾ú´Ù" : "¾È¸Ô¾ú´Ù") + "\n");
//		ta.append("3. µþ±â : " + (bery.getState() == true ? "¸Ô¾ú´Ù" : "¾È¸Ô¾ú´Ù")+ "\n");
		ta.append("1. »ç°ú : " + eat(app.getState()) + "\n)");
		ta.append("2. ¹Ù³ª³ª : "+ eat(bana.getState()) + "\n");
		ta.append("3. µþ±â : " + eat(bery.getState())+ "\n");
		ch.select(selStr);
	
	}
	
	private String eat(boolean flag) {
		return flag? "¸Ô¾ú´Ù" : "¾È¸Ô¾ú´Ù";
	}

}
