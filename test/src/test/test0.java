package test;

public class test0 {

	public static void main(String[] args) {

		int t = (int) (Math.random() * 30);
		int y = (int) (Math.random() * 30);
		int z = (int) (Math.random() * 30);
		System.out.println("t : " + t);
		System.out.println("y : " + y);
		System.out.println("z : " + z);
		System.out.println("-------------------");
		if (t > y && t > z) {
			System.out.println("최대값은 t : " + t);
		} else if (y > t && y > z) {
			System.out.println("최대값은 y : " + y);
		} else {
			System.out.println("최대값은 z : " + z);
		}

	}

}
