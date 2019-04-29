/*자료형
변수
연산자
제어문(조건, 반복)

** 객체(Object)
class : class는 객체를 생성하기 위한 틀.


						Object(class) : 자동차(Car) //class를 가지고 생성


		속성(특징/field)			기능(method)
		----------------------------------------
		차이름(carName)					가속(speedUp)
		색상(color)						감속(speedDown)
		제조사(maker)					정지(stop)
		속도(speed)

** method : 함수, 기능, 행동
형식)
접근제어자 ReturnType methodName([args]){
		실행문;
		실행문;
		실행문;
		실행문;
		실행문;
		return 값;
}
- ReturnType : 실행 결과의 data type  // 값이 숫자 : int type 문자열 : string type
				return할 값이 없을 경우 : void

**class 
접근제어자/*public/default*/ /*class ClassName{

	속성 

	---------------------------
	메소드

}

 Class의 사용. (참조형(reference) Data Type)
1. 선언
	형식)
	접근제어자 ClassName 객체명(변수명);
	예)
	public String carName;
	private Car car;  //class이름이 객체이름가능
	GBB gbb;
2. 생성
	형식)
	객체명 = new ClassName();          //**ClassName : 생성자명
	carName = new String ("쏘나타")
	car = new Car();
	gbb = new GBB;
		>>>>>>>>> 1, 2 동시에
		접근제어자 Class Name 객체명 = new ClassName();
		public String carName = new String("쏘나타");
		private Car car = new Car();
		GBB gbb = new GBB();

3. 사용
   형식)
   객체명.변수; // get
   객체명.변수 = 값; //set
   객체명.method();
   예)
	int len = carName.length();
	car.speed = 100;
	System.out.println(car.speed);//100 출력
	gbb.game();


** 생성자(Constructor)
1. 객체 생성시 최초로 호출. 단, new 연사자와 함께 호출.
2. 객체 생성시 객체의 초기화 작업.
3. 사용자 정의 생성자가 없을 경우 default 생성자가 생략되어 있다.
	D C : public ClassName()
	사용자 정의 생성자를 하나 이상만들경우 default생성자는 사라진다.
4. Class의 이름과 같은 method의 일종.
   Return Type이 없다.
   형식)
   접근제어자 ClassName([args]) {

}
5. method overloading ( 다중정의 ) //여러개를 만든다.
	같은 이름의 method를 여러개 정의 하는것.
	단, 인자값의 갯수가 다르거나
				 타입이 달라야 한다.
	예)
	public void a() {}
	public void a() {}					// x
	public void a(int x) {}				// o
	public void a(int y) {}				// x  int x 와 타입이 같으므로 x
	public int a() {}					// x  int x 와 타입이 같으므로 x
	public void a(int x, String s) {}   // o  숫자 + 문자
	public void a(int x, int y) {}		// o
	public void a(String s m int y) {}  // o 문자 + 숫자 

6. this		: 자기클래스 참조변수
   super	: 상위클래스 참조변수
   
   this()	: 자기클래스 생성자 호출
   super()	: 상위클래스 생성자 호출*/








