package com.kitri.util.jcf;

import java.util.*;

public class SetTest {

	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();
		set.add("Ȳ����");
		set.add("�ڹ̷�");
		set.add("������");
		set.add("������");
		set.add("�ڹ̷�");
		System.out.println("set�� ũ�� : " + set.size());
		
//		Object ob[] = set.toArray();
//		int len = ob.length;
//		for (int j = 0; j < len; j++) {
//			System.out.println((String) ob[j]);
//			
//		}
		
		String str[] = set.toArray(new String[0]);
		int len = str.length;
		for (int i = 0; i < len; i++) {
			System.out.println(str[i]);
		}
		
		System.out.println("-------------------------------");
		Iterator<String> iterate = set.iterator();
		while(iterate.hasNext()) {
			System.out.println(iterate.next());
		}
	}

}
