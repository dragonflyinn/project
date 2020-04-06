<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원 가입 </title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<style>
	#joinformArea{
		width : 400px;
		margin : auto;
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
<section id = "joinformArea">
<form name="joinform" action="${pageContext.request.contextPath }/userJoinAction.me" method="post">
<table>
	<tr>
		<td colspan="2">
			<h1>회원가입 페이지</h1>
		</td>
	</tr>
	<tr>
		<td><label for = "user_id">아이디 </label> </td>
		<td><input type="text" name="user_id" id = "user_id"/></td>
	</tr>
	<tr>
		<td><label for = "user_password">비밀번호 </label></td>
		<td><input type="password" name="user_password" id = "user_password"/></td>
	</tr>
	<tr>
		<td><label for = "user_email">이메일 주소 </label></td>
		<td><input type="text" name="user_email" id = "user_email"/></td>
	</tr>
	<tr><td><br></td></tr>
	<tr>
		<td colspan="2">
		<button onclick="javascript:joinform.submit()">회원가입</button>&nbsp;&nbsp;
		<button type="button" onclick="javascript:joinform.reset()">다시작성</button>&nbsp;&nbsp;
			
			<!-- <a href="javascript:joinform.reset()">다시작성</a> -->
		</td>
		<tr><td><br></td></tr>
	</tr>
</table>
</form>
</section>
</body>
</html>