<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#joinformArea{
		width : 400px;
		margin : auto;
		border : 1px solid gray;
		
	}
	table{
		width : 380px;
		margin :  auto;
		text-align: center;
	}
</style>
</head>
<body>
<section id = "joinformArea">
<form name="joinform" action="./UserJoinAction.me" method="post">
<table>
	<tr>
		<td colspan="2">
			<h1>회원가입 페이지</h1>
		</td>
	</tr>
	<tr>
		<td><label for = "user_id">아이디 : </label> </td>
		<td><input type="text" name="user_id" id = "user_id"/></td>
	</tr>
	<tr>
		<td><label for = "user_password">비밀번호 : </label></td>
		<td><input type="password" name="user_password" id = "user_password"/></td>
	</tr>
	<tr>
		<td><label for = "user_email">이메일 주소 : </label></td>
		<td><input type="text" name="user_email" id = "user_email"/></td>
	</tr>
	<tr>
		<td colspan="2">
			<a href="javascript:joinform.submit()">회원가입</a>&nbsp;&nbsp;
			<a href="javascript:joinform.reset()">다시작성</a>
		</td>
	</tr>
</table>
</form>
</section>
</body>
</html>