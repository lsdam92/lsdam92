public class Car {
	
	String carName;					//전역변수
	String color;
	String maker;
	int speed;
	//public Car() {} default생성자가 생략되어있다.
		
	public void speedUp(){		//
			speed += 10;						//지역변수
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