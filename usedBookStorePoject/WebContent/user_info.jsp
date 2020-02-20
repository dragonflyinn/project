<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
		<td>${user.user_id }</td>
	</tr>
	<tr>
		<td>비밀번호 : </td>
		<td>${user.user_password}</td>
	</tr>
	<tr>
		<td>이메일 주소 : </td>
		<td>${user.user_email}</td>
	</tr>
	<tr>
		<td> 회원 등급 : </td>
		<td>${user.user_grade}</td>
	</tr>
	<tr>
		<td colspan=2>
			<a href="UserListAction.me">리스트로 돌아가기</a>
		</td>
	</tr>
</table>
</section>
</body>
</html>