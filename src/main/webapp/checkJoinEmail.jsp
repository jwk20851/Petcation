<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String email = (String)session.getAttribute("email");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 인증</title>
<style>
	body{
		text-align:center;
	}
</style>
</head>
<body>
<% if(email != null){ %>
<h2>인증번호를 발송하였습니다.</h2>
<% } else {%>
<h2>이메일 인증에 실패하였습니다.</h2>

<%} %>

<button name="check" onclick="check()">확인</button>
</body>
<script>
 function check(){
	 window.close();
 }
</script>
</html>