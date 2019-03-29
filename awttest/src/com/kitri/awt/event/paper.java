package com.kitri.awt.event;

import java.awt.*;



public class paper extends Frame{

	Panel n1 = new Panel();
	Panel n2 = new Panel();
	Panel n312 = new Panel();
	Panel n4 = new Panel();
	Panel n5 = new Panel();
	
	TextField tf1 = new TextField();
	TextField tf2 = new TextField();
	
	TextArea ta = new TextArea();
	
	Label from = new Label("From : ", Label.CENTER);
	Label to = new Label("To : ", Label.CENTER);
	
	Button bL = new Button("보내기");
	Button bR = new Button("취소");
	
	public paper() {
		super("쪽지보내기~~~");
		
		n1.setLayout(new BorderLayout());
		n1.add(from, "West");
		n1.add(tf1, "Center");
		
		n2.setLayout(new BorderLayout());
		n2.add(to,"West");
		n2.add(tf2,"Center");
		
		n312.setLayout(new GridLayout(1,2));
		n312.add(n1);
		n312.add(n2);
		
		n4.setLayout(new BorderLayout());
		n4.add(ta, "Center");
		
		n5.setLayout(new GridLayout(1,2));
		n5.add(bL);
		n5.add(bR);
		
		setLayout(new BorderLayout());
		add(n312,"North");
		add(n4, "Center");
		add(n5, "South");
		
		
		
		setBounds(300, 200, 400, 300);
		setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new paper();
	}

}
