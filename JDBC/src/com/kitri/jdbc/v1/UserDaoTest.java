package com.kitri.jdbc.v1;

import java.sql.SQLException;

class UserDaoTest {	// UserService와 같은 의미 
							// 데이터 포맷(한마디로 스트링버퍼랑 비슷한 역할??)은 dto 클래스가
							// 데이터 조회 및 조작은 dao 클래스가
							// 애플리케이션의 비즈니스로직은 service 클래스가 각각 담당한다
							// 서로 집중하는 일이 다르기 때문에 클래스를 나누어 구현하면 코드의 수정이 용이하고
							// 재사용성이 크게 증가한다
	static void main(String[] args) throws ClassNotFoundException, SQLException {
		UserDao dao = new UserDao();
		UserDto user = new UserDto();
		user.setId("testid");
		user.setName("testname");
		user.setPassword("testpass");
		
		dao.add(user);
		
		System.out.println(user.getId() + "등록 성공");
		
		UserDto user2 = dao.get(user.getId());
		System.out.println(user2.getName());
		System.out.println(user2.getPassword());
		
		System.out.println(user2.getId() + "조회 성공");
	}

}
