package com.kitri.test5;

public class SonataArrayTest {

	
	public static void main(String[] args) {
	Drama car1[] = new Drama[4];
	int len = car1.length;
	for (int i = 0; i < len; i++) {
		car1[0] = new Drama("흰색", 5000, "승용", "NF");
		car1[1] = new Drama("은색", 7000, "업무", "Brilliant");
		car1[2] = new Drama("감홍색", 4000, "택시", "EF");
		car1[3] = new Drama("검정색", 6000, "승용", "Hybrid");
			
	}
	System.out.println("=================Sonata 생산 시작==================\n"+
						car1[0]+"\n"+car1[1]+"\n"+car1[2]+"\n"+car1[3]);
	
	
}
}
