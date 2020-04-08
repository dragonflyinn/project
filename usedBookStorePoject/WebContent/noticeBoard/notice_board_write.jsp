<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지게시판</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<style type="text/css">
#registForm {
	width: 500px;
	height: auto;
	border : 1px solid #e0f1f2;
	margin: auto;
	background: #e0f1f2;
	border-radius : 20px 20px 0px 0px;
}

h2 {
	text-align: center;
}

table {
	margin: auto;
	width: 450px;
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
</style>
</head>
<body>
	<!-- 게시판 등록 -->

	<section id="writeForm">
		<h2>공지글 등록</h2>
		<form action="noticeWritePro.notice" method="post" name="boardform">
			<table>
				<tr>
					<td class="td_left"><label for="post_title">제 목</label></td>
					<td class="td_right"><input name="post_title" type="text"
						id="post_title" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="post_content">내 용</label></td>
					<td><textarea id="post_content" name="post_content"
							cols="40" rows="15" required="required"></textarea></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="등록">&nbsp;&nbsp; <input
					type="reset" value="다시쓰기" />
			</section>
		</form>
	</section>
</body>
</html>