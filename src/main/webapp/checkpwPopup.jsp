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
<h2>비밀번호가 일치합니다.</h2>
<input type="hidden" id="n1" value="1">
<% } else {%>
<h2>비밀번호가 일치하지 않습니다.</h2>
<input type="hidden" id="n1" value="2">
<%} %>

</body>
<script>
 
 	var num = document.getElementById("n1");
 	if(num.value == "1"){
 		opener.parent.location.replace("manageUserInfo.jsp");
 	}else{
 		opener.parent.location.replace("checkpw.jsp");
 	}
 	setTimeout(function() {
 		self.close();
 	}, 4000);

	

		

</script>
</html>