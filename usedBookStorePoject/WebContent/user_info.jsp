<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="checkUser.jsp"/>
<%
	UserBean user=(UserBean)session.getAttribute("user");
	if(user.getUser_id()!=null){
	
	}else{
		out.println("<script>");
		out.println("alert('로그인을 하세요!!');");
		out.println("location.href='loginForm.jsp';");
		out.println("</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 시스템 (회원 정보 보기)</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<style>
	#userInfoArea{
		margin : auto;
		width : 400px;
		border : 1px solid #e0f1f2;
		border-radius : 20px 20px 20px 20px;
		background: #e0f1f2;
	}
	
	table{
		width : 280px;
		margin : auto;
		text-align: center;
	}
	
	button {
		text-align: center;
		font-family: 'Nanum Pen Script', cursive;
		font-size: 20px;
	}
	.style1 {
		text-align: center;
		font-family: 'Nanum Pen Script', cursive;
		font-size: 25px;
	}
</style>
</head>
<body>

<section id = "userInfoArea">
<table>
	<tr><td><br></td></tr>
	<tr>
		<td class="style1">아이디 : </td>
		<td>${viewUser.user_id }</td>
	</tr> 
	<tr>
		<td class="style1">이메일 : </td>
		<td>${viewUser.user_email}</td>
	</tr>
	<tr><td><br></td></tr>
	<tr>
		<td colspan=2>
		<button type="button" onclick="location.href='main.me'">메인페이지</button>
		<button type="button" onclick="location.href='userInfoModifyAction.me?id=${user.user_id}'">수정</button>
			<!-- <a href="main.me">메인페이지</a>&nbsp;&nbsp;
			<a href="userInfoModifyAction.me?id=${user.user_id}">수정</a>-->
		</td>
	</tr>
	<tr><td><br></td></tr>
</table>
</section>
</body>
</html>