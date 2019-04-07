package com.kitri.jdbc.v5;

public class UserDaoTest { // 사실상 UserService 클래스 (비즈니스 로직 단계에서 어떤 커넥션을 쓸지 결정한다)
	public static void main(String[] args) {
		ConnectionMaker connectionMaker = new OracleConnectionMaker();
		
		UserDao dao = new UserDao(connectionMaker);
		
		//dao의 메소드를 활용하여 비즈니스 로직을 구현
	}
}
