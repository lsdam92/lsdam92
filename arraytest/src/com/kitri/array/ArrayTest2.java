package com.kitri.array;

public class ArrayTest2 {

	public static void main(String[] args) {
		Car car[] = new Car[6];

		int len = car.length;
		for (int i = 0; i < len; i++) {
			car[0] = new Car("�ƹݶ�", "ȸ��", "����");
			car[1] = new Car("K5", "���", "���");
			car[2] = new Car("SM5", "����", "�Ｚ");
			car[3] = new Car("�Ͼ��", "��ѱ��", "����");
			car[4] = new Car("�ƹݶ�", "���", "����");
			car[5] = new Car("��Ÿ��", "������", "����");
//			System.out.println(i + 1 + "��°���� : " + car[i]);

		}
//			String name = "�Ͼ��";
		String name = "QM5";
		Car findCar = null;
		int count = 0;
		for (int i = 0; i < len; i++) {
			if (name.equals(car[i].getCarName())) {
				findCar = car[i];
				count = i +1;
				break; // ù��°�� ã����� �������� ã���ʰ����ش�
			}
		}
		
		if (findCar != null) {
				System.out.println(findCar.getColor() + " " + findCar.getCarName() + "(" + findCar.getMaker() + ")��"
						+ (count) + "��°������ �ֽ��ϴ�.");
		}else {
			System.out.println(name + "�� �����ϴ�.");
		}
		// ��ѱ�� �Ͼ��(���)�� 5��°�� �ֽ��ϴ�.
		// QM5�� �����ϴ�.
	}

}
