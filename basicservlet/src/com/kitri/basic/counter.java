package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/counter")
public class counter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int cnt;
	int totallen;
	
	@Override
	public void init() {
		cnt =0;
		totallen = 8;
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		cnt++;
		
//		String count = Integer.toString(cnt);
		String count = cnt + "";
		int len = count.length();
		int zerolen = totallen -len; 
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("	<body>");
		out.println("당신은");
//		for(int i=0;i<8-len;i++) {
//			out.println("<img src=\"/basicservlet/img/0.PNG\">");
//		}
		
		//totallen을 이용하여 숫자가 클경우 유동적이게 한다
		for(int i=0;i<zerolen;i++) {
			out.println("<img src=\"/basicservlet/img/0.PNG\">");
		}
		for(int i= 0;i<len;i++) {
			out.println("<img src=\"/basicservlet/img/"+count.charAt(i)+".PNG\">");
		}

		
		out.println("번째 방문자입니다.");
		out.println("	</body>");
		out.println("</html>");
	}

	

}
