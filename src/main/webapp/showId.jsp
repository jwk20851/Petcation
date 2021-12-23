<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<style>
	body{
		text-align:center;
	}
</style>
</head>
<body>
<% if(id != null){ %>
<h2>회원님의 아이디는 <%=id %>입니다.</h2>
<% } else {%>
<h2>등록된 회원이 아닙니다.</h2>

<%} %>

<button name="check" onclick="check()">확인</button>
</body>
<script>
 function check(){
	 window.close();
 }
</script>
</html>