package com.kitri.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatTest {

	public static void main(String[] args) {
//		2019.03.26 14:25:30
		Date date = new Date();
		System.out.println(date);
		
		Format f = new SimpleDateFormat("yyyy년.MM월.dd일 HH시:mm분:ss초");
		String today = f.format(date);
		System.out.println(today);

	}

}
