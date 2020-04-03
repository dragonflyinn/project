<%@page import="vo.BoardBean"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>

<%
	BoardBean article = (BoardBean)request.getAttribute("article");
    String nowPage = (String)request.getAttribute("page");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지게시판</title>
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
	<!-- 게시판 수정 -->
	<section id="articleForm">
		<h2>글 내용 상세보기</h2>
		<section id="basicInfoArea">
			제 목 :
			<%=article.getPost_title()%>
		</section>
		<section id="articleContentArea">
			내 용 : 
			<%=article.getPost_content() %>
		</section>
	</section>
	<section id="commandList">
		<a href="noticeModifyForm.notice?post_serial_number=<%=article.getPost_serial_number() %>"> [수정] </a> 
		<a href="noticeDeletePro.notice?post_serial_number=<%=article.getPost_serial_number() %>&page=<%=nowPage%>">
		[삭제] </a> 
		<a href="noticeList.notice?page=<%=nowPage%>">[목록]</a>&nbsp;&nbsp;
	</section>
</body>
</html>