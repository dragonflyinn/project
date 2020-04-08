<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	BoardBean article=(BoardBean)request.getAttribute("article");
    String nowPage = (String)request.getAttribute("page");
   String userId = (String)request.getAttribute("writingUserID");
    System.out.println("리플라이 아티클"+article);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>고객센터 답변 게시판</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<script language="javascript">
	</script>
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
	background: #e0f1f2;
	text-align: center;
}

.td_right {
	width: 300px;
	background: #e0f1f2;
}

#commandCell {
	text-align: center;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 25px;
}
button {
	text-align: center;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 20px;
}
.style1 {
	text-align: center;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 25px;
}
</style>
</head>
<body>
	<!-- 게시판 답변 -->


	<section id="writeForm">
		<h2>답변 글등록</h2>
		<form action="boardReplyPro.board" method="post" name="boardform">
			<input type="hidden" name="page" value="<%=nowPage %>" /> 
			<input type="hidden" name="post_serial_number" value="<%=article.getPost_serial_number() %>">
			<input type="hidden" name="writing_user_serial_number" value="<%=article.getWriting_user_serial_number() %>">
			<input type="hidden" name="board_re_ref" value="<%=article.getBoard_re_ref() %>">
			<input type="hidden" name="board_re_lev" value="<%=article.getBoard_re_lev() %>">
			<input type="hidden" name="board_re_seq" value="<%=article.getBoard_re_seq() %>">
			<table>
				<tr>
					<td class="td_left">
					<label for="post_title" class="style1">제 목</label></td>
					
					<td class="td_right">
					<input name="post_title" type="text" id="post_title" /></td>
				</tr>
					<td class="td_left">
					<label for="writing_serial_user" class="style1">글쓴이</label></td>
					
					<td class="td_right">${user.user_id } </td>
					
				<tr>
					<td class="td_left"><label for="post_content" class="style1">내 용</label></td>
					<td><textarea id="post_content" name="post_content" cols="40" rows="15"></textarea></td>
				</tr>
			</table>
			<section id="commandCell">
				<button onclick="javascript:boardform.submit()">답변글등록</button>
				<button type="button" onclick="javascript:boardform.reset()">다시작성</button>
			</section>
		</form>
	</section>
</body>
</html>