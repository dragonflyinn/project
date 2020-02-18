<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String book = (String) request.getAttribute("book");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 서평 게시판</title>
<style>
	table {
		width: 400px;
		margin: auto;
		border: 1px solid pink;
	}
</style>
</head>
<body>
	<form action="GetBookAction.book" method="post">
		<table>
			<tr>
				<td>도서 시리얼 넘버 :</td>
				<td><input type="text" name="book_serial_number"></td>
			</tr>
			<tr>
				<td>도서명 :</td>
				<td><input type="text" name="book_name"></td>
			</tr>
			<tr>
				<td colspan=2 align=center><input type="submit" value="확인"></td>
			</tr>
		</table>
	</form>
</body>
</html>