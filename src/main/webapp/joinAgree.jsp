
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

<link rel="stylesheet" href="css/common2.css">

<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
* {
	box-sizing: border-box;
}

.regist {
	text-align: center;
	margin-left: 49.5%;
}

.add {
	border-radius: 25px;
	background-color: #04AA6D;
	color: white;
	padding: 10px 10px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 80px;
}

.agreecheck {
	border-radius: 25px;
	background-color: #04AA6D;
	color: white;
	padding: 10px 10px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 80px;
}

html, body {
	height: 100%;
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

input[type=text] {
	border-radius: 25px;
	width: 100%;
	padding: 15px;
	margin: 5px 0 10px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

button {
	border-radius: 25px;
	border-us: 25px;
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 20px;
}

#checkbutton {
	margin-top: 20px;
	width: 15%;
}

.out_container {
	display: grid;
	grid-template-columns: 120%;
	padding-left: 30%;
	padding-right: 20%;
	padding-bottom: 5%;
	text-align: center;
	height: 50%; /* 100% */
	margin-right: 13%;
}

.info, .info2 {
	border-radius: 0px;
	background-color: white;
	color: black;
	border: 1px;
	cursor: pointer;
}
</style>
<title>회원가입확인</title>
</head>
<body>
	<div style="height: 100%; width: 100%;">
		<div id="id01" class="modal">
			<div id="body-content">


				<form class="modal-content" action="join.jsp"
					onsubmit="return input_check()">
					<div class="head">
						<h1 style="font-size: 3vw; text-align: center">회원가입확인</h1>
					</div>

					<div class="out_container">
						<div class="container"
							style="margin-left: 0; padding-bottom: 5%; padding-left: 5%; padding-right: 5%; display: flex; flex-direction: column;">
							<div class="termscondition"
								style="border: 1px solid; text-align: left;">
								<p style="text-align: center; font-size: 1.2vw; margin: 2%;">펫케이션
									서비스약관에 동의해주세요</p>
								<hr>
								<p style="text-aligin: left; font-size: 0.9vw; margin: 2%;">
									[필수] 개인정보처리방침
									<button type="button" class="info"
										style="width: 20%; padding: 0px 0px; font-size: 0.9vw;"
										onclick="personalpop()">[더보기]</button>
									<br>동의<input type="checkbox" id="personalcheck"
										name="personalcheck" style="margin: 1%; margin: 2%;"><br>
									<br> <br> [필수] 서비스이용약관
									<button type="button" class="info2"
										style="width: 20%; padding: 0px 0px; font-size: 0.9vw;"
										onclick="servicepop()">[더보기]</button>
									<br>동의<input type="checkbox" id="servicecheck"
										name="servicecheck" style="margin: 1%; margin: 2%;">
								</p>
								<hr>
								<input type="checkbox" id="agreecheck" name="agreecheck"
									onclick="agreement()"
									style="padding: 20px 20px; margin: 2%; margin-left: 35%;">
								<label for="agreecheck" style="margin: 1%; font-size: 0.8vw;">모든
									약관에 동의합니다.</label>
							</div>

							<div>
								<button type="submit" style="margin-top: 20px; width: 20%;">다음</button>
								<button type="button" style="width: 20%; margin-left: 10px;"
									onclick="location.href=main.jsp">취소</button>
							</div>
							<br>
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
			if (x.className == "topnav") {
				x.className += " responsive";
			} else {
				x.className = "topnav";
			}
		}
		function agreement() {
			var service = document.getElementById("servicecheck");
			var personal = document.getElementById("personalcheck");
			var agree = document.getElementById("agreecheck");

			if (agree.checked == true) {
				service.checked = true;
				personal.checked = true;
			} else {
				service.checked = false;
				personal.checked = false;
			}
		}

		function input_check() {
			var service = document.getElementById("servicecheck");
			var personal = document.getElementById("personalcheck");
			var agree = document.getElementById("agreecheck");

			if (service.checked == false || personal.checked == false) {
				alert("모든 약관에 동의해주세요!");
				return false;
			} else {
				
				return true;
			}

		}

		function personalpop() {
			window.open("personalpop.jsp", "개인정보처리방침",
					"width=400, height=700, left=750, top=150");
		}
		function servicepop() {
			window.open("servicepop.jsp", "서비스이용약관",
					"width=400, height=700, left=750, top=150");
		}
		$(window).bind("pageshow", function(event) {
			if (event.originalEvent.persisted) {
				// 뒤로가기로 페이지 로드 시
				document.checkpwForm.reset();
			}

		});
	</script>

</body>
</html>
