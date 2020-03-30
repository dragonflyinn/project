<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정(일반 회원 모드)</title>

<script type="text/javascript">
	function modifyboard() {
		modifyform.submit();
	}
</script>

<style type="text/css">
#userInfoArea {
	width: 400px;
	margin: auto;
	border: 1px solid gray;
}

table {
	width: 380px;
	margin: auto;
	text-align: center;
}
</style>
</head>

<body>
	<section id="userInfoArea">
		<form
			action="${pageContext.request.contextPath }/userInfoModifyProAction.me"
			method="post" name="modifyform">
			<input type="hidden" name="user_id" value="${user.user_id }">
			<table>
				<tr>
					<td>아이디 :</td>
					<td>${user.user_id }</td>
				</tr>

				<tr>
					<td><label for="user_email">이메일 주소 : </label></td>
					<td><input type="text" name="user_email" id="user_email" /></td>
				</tr>

				<tr>
					<td colspan=2><a href="main.me">메인페이지</a>&nbsp;&nbsp; <a
						href="javascript:modifyboard()">수정</a></td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>