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
<title>고객센터 답변글 상세보기</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<style type="text/css">
#articleForm {
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

button {
		text-align: center;
		font-family: 'Nanum Pen Script', cursive;
		font-size: 25px;
}
</style>
</head>

<body>
	<section id="articleForm">
		<h2>답변 글 내용 상세보기</h2>
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
		<button type="button" onclick="location.href='boardModifyForm.board?post_serial_number=<%=article.getPost_serial_number() %>'">수정</button>
		<button type="button" onclick="location.href='boardDeletePro.board?post_serial_number=<%=article.getPost_serial_number() %>&page=<%=nowPage%>'">삭제</button>
		<button type="button" onclick="boardList.board?page=<%=nowPage%>'">목록</button>
	
		<a href="boardModifyForm.board?post_serial_number=<%=article.getPost_serial_number() %>"> [수정] </a> 
		<a href="boardDeletePro.board?post_serial_number=<%=article.getPost_serial_number() %>&page=<%=nowPage%>"> [삭제] </a> 
		<a href="boardList.board?page=<%=nowPage%>"> [목록] </a>&nbsp;&nbsp;
	</section>
</body>
</html>