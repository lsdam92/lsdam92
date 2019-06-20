<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include.jsp</title>
</head>
<body>
 <h3>포함 지시자</h3><!-- 변하지 않는 똑같은 값일 때 사용-->
 <%@include file="loginresult.jsp" %>
 <hr>
 <h3>포함태그</h3>
 <jsp:include page="loginresult.jsp"/><!--동적인 상황에 사용   -->
</body>
</html>