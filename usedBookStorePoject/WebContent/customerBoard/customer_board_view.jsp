<%@page import="vo.BoardBean"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%
	BoardBean article = (BoardBean)request.getAttribute("article");
    String nowPage = (String)request.getAttribute("page");
    String userId = (String)request.getAttribute("writingUserID");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터 글 상세보기</title>
<style type="text/css">
#articleForm {
	width: 500px;
	height: 500px;
	border: 1px solid red;
	margin: auto;
}

h2 {
	text-align: center;
}

#basicInfoArea {
	height: 40px;
	text-align: center;
}

#articleContentArea {
	background: orange;
	margin-top: 20px;
	height: 350px;
	text-align: center;
	overflow: auto;
}

#commandList {
	margin: auto;
	width: 500px;
	text-align: center;
}
</style>
</head>

<body>
	<section id="articleForm">
		<h2>글 내용 상세보기</h2>
		<section id="basicInfoArea">
			제 목 :
			<%=article.getPost_title()%>
			글쓴이:
			<%=userId %>
			날 짜 :
			<%=article.getPost_date() %>
			조회수 :
			<%=article.getPost_readcount() %>
		</section>
		<section id="articleContentArea">
			내 용 :
			<%=article.getPost_content() %>
		</section>
	</section>
	<section id="commandList">
		<a
			href="boardReplyForm.board?post_serial_number=<%=article.getPost_serial_number() %>&page=<%=nowPage%>">
			[답변] </a> <a
			href="boardModifyForm.board?post_serial_number=<%=article.getPost_serial_number() %>&page=<%=nowPage%>">
			[수정] </a> <a
			href="boardDeletePro.board?post_serial_number=<%=article.getPost_serial_number() %>&page=<%=nowPage%>">
			[삭제] </a> <a href="boardList.board?page=<%=nowPage%>">[목록]</a>&nbsp;&nbsp;
	</section>
</body>
</html>