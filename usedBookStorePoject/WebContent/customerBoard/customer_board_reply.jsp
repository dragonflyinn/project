<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	BoardBean article=(BoardBean)request.getAttribute("article");
    String nowPage = (String)request.getAttribute("page");
    System.out.println("리플라이 아티클"+article);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>고객센터 답변 게시판</title>
<script language="javascript">
	</script>
<style type="text/css">
#registForm {
	width: 500px;
	height: 610px;
	border: 1px solid red;
	margin: auto;
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
	background: orange;
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
	<!-- 게시판 답변 -->


	<section id="writeForm">
		<h2>답변 글등록</h2>
		<form action="boardReplyPro.board" method="post" name="boardform">
			<input type="hidden" name="page" value="<%=nowPage %>" /> 
			<input type="hidden" name="post_serial_number" value="<%=article.getPost_serial_number() %>">
			<input type="hidden" name="board_re_ref" value="<%=article.getBoard_re_ref() %>"> 
			<input type="hidden" name="board_re_lev" value="<%=article.getBoard_re_lev() %>"> 
			<input type="hidden" name="board_re_seq" value="<%=article.getBoard_re_seq() %>">
			<table>
				<tr>
					<td class="td_left"><label for="post_title">제 목</label></td>
					<td class="td_right"><input name="post_title" type="text"
						id="post_title" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="user_id">글쓴이</label></td>
					<td class="td_right"><input name="post_title" type="text"
						id="user_id" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="post_content">내 용</label></td>
					<td><textarea id="post_content" name="post_content"
							cols="40" rows="15"></textarea></td>
				</tr>
			</table>
			<section id="commandCell">
				<input type="submit" value="답변글등록" />&nbsp;&nbsp; <input
					type="reset" value="다시작성" />
			</section>
		</form>
	</section>
</body>
</html>