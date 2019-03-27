package com.kitri.util;

import java.util.StringTokenizer;
import java.util.UUID;

public class CtringTokenizerTest {

	public static void main(String[] args) {
		String str = "hello java !!!";
		StringTokenizer st = new StringTokenizer(str);
		int cnt = st.countTokens();
		System.out.println("토큰수 : " + cnt);  //지정을 하지않으면 defult는 공백기준으로
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		str = "TO|이소담|안녕하세요";
		StringTokenizer st2 = new StringTokenizer(str, "|");
		String protocol = st2.nextToken();
		String to = st2.nextToken();
		String msg = st2.nextToken();
		System.out.println("기능 : " + protocol);
		System.out.println("누구에게 : " + to);
		System.out.println("보내는 메세지 : " + msg);
		
		System.out.println(UUID.randomUUID());
	}

}
