<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    
    request.setCharacterEncoding("UTF-8"); 
    
    String id = request.getParameter("id2");
    String name = request.getParameter("name2");

    Thread.sleep(1*100);
    %>
    <%=id %>(<%=name %>)님 반갑습니다.
    
