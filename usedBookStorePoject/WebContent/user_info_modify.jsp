<%@page import="vo.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리 시스템 관리자모드(회원 등급 부여 페이지)</title>

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
	<form action="/UserInfoModifyProAction.me" method="post" name="modifyform">
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
				<td>
					<select>
					<option value="A">최고 관리자 </option>
					<option value="B">중간 관리자 </option>
					<option value="C">일반 회원 </option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan=2><a href="UserListAction.me">리스트로 돌아가기</a>&nbsp;&nbsp;
				<a href="javascript:modifyboard()">수정</a></td>
			</tr>
		</table>
	</form>
	</section>
</body>
</html>