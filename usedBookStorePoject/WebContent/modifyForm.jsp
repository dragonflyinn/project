<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#modifyformArea {
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
		font-size: 25px;
}
</style>
</head>
<body>
	<section id="modifyformArea">
		<form name="modifyform" action="/userInfoModifyAction.me"
			method="post">
			<table>
				<tr>
					<td>아이디 :</td>
					<td>${user.user_id }</td>
				</tr>
				<tr>
					<td>비밀번호 :</td>
					<td>${user.user_password}</td>
				</tr>
				<tr>
					<td>이메일 주소 :</td>
					<td>${user.user_email}</td>
				</tr>
				<tr>
					<td>회원 등급 :</td>
					<td>${user.user_grade}</td>
				</tr>
				<tr>
					<td colspan=2>
					<button type="button" onclick="location.href='UserListAction.me'">회원가입</button>
					<button onclick="javascript:modifyboard()">수정</button>
						<a href="UserListAction.me">리스트로 돌아가기</a>&nbsp;
						<a href="javascript:modifyboard()">수정</a>
					</td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>