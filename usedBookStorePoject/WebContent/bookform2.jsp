<%@page import="java.util.ArrayList"%>
<%@ page import="vo.BookBoardBean"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>도서 서평 페이지</title>

<style type="text/css">
#listForm1 {
	width: 500px;
	height: 610px;
	border: 1px solid pink;
	margin: auto;
}

#listForm2 {
	width: 500px;
	height: auto;
	border: 1px solid pink;
	margin: auto;
}

#bookForm {
	width: 500px;
	height: 610px;
	border: 1px solid pink;
	margin: auto;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
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
	background: skyblue;
}

#commandCell {
	text-align: center;
}
</style>
</head>



<body>

	<section id="listForm1">
		<h3>${book.book_serial_number}</h3>
		<h3>${book.book_name}</h3>
	</section>


	<form action="BookBoardWriteAction.bo" method="post" name="bookform">
		<section id="bookForm">
			<h2>서평 등록</h2>

			<input type="hidden" name="book_serial_number"
				value="${book.book_serial_number}" />
			<table>
				<tr>
					<td class="td_left"><label for="board_name">글쓴이</label></td>
					<td class="td_right"><input type="text" name="board_name"
						id="board_name" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="post_content">내 용</label></td>
					<td class="td_right"><textarea id="post_content"
							name="post_content" cols="40" rows="15"></textarea></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="등록" />&nbsp;&nbsp; <input type="reset"
					value="다시 작성" />
			</section>
		</section>
	</form>

	<section id="listForm2">
		<h2>서평 목록</h2>
		<c:forEach items="${articleList }" var="article">

			<table>
				<tr>
					<td class="td_left"><label for="board_num">번 호</label></td>
					<td class="td_right"><h3>${article.book_serial_number}</h3></td>
				</tr>
				<tr>
					<td class="td_left"><label for="post_date">날 짜</label></td>
					<td class="td_right"><h3>${article.post_date}</h3></td>
				</tr>
				<tr>
					<td class="td_left"><label for="post_content">내 용</label></td>
					<td class="td_right"><h3>${article.post_content}</h3></td>
				</tr>
			</table>
		</c:forEach>
	</section>
</body>
</html>