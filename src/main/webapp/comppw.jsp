<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserVO userVO = (UserVO)session.getAttribute("userVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<style>
	body{
		text-align:center;
	}
</style>
</head>
<body>
<% if(userVO != null){ %>
<h2>임시 비밀번호가 생성되었습니다. <br>이메일을 확인해주세요!</h2>
<% } else {%>
<h2>등록된 계정이 아닙니다.</h2>
<%} %>
<button name="check" onclick="check()">확인</button>

</body>
<script>
 function check(){
	 window.close();
 }
 
 
</script>
</html>