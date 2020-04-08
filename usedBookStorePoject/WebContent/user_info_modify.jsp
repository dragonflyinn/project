<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정(일반 회원 모드)</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">

<script type="text/javascript">
	function modifyboard() {
		modifyform.submit();
	}
</script>

<style type="text/css">
#userInfoArea {
	width: 400px;
	margin: auto;
	border-radius : 20px 20px 20px 20px;
	background: #e0f1f2;
}

table {
	width: 380px;
	margin: auto;
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
	<section id="userInfoArea">
		<form
			action="${pageContext.request.contextPath }/userInfoModifyProAction.me"
			method="post" name="modifyform">
			<input type="hidden" name="user_id" value="${user.user_id }">
			<table>
				<tr><td><br></td></tr>
				<tr>
					<td class="style1">아이디 :</td>
					<td>${user.user_id }</td>
				</tr>

				<tr>
					<td class="style1"><label for="user_email">이메일 주소 : </label></td>
					<td><input type="text" name="user_email" id="user_email" /></td>
				</tr>

				<tr><td><br></td></tr>
				<tr>
				<td colspan=2>
				<button type="button" onclick="location.href='userViewAction.me'">이전</button>
				<button onclick="javascript:modifyboard()">수정</button>
				</td>
				</tr>
				<tr><td><br></td></tr>
			</table>
		</form>
	</section>
</body>
</html>