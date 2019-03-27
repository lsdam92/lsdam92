package com.kitri.util;


import java.text.DecimalFormat;
import java.text.Format;

public class NumberFormatTest {

	public static void main(String[] args) {
		double number = 34563242365453.126;
//		34,563,242,365,453.13
	
		Format f = new DecimalFormat("##,###,###,###,###.##");
		String d = f.format(number);
		System.out.println(d);
	
	
	}

}
