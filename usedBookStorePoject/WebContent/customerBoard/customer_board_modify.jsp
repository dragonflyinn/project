<%@page import="vo.BoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%

	BoardBean article = (BoardBean)request.getAttribute("article");
	String nowPage = (String)request.getAttribute("page");
	System.out.println(article);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
	<title>고객센터 게시판</title>
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
      margin:auto; 
      border : 1px solid #e0f1f2;
      border-radius : 20px 20px 20px 20px;
      background: #e0f1f2;
   }  
    
   h2{
      text-align: center;
   }
   
   table{
      margin:auto;
      width: 450px;
      text-align: center;
      font-family: 'Nanum Pen Script', cursive;
      font-size: 25px;
}

   .td_left{
      width: 150px;
      background:orange;
   }
   
   .td_right{
      width: 300px;
      background:skyblue;
   }
   
   #commandCell{
      text-align: center;
      
   }
   
</style>
</head>
<body>
<!-- 게시판 등록 -->

<section id = "writeForm">
<h2>게시판글수정</h2>
<form action="boardModifyPro.board" method="post" name = "modifyform">
<input type = "hidden" name = "page" value = "<%=nowPage %>"/>
<input type = "hidden" name = "post_serial_number" value = "<%=article.getPost_serial_number()%>"/>
<table>
	<tr>
		<td class="td_left">
			<label for = "board_name">글쓴이</label>
		</td>
		<td class="td_right">
			 ${user.user_id }
		</td>
	</tr>
	<tr>
		<td class="td_left">
			<label for = "post_title">제 목</label>
		</td>
		<td class="td_right">
			<input name="post_title" type="text" id = "post_title" value = "<%=article.getPost_title()%>"/>
		</td>
	</tr>
	<tr>
		<td class="td_left">
			<label for = "post_content">내 용</label>
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