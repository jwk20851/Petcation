<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-latest.min.js" type="application/javascript"></script>
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

html, body {
	height: 100%;
	margin: 0;
	font-family: Arial, Helvetica, sans-serif;
}

input[type=text] {
	width: 100%;
	margin: 0px 0 0px 0;
	display: inline-block;
	border: none;
	display: inline-block;
	border: none;
	background: none;
	border: none;
	display: inline-block;
	border: none;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus {
	background-color: white;
	outline: none;
	text-align: top;
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
	width: 100px;
}

button:hover {
	opacity: 0.8;
}
}
</style>
<title>예약확인</title>
</head>
<body>
	<div style ="height:100%;width:100%;">
	<div id="id01" class="modal">
	<div id = "body-content">


				<form class="modal-content" action="reservation.jsp"
					onsubmit="return false">
					<div class="head">
						<h1 style="font-size: 3vw; text-align: center;">병원진료예약</h1>
					</div>
					<div class="out_container">
						<div class = "sidebar">
							<div class="sidenav">
							  <h1 style = "font-size:2vw; text-align:center; margin-top:10px; margin-bottom:10px">병원관리</h1>
							  <hr style= "margin-bottom:20px">
							  <a href="watchmgHosInfo.pet">병원정보관리</a>
							  <a href="viewresv.pet">진료예약조회</a>
							  <a href="#services">병원리뷰조회</a>  
							</div>
						</div>
						<div class="container" style="padding-bottom: 5%; padding-left: 5%; padding-right: 5%">
							<input type="hidden" id="tprimary" name="" value="${hospResvVO.tprimary}">
							<table border="1" width="100%" cellpadding="0" cellspacing="0"
							align="center" style="text-align: left; margin-top: 80px;">
							<tr>
								<td style="padding: 5px 20px;">예약자 : ${reserverVO.user_name }</td>
								<td style="padding: 5px 20px;">날짜 : ${resvdateVO.rdate }</td>
								<td style="padding: 5px 20px;">진료시간 : ${hospResvVO.rt }</td>
							</tr>

							<tr>
								<td colspan="2" style="width: 50%; padding: 5px 20px;">진료예약
									동물 : ${hospResvVO.pet_name }</td>
								<td style="padding: 5px 20px;">기타사항 : ${resvpetVO.pet_Infodetail}</td>
							</tr>

							<tr>
							<c:if test="${hospResvVO.pet_name != '없음' }">
								<td colspan="3" style="padding: 5px 20px; line-height: 200%;">나이
									: ${resvpetVO.pet_Age }<br> 품종 : ${resvpetVO.pet_Kind }<br> 성별 : ${resvpetVO.pet_Gender }<br>
									몸무게 : ${resvpetVO.pet_Weight }<br> 질병 : ${resvpetVO.pet_Disease }<br>
								</td>
							</c:if>
							<c:if test="${hospResvVO.pet_name == '없음' }">
								<td colspan="3" style="padding: 5px 20px; line-height: 200%;"><br><br>없음<br><br><br></td>
							</c:if>
								<!-- <td height="auto"><textarea placeholder="진료기록 500자 이내로 적어주세요." id="detailinfo"
										name="detailinfo"
										style="width: 100%; height:200px;font-size: 20px; border: none; resize: none"
										maxlength="500"></textarea></td> -->
							</tr>
						</table>
						<div class="clearfix"
							style="margin-top: 10px;float: right;">

							<button type="button" class="save" onclick="location.href='viewresv.pet'">돌아가기</button>
							<button type="button" class="cancel" onclick="finishtreat()">진료완료</button>
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
				<img src="images/footer_logo.png" style="width: 100%; height: 148px;" />
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
		
		function finishtreat(){
			
			var allData = { "username": "${reserverVO.user_name}",
					"rdate": "${resvdateVO.rdate}",
					"rt" : "${hospResvVO.rt}",
					"petname" : "${hospResvVO.pet_name}",
					"petInfodetail" : "${resvpetVO.pet_Infodetail}",
					"tprimary" : "${hospResvVO.tprimary}"
			};
			
			$.ajax({
		        url:"fintreat.pet",
		        type:"POST",
		        data:allData,
		        success:function(data){
		        	alert("진료완료되었습니다!");
		        	location.reload();
		        },
		        error:function(jqXHR, textStatus, errorThrown){
		            alert("에러 발생");
		        }
		    });
		}
	</script>
	
</body>
</html>