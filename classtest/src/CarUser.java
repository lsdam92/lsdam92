public class CarUser {
	public static void main(String[] args) {
		Car car1 = null;  /*null �������ʾҴ�.*/
		car1 = new Car(); 
			System.out.println("1. ���̸� : " + car1.carName + "  ���� : " +car1.color  + "  ������ : " + car1.maker);
		car1.carName = " �Ÿ";
		car1.color = "����";
		car1.maker = "����";
		System.out.println("2. ���̸� : " + car1.carName + "  ���� : " +car1.color  + "  ������ : " + car1.maker);
	
		
	Car car2 =new Car(); //���� new Car �̿��� ���� ��ü�� ���������.
	System.out.println("z. ���̸� : " + car2.carName + "  ���� : " +car2.color  + "  ������ : " + car2.maker);
		car2.carName = "K5";
		car2.color = "���";
		car2.maker = "���";
		System.out.println("zz. ���̸� : " + car2.carName + "  ���� : " +car2.color  + "  ������ : " + car2.maker);
	
	Car car3 = new Car();
		car3.speedUp();
		car3.speedUp();
		car3.speedUp();
		car3.speedDown();
	 	System.out.println(" " +car3.speed);

		System.out.println("car1 : " + car1);
		System.out.println("car2 : " + car2);
		System.out.println("car3 : " + car3);
		
		System.out.println("���� " + car1.carName + "�� �ӵ� : " + car1.speed);
		System.out.println("car1�� �ӵ��� 8ȸ����!!!");
		
			car1.speedUp();
			car1.speedUp();
				
		System.out.println("car1�� �ӵ� : " + car1.speed);
						
		for(int i = 0 ; i<8; i++){
			car1.speedUp();
		}
		System.out.println("8ȸ ���� �� " + car1.speed);
						
		for(int i = 0 ; i <10 ; i++){
			car1.speedDown();
					}
		System.out.println("car1�� �ӵ� 10ȸ ���Ӽӵ� : " +car1.speed);

	}
}
