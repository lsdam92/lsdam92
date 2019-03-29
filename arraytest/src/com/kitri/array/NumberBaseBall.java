package com.kitri.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//0. com, my 3자리 배열.
//1. com 세자리 난수 발생. >> comRandom()
//2. 1의 숫자는 중복 숫자 x
//			 0으로시작 x
//3. 내가 입력한 3자리숫자를 my 배열에 넣기			 
//4. com과 my의  숫자와 자리비교
//5. 숫자가 같다면
//	5-1. 자리수 같다면 strike 증가
//	5-2 자리수 다르다면 ball 증가.
//6. 5의 결과
//   6-1 skrike 3 :
//   	 xxx는 x번째만에 정답
//		  계속(1), 종료(0)
//	 6-2 strike가 3이 아니라면
//	  xxx는 x스트라이크 x볼입니다. >> 3번으로

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
			System.out.print("숫자입력 : ");
			int myNum = getNumber(); // 149

			my[0] = myNum / 100; // 1
			my[1] = myNum / 10 % 10; // 4
			my[2] = myNum % 10; // 9
			// 똑같은 숫자입력시 다시시작 추가하기.

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
			
			if (strike != 3) { // 결과

				System.out.println(count + "." + "내번호 : " + myNum + " \t" + strike + " :스트라이크 \t" + ball + ": 볼");
				System.out.println("컴퓨터 : " + com[0] + "" + com[1] + "" + com[2]);

			} else {

				System.out.println(myNum + "은 " + count + "번째 만에 정답입니다");
				System.out.println("계속하기(1)" + "그만하기(0)");

				int num = getNumber();
				if (num == 1) {
					count = 0;
//					strike = 0;
//					ball = 0;
					comRandom();
				//	game();
				} else {
					System.out.println("게임이 종료됩니다.");
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
