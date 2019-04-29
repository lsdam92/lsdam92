package com.kitri.util;


import java.util.*;

public class CalendarTest {

	public static void main(String[] args) {

		//2019�� 03�� 27�� ���� 1�� 17�� 35��
		
//		Calendar c = new GregorianCalendar();
		Calendar c =  Calendar.getInstance();
	
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH)+1;
		int d = c.get(Calendar.DATE);
		int apm = c.get(Calendar.AM_PM);
		int h = c.get(Calendar.HOUR);
		int mi = c.get(Calendar.MINUTE);
		int si = c.get(Calendar.SECOND);
		
		System.out.println(y + "��" + zeroPlus(m)+ "��" +
				zeroPlus(d) + "��"+ (apm == 0 ? "����" : "����") +"" +
				zeroPlus(h) + "��" + zeroPlus(mi) + "��" + zeroPlus(si) + "��");
		
		Date date = new Date();
		System.out.println(date.toString());
	}

	private static String zeroPlus(int num) {	//�ڽ��� �������� ����������� static
		return num<10 ? "0" + num : ""+num;
	}
	
}
