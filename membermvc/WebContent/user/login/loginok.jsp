<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.kitri.member.model.MemberDto,com.kitri.util.MoveUrl"%>
<%@ include file="/template/header.jsp"%>

<%
MemberDto memberDto = (MemberDto) session.getAttribute("userInfo");

if(memberDto != null){
%>
<script>
function deletemember() {
	if(confirm("정말 탈퇴?")){
		document.location.href = "<%=root%>/user?act=deletmember";
		}
	}
</script>
<strong><%=memberDto.getName() %>님 안녕하세요.</strong>
<a href="<%=root%>/user?act=loginout">로그아웃</a>
<a href="<%=root%>/user?act=mvmodify">정보수정</a>
<a href="#" onclick="javascript:deletemember();">회원탈퇴</a>
<%
		if("SOdam".equals(memberDto.getId())){
%>
		<a href="<%=root%>/admin?act=memberlist">관리자</a>
<%
		}else{
		MoveUrl.redirect(request, response, "/user?act=mvlogin");
		}

	}else{
		MoveUrl.redirect(request, response, "/user?act=mvlogin");
	}
 %>
<%@ include file="/template/footer.jsp"%>