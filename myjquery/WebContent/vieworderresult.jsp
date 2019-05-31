<%@page import="com.kitri.dto.Product"%>
<%@page import="com.kitri.dto.OrderLine"%>
<%@page import="java.util.Date"%>
<%@page import="com.kitri.dto.OrderInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<style>
	div.vieworder>table, div.vieworder>table th,
	div.vieworder>table td {
	border:1px solid;
	}
	table {
	text-align: center;
	width:80%;
	margin: 0 auto;
	}
	</style>
<div class="vieworder">
	<h3 style="text-align: center;">주문내역보기</h3>
	<table>
		<tr>
			<th>주문번호</th>
			<th>주문일자</th>
			<th>주문상품번호</th>
			<th>상품명</th>
			<th>가격</th>
			<th>주문수량</th>
		</tr>
		<%
			List<OrderInfo> list = (List) request.getAttribute("orderlist");

			for (OrderInfo info : list) {
		%>
		<tr>
			<%
				int order_no = info.getOrder_no();//주문번호
					Date order_dt = info.getOrder_dt();//주문일자
					List<OrderLine> lines = info.getLines();
			%>
			<td rowspan="<%=lines.size()%>"><%=order_no%></td>
			<td rowspan="<%=lines.size()%>"><%=order_dt%></td>
			<%
				for (OrderLine line : lines) {

						Product p = line.getProduct();
						String prod_no = p.getProd_no();//상품번호
						String prod_name = p.getProd_name();//상품명
						int prod_price = p.getProd_price();//가격
						int prod_quantity = line.getOrder_quantity();//수량
			%>
			<td><%=prod_no%></td>
			<td><%=prod_name%></td>
			<td><%=prod_price%></td>
			<td><%=prod_quantity%></td>

		</tr>
		<%
			} //end line

			} //end for
		%>
	</table>
</div>