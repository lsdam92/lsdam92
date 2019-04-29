package com.kitri.util;


import java.util.*;

public class CalendarTest {

	public static void main(String[] args) {

		//2019년 03월 27일 오후 1시 17분 35초
		
//		Calendar c = new GregorianCalendar();
		Calendar c =  Calendar.getInstance();
	
		int y = c.get(Calendar.YEAR);
		int m = c.get(Calendar.MONTH)+1;
		int d = c.get(Calendar.DATE);
		int apm = c.get(Calendar.AM_PM);
		int h = c.get(Calendar.HOUR);
		int mi = c.get(Calendar.MINUTE);
		int si = c.get(Calendar.SECOND);
		
		System.out.println(y + "년" + zeroPlus(m)+ "월" +
				zeroPlus(d) + "일"+ (apm == 0 ? "오전" : "오후") +"" +
				zeroPlus(h) + "시" + zeroPlus(mi) + "분" + zeroPlus(si) + "초");
		
		Date date = new Date();
		System.out.println(date.toString());
	}

	private static String zeroPlus(int num) {	//자신이 보낸것을 돌려받을경우 static
		return num<10 ? "0" + num : ""+num;
	}
	
}
