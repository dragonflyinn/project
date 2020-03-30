<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
<style>
#userListArea {
	width: 400px;
	border: 1px solid gray;
	margin: auto;
}

table {
	width: 380px;
	margin: auto;
	text-align: center;
}
</style>
</head>
<body>
	<section id="userListArea">
		<table>
			<tr>
				<td colspan=2><h1>회원 목록</h1></td>
			</tr>
			<c:forEach var="user" items="${userList}">
				<tr>
					<td><a href="adminViewAction.admin?id=${user.user_id}">
							${user.user_id} </a></td>
					<td><a href="adminInfoModifyAction.admin?id=${user.user_id}">수정</a>&nbsp;
						<a href="adminDeleteAction.admin?id=${user.user_id}">삭제</a></td>
				</tr>
			</c:forEach>
			<!-- 반복 -->
			<tr>
				<td><a href="main.me">메인으로 돌아가기</a></td>
			</tr>
		</table>
	</section>
</body>
</html>