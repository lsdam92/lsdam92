<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
int totalCnt;
int starSum;
%>
<%
totalCnt++;
int star = Integer.parseInt(request.getParameter("star"));
starSum += star;
%>

참여자 수 : <%=totalCnt%>
총 별점   :  <%=starSum%>