<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul>
	<%
		String id = (String) session.getAttribute("loginInfo");
		if (id == null) { // 로그인 안했을때
	%>
	<li><a href="user/login.html">로그인</a></li>
	<li><a href="user/member.html">가입</a></li>


	<%
		} else { //로그인 했을때
	%>
	<li><a href="logout">로그아웃</a></li>
	<li><a href="productlist">전체상품</a></li>
	<li><a href="productlistjson">전체상품JSON</a></li>
	<li><a href="viewcart">장바구니보기</a></li>
	<%
		if (id != null) {
	%>
	<li><a href="vieworder">주문내역보기</a></li>
	<%
		}
	%>
	<%
		}
	%>
</ul>