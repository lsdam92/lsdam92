package com.kitri.test5;

public class SonataArrayTest {

	
	public static void main(String[] args) {
	Drama car1[] = new Drama[4];
	int len = car1.length;
	for (int i = 0; i < len; i++) {
		car1[0] = new Drama("���", 5000, "�¿�", "NF");
		car1[1] = new Drama("����", 7000, "����", "Brilliant");
		car1[2] = new Drama("��ȫ��", 4000, "�ý�", "EF");
		car1[3] = new Drama("������", 6000, "�¿�", "Hybrid");
			
	}
	System.out.println("=================Sonata ���� ����==================\n"+
						car1[0]+"\n"+car1[1]+"\n"+car1[2]+"\n"+car1[3]);
	
	
}
}
