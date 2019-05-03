package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/multiparam")
public class MultiParameterTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1.date get
		String name = request.getParameter("name");
		String id =request.getParameter("id");
		int age =Integer.parseInt(request.getParameter("age"));
		String[] fruit = request.getParameterValues("fruit");
//		2.logic
		String color = age == 10 ? "pink" : "cyan";
		String likefruit = "";
		if(fruit != null) {
			int len = fruit.length;
		for(int i=0;i<len-1;i++)
			likefruit += fruit[i] + ", ";
			likefruit += fruit[len-1];	
			likefruit += "입니다.";
		}else {
			likefruit += "없습니다.";
		}

		

//		3.response page
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println(name + "<font color=\""+color+"\">"+id+ "</font>님 안녕하세요");
		out.println("당신이 좋아하는 과일은"+likefruit);
		out.println("	</body>");
		out.println("</html>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
