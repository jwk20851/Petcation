<%@page import="java.util.Random"%>
<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<%
	UserVO userVO = (UserVO)session.getAttribute("userVO");
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
/* 
/* Full-width input fields */
input[type=text], input[type=password] {
	border-radius: 25px;
	width: 410px;
	padding: 15px;
	margin: 5px 0 10px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
	box-sizing: border-box;
}

/* Set a style for all buttons */
button {
	border-radius: 25px;
	border-us: 25px;
	background-color: #04AA6D;
	color: white;
	padding: 14px 20px;
	border: none;
	cursor: pointer;
	width: 410px;
}

button:hover {
	opacity: 0.8;
}

h1 {
	text-align: center;
}

p {
	display: none;
	text-align: left;
	color: red;
	font-size: 12px;
}

#psw:hover+p {
	display: block;
	color: red;
}

.clearfix {
	margin-top: 10px;
}

#postalcode {
	width: 295px;
}

.checkposcode {
	padding-top: 12px;
	width: 110px;
}



#email {
	width: 290px;
}

.checkid {
	padding-top: 12px;
	width: 110px;
}

.checkemail {
	padding-top: 12px;
	width: 110px;
}

#crn {
	width: 290px;
}

.checkcrn {
	padding-top: 12px;
	width: 110px;
	margin-left: 5px;
}
}
*
/
</style>
<title>회원정보관리</title>
</head>
<body>
	<div style="height: 100%; width: 100%;">
		<div id="id01" class="modal" style="min-height: 1300px;">
			<div id="body-content">


				<form class="modal-content" name="updateInfoform" id="updateInfoform" action="updateuserinfo.pet" onsubmit="return input_check()">
				<div class="head">
						<h1 style="font-size: 3vw; text-align: center;">회원정보</h1>
					</div>
					<div class="out_container">
						<div class="sidebar">
							<div class="sidenav">
								<h1
									style="font-size: 2vw; text-align: center; margin-top: 10px; margin-bottom: 10px">마이페이지</h1>
								<hr style="margin-bottom: 20px">
								<a href="manageUserInfo.jsp">회원정보</a>
								<a href="petInfo_list.pets">반려동물관리</a>
								<a href="#services">리뷰관리</a>
								<a href="#services">즐겨찾기관리</a>
								<a href="deleteUserInfo.jsp">회원탈퇴</a>
							</div>
						</div>
						<div class="container"
							style="padding-bottom: 5%; padding-right: 15%">
							<div class="container">
								<input type="text" placeholder="아이디" name="id" id="id" value="<%=userVO.getUser_id()%>" readonly="readonly">
								<br> 
								<input type="text" placeholder="이메일" name="email" id="email" value="<%=userVO.getUser_email()%>"  required>
								<button type="button" class="checkemail">인증</button>
								<br id="numberbr" style="display:none;">
								<input type="text" placeholder="인증번호" name="checknumber" id="checknumber" style="display:none;" maxlength="6">
								<input type="hidden" name = "eqn" id ="eqn" value="<%=checkNum%>"><br>
								<input type="password" placeholder="비밀번호" name="psw" id="psw" maxlength="16">
								<p style="text-align: center;">
									영문/숫자/특수문자 2가지 이상 조합 (8~16자)<br> ※ 3개 이상 연속되거나 동일한 문자/숫자
									제외
								</p>
								<br> 
								<input type="password" placeholder="비밀번호 확인" name="psw-repeat" id="psw-repeat" maxlength="16"><br> 
								<input type="text" placeholder="이름" name="name" id="name" value="<%=userVO.getUser_name()%>" maxlength="15"><br>
								<input type="text" placeholder="닉네임" name="nickname" id="nickname" value="<%=userVO.getUser_nickname()%>" maxlength="17"><br>
								<input type="text" placeholder="전화번호" name="phonenumber" id="phonenumber" value="<%=userVO.getUser_phone()%>" maxlength="13"><br> 
								<input type="text" placeholder="우편번호" name="postalcode" id="postalcode" value="<%=userVO.getUser_postcode()%>">
								<button type="button" class="checkposcode">우편번호 검색</button>
								<br> 
								<input type="text" placeholder="기본주소" name="addr" id="addr" value="<%=userVO.getUser_addr()%>"><br> 
								<input type="text" placeholder="상세주소" name="detailaddr" id="detailaddr" value="<%=userVO.getUser_detailaddr()%>"><br>
								<br>

								<div class="clearfix">
									<button type="submit" class="join" style="width: 410px;">저장</button>
									<br>
									<button type="button" class="cancel"
										style="width: 410px; margin-top: 10px;" onclick="location.href='main.jsp'">취소</button>
								</div>
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
			style="display: flex; flex-direction: row; min-height: 220px; align-items: center; justify-content: center; z-index: 10;">
			<div>
				<img src="../images/footer_logo.png"
					style="width: 100%; height: 148px;" />
			</div>
			<div>
				<p1 style="font-size: 2vh;"> <strong>주소</strong> : 대구광역시 수성구
				알파시티1로31길 24-5<br>
				<strong>대표</strong> : 스폰지밥<br>
				<strong>대표전화</strong> : <a href="tel:000-1111-2222" target="_blank"
					style="text-decoration-line: none; color: inherit;">000-111-2222</a>
				<br>
				<br>
				Copyright ⓒ 2021 펫케이션. All rights reserved. Designed by Petcation. <p1
					style="font-size: 1vh;"> <br>
				※ 본 웹사이트는 게시된 사진이 무단 수집되어 도용되는 것을 거부하며, 이를 위반 시 『저작권법』등에 의해 처벌 받을 수
				있습니다.<br>
				사진을 기술적 장치를 사용하여 무단으로 복제, 공연, 공중송신, 전시, 배포, 대여, 2차적저작물 작성의 방법으로 침해한
				자는 [저작권법] 제 136조 제 1항에 의하여 5년 이하의 징역 또는 5천만원 이하의 벌금에 처해집니다.
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
			
			var pw = document.getElementById("psw");
			var email = document.getElementById("email");
			var name = document.getElementById("name");
			var nickname = document.getElementById("nickname");
			var phonenumber = document.getElementById("phonenumber");
			var detailaddr = document.getElementById("detailaddr");
			var checknumber = document.getElementById("checknumber");
			var eqn = document.getElementById("eqn");
			
			var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$/;
			var hangulcheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
			var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
			
			
			if(re.test(email.value) == false){
				alert('이메일 형식에 맞지 않습니다.');
				return false;
			}
			
			if(checknumber.value != eqn.value){
				alert('인증번호가 일치하지 않습니다.');
				return false;
			}
			
			
			if(pw.value != ""){
				if(false === reg.test(pw.value)) {
					
					alert('비밀번호는 8자 이상이어야 하며, 숫자/대문자/소문자/특수문자를 모두 포함해야 합니다.');
					return false;
					
					}else if(/(\w)\1\1/.test(pw.value)){
						
					 alert('같은 문자를 3번 이상 사용하실 수 없습니다.');
					 return false;
					 
					 }else if(pw.value.search(id.value) > -1){
						 
					 alert("비밀번호에 아이디가 포함되었습니다.");
					  return false;
					  
					 }else if(pw.value.search(/\s/) != -1){
						 
					 alert("비밀번호는 공백 없이 입력해주세요.");
					 return false;
					 
					 }else if(hangulcheck.test(pw.value)){
						 
					 alert("비밀번호에 한글을 사용 할 수 없습니다."); 
					 }
					 else{
						 document.updateInfoform.target = "_self";
						 document.updateInfoform.action="updateuserinfo.pet";
						 document.updateInfoform.submit();
					 }
			}
			 else{
				 document.updateInfoform.target = "_self";
				 document.updateInfoform.action="updateuserinfo.pet";
				 document.updateInfoform.submit();
			 }
			
		}
		
		function showPopup() {
			document.getElementById('checknumber').value = null;
			document.getElementById('numberbr').style.display='';
			document.getElementById('checknumber').style.display='';
			window.open("checkJoinEmail.jsp", "이메일인증", "width=400, height=200, left=100, top=50");
			document.updateInfoform.target = "이메일인증";
			document.updateInfoform.action="mailidenti.pet";
			joinform.submit();
		}
		
		function openpost() {
		    new daum.Postcode({
		        oncomplete: function(data) {
		           document.querySelector("#postalcode").value = data.zonecode;
		           document.querySelector("#addr").value =  data.address
		        }
		    }).open();
		}
		document.getElementById('checknumber').value = document.getElementById('eqn').value;
		
		$(window).bind("pageshow", function (event) {
			if (event.originalEvent.persisted) {
				// 뒤로가기로 페이지 로드 시
				location.href = "checkpw.jsp"
			}
			
		});
	</script>

</body>
</html>