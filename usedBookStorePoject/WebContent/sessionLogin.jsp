<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vo.UserBean"%>
<%
	session.setAttribute("id", request.getParameter("id"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Login</title>
</head>
<body>
	<%
		UserBean user = (UserBean) session.getAttribute("user");
	%>
	<h3><%=user.getUser_id()%>님 로그인되었습니다.
	</h3>
	<%=user.getUser_serial_number()%>
	<a href="main.jsp">메인 페이지</a>
</body>
</html>