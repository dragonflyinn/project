<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
<style>
	#userListArea{
		width : 400px;
		border : 1px solid gray;
		margin : auto;
	}
	table{
		width : 380px;
		margin : auto;
		text-align: center;
	}
</style>
</head>
<body>
<section id = "userListArea">
<table>
	<tr>
		<td colspan=2><h1>회원 목록</h1></td>
	</tr>
	<c:forEach var = "user" items = "${userList}">
	<tr>
		<td>
			<a href="UserViewAction.me?id=${user.user_id}">
				${user.user_id}
			</a>
		</td>
		<td>
		<a href="UserDeleteAction.me?id=${user.user_id}">삭제</a>
		</td>
	</tr>
	</c:forEach>
</table>
</section>
</body>
</html>