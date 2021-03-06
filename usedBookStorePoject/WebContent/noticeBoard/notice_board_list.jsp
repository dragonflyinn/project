<%@page import="vo.PageInfo"%>
<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<link
	href="https://fonts.googleapis.com/css2?family=Nanum+Pen+Script&display=swap"
	rel="stylesheet">
<style type="text/css">
#registForm {
	width: 500px;
	height: 600px;
	border: 1px solid #e0f1f2;
	border-radius: 20px 20px 20px 20px;
	background: #e0f1f2;
}

h2 {
	text-align: center;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 35px;
}

table {
	margin: auto;
	width: 450px;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 19px;
}

#tr_top {
	background: #e0f1f2;
	text-align: center;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 18px;
}

#pageList {
	margin: auto;
	width: 500px;
	text-align: center;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 23px;
}

#emptyArea {
	margin: auto;
	width: 500px;
	text-align: center;
}

a {
	text-decoration: none;
}

button {
		text-align: center;
		font-family: 'Nanum Pen Script', cursive;
		font-size: 20px;
}
</style>
</head>

<body>
	<!-- 게시판 리스트 -->

	<section id="listForm">
				<h2>공지글 목록</h2>
		<table>
			<tr>
				<td>
					<c:if test="${user.user_grade == 'A'|| user.user_grade == 'B' }">
						<button type="button" onclick="location.href='noticeWriteForm.notice?page=<%=nowPage%>'">글쓰기</button>
					</c:if>
				</td>
			</tr>
			
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
					<div
						style="position: relative; width: 200px; text-overflow: ellipsis; overflow: hidden; cursor: hand;">
						<nobr>
							<a
								href="noticeDetail.notice?post_serial_number=<%=articleList.get(i).getPost_serial_number()%>&page=<%=nowPage%>">
								<%=articleList.get(i).getPost_title()%></a>
						</nobr>
					</div>
				</td>
				<td><%=articleList.get(i).getUser_id()%></td>
				<td><%=articleList.get(i).getPost_date()%></td>
				<td><%=articleList.get(i).getPost_readcount()%></td>
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