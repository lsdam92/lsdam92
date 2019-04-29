package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0. com, my 3�ڸ� �迭.
//1. com ���ڸ� ���� �߻�. >> comRandom()
//2. 1�� ���ڴ� �ߺ� ���� x
//			 0���ν��� x
//3. ���� �Է��� 3�ڸ����ڸ� my �迭�� �ֱ�			 
//4. com�� my��  ���ڿ� �ڸ���
//5. ���ڰ� ���ٸ�
//	5-1. �ڸ��� ���ٸ� strike ����
//	5-2 �ڸ��� �ٸ��ٸ� ball ����.
//6. 5�� ���
//   6-1 skrike 3 :
//   	 xxx�� x��°���� ����
//		  ���(1), ����(0)
//	 6-2 strike�� 3�� �ƴ϶��
//	  xxx�� x��Ʈ����ũ x���Դϴ�. >> 3������

public class NumberBaseBall {

	private int my[] = new int[3];
	private int com[] = new int[3];
	BufferedReader in;
	private int strike = 0;
	private int ball = 0;
	int count = 0;

	public NumberBaseBall() {
		comRandom();
		in = new BufferedReader(new InputStreamReader(System.in));
	}

	private void comRandom() {
		com[0] = (int)(Math.random()*9+1);
		do {
			com[1] = (int)(Math.random()*10);
		}while (com[0] == com[1]);
		do {
			com[2] = (int)(Math.random()*10);
		} while (com[2] == com[0] || com[1] == com[2]);
	
	}

	private void game() {
		while (true) {
			System.out.print("�����Է� : ");
			int myNum = getNumber(); // 149

			my[0] = myNum / 100; // 1
			my[1] = myNum / 10 % 10; // 4
			my[2] = myNum % 10; // 9
			// �Ȱ��� �����Է½� �ٽý��� �߰��ϱ�.

			strike = 0;
			ball = 0;

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (my[i] == com[j] && i == j) {
						strike++;
					} else if (my[i] == com[j]) {
						ball++;
					}
				}
			}
			count++;
			
			if (strike != 3) { // ���

				System.out.println(count + "." + "����ȣ : " + myNum + " \t" + strike + " :��Ʈ����ũ \t" + ball + ": ��");
				System.out.println("��ǻ�� : " + com[0] + "" + com[1] + "" + com[2]);

			} else {

				System.out.println(myNum + "�� " + count + "��° ���� �����Դϴ�");
				System.out.println("����ϱ�(1)" + "�׸��ϱ�(0)");

				int num = getNumber();
				if (num == 1) {
					count = 0;
//					strike = 0;
//					ball = 0;
					comRandom();
				//	game();
				} else {
					System.out.println("������ ����˴ϴ�.");
					System.exit(0);
				}

			}
		}
	}

	private int getNumber() {
		int num = 0;

		try {
			num = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return num;
	}

	public static void main(String[] args) {
		NumberBaseBall nbb = new NumberBaseBall();
		nbb.game();

	}

}
