<%@page import="vo.UserVO"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<%
	String eqn = (String)request.getAttribute("eqn");
	Random random = new Random();
    int checkNum = random.nextInt(888888) + 111111;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-latest.min.js"
	type="application/javascript"></script>
<script type="application/javascript" src="js/hangjungdong.js"></script>

<link rel="stylesheet" href="css/common2.css">

<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
input[type=text], input[type=password] {
	border-radius: 25px;
	width: 50%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

.checkid {
	margin-left: 5%;
}

/* Set a style for all buttons */
button {
	border-radius: 25px;
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 50%;
	margin-bottom: 2%;
}

button:hover {
	opacity: 0.8;
}

.container {
	padding: 16px;
}

.findidlogin {
	padding-top: 1%;
	padding-bottom: 1%;
	text-align: center;
}

h1 {
	text-align: center;
}

.findidlogin button {
	width: 49.5%;
}

#email {
	width: 35%;
}

.checkCode {
	width: 15%;
	padding-top: 10px;
}

.findidlogin button {
	width: 49.5%;
}

}
#join {
	margin-right: 10%;
	text-align: center;
}

#findid {
	margin-right: 10%;
	margin-left: 10%;
	text-align: center;
}
</style>
<title>비밀번호 찾기</title>
</head>
<body>
	<div style="height: 100%; width: 100%;">
		<div id="id01" class="modal">
			<div id="body-content">


				<form class="modal-content" action="login.jsp" name="findPwForm" id="findPwForm" onsubmit="return input_check()">
					<div class="head">
					<h1 style="font-size: 3vw; text-align: center">비밀번호 찾기</h1>
					</div>

					<div class="out_container">
						<div class="sidebar">
							<div class="sidenav">
								<h1
									style="font-size: 2vw; text-align: center; margin-top: 10px; margin-bottom: 10px">병원예약</h1>
								<hr style="margin-bottom: 20px">
								<a href="#about">회원정보</a> <a href="#services">반려동물정보</a> <a
									href="#services">리뷰관리</a> <a href="#services">즐겨찾기관리</a> <a
									href="#services">회원탈퇴</a>
							</div>
						</div>
						<div class="container" style="padding-bottom: 5%; padding-left: 5%; padding-right: 5%">
							<h1 style="text-aligin: center; padding-bottom: 20px;">비밀번호
								찾기</h1>

							<input type="text" placeholder="아이디" name="id" id="id" required><br>
							<input type="text" placeholder="이메일" name="email" id="email" required>
							<button type="button" class="checkCode" onclick="showPopup()">인증하기</button>
							<br> <input type="text" placeholder="인증코드" name="checkcode" id="checkcode"
								required="required" >
							<input type="hidden" placeholder="인증코드확인해봄" name="eqn" id="eqn" value="<%=checkNum%>">
							<button type="submit">비밀번호 찾기</button>

							<div class="findidpw">
								<a id="join" href="join.jsp">회원가입</a> <a id="findid" href="findId.jsp">아이디찾기</a>
								<a id="login" href="login.jsp">로그인하기</a>
							</div>
						</div>
						<br>
					</div>


					<div class="header">
				<nav>
		            <ul class="topnav" id = "myTopnav">
		                <li class="menu_a"> <a href="main.jsp"><img src="images/logo.png" id = "logo"/></a> </li>
		                <c:if test="${not empty userVO}">
		                <li class="menu_a"> <a href="findpetName.pet">병원예약</a> </li>
		                </c:if>
		            	<c:if test="${empty userVO}">
		                <li class="menu_a"> <a href="javascript:void(0);" onclick="alert('회원이 아니면 사용하실 수 없습니다!')">병원예약</a> </li>
						</c:if>		                
		                <li class="menu_a"> <a href="searchHosp.jsp">병원검색</a> </li>
		                <c:if test="${not empty userVO}">
		                <li class="menu_a"> <a href="#myHosp">MY병원</a> </li>
		                </c:if>
		                <c:if test="${empty userVO}">
		                <li class="menu_a"> <a href="javascript:void(0);" onclick="alert('회원이 아니면 사용하실 수 없습니다!')">MY병원</a> </li>
		                </c:if>
		                <li class="menu_a"> <a href="#cusCenter">고객센터</a> </li>
		                <c:if test="${not empty userVO}">
		                <c:if test="${userVO.user_authority == 2}">
		                <li class="menu_a"> <a href="watchmgHosInfo.pet">병원관리</a> </li> 
		                </c:if>
		                <c:if test="${userVO.user_authority != 2}">
		                <li class="menu_a"> <a href="hoscheckpw.jsp">병원관리</a> </li> 
		                </c:if>
		                </c:if>
		                <c:if test="${empty userVO}">
		                <li class="menu_a"> <a href="javascript:void(0);" onclick="alert('회원이 아니면 사용하실 수 없습니다!')">병원관리</a> </li> 
		                </c:if>            
		            	<li class="space"></li>
		            	<c:if test="${not empty userVO}">
		            		<li class="menu_a"><a href="logout.pet">로그아웃</a></li>
		            		<li class="menu_a"><a href="checkpw.jsp">마이페이지</a></li>
		            	</c:if>
		            	<c:if test="${empty userVO}">
		            		<li class="menu_a"><a href="login.jsp">로그인</a></li>
							<li class="menu_a"><a href="joinAgree.jsp">회원가입</a></li>
		            	</c:if>
						<li2 class="menu_a" onclick="myFunction()"><a href="javascript:void(0);" class="icon">
		    			<i class="fa fa-bars" id="icon"></i>
		  				</a></li2>
					</ul>
				</nav>
		</div>
				</form>
			</div>
		</div>

		<div id="footer-content"
			style="display: flex; flex-direction: row; min-height: 220px; align-items: center; justify-content: center;">
			<div>
				<img src="images/footer_logo.png"
					style="width: 100%; height: 148px;" />
			</div>
			<div style="padding: 0;">
				<p style="font-size: 2vh;">
					<strong>주소</strong> : 대구광역시 수성구 알파시티1로31길 24-5<br> <strong>대표</strong>
					: 스폰지밥<br> <strong>대표전화</strong> : <a href="tel:000-1111-2222"
						target="_blank"
						style="text-decoration-line: none; color: inherit;">000-111-2222</a><br>
					<br> Copyright ⓒ 2021 펫케이션. All rights reserved. Designed by
					Petcation.
				<p style="font-size: 1vh;">
					※ 본 웹사이트는 게시된 사진이 무단 수집되어 도용되는 것을 거부하며, 이를 위반 시 『저작권법』등에 의해 처벌 받을 수
					있습니다.<br> 사진을 기술적 장치를 사용하여 무단으로 복제, 공연, 공중송신, 전시, 배포, 대여,
					2차적저작물 작성의 방법으로 침해한 자는 [저작권법] 제 136조 제 1항에 의하여 5년 이하의 징역 또는 5천만원
					이하의 벌금에 처해집니다.
				</p>
			</div>
		</div>
	</div>
	<script>
		function myFunction() {
			/* alert('성공'); */
			var x = document.getElementById("myTopnav");
			if (x.className === "topnav") {
				x.className += " responsive";
			} else {
				x.className = "topnav";
			}
		}
		function input_check(){
			
			var email = document.getElementById("email");
			var checkcode = document.getElementById("checkcode");
			var eqn = document.getElementById("eqn");
			
			var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
			
			
			if(re.test(email.value) == false){
				alert('이메일 형식에 맞지 않습니다.');
				return false;
			}
			
			if(checkcode.value != eqn.value){
				alert('인증번호가 일치하지 않습니다.');
				return false;
			}
			 else{
				 window.open("comppw.jsp", "비밀번호찾기", "width=400, height=200, left=100, top=50");
				 document.findPwForm.target = "비밀번호찾기";
				 document.findPwForm.action="findpw.pet";
				 document.findPwForm.submit();
				 document.findPwForm.target = "_self";
				 document.findPwForm.action="login.jsp";
				 document.findPwForm.submit();
			 }
			
			
		}
		function showPopup() {
			window.open("checkJoinEmail.jsp", "이메일인증", "width=400, height=200, left=100, top=50");
			document.findPwForm.target = "이메일인증";
			document.findPwForm.action="mailidenti.pet";
			findPwForm.submit();
		}
		
		
		
		$(window).bind("pageshow", function (event) {
			if (event.originalEvent.persisted) {
				// 뒤로가기로 페이지 로드 시
				document.findPwForm.reset();
			}
			
		});
	</script>

</body>
</html>