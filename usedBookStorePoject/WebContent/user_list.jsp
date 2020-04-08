<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<style>
	#userListArea{
		width : 400px;
		margin : auto;
		border : 1px solid #e0f1f2;
		border-radius : 20px 20px 20px 20px;
		background: #e0f1f2;
	}
	table{
		width : 380px;
		margin : auto;
		text-align: center;
	}
	button {
	text-align: center;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 20px;
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
			<a href="userViewAction.me?id=${user.user_id}">
				${user.user_id}
			</a>
		</td>
		<td>
		<button type="button" onclick="location.href='userInfoModifyAction.me?id=${user.user_id} %>'">수정</button>
		<button type="button" onclick="location.href='userDeleteAction.me?id=${user.user_id} %>'">삭제</button>
		</td>
	</tr>
	</c:forEach>
	<tr>
		<button type="button" onclick="location.href='main.me'">메인</button>
	</tr>
</table>
</section>
</body>
</html>