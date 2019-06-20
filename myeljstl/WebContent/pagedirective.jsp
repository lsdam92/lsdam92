<%@page import="java.io.FileInputStream"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page buffer="100kb" %>
<%@page errorPage = "err.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pagedirective.jsp</title>
</head>
<body>
  
<% 
//1부터 10000까지 출력
for(int i=1;i<=10000;i++){%>
<%=i %>
<%	
}
%>

<%
FileInputStream fis=null;
fis = new FileInputStream("a.txt");
%>


</body>
</html>