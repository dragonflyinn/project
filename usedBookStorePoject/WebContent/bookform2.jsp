<%@page import="java.util.ArrayList"%>
<%@page import="vo.UserBean"%>
<%@ page import="vo.BookBoardBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	UserBean user = (UserBean) session.getAttribute("user");
	if (user.getUser_id() != null) {

	} else {
		out.println("<script>");
		out.println("alert('로그인을 하세요!!');");
		out.println("location.href='loginForm.jsp';");
		out.println("</script>");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>도서 서평 페이지</title>
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<style type="text/css">
#listForm1 {
	width: 500px;
	height: 610px;
	border: 1px solid #e0f1f2;
	border-radius: 20px 20px 0px 0px;
	background: #e0f1f2;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 40px;
	text-align: center;
	margin: auto;
}

#listForm2 {
	width: 500px;
	height: auto;
	border: 1px solid #e0f1f2;
	margin: auto;
	border-radius: 0px 0px 20px 20px;
	background: #e0f1f2;
	font-size: 10px;
}

#bookForm {
	width: 500px;
	height: auto;
	border: 1px solid #e0f1f2;
	background: #e0f1f2;
	margin: auto;
}

h2 {
	text-align: center;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 40px;
}

table {
	margin: auto;
	width: 450px;
	text-align: center;
}

#emptyArea {
	margin: auto;
	wodth: 500px;
	text-align: center;
}

.td_left {
	width: 150px;
	background: pink;
}

.td_right {
	width: 300px;
	background: white;
}

#commandCell {
	text-align: center;
}

.style1 {
	text-align: center;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 20px;
}
</style>
</head>



<body>
	<section id="listForm1">
		<h3>도서 번호: ${book.book_serial_number}</h3>
		<h3>도서명: ${book.book_name}</h3>
	</section>


	<form action="bookBoardWriteAction.bo" method="post" name="bookform">
		<section id="bookForm">
			<hr style="border: dotted 5px #4dd0e1;">
			<tr>
				<td><br></td>
			</tr>
			<h2>서평 등록</h2>

			<input type="hidden" name="book_serial_number"
				value="${book.book_serial_number}" />
			<table>
				<tr>
					<td class="td_left"><label for="board_name" class="style1">글쓴이</label></td>
					<td class="td_right">${viewUser.user_id }</td>
				</tr>
				<tr>
					<td class="td_left">
					<label for="post_content" class="style1">내용</label></td>
					<td class="td_right">
					<textarea id="post_content" name="post_content" cols="40" rows="15"></textarea></td>
				</tr>
			</table>
			<section id="commandCell">
				<tr>
					<td><br></td>
				</tr>
				<input type="submit" class="style1" value="등록" /> <input
					type="reset" class="style1" value="다시 작성" />
				<tr>
					<td><br></td>
				</tr>
			</section>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<hr style="border: dotted 5px #4dd0e1;">
		</section>
	</form>

	<section id="listForm2">
		<h2>서평 목록</h2>
		<c:forEach items="${articleList }" var="article">

			<table>
				<tr>
					<td><br></td>
				</tr>
				<tr>
					<td class="td_left"><label for="post_num" class="style1">번
							호</label></td>
					<td class="td_right"><h3>${article.book_serial_number}</h3></td>
				</tr>
				<tr>
					<td class="td_left"><label for="post_date" class="style1">날
							짜</label></td>
					<td class="td_right"><h3>${article.post_date}</h3></td>
				</tr>
				<tr>
					<td class="td_left"><label for="post_content" class="style1">내
							용</label></td>
					<td class="td_right"><h3>${article.post_content}</h3></td>
				</tr>
				<tr>
					<td><br></td>
				</tr>
			</table>
		</c:forEach>
	</section>
</body>
</html>