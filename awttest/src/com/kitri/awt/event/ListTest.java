package com.kitri.awt.event;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListTest extends Frame implements ActionListener{

	Panel pE = new Panel();
	Panel pC = new Panel();
	Panel pW = new Panel();
	Panel pG = new Panel();
	
	TextField tfR = new TextField();
	TextField tfL = new TextField();
	
	List listR = new List(10,true);
	List listL = new List();
	
	Button btr = new Button("��");
	Button btrA = new Button("��");
	Button btl = new Button("��");
	Button btlA = new Button("��");

		
	public ListTest() {
	
		super("List Test !!!");
		
		
		
		pW.setLayout(new BorderLayout(0, 10));
		pW.add(tfR, "South");
		pW.add(listR, "Center");
		
		pC.setLayout(new GridLayout(6,1, 0, 20));
		pC.add(pG);
		pC.add(btr);
		pC.add(btrA);
		pC.add(btl);
		pC.add(btlA);
		
		pE.setLayout(new BorderLayout(0, 10));
		pE.add(tfL, "South");
		pE.add(listL, "Center");
	
		setLayout(new GridLayout(1, 3, 10, 0));
		add(pE);
		add(pC);
		add(pW);
		
		
			
		setBounds(300, 200, 500, 500);
		setVisible(true);
		
		tfR.addActionListener(this);
		tfL.addActionListener(this);
		btr.addActionListener(this);
		btrA.addActionListener(this);
		btl.addActionListener(this);
		btlA.addActionListener(this);
	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == tfL) {
//			1.tfl�� ��get
			String tmp = tfL.getText().trim();
			tfL.setText("");
			if(tmp.isEmpty())
				return;
//			2.listl�� �߰�
			listL.add(tmp);
		}else if(ob == tfR) {
			String tmp = tfR.getText().trim();
			tfR.setText("");
			if(tmp.isEmpty())
				return;
			listR.add(tmp);
		}else if(ob == btr) {
//			1.listl���� �����ѹ��ڿ� get.
			String tmp = listL.getSelectedItem();
			if(tmp==null)
				return;
//			2.1�� ���� listr�� �߰�.
			listR.add(tmp);
//			3.1�� ���� listl���� ����.
			listL.remove(tmp);
		}else if(ob == btrA) {
//			1.listl�� ���� ��� get
			String tmp[] = listL.getItems();
//			2.1�ǰ��� listR�� ��� �߰�
			int len = tmp.length;
			for (int i = 0; i < len; i++) {
				listR.add(tmp[i]);
			}
//			3.1�� ���� listL���� ��λ���
			listL.removeAll();
//			len = tmp.length;
//			for (int i = len-1; i >= 0; i--) {
//				listL.remove(i);
//			}
		}else if(ob == btl) {
			String tmp = listR.getSelectedItem();
			if(tmp==null)
				return;
			listL.add(tmp);
			listR.remove(tmp);
		}else if(ob == btlA) {
			String tmp[] = listR.getItems();
			int len = tmp.length;
			for (int i = 0; i < len; i++) {
				listL.add(tmp[i]);
			}
				listR.removeAll();
		}
	}
	
	public static void main(String[] args) {
		new ListTest();
	}


	

}
