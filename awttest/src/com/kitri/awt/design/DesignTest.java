package com.kitri.awt.design;

import java.awt.*;

//1. Frame ���
//2. ������� �ʿ��� ��ü ����.
//3. ��ġ��(������)���� design(component ��ġ)
// **�۾��� ������ -> ū��


public class DesignTest extends Frame {

//				�����
	Panel pN = new Panel();
	Panel pS = new Panel();
	
	Label l = new Label("�Է�", Label.CENTER);
	TextField tf = new TextField();
	Button send = new Button("����");
	
	TextArea ta = new TextArea();
	
	Choice ch = new Choice();
	Button exit = new Button("����");
	
	
	
	public DesignTest() {
		super("Design Test !!!");
//				��ġ��
		pN.setLayout(new BorderLayout(10, 0));
		l.setBackground(new Color(0, 0, 0));
//		l.setForeground(new Color(255, 255, 255));
		l.setForeground(Color.gray);
		Font f = new Font("����", Font.BOLD, 20);
		l.setFont(f);
		pN.add(l, "West");
		pN.add(tf, "Center");
		send.setFont(f);
		pN.add(send, "East");
		
		pS.setLayout(new GridLayout(1, 2, 10, 0));
		ch.add("����");
		ch.add("���,��õ");
		ch.add("����");
		ch.add("��û");
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
		setVisible(true);			//�׻� �ϼ��� �ǰ� ���� �������� setVisible();
	}
	
	public static void main(String[] args) {
		new DesignTest();			//�̸����� ��ü���� �����ڸ� ȣ���ؼ� ����Ұ��
	}

}
