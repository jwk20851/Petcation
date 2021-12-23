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


<form action="#" name = "deletepopupForm" id = "deletepopupForm">
<h2>회원탈퇴하시겠습니까?</h2>
<input type="button" id="n1" value="예" onclick = "yes()">
<input type="button" id="n1" value="아니요" onclick="no()">

</form>


</body>
<script>
	function yes(){
		window.opener.name = "parentPage"; // 부모창의 이름 설정
	    document.deletepopupForm.target = "parentPage"; // 타켓을 부모창으로 설정
	    document.deletepopupForm.action = "deleteuserinfo.pet";  //부모창에 호출될 url 
	    document.deletepopupForm.submit();
 		
		self.close();
		
	}
	function no() {
		self.close();
	}
 	

	

		

</script>
</html>