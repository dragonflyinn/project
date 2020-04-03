<%@page import="vo.PageInfo"%>
<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<title>공지게시판</title>
<style type="text/css">
#registForm {
	width: 500px;
	height: 600px;
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

#tr_top {
	background: orange;
	text-align: center;
}

#pageList {
	margin: auto;
	width: 500px;
	text-align: center;
}

#emptyArea {
	margin: auto;
	width: 500px;
	text-align: center;
}
</style>
</head>

<body>
	<!-- 게시판 리스트 -->

	<section id="listForm">
	<c:choose>
	<c:when test="${user.user_grade == 'A'|| user.user_grade == 'B' }">
		<h2>
			공지글 목록<a href="noticeWriteForm.notice">게시판글쓰기</a>
		</h2>
	</c:when>
	<c:otherwise>
		<h2>공지글 목록</h2>
	</c:otherwise>
	</c:choose>
	
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
				<a href="noticeDetail.notice?post_serial_number=<%=articleList.get(i).getPost_serial_number() %>&page=<%=nowPage %>">
				<%=articleList.get(i).getPost_title() %></a></td>
				<td><%=articleList.get(i).getUser_id()%></td>
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
		<a href="noticeList.notice?page=<%=nowPage - 1%>">[이전]</a>&nbsp;
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
		<a href="noticeList.notice?page=<%=a%>">[<%=a%>]
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
		<a href="noticeList.notice?page=<%=nowPage + 1%>">[다음]</a>
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

</body>
</html>