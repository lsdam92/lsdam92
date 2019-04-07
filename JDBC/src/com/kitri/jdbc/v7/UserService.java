package com.kitri.jdbc.v7;

import java.sql.SQLException;

public class UserService { // 이제 비즈니스 로직 단계에서 어떤 커넥션을 쓸지 결정하지 않는다. 단순히 daofactory의 메소드를 호출하기만 하면 되기 때문이다
							// 그리고 이제 UserService와 Test 클래스를 나누겠다
	private UserDto user = new UserDto();
	private UserDao dao = new DaoFactory().userDao();

	public void addUser(UserDto user) throws ClassNotFoundException, SQLException {
		dao.add(user);
		System.out.println(user.getId() + "등록 성공");
	}

	public UserDto getUser(String id) throws ClassNotFoundException, SQLException {
		UserDto user = dao.get(id);
		System.out.println(user.getName());
		System.out.println(user.getPassword());
		return user;
	}
}