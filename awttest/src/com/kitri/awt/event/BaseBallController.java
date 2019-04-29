package com.kitri.awt.event;

import java.awt.event.*;

public class BaseBallController extends WindowAdapter implements ActionListener, AdjustmentListener {
	
	BaseBall baseBall;
	

	BaseBallService baseBallService;
	
	public BaseBallController(BaseBall baseBall) {
		this.baseBall = baseBall;
		baseBallService = new BaseBallService(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == baseBall.newG) {
			baseBallService.newGame();
		}else if(ob == baseBall.clear) {
			baseBallService.clear();
		}else if(ob == baseBall.dap) {
			baseBallService.showDap();
		}else if(ob == baseBall.fontC) {
			baseBallService.fontColorChange();
		}else if(ob == baseBall.exit) {
			baseBallService.exit();
		}else if(ob == baseBall.tf) {
			baseBallService.game();
		}else if(ob == baseBall.FontColorChooser.ok) {
			baseBallService.selectColor();
		}
		
	}
	
	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) {
		
		baseBallService.changeColor();
	}
//	WindowAdapter를 상속받으면 한개이상을 override하면 가능하다
//	WindowListener를 implements하면 모든 method를 override해야하므로
//	한가지만 쓸수있는 WindowAdapter를 써서 한개이상의 method를 override만 하면된다
	@Override  
	public void windowClosing(WindowEvent e) {
		baseBallService.exit();	
		}

	
}
