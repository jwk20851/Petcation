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
	

<link rel="stylesheet" href="css/common_single.css">
<link rel="stylesheet" href="css/logintype/join.css">

<meta name="viewport" content="width=device-width, initial-scale=1">


<title>회원가입</title>
</head>
<body>
	<div style="height: 100%; width: 100%;">
		<div id="id01" class="modal" style="min-height: 1300px;">
			<div id="body-content">


				<form class="modal-content" name="joinform" id="joinform" action="join.pet" onsubmit="return input_check()">
					<div class="head">
						<h1 style="font-size: 3vw; text-align: center;">회원가입</h1>
					</div>

					<div class="out_container">

						<div class="container" style="padding-bottom: 5%;">
							<div class="container">
								<input type="text" placeholder="아이디" name="id" id="id" required="required" maxlength="12">
								<button type="button" class="checkid" onclick="checkolid()">중복 확인</button>
								<br> <input type="text" placeholder="이메일" name="email"
									id="email" required="required">
								<button type="button" id="checkemail" class="checkemail" onclick="showPopup()">인증</button>
								<br id="numberbr" style="display:none;">
								<input type="text" placeholder="인증번호" name="checknumber" id="checknumber" required="required"
								style="display:none;" maxlength="6">
								<input type="hidden" name = "eqn" id ="eqn" value="<%=checkNum%>">
								<br> <input type="password" placeholder="비밀번호" name="psw"
									id="psw" required="required" maxlength="16">
								<p style="text-align: center;">
									영문/숫자/특수문자 2가지 이상 조합 (8~16자)<br> ※ 3개 이상 동일한 문자/숫자
									제외
								</p>
								<br> <input type="password" placeholder="비밀번호 확인"
									name="psw-repeat" id="psw-repeat" required="required" maxlength="16"><br> 
								<input type="text" placeholder="이름" name="name" id="name" required="required" maxlength="15"><br>
								<input type="text" placeholder="닉네임" name="nickname" id="nickname" required="required" maxlength="17"><br>
								<input type="text" placeholder="전화번호" name="phonenumber"
									id="phonenumber" required="required" maxlength="13"><br> 
								<input type="text"
									placeholder="우편번호" name="postalcode" id="postalcode" readonly="readonly" required="required">
								<button type="button" class="checkposcode" id="checkposcode" onclick="openpost()">우편번호 검색</button>
								<br> <input type="text" placeholder="기본주소" name="addr"
									id="addr" readonly="readonly" required><br> 
								<input type="text"
									placeholder="상세주소" name="detailaddr" id="detailaddr" required><br>
								
								<br>

								<div class="clearfix">
									<button type="submit" class="join">회원가입</button>
									<br>
									<button type="button" class="cancel">취소</button>
								</div>
							</div>
							<br>
						</div>
					</div>

					<div class="header">
				<nav>
		            <ul class="topnav" id = "myTopnav">
		                <li class="menu_a"> <a href="main.jsp"><img src="images/logo.png" id = "logo"/></a> </li>
		                <li class="menu_a"> <a href="#reserveHosp">병원예약</a> </li>
		                <li class="menu_a"> <a href="#searchHosp">병원검색</a> </li>
		                <li class="menu_a"> <a href="#myHosp">MY병원</a> </li>
		                <li class="menu_a"> <a href="#cusCenter">고객센터</a> </li>             
		                <li class="menu_a"> <a href="#manageHosp">병원관리</a> </li>             
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
				<img src="images/footer_logo.png"
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
					style="font-size: 1vh;">
				<br>
				※ 본 웹사이트는 게시된 사진이 무단 수집되어 도용되는 것을 거부하며, 이를 위반 시 『저작권법』등에 의해 처벌 받을 수
				있습니다.<br>
				사진을 기술적 장치를 사용하여 무단으로 복제, 공연, 공중송신, 전시, 배포, 대여, 2차적저작물 작성의 방법으로 침해한
				자는 [저작권법] 제 136조 제 1항에 의하여 5년 이하의 징역 또는 5천만원 이하의 벌금에 처해집니다.
				</p>
			</div>
		</div>
	</div>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
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
			var id = document.getElementById("id");
			var pw = document.getElementById("psw");
			var email = document.getElementById("email");
			var name = document.getElementById("name");
			var nickname = document.getElementById("nickname");
			var phonenumber = document.getElementById("phonenumber");
			var detailaddr = document.getElementById("detailaddr");
			var checknumber = document.getElementById("checknumber");
			var eqn = document.getElementById("eqn");
			
			var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,16}$/;	//비번 유효성 검사
			var hangulcheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
			var re = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;
			var idReg = /^[a-zA-z0-9]{4,12}$/; //아이디 유효성 검사
			
			if(re.test(email.value) == false){
				alert('이메일 형식에 맞지 않습니다.');
				return false;
			}
			
			if(checknumber.value != eqn.value){
				alert('인증번호가 일치하지 않습니다.');
				return false;
			}
			
			
	        if (!idReg.test(id.value)) {
	            alert("아이디는 영문 대소문자와 숫자 4~12자리로 입력해야합니다!");
	            return false;
	        }

			
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
				 document.joinform.target = "_self";
				 document.joinform.action="join.pet";
				 document.joinform.submit();
			 }
			
			
		}
		
		function checkolid(){
			window.open("checkOlId.jsp", "중복확인", "width=400, height=200, left=100, top=50");
			document.joinform.target = "중복확인";
			document.joinform.action="checkolid.pet";
			joinform.submit();
		}
		
		function showPopup() {
			document.getElementById('numberbr').style.display='';
			document.getElementById('checknumber').style.display='';
			window.open("checkJoinEmail.jsp", "이메일인증", "width=400, height=200, left=100, top=50");
			document.joinform.target = "이메일인증";
			document.joinform.action="mailidenti.pet";
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
		
		$(window).bind("pageshow", function (event) {
			if (event.originalEvent.persisted) {
				// 뒤로가기로 페이지 로드 시
				document.joinform.reset();
			}
			
		});
	</script>

</body>
</html>