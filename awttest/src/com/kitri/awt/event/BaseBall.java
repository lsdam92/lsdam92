package com.kitri.awt.event;

import java.awt.*;

public class BaseBall extends Frame {

	Panel pE = new Panel();
	Panel pS = new Panel();
	Panel pC = new Panel();

	TextArea ta = new TextArea();
	TextField tf = new TextField();
	Label d = new Label("입력", Label.CENTER);

	Button newG = new Button("새게임");
	Button clear = new Button("지우기");
	Button dap = new Button("정답");
	Button fontC = new Button("글자색");
	Button exit = new Button("종료");
	
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
		ta.setEditable(false);	//수정x
//		ta.setEnabled(false); 사용불가 수정x
		pC.add(ta, "Center");
		
		
		setLayout(new BorderLayout(10, 0));
		add(pE, "East");
		add(pC, "Center");
		
		
		setBounds(300, 200, 500, 400);
		setVisible(true);

		baseBallController = new BaseBallController(this);
		
//		BaseBall 창 이벤트 목록
		newG.addActionListener(baseBallController);
		exit.addActionListener(baseBallController);
		clear.addActionListener(baseBallController);
		dap.addActionListener(baseBallController);
		fontC.addActionListener(baseBallController);
		tf.addActionListener(baseBallController);
		
//		FontColorChooser창 이벤트목록
		FontColorChooser.Rr.addAdjustmentListener(baseBallController);
		FontColorChooser.Rr2.addAdjustmentListener(baseBallController);
		FontColorChooser.Rr3.addAdjustmentListener(baseBallController);
		
		FontColorChooser.ok.addActionListener(baseBallController);
	}

	public static void main(String[] args) {

		new BaseBall();

	}

}
