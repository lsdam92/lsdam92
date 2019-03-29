package com.kitri.awt.event;

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
	
	BaseBallController baseBallController;
	FontColorChooser FontColorChooser = new FontColorChooser();

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
		pC.add(pS, "South");
		ta.setEditable(false);	//����x
//		ta.setEnabled(false); ���Ұ� ����x
		pC.add(ta, "Center");
		
		
		setLayout(new BorderLayout(10, 0));
		add(pE, "East");
		add(pC, "Center");
		
		
		setBounds(300, 200, 500, 400);
		setVisible(true);

		baseBallController = new BaseBallController(this);
		
//		BaseBall â �̺�Ʈ ���
		newG.addActionListener(baseBallController);
		exit.addActionListener(baseBallController);
		clear.addActionListener(baseBallController);
		dap.addActionListener(baseBallController);
		fontC.addActionListener(baseBallController);
		tf.addActionListener(baseBallController);
		
//		FontColorChooserâ �̺�Ʈ���
		FontColorChooser.Rr.addAdjustmentListener(baseBallController);
		FontColorChooser.Rr2.addAdjustmentListener(baseBallController);
		FontColorChooser.Rr3.addAdjustmentListener(baseBallController);
		
		FontColorChooser.ok.addActionListener(baseBallController);
	}

	public static void main(String[] args) {

		new BaseBall();

	}

}
