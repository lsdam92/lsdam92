package test;

public class test1 {

	public static void main(String[] args) {
		int age = 23;
		int basicprice = 1000;
		int price = 0;
		
		if(age <= 3) {
			price = (int)(basicprice * 0);
		}
		if(age > 3 && age <=13) {
			price = (int)(basicprice * 0.5);
		}
		if(age >13 && age <= 19) {
			price = (int)(basicprice * 0.75);
		}
		if(age >=20 && age<65) {
			price = (int)(basicprice * 1);
		}
		if(age >= 65){
			price = (int)(basicprice * 0);
		}
		
	System.out.println(age + "\t최종요금 : " + price);
		
	
	
	
	
	
	}
		
	}


