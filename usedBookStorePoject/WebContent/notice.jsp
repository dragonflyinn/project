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
<title>공지 게시판</title>

<style type="text/css">
#listForm {
	width: 500px;
	height: auto;
	border: 1px solid pink;
	margin: auto;
}

#boardForm {
	width: 500px;
	height: 610px;
	border: 1px solid pink;
	margin: auto;
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
	background: skyblue;
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
						<td><a href="boardDetail.board?page=<%=nowPage %>&post_serial_number=<%=articleList.get(i).getPost_serial_number()%>"><%=articleList.get(i).getPost_title()%></a></td>
						<td><%=articleList.get(i).getUser_id() %></td>
						<td><%=articleList.get(i).getPost_date()%></td>
						<td><%=articleList.get(i).getBoard_readcount()%></td>
					</tr>
					
					<%
						}
					%>
					
				</table>
		</section>

		<section id="pageList">
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
			<%
				}
			%>
			<%
				}
			%>

			<%
				if (nowPage >= maxPage) {
			%>
			[다음]
			<%
				} else {
			%>
			<a href="boardList.board?page=<%=nowPage + 1%>">[다음]</a>
			<%
				}
			%>
		</section>
		<%
			} else {
		%>
		<section id="emptyArea">등록된 글이 없습니다.</section>
		<%
			}
		%>

	<form action="boardWritePro.board" method="post" name="boardform">
		<section id="boardForm">
			<h2>공지글 등록</h2>

			<input type="hidden" name="post_serial_number"
				value="${board.post_serial_number}" />
			<table>
				<tr>
					<td class="td_left"><label for="post_title">제 목</label></td>
					<td class="td_right"><input name="post_title" type="text"
						id="post_title" required="required" /></td>
				</tr>
				<tr>
					<td class="td_left"><label for="post_content">내 용</label></td>
					<td><textarea id="post_content" name="post_content" cols="40"
							rows="15" required="required"></textarea></td>
				</tr>
			</table>

			<section id="commandCell">
				<input type="submit" value="등록" />&nbsp;&nbsp; <input type="reset"
					value="다시 작성" />
			</section>
		</section>
	</form>

</body>
</html>