<%@ page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserVO userVO = (UserVO)session.getAttribute("userVO");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 확인</title>
<style>
	body{
		text-align:center;
	}
</style>
</head>
<body>


<% if(userVO != null){ %>
<h2>본인 확인 완료하였습니다.</h2>
<input type="hidden" id ="n1" value="1">
<% } else {%>
<h2>본인 확인 실패하였습니다.</h2>
<%} %>
<input type="button" id="checkbutton" value="확인" onclick="showpop()">
<input type="hidden" id ="n1" value="2">
</body>
<script>
	var n1 = document.getElementById("n1").value;
	opener.document.deleteinfoForm.popnum.value = n1;
	if(n1 == "1"){
		
		opener.document.deleteinfoForm.checkbutton.style="background-color:lightgray;";
		opener.document.deleteinfoForm.checkbutton.disabled = true;
	}

	
 	function showpop(){
 		
 		self.close();
 	}

</script>
</html>