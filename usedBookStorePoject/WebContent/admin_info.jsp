<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<title>회원관리 시스템 관리자모드(회원 정보 보기)</title>
<style>
	#userInfoArea{
		width : 400px;
		margin : auto;
		border : 1px solid gray;
	}
	table{
		width : 380px;
		margin : auto;
		text-align: center;
	}
</style>
</head>
<body>

<section id = "userInfoArea">
<table>
	<tr>
		<td>아이디 : </td>
		<td>${viewUser.user_id }</td>
	</tr>
	<tr>
		<td>이메일 주소 : </td>
		<td>${viewUser.user_email}</td>
	</tr>
	<tr>
		<td> 회원 등급 : </td>
		<td>${viewUser.user_grade}</td>
	</tr>
	<tr>
		<td colspan=2>
			<a href="main.me">메인페이지</a>&nbsp;&nbsp;
			<a href="adminInfoModifyAction.admin?id=${user.user_id}">수정</a>
		</td>
	</tr>
</table>
</section>
</body>
</html>
