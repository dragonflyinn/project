<%@page import="vo.BoardBean"%>
<%@page import="vo.UserBean"%>
<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	BoardBean article = (BoardBean)request.getAttribute("article");
    String nowPage = (String)request.getAttribute("page");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지게시판</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
<style type="text/css">

#articleForm {
	width : 500px;
	margin : auto;
	border : 1px solid #e0f1f2;
	border-radius : 20px 20px 20px 20px;
	background: #e0f1f2;
}

 h2 {
	text-align: center;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 40px;
}

#basicInfoArea {
	height: 40px;
	text-align: center;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 25px;
}

#articleContentArea {
	background: #white;
	margin-top: 20px;
	height: 400px;
	text-align: left;
	overflow: auto;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 15px;
	border-radius : 0px 0px 20px 20px;
}

#commandList {
	margin: auto;
	width: 500px;
	text-align: center;
	font-family: 'Nanum Pen Script', cursive;
}

button {
		text-align: center;
		font-family: 'Nanum Pen Script', cursive;
		font-size: 20px;
}

</style>
</head>

<body>
	<!-- 게시판 수정 -->
	<section id="articleForm">
		<h2>공지</h2>
		
		<section id="basicInfoArea">
			제 목 :
			<%=article.getPost_title()%>
		</section>
	<hr style="border: dotted 5px #4dd0e1;">
		<section id="articleContentArea">
			<!-- 내용 -->
			<td align="left" width="375" colspan="3" >
			<pre style="word-wrap: break-word;white-space: pre-wrap;white-space: -moz-pre-wrap;white-space: -pre-wrap;white-space: -o-pre-wrap;word-break:break-all;">
			<%=article.getPost_content() %>
			</pre>
			</td>
		</section>

		<hr style="border: dotted 5px #4dd0e1;">
		<section id="commandList">
	<tr><td><br></td></tr>
	<c:if test="${user.user_grade == 'A'|| user.user_grade == 'B' }">
		<button type="button" onclick="location.href='noticeModifyForm.notice?post_serial_number=<%=article.getPost_serial_number() %>'">수정</button>
		<button type="button" onclick="location.href='noticeDeletePro.notice?post_serial_number=<%=article.getPost_serial_number() %>&page=<%=nowPage%>'">삭제</button>
	</c:if>
	<button type="button" onclick="location.href='noticeList.notice?page=<%=nowPage%>'">목록</button>
	</section>
	<tr><td><br></td></tr>
	</section>
</body>
</html>