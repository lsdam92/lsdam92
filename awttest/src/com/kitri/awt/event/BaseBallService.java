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
		viewResult("새로운 게임을 시작합니다!!!");
		count = 0;
		System.out.println("컴터 : " + com[0] + com[1] + com[2]);

	}

	public void clear() {
		baseBallController.baseBall.ta.setText(" ");
	}

	public void showDap() {
		bb.ta.append("정답은 " + com[0] + com[1] + com[2] + "입니다");
		bb.ta.append("새게임 또는 종료를 누르세요!!" + "\n");
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
			viewResult("3자리 숫자르 입력하세요!!!!");
			return;
		}

		if (!isNumber(myNumStr)) {
			viewResult("숫자만 입력하세요!!!");
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
			viewResult(count + "." + "내번호 : " + myNumStr + " \t" + strike + " :스트라이크 \t" + ball + ": 볼");
		} else {
			viewResult(myNumStr + "은 " + count + "번째 만에 정답입니다" + "\n");
			bb.ta.append("새게임 또는 종료를 누르세요!!" + "\n");
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
