package com.kitri.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ggd")
public class Gugudan extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	String color;
	String clear;
  
	@Override
	public void init() throws ServletException {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<style type=\"text/css\">");
		out.println(".item {"
				+ "border: 3px solid;"
				+ "float: left;"
				+ "width:100px;"
				+ "height:30px;"
				+ "}"
				+ ".container{"
				+ "width:900px;"
				+ "height:350px;"
				+ "margin: 0 auto;"
				+ "padding:10px;"
				+ "}");
		out.println("</style>");
		out.println("<html>");
		out.println("	<body>");
		out.println("	<h3>***구구단***</h3>");
		out.println("<div class=container align=center>");
		for(int i=1;i<10;i++) {
			for(int j=2;j<10;j++) {		
					color = j % 2 == 0  ? "pink" : "steelblue";
					out.println("<div class=item style=\"background-color:"+color+"\" clear:"+clear+"\">" + j + " * " + i +" = " + i*j +"</div>");		
			}		
		}
		out.println("</div>");
		out.println("	</body>");
		out.println("</html");
	}

	
}
