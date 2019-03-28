package com.kitri.util;

import java.util.StringTokenizer;
import java.util.UUID;

public class CtringTokenizerTest {

	public static void main(String[] args) {
		String str = "hello java !!!";
		StringTokenizer st = new StringTokenizer(str);
		int cnt = st.countTokens();
		System.out.println("��ū�� : " + cnt);  //������ ���������� defult�� �����������
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
		
		str = "TO|�̼Ҵ�|�ȳ��ϼ���";
		StringTokenizer st2 = new StringTokenizer(str, "|");
		String protocol = st2.nextToken();
		String to = st2.nextToken();
		String msg = st2.nextToken();
		System.out.println("��� : " + protocol);
		System.out.println("�������� : " + to);
		System.out.println("������ �޼��� : " + msg);
		
		System.out.println(UUID.randomUUID());
	}

}