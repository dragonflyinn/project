<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	BoardBean article = (BoardBean)request.getAttribute("article");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
	<title>공지게시판</title>
	<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">
	<script type="text/javascript">
	function modifyboard(){
		modifyform.submit();
	}
	</script>
<style type="text/css">
	#registForm{
		width: 500px;
		height: 600px;
      	border : 1px solid #e0f1f2;
		border-radius : 20px 20px 20px 20px;
		background: #e0f1f2;
	}   
	h2{
		text-align: center;
		font-family: 'Nanum Pen Script', cursive;
		font-size: 40px;
	}
   table{
		margin:auto;
		width: 450px;
		text-align: center;
	}
	.td_left{
		width: 150px;
		background:#e0f1f2;
	}
	.td_right{
		width: 300px;
		background:#e0f1f2;
	}
	#commandCell{
		text-align: center;
      
	}
	button {
		text-align: center;
		font-family: 'Nanum Pen Script', cursive;
		font-size: 20px;
	}
	.style1 {
		text-align: center;
		font-family: 'Nanum Pen Script', cursive;
		font-size: 24px;
	}
</style>
</head>
<body>
<!-- 게시판 등록 -->

<section id = "writeForm">
<h2>게시판글수정</h2>
<form action="noticeModifyPro.notice" method="post" name = "modifyform">
<input type = "hidden" name = "post_serial_number" value = "<%=article.getPost_serial_number()%>"/>
<table>
	<tr>
		<td class="td_left">
			<label for = "user_id" class="style1">글쓴이</label>
		</td>
		<td class="td_right"> ${user.user_id } </td>
	</tr>
	<tr>
		<td class="td_left">
			<label for = "post_title" class="style1">제 목</label>
		</td>
		<td class="td_right">
			<input name="post_title" type="text" id = "post_title" value = "<%=article.getPost_title()%>"/>
		</td>
	</tr>
	<tr>
		<td class="td_left">
			<label for = "post_content" class="style1">내 용</label>
		</td>
		<td>
			<textarea id = "post_content" name="post_content" cols="40" rows="15"><%=article.getPost_content()%></textarea>
		</td>
	</tr>
</table>
	<section id = "commandCell">
		<button onclick="javascript:history.go(-1)">이전</button>
		<button onclick="javascript:modifyboard()">수정</button>
	</section>
</form>
</section>
</body>
</html>