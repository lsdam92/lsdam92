package com.kitri.test6;

import java.util.ArrayList;
import java.util.List;



public class DramaListTest {

	public static void main(String[] args) {
		Drama dr[] = new Drama[4];
		int len = dr.length;
//		for (int i = 0; i < len; i++) {
//			dr[0] = new Drama("�� �ܿ�, �ٶ��̺д�", "SBS", "�����", "���μ�", "������");
//			dr[1] = new Drama("����� ����", "MBC", "�ּ���", "", "");
//			dr[2] = new Drama("���̸���2", "KBS", "ǥ�μ�", "����", "�̴���");
//			dr[3] = new Drama("�ְ�� �̼���", "KBS", "������", "", "������");
//			System.out.println(dr[i]);
//		}	
		List<Drama> list = new ArrayList<Drama>();
//		list.add("�� �ܿ�, �ٶ��̺д�", "SBS", "�����", "���μ�", "������");
//		list.add("����� ����", "MBC", "�ּ���", "", "");
//		list.add("���̸���2", "KBS", "ǥ�μ�", "����", "�̴���");
//		list.add("�ְ�� �̼���", "KBS", "������", "", "������");
		len = dr.length;
		for (int i = 0; i < len; i++) {
			System.out.println(list.get(i));
		}
	
	}

}
