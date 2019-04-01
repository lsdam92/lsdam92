package test;

import sun.management.Agent;

public class test2 {

	
	int basicprice = 1000;
	int price;
	int a;
		
	
	public int totalprice(int a) {
		
			
		 if (a <= 3) {
			price = (int) (basicprice * 0);
		
		} else if (a > 3 && a <= 13) {
			price = (int) (basicprice * 0.5);
			
		} else if (a > 13 && a <= 19) {
			price = (int) (basicprice * 0.75);
		} else {
			price = (int) (basicprice * 1);
		} return price;
		} 
	
	
	public static void main(String[] args) {

		test2 t2 = new test2();
		
		t2.totalprice(12);
		
		System.out.println(t2.a+ "\t 최종요금 : " + t2.totalprice(12));
		t2.totalprice(65);
		System.out.println(t2.a + "\t 최종요금 : " + t2.totalprice(65));
		t2.totalprice(3);
		System.out.println(t2.a + "\t 최종요금 : " + t2.totalprice(3));
		

	
	}
}
