package com.kitri.awt.event;

import java.awt.Color;
import java.util.Random;

public class BaseBallService {

	BaseBallController baseBallController;
	private BaseBall bb;
	private FontColorChooser fcc;

	private int my[];
	private int com[];
	int gameLength;
	Random random = new Random();
	int count;
	int r, g, b;
	
	

	public BaseBallService(BaseBallController baseBallController) {

		this.baseBallController = baseBallController;
		bb = baseBallController.baseBall;
		fcc = baseBallController.baseBall.FontColorChooser;
		gameLength = 3;
		my = new int[gameLength];
		com = new int[gameLength];
		newGame();

	}

	public void newGame() {
		com[0] = random.nextInt(9) + 1;
		do {
			com[1] = random.nextInt(10);
		} while (com[0] == com[1]);
		do {
			com[2] = random.nextInt(10);
		} while (com[2] == com[0] || com[1] == com[2]);
		bb.tf.setEnabled(true);
		clear();
		viewResult("���ο� ������ �����մϴ�!!!");
		count = 0;
		System.out.println("���� : " + com[0] + com[1] + com[2]);

	}

	public void clear() {
		baseBallController.baseBall.ta.setText(" ");
	}

	public void showDap() {
		bb.ta.append("������ " + com[0] + com[1] + com[2] + "�Դϴ�");
		bb.ta.append("������ �Ǵ� ���Ḧ ��������!!" + "\n");
		bb.tf.setEnabled(false);
	}

	public void fontColorChange() {
		fcc.setVisible(true);
		changeColor();
	}

	public void exit() {
		System.exit(0);
	}

	public void game() {

		int strike = 0;
		int ball = 0;
		String myNumStr = bb.tf.getText().trim();
		bb.tf.setText("");

		if (myNumStr.length() != gameLength) {
			viewResult("3�ڸ� ���ڸ� �Է��ϼ���!!!!");
			return;
		}

		if (!isNumber(myNumStr)) {
			viewResult("���ڸ� �Է��ϼ���!!!");
			return;
		}

		for (int i = 0; i < gameLength; i++) {
			my[i] = myNumStr.charAt(i) - 48;
		}
		for (int i = 0; i < gameLength; i++) {
			for (int j = 0; j < 3; j++) {
				if (my[i] == com[j] && i == j) {
					strike++;
				} else if (my[i] == com[j]) {
					ball++;
				}
			}
		}
		count++;

		if (strike != gameLength) {
			viewResult(count + "." + "����ȣ : " + myNumStr + " \t" + strike + " :��Ʈ����ũ \t" + ball + ": ��");
		} else {
			viewResult(myNumStr + "�� " + count + "��° ���� �����Դϴ�" + "\n");
			bb.ta.append("������ �Ǵ� ���Ḧ ��������!!" + "\n");
			bb.tf.setEnabled(false);
		}
	}

	private void viewResult(String msg) {
		bb.ta.append(msg + "\n");
	}

	private boolean isNumber(String str) {
		boolean flag = true;
		for (int i = 0; i < gameLength; i++) {
			int num = str.charAt(i) - 48;
			if (num < 0 || num > 9) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	public void changeColor() {
		r = fcc.Rr.getValue();
		g = fcc.Rr2.getValue();
		b = fcc.Rr3.getValue();
		fcc.colorS.setBackground(new Color(r, g, b));
		fcc.tf.setText("r = " + r + " g = " + g + " b = " + b);
	}

	public void selectColor() {
		bb.ta.setForeground(new Color(r, g, b));
		fcc.setVisible(false);
		
	}
}
