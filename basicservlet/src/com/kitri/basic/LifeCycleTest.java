package com.kitri.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/life")
public class LifeCycleTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LifeCycleTest() {
		System.out.println("생성자 호출!!");
	}

	//초기화작업은 init()에서.
	@Override
	public void init() throws ServletException {
		System.out.println("init() 호출!!");
	}	
	//WAS가 client당 하나의thread를 만든다,socket까지 알아서 처리
	//client 실행시 매번 실행됨.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 호출!!");
	}

	//서버가 끝날때, 닫을때
	@Override
	public void destroy() {
		System.out.println("destory() 호출!!");
	}
	

}
