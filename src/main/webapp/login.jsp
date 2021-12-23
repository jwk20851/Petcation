<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-latest.min.js"
	type="application/javascript"></script>
<script type="application/javascript" src="js/hangjungdong.js"></script>

<link rel="stylesheet" href="css/common_single.css">

<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
input[type=text], input[type=password] {
	border-radius: 25px;
	width: 400px;
	padding: 12px 20px;
	margin: 6px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

.checkid {
	display: inline-block;
	width: 100%;
	text-align: left;
	padding-left: 10%;
}

#findpw {
	margin-left: 8%;
	margin-right: 8%;
	text-align: center;
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
	width: 400px;
	text-align: center;
}

.findidpw {
	padding-top: 1%;
	padding-bottom: 1%;
	text-align: center;
}

.findidpw a {
	padding-left: 1%
}

h1 {
	text-align: center;
}

.logincont {
	width: 50%;
	display: inline-block;
}
</style>
<title>로그인</title>
</head>
<body>
	<div style="height: 100%; width: 100%;">
		<div id="id01" class="modal">
			<div id="body-content">

				<%
				String cookie = "";
				Cookie[] cookies = request.getCookies(); //쿠키생성
				if (cookies != null && cookies.length > 0)
					for (int i = 0; i < cookies.length; i++) {
						System.out.println("확인1, 아이디는 :" + cookies[i].getValue());
						if (cookies[i].getName().equals("id")) { // 내가 원하는 쿠키명 찾아서 값 저장
						System.out.println("확인2, 아이디는 :" + cookies[i].getValue());
					cookie = cookies[i].getValue();
						}
					}
				System.out.println("로그인 성공, 아이디는 :" + cookie);
				%>
				<form class="modal-content" action="login.pet">
					<div class="head">
						<h1 style="font-size: 3vw; text-align: center;"> </h1>
					</div>
					<h1 style="font-size: 3vw; text-align: center;">로그인</h1>
					<div class="out_container" style="text-align: center;">
						<div class="container" style="padding-bottom: 5%; margin-top: 5%;">
							<div class="logincont" style="width: 400px;">
								<input type="text" placeholder="아이디" name="id"
									value="<%=cookie%>" required><br> <input
									type="password" placeholder="비밀번호" name="psw" required><br>
								<label class="checkid"> <input type="checkbox"
									id="saveid" name="remeberId"> 아이디저장
								</label><br>
								<button type="submit">로그인</button>


								<div class="findidpw">
									<a href="findId.jsp" id="findid">아이디찾기</a> <a href="findPw.jsp" id="findpw">비밀번호찾기</a>
									<a href="join.jsp" id="join">회원가입</a>
								</div>
								<br>
							</div>
						</div>
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
	</script>

</body>
</html>