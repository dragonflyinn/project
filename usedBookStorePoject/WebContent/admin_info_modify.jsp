<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 등급 부여 페이지)</title>
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
</style>
</head>

<body>
	<section id="userInfoArea">
		<form
			action="${pageContext.request.contextPath }/adminInfoModifyProAction.admin"
			method="post" name="modifyform">
			<input type="hidden" name="user_id" value="${user.user_id }">
			<table>
				<tr>
					<td>아이디 :</td>
					<td>${user.user_id }</td>
				</tr>
				
				<tr>
					<td>이메일 주소 :</td>
					<td>${user.user_email}</td>
				</tr>

				<tr>
					<td>회원 등급 :</td>
					<td>
						<select name="user_grade">
							<option value="A">최고 관리자</option>
							<option value="B">중간 관리자</option>
							<option value="C">일반 회원</option>
						</select>
					</td>
				</tr>
				
				<tr>
					<td colspan=2><button type="button" onclick="location.href='userViewAction.me'">이전</button>
					<button onclick="javascript:modifyboard()">수정</button></td>
				</tr>
			</table>
		</form>
	</section>
</body>
</html>