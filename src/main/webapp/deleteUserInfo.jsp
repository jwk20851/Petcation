<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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

.delete {
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

#checkbutton{
	margin-top: 20px;
	width: 15%;
}
</style>
<title>병원관리자(비밀번호 확인)</title>
</head>
<body>
	<div style="height: 100%; width: 100%;">
		<div id="id01" class="modal">
			<div id="body-content">


				<form class="modal-content" action="#" name = "deleteinfoForm" id = "deleteinfoForm" onsubmit="return input_check()">
					<div class="head">
					<h1 style="font-size: 3vw; text-align: center">회원탈퇴</h1>
					</div>

					<div class="out_container">
						<div class="sidebar">
							<div class="sidenav">
								<h1
									style="font-size: 2vw; text-align: center; margin-top: 10px; margin-bottom: 10px">마이페이지</h1>
								<hr style="margin-bottom: 20px">
								<a href="../manageUserInfo.jsp">회원정보</a>
								<a href="petInfo_list.pets">반려동물관리</a>
								<a href="#services">리뷰관리</a>
								<a href="#services">즐겨찾기관리</a>
								<a href="../deleteUserInfo.jsp">회원탈퇴</a>
							</div>
						</div>
						<div class="container"
							style="padding-bottom: 5%; padding-left: 5%; padding-right: 5%; display: flex; flex-direction: column;">
							<div class="termscondition" style="border:1px solid; text-align: left;">
								<p style="text-aligin: left; font-size: 1.2vw; margin:2%;">보안을 위해 회원님의 이름과 계정 이메일 및 비밀번호를 확인합니다.</p>
								<hr>
								<p style="text-aligin: left; font-size: 0.9vw; margin:2%;">1. 회원탈퇴 전, 유의사항을 확인해 주시기 바랍니다.
								회원탈퇴 시 회원전용 웹 서비스 이용이 불가합니다. <br>※회사는 원칙적으로 이용자의 개인정보를 회원 탈퇴 시 지체없이 파기하고 있습니다.</p>
								<hr>
								<input type="checkbox" id="deletecheck" name="deletecheck" style="margin:1%; margin-left:2%;">
								<label for="deletecheck" style="margin:1%; font-size: 0.8vw; ">상기 펫케이션 회원탈퇴 시 처리사항 안내를 확인하였음을 동의합니다.</label>
							</div>
							<div class="containercheckpw" style="border:1px solid;font-size: 1vw;text-align: left; padding-left:2%;">
								<p style="text-aligin: left; font-size: 1.2vw; margin:2%; margin-left:0;">보안을 위해 회원님의 이름과 계정 이메일 및 비밀번호를 확인합니다.</p>
								<label for="name">
								이름 : 
								</label>
								<input type="text"
									style="width: 20%; height: 40px; margin-top: 10px; border-radius: 25px; color: black; font-size: 15px; margin-right:1%;"
									 id="name" name="name" required>
								<label for="id">
								아이디 : 
								</label>
								<input type="text"
									style="width: 20%; height: 40px; margin-top: 10px; border-radius: 25px; color: black; font-size: 15px;margin-right:1%;"
									 id="id" name="id" required>
								<label for="checkpsw">
								비밀번호 : 
								</label>
								<input type="password"
									style="width: 20%; height: 40px; margin-top: 10px; border-radius: 25px; color: black; font-size: 15px;margin-right:1%;"
									 id="psw" name="psw" required>
								<button type="button" id="checkbutton" onclick="checkuser()">본인확인</button>
								<input type="hidden" name="popnum" id="popnum">
							</div>
							<div>
								<button type="submit" style="margin-top: 20px; width: 20%;">탈퇴</button>
								<button type="button" style="width: 20%; margin-left: 10px;" onclick="location.href='main.jsp'">취소</button>
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
		
		function input_check(){
			var pw = document.getElementById("psw");
			var num = document.getElementById("popnum").value;
			if(document.getElementById("deletecheck").checked == false){
				alert("탈퇴 약관에 체크해주세요!");
				return false;	
			}
			else{
				if(num == "1"){
					window.open("deleteinfopop.jsp", "회원탈퇴", "width=400, height=50, left=100, top=50");
					return true;
				}
				else{
					alert("본인 확인부터 해주세요!");
					return false;
				}
				
			}
			
		 	
		}
		
		function checkuser(){
			window.open("checkUserpop.jsp", "본인확인", "width=400, height=50, left=100, top=50");
			document.deleteinfoForm.target = "본인확인";
			document.deleteinfoForm.action="checkUser.pet";
			deleteinfoForm.submit();
		}
		
		$(window).bind("pageshow", function (event) {
			if (event.originalEvent.persisted) {
				// 뒤로가기로 페이지 로드 시
				document.checkpwForm.reset();
			}
			
		});
	</script>

</body>
</html>