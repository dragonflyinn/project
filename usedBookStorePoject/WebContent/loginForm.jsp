<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<style>
	#loginformArea{
	    margin : auto;
		width : 400px;
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
<section id = "loginformArea">
<form name="loginform" action="${pageContext.request.contextPath }/userLoginAction.me" method="post">
<table>
	<tr>
		<td colspan="2">
			<h1>로그인 페이지</h1>
		</td>
	</tr>
	<tr><td><label for = "user_id">아이디 : </label></td><td><input type="text" name="user_id" id = "user_id"/></td></tr>
	<tr><td><label for = "user_password">비밀번호 : </label></td><td><input type="password" name="user_password" id = "user_password"/></td></tr>
	<tr>
		<td colspan="2">
			<a href="javascript:loginform.submit()">로그인</a>&nbsp;&nbsp;
			<a href="userJoin.me">회원가입</a>
		</td>
	</tr>
</table>
</form>
</section>
</body>
</html>