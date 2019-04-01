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
//	WindowAdapter�� ��ӹ����� �Ѱ��̻��� override�ϸ� �����ϴ�
//	WindowListener�� implements�ϸ� ��� method�� override�ؾ��ϹǷ�
//	�Ѱ����� �����ִ� WindowAdapter�� �Ἥ �Ѱ��̻��� method�� override�� �ϸ�ȴ�
	@Override  
	public void windowClosing(WindowEvent e) {
		baseBallService.exit();	
		}

	
}
