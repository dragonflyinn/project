<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% if(session.getAttribute("user")==null){ %>
<script>
alert("로그인을 하세요");
location.href="userLogin.me";
</script>
<%} %>
</body>
</html>