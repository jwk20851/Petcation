<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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

input[type=text] {
	border-radius: 25px;
	width: 48%;
	padding: 15px;
	margin: 5px 0 10px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}
</style>
<title>예약확인</title>
</head>
<body>
	<div style="height: 100%; width: 100%;">
		<div id="id01" class="modal">
			<div id="body-content">


				<form class="modal-content" action="reservation.jsp" name="selfResvListForm"
					onsubmit="return false">

					<div class="head">
						<h1 style="font-size: 3vw; text-align: center;">병원진료예약</h1>
					</div>
					<div class="out_container">
						<div class="sidebar">
							<div class="sidenav">
								<h1
									style="font-size: 2vw; text-align: center; margin-top: 10px; margin-bottom: 10px">병원예약</h1>
								<hr style="margin-bottom: 20px">
								<a href="findpetName.pet">병원진료예약</a>
                 				<a href="findselfresv.pet">진료예약조회</a>
							</div>
						</div>
						<div class="container"
							style="padding-bottom: 5%; padding-left: 5%; padding-right: 5%">
							<table border="1" width="100%" cellpadding="0" cellspacing="0"
								align="center"
								style="text-align: center; margin-top: 80px; height: 150px;">

								<tr style="background-color: gray; height: 50px;"">
									<th>병원명</th>
									<th><input type="checkbox" id="allCheck" name="allCheck"
										onclick="checkAll()" /></th>
									<th colspan="2">반려동물정보</th>
									<th>예약동물</th>
									<th>예약일</th>
								</tr>
                      			<c:if test="${not empty findResvList}">
                      			<c:forEach var="resvList" items="${findResvList}" varStatus="status">
								<c:if test="${resvList.pet_name == '없음'}">
                      			<tr style="height: 50px;">
									<td>${resvList.hos_name}</td>
									<th><input type="checkbox" class="tdcheck" id="tdcheck" name="tdcheck" onclick="Checkrow(this, '${resvList.tprimary}', '${resvList.time_num}')"/></th>
									<td
										style="text-align: left; padding-left: 10px; font-size: 20px;">
										<input type="hidden" id="tpri" name="tpri" value="${resvList.tprimary}">
										<input type="hidden" id="time_num" name="time_num" value="${resvList.time_num}">
										
										없음</td>
									<td align="center" width="5%" style="cursor: pointer;"
										id="maxmin" onclick="maxmin()">닫기</td>
									<td>${resvList.pet_name}</td>
									<td>${findresvdate.get(status.index).rdate}</td>
								</tr>
								<tr style="padding: 10px, 10px;" id="answer1">
									<td colspan="6" style="text-align: left; padding: 20px 10px;"></td>
								</tr>
                      			</c:if>
                      			<c:if test="${resvList.pet_name != '없음'}">

								<tr style="height: 50px;">
									<td>${resvList.hos_name}</td>
									<th><input type="checkbox" class="tdcheck" id="tdcheck" name="tdcheck" onclick="Checkrow(this, '${resvList.tprimary}', '${resvList.time_num}')"/></th>
									<td
										style="text-align: left; padding-left: 10px; font-size: 20px;">반려동물
										나이 : ${findresvpet.get(status.index).pet_Age}<br> 반려동물 품종 : ${findresvpet.get(status.index).pet_Kind}<br> 반려동물 성별 : ${findresvpet.get(status.index).pet_Gender}<br>
										반려동물 몸무게 : ${findresvpet.get(status.index).pet_Weight}<br> 반려동물 질병 : ${findresvpet.get(status.index).pet_Disease}<br>
										<input type="hidden" id="tpri" name="tpri" value="${resvList.tprimary}">
										<input type="hidden" id="time_num" name="time_num" value="${resvList.time_num}">
										</td>
									<td align="center" width="5%" style="cursor: pointer;"
										id="maxmin" onclick="maxmin()">닫기</td>
									<td>${resvList.pet_name}</td>
									<td>${findresvdate.get(status.index).rdate}</td>
								</tr>
								<tr style="padding: 10px, 10px;" id="answer1">
									<td colspan="6" style="text-align: left; padding: 20px 10px;">${findresvpet.get(status.index).pet_Infodetail}</td>
								</tr>
								</c:if>
								</c:forEach>
								</c:if>
								<c:if test="${empty findResvList}">
								<tr>
									
									<td colspan="6">없음</td>
									
								</tr>
								</c:if>

							</table>
							<div class="clearfix" style="margin-top: 10px; float: right;">

								<button type="button" class="save" onclick="findpetName.pet">돌아가기</button>
								<button type="button" class="cancel" onclick="cancelresv()">예약취소</button>
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
			if (x.className === "topnav") {
				x.className += " responsive";
			} else {
				x.className = "topnav";
			}
		}
		function maxmin() {
			if (document.getElementById('maxmin').innerHTML == "닫기") {
				document.getElementById('answer1').style.display = 'none';
				document.getElementById('maxmin').innerHTML = "열기";
			} else {
				document.getElementById('answer1').style.display = '';
				document.getElementById('maxmin').innerHTML = "닫기";
			}
		}

		function checkAll() {
			var allCheck = document.getElementById("allCheck");
			var x = document.getElementsByClassName("tdcheck");			
			if(allCheck.checked){
				

				for(var i of x){
					i.checked = true;
				}
			}
			else{
				for(var i of x){
					i.checked = false;
				}
			}
		}
		

		var tparr = [];
		var timearr = [];
		var tnum = 0;
		function Checkrow(e0, e1, e2){
			
				if(e0.checked == true){
					
					
				}
				
				
			
		}
		
		function cancelresv(){
			var x = document.getElementsByClassName("tdcheck");			

			for(var i of x){
				if(i.checked == true){
					tparr[tnum] = i.parentNode.parentNode.cells[2].getElementsByTagName("input")[0].value;
					timearr[tnum] = i.parentNode.parentNode.cells[2].getElementsByTagName("input")[1].value;
					tnum++;
				}
			}
			
			
			
			$.ajax({
			    method      : 'POST',
			    url         : 'cancelresv.pet',
			    traditional : true,
			    data        : {
			        'tp' : tparr,
			        'tm' : timearr
			    },
			    success     : function(data) {
			    	tparr = [];
					timearr = [];
					tnum = 0;
					location.href="findselfresv.pet";     
			    },
			    error       : function(request, status, error) {
			        alert("예약취소 실패하였습니다!");
			    }
			 
			});

			
			
			
		}
	</script>

</body>
</html>