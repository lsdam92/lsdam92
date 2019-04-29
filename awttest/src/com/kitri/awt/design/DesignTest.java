package com.kitri.awt.design;

import java.awt.*;

//1. Frame 상속
//2. 선언부의 필요한 객체 생성.
//3. 배치부(생성자)에서 design(component 배치)
// **작업은 작은것 -> 큰것


public class DesignTest extends Frame {

//				선언부
	Panel pN = new Panel();
	Panel pS = new Panel();
	
	Label l = new Label("입력", Label.CENTER);
	TextField tf = new TextField();
	Button send = new Button("전송");
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice();
	Button exit = new Button("종료");
	
	
	
	public DesignTest() {
		super("Design Test !!!");
//				배치부
		pN.setLayout(new BorderLayout(10, 0));
		l.setBackground(new Color(0, 0, 0));
//		l.setForeground(new Color(255, 255, 255));
		l.setForeground(Color.gray);
		Font f = new Font("굴림", Font.BOLD, 20);
		l.setFont(f);
		pN.add(l, "West");
		pN.add(tf, "Center");
		send.setFont(f);
		pN.add(send, "East");
		
		pS.setLayout(new GridLayout(1, 2, 10, 0));
		ch.add("서울");
		ch.add("경기,인천");
		ch.add("강원");
		ch.add("충청");
		pS.add(ch);
		pS.add(exit);
		exit.setFont(f);
		
		setLayout(new BorderLayout(0, 10));
		add(pN, "North");
		add(ta, "Center");
		add(pS, BorderLayout.SOUTH);
		
		
//		setSize(300, 400);
//		setLocation(300, 200);
		setBounds(300, 200, 300, 500);
		setVisible(true);			//항상 완성이 되고 난뒤 마지막에 setVisible();
	}
	
	public static void main(String[] args) {
		new DesignTest();			//이름없이 객체생성 생성자만 호출해서 사용할경우
	}

}
