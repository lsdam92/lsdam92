public class Car {
	
	String carName;					//��������
	String color;
	String maker;
	int speed;
	//public Car() {} default�����ڰ� �����Ǿ��ִ�.
		
	public void speedUp(){		//
			speed += 10;						//��������
	}
	
	public void speedDown(){
			speed -= 10;
			if(speed < 0)
			stop();	//speed = 0;
	}
	public void stop(){
			speed = 0;
	}	
}