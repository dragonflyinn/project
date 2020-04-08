<%@ page import="java.util.*"%>
<%@page import="vo.PageInfo"%>
<%@ page import="vo.BoardBean"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>

<%
	ArrayList<BoardBean> articleList = (ArrayList<BoardBean>) request.getAttribute("articleList");
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	int listCount = pageInfo.getListCount();
	int nowPage = pageInfo.getPage();
	int maxPage = pageInfo.getMaxPage();
	int startPage = pageInfo.getStartPage();
	int endPage = pageInfo.getEndPage();
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>문의 게시판</title>
<link href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap" rel="stylesheet">

<style type="text/css">
#listForm {
	width: 500px;
	height: auto;
	border : 1px solid #e0f1f2;
	margin: auto;
	background: #e0f1f2;
	border-radius : 20px 20px 0px 0px;
}

#boardForm {
	width: 500px;
	height: auto;
	border : 1px solid #e0f1f2;
	margin: auto;
	background: #e0f1f2;
	border-radius : 0px 0px 20px 20px;
}

#registForm {
	width: 500px;
	height: 600px;
	border: 1px solid red;
	margin: auto;
}

#emptyArea {
	margin: auto;
	wodth: 500px;
	text-align: center;
}

#commandCell {
	text-align: center;
}

#tr_top {
	background: orange;
	text-align: center;
}

#pageList {
	margin: auto;
	width: 500px;
	text-align: center;
	background: #e0f1f2;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 20px;
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
	text-align: center;
}

.td_right {
	width: 300px;
	background: white;
}
.style1 {
	text-align: center;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 20px;
}
button {
		text-align: center;
		font-family: 'Nanum Pen Script', cursive;
		font-size: 20px;
	}
a {
	text-decoration: none;
}
</style>
</head>



<body>
		<section id="listForm">
			<h2>문의글 목록</h2>

				<table>
					<%
						if (articleList != null && listCount > 0) {
					%>

					<tr id="tr_top">
						<td>번호</td>
						<td>제목</td>
						<td>작성자</td>
						<td>날짜</td>
						<td>조회수</td>
					</tr>

					<%
						for (int i = 0; i < articleList.size(); i++) {
					%>
					
					<tr>
						<td><%=articleList.get(i).getPost_serial_number()%></td>
						<td>
						<% if(articleList.get(i).getBoard_re_lev() !=0) { %>
						<% for(int a=0; a<=articleList.get(i).getBoard_re_lev()*2;a++) { %> &nbsp;
						<% } %> ▶
						<%} %>
						<a href="boardDetail.board?post_serial_number=<%=articleList.get(i).getPost_serial_number()%>&page=<%=nowPage%>">
						<%=articleList.get(i).getPost_title()%></a></td>
						<td><%=articleList.get(i).getUser_id() %></td>
						<td><%=articleList.get(i).getPost_date()%></td>
						<td><%=articleList.get(i).getPost_readcount()%></td>
					</tr>
					
					<%} %>
					
				</table>
		</section>

		<section id="pageList">
		<tr><td><br></td></tr>
			<%
				if (nowPage <= 1) {
			%>
			[이전]&nbsp;
			<%
				} else {
			%>
			<a href="boardList.board?page=<%=nowPage - 1%>">[이전]</a>&nbsp;
			<%
				}
			%>

			<%
				for (int a = startPage; a <= endPage; a++) {
							if (a == nowPage) {
			%>
			[<%=a%>]
			<%
				} else {
			%>
			<a href="boardList.board?page=<%=a%>">[<%=a%>]
			</a>&nbsp;
			<%}%>
			<%}%>

			<% if (nowPage >= maxPage) { %>
			[다음]
			<% } else { %>
			<a href="boardList.board?page=<%=nowPage + 1%>">[다음]</a>
			<% } %>
		</section>
		
		<% } else { %>
		<section id="emptyArea">등록된 글이 없습니다.</section>
		<% } %>

	<form action="boardWritePro.board" method="post" name="boardform">
		<section id="boardForm">
		
			<tr><td><br></td></tr>
			<hr style="border: dotted 5px #4dd0e1;">
			
			<h2>문의글 등록</h2>

			<input type="hidden" name="post_serial_number"
				value="${board.post_serial_number}" />
			<table>
				<tr>
					<td class="td_left">
					<label for="post_title" class="style1">제 목</label></td>
					<td class="td_right">
					<input name="post_title" type="text" id="post_title" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="post_content" class="style1">내 용</label></td>
					<td><textarea id="post_content" name="post_content" cols="40" rows="15" required="required"></textarea></td>
				</tr>
			</table>

			<section id="commandCell">
			<tr><td><br></td></tr>
				<button onclick="javascript:boardform.submit()">등록</button>
				<button type="button" onclick="javascript:joinform.reset()">다시작성</button>
			</section>
			<tr><td><br></td></tr>
		</section>
	</form>

</body>
</html>