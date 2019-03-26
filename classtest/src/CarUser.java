public class CarUser {
	public static void main(String[] args) {
		Car car1 = null;  /*null 만들지않았다.*/
		car1 = new Car(); 
			System.out.println("1. 차이름 : " + car1.carName + "  색상 : " +car1.color  + "  제조사 : " + car1.maker);
		car1.carName = " 쏘나타";
		car1.color = "검정";
		car1.maker = "현대";
		System.out.println("2. 차이름 : " + car1.carName + "  색상 : " +car1.color  + "  제조사 : " + car1.maker);
	
		
	Car car2 =new Car(); //같은 new Car 이여도 각자 개체가 만들어진다.
	System.out.println("z. 차이름 : " + car2.carName + "  색상 : " +car2.color  + "  제조사 : " + car2.maker);
		car2.carName = "K5";
		car2.color = "흰색";
		car2.maker = "기아";
		System.out.println("zz. 차이름 : " + car2.carName + "  색상 : " +car2.color  + "  제조사 : " + car2.maker);
	
	Car car3 = new Car();
		car3.speedUp();
		car3.speedUp();
		car3.speedUp();
		car3.speedDown();
	 	System.out.println(" " +car3.speed);

		System.out.println("car1 : " + car1);
		System.out.println("car2 : " + car2);
		System.out.println("car3 : " + car3);
		
		System.out.println("최초 " + car1.carName + "의 속도 : " + car1.speed);
		System.out.println("car1의 속도를 8회증가!!!");
		
			car1.speedUp();
			car1.speedUp();
				
		System.out.println("car1의 속도 : " + car1.speed);
						
		for(int i = 0 ; i<8; i++){
			car1.speedUp();
		}
		System.out.println("8회 증가 후 " + car1.speed);
						
		for(int i = 0 ; i <10 ; i++){
			car1.speedDown();
					}
		System.out.println("car1의 속도 10회 감속속도 : " +car1.speed);

	}
}
