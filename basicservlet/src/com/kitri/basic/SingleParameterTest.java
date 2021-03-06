package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/singleparam")
public class SingleParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.data get
//		byte b[] = name.getBytes("iso-8859-1"); 한글이 깨질때 
//		name = new String(b, "euc-kr");
		
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		
//		2. logic
		String color = age == 10 ? "pink" : "cyan";
		
//		3.response page : 안효인(java2)님 안녕하세요. 성인 id blue 10대 red
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println(name + "(<font color=\"" + color + "\">" + id + "</font>)님 안녕하세요.");
		out.println("	</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.data get
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("name");
		String id = request.getParameter("id");
		int age = Integer.parseInt(request.getParameter("age"));
		
//		2. logic
		String color = age == 10 ? "pink" : "cyan";
		
//		3.response page : 안효인(java2)님 안녕하세요. 성인 id blue 10대 red
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println(name + "(<font color=\"" + color + "\">" + id + "</font>)님 안녕하세요.");
		out.println("	</body>");
		out.println("</html>");
	}

}
