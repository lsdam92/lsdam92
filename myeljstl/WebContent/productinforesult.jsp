<%@page import="com.kitri.dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
	Product p = (Product)request.getAttribute("productinfo");
	String no = p.getProd_no();
--%>
<c:set var = "p" value="${requestScope.productinfo}"/>
<c:set var = "no" value="${p.prod_no}"/>

<script>
$(function(){
	var $bt = $(".submit dl>dt>button");
	$bt.click(function() {
		$.ajax({
			url:'addcart',
			method:'get',
			data:
				'no=${no}&quantity='+$("input[name=quantity]").val(),
			success:function(result){
				$("div.addcartresult").remove();	//div의 class이름작성 후 .remove() 로 먼져 생성된 div를 지움
				$("section").append(result.trim());	//해당화면 section에 바로 띄움
			}
		});
		return false;
	});
});
</script>

<div >
	<div>
		<img src="images/${no}.jpg">
	</div>
	<div>
		<h4>${p.prod_name}</h4>
		<p>${p.prod_detail == null ? "" : p.prod_detail}</p>
		<div>
	<!-- <form action="addcart" method="get"> -->
		<input type="hidden" name="no" value="${no}">
			<ul>
				<li class="no">
					<dl>
						<dt>상품번호:</dt>
						<dd>${no}</dd>
					</dl>
				</li>
				<li class="name">
					<dl>
						<dt>가격:</dt>
						<dd><fmt:formatNumber value="${p.prod_price}" type="currency" currencySymbol="&#65510;"/>
					</dl>
				</li>
				
				<li class="quantity">
					<dl>
						<dt>수량:</dt>
						<dd>
							<input type="number" name="quantity" min="1" max="30">
						</dd>
					</dl>
				</li>
				<li class="submit">
					<dl>
						<dt><button>장바구니넣기</button></dt>
					</dl>
				</li>
			</ul>
	<!-- 	</form> -->
		</div>
	</div>
</div>