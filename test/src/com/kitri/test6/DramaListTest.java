package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;



public class DramaListTest {

	public static void main(String[] args) {
	
//		Drama drama = new Drama("�� �ܿ�, �ٶ��̺д�", "SBS", "�����", "���μ�", "������");
//		Drama drama2 = new Drama("����� ����", "MBC", "�ּ���");
//		Drama drama3 = new Drama("�� �ܿ�, �ٶ��̺д�", "KBS", "ǥ�μ�", "����", "�̴���");
//		Drama drama4 = new Drama("�� �ܿ�, �ٶ��̺д�", "KBS", "������", "null", "������");
		List<Drama> list = new ArrayList<Drama>();
		list.add(new Drama("�� �ܿ�, �ٶ��̺д�", "SBS", "�����", "���μ�", "������"));
		list.add(new Drama("����� ����", "MBC", "�ּ���"));
		list.add(new Drama("���̸���2", "KBS", "ǥ�μ�", "����", "�̴���"));
		list.add(new Drama("�ְ�� �̼���", "KBS", "������", null, "������"));

//		list.add(drama);
//		list.add(drama2);
//		list.add(drama3);
//		list.add(drama4);
		int len = list.size();
		for (int i = 0; i < len; i++) {
			System.out.println(list.get(i));
		}
	
	}

}
