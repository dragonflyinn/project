<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 로그인 </title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<style>
	#loginformArea{
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
		font-family: 'Nanum Pen Script', cursive;
		font-size: 25px;
	}
	
	button {
		text-align: center;
		font-family: 'Nanum Pen Script', cursive;
		font-size: 25px;
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
	<tr><td><label for = "user_id">아이디 </label></td><td><input type="text" name="user_id" id = "user_id"/></td></tr>
	<tr><td><label for = "user_password">비밀번호 </label></td><td><input type="password" name="user_password" id = "user_password"/></td></tr>
	<tr><td><br></td></tr>
	<tr>
		<td colspan="2">
		<button onclick="javascript:loginform.submit()">로그인</button>
		<button type="button" onclick="location.href='userJoin.me'">회원가입</button>
		</td>
	</tr>
	<tr><td><br></td></tr>
</table>
</form>
</section>
</body>
</html>