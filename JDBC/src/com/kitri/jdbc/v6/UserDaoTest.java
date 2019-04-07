package com.kitri.jdbc.v6;

import java.sql.SQLException;

public class UserDaoTest { // 사실상 UserService 클래스 (비즈니스 로직 단계에서 어떤 커넥션을 쓸지 결정한다)
	private UserDto user = new UserDto();
	private static UserDao dao;
	public static void main(String[] args) {
//		ConnectionMaker connectionMaker = new OracleConnectionMaker();
		
		dao = new DaoFactory().userDao();
		
		//dao의 메소드를 활용하여 비즈니스 로직을 구현
	}

		private void addTest() throws ClassNotFoundException, SQLException {
		user.setId("testid");
		user.setName("testname");
		user.setPassword("testpass");
		
		dao.add(user);
		
		System.out.println(user.getId() + "등록 성공");
		}
		private void selectTest() throws ClassNotFoundException, SQLException {
		UserDto user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + "조회 성공");
		}
}
