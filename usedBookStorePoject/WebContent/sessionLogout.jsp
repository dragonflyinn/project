<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="vo.UserBean" %>

<%session.removeAttribute("user"); %>
<%UserBean user = (UserBean)session.getAttribute("user"); %>
<h3><%=user.getUser_id()%>님 로그아웃 되었습니다.</h3>

<a href="main.jsp">메인 페이지</a>