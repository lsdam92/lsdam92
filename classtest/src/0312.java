/*�ڷ���
����
������
���(����, �ݺ�)

** ��ü(Object)
class : class�� ��ü�� �����ϱ� ���� Ʋ.


						Object(class) : �ڵ���(Car) //class�� ������ ����


		�Ӽ�(Ư¡/field)			���(method)
		----------------------------------------
		���̸�(carName)					����(speedUp)
		����(color)						����(speedDown)
		������(maker)					����(stop)
		�ӵ�(speed)

** method : �Լ�, ���, �ൿ
����)
���������� ReturnType methodName([args]){
		���๮;
		���๮;
		���๮;
		���๮;
		���๮;
		return ��;
}
- ReturnType : ���� ����� data type  // ���� ���� : int type ���ڿ� : string type
				return�� ���� ���� ��� : void

**class 
����������/*public/default*/ /*class ClassName{

	�Ӽ� 

	---------------------------
	�޼ҵ�

}

 Class�� ���. (������(reference) Data Type)
1. ����
	����)
	���������� ClassName ��ü��(������);
	��)
	public String carName;
	private Car car;  //class�̸��� ��ü�̸�����
	GBB gbb;
2. ����
	����)
	��ü�� = new ClassName();          //**ClassName : �����ڸ�
	carName = new String ("�Ÿ")
	car = new Car();
	gbb = new GBB;
		>>>>>>>>> 1, 2 ���ÿ�
		���������� Class Name ��ü�� = new ClassName();
		public String carName = new String("�Ÿ");
		private Car car = new Car();
		GBB gbb = new GBB();

3. ���
   ����)
   ��ü��.����; // get
   ��ü��.���� = ��; //set
   ��ü��.method();
   ��)
	int len = carName.length();
	car.speed = 100;
	System.out.println(car.speed);//100 ���
	gbb.game();


** ������(Constructor)
1. ��ü ������ ���ʷ� ȣ��. ��, new �����ڿ� �Բ� ȣ��.
2. ��ü ������ ��ü�� �ʱ�ȭ �۾�.
3. ����� ���� �����ڰ� ���� ��� default �����ڰ� �����Ǿ� �ִ�.
	D C : public ClassName()
	����� ���� �����ڸ� �ϳ� �̻󸸵��� default�����ڴ� �������.
4. Class�� �̸��� ���� method�� ����.
   Return Type�� ����.
   ����)
   ���������� ClassName([args]) {

}
5. method overloading ( �������� ) //�������� �����.
	���� �̸��� method�� ������ ���� �ϴ°�.
	��, ���ڰ��� ������ �ٸ��ų�
				 Ÿ���� �޶�� �Ѵ�.
	��)
	public void a() {}
	public void a() {}					// x
	public void a(int x) {}				// o
	public void a(int y) {}				// x  int x �� Ÿ���� �����Ƿ� x
	public int a() {}					// x  int x �� Ÿ���� �����Ƿ� x
	public void a(int x, String s) {}   // o  ���� + ����
	public void a(int x, int y) {}		// o
	public void a(String s m int y) {}  // o ���� + ���� 

6. this		: �ڱ�Ŭ���� ��������
   super	: ����Ŭ���� ��������
   
   this()	: �ڱ�Ŭ���� ������ ȣ��
   super()	: ����Ŭ���� ������ ȣ��*/








