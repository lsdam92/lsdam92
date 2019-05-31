<%@page import="com.kitri.dto.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>usebean.jsp</title>
</head>
<body>
<%--
//1.request의 속성 ( 이름: " C " , 타입: com.kitri.dto.customer) 얻기
Customer c= (Customer)request.getAttribute("c");

//2.1의속성이 null인경우
//	Customer객체생성하여 c참조변수에 대입
//	c참조변수를 requset의 속성(이름:"c")로 추가
	if(c == null){
		c = new Customer();
		request.setAttribute("c", c);
	}

--%>
<jsp:useBean id="c" class="com.kitri.dto.Customer" scope="request"/>

<%--
c.setId("id1");
--%>
<jsp:setProperty property="id" name="c" value="id1"/>

<%--
c.setName(request.getParameter("n"));
 --%>
 <jsp:setProperty property="name" name="c" param="n"/>
 
 <%--= c.getId() --%>
 <jsp:getProperty property="id" name="c"/>
</body>
</html>