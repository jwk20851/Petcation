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
<title>중복확인</title>
<style>
	body{
		text-align:center;
	}
</style>
</head>
<body>
<% if(id != null){ %>
<h2>이미 있는 아이디입니다.</h2>
<% } else {%>
<h2>사용 가능한 아이디입니다.</h2>

<%} %>

<button name="check" onclick="check()">확인</button>
</body>
<script>
 function check(){
	 window.close();
 }
</script>
</html>