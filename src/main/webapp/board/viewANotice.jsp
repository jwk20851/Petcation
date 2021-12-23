<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri= "http://java.sun.com/jsp/jstl/fmt" %>
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
#noticebutton{
		width:60%;
	height:40px;
	float:right;
	margin-top:5%;
	}
textarea{
	width : 100%;
	height : 100%;
	border : none;
	
}
</style>
<title>고객센터(A공지사항조회)</title>
</head>
<body>
	<div style ="height:100%;width:100%;">
	<div id="id01" class="modal">
	<div id = "body-content">


				<form class="modal-content" action="reservation.jsp"
					onsubmit="return false">
					<div class="head">
						<h1 style="font-size: 3vw; text-align: center;">공지사항 조회</h1>
					</div>

					<div class="out_container">
						<div class="sidebar">
							<div class="sidenav">
								<h1
									style="font-size: 2vw; text-align: center; margin-top: 10px; margin-bottom: 10px">고객센터</h1>
								<hr style="margin-bottom: 20px">
									<a href="noticeAList.bo">공지사항</a> 
									<a href="afaqList.bo">FAQ</a> 
									<a href="amtmList.bo">1대1문의내역</a> 
							</div>
						</div>
						<div class="container" style="padding : 5%">
							<table border="1" width="100%" cellpadding="0" cellspacing="0" align="center" id = "board"> 
    			<tr height = "35">
    				<input type="hidden" name="num" value="${boardVO.num}"> 
					<td width="100" align="center">${boardVO.title}</td>
					<td width="70" align="center">작성자</td>
					<td width="70" align="center"><fmt:formatDate pattern="yyyy-MM-dd " value="${boardVO.reg_date}"/></td>
					<td width="70" align="center">조회수 : ${boardVO.readcount}</td>
				</tr>
				</table>
				<table border="1" width="100%" height= "150%" cellpadding="0" cellspacing="0" align="center" id = "board"> 
				<tr>
					<td width="70" align="center">내 용</td>
					<td width="630"><textarea style = "resize : none; height : 100%;" name="content" readonly>${boardVO.content}</textarea>
					</td>
				</tr>
				
				</table>
				<table width="100%" align="center">
				
				<tr >
					<td colspan=2 align="right" id = noticebutton>
					<input type="button" value="글목록"  style = "width:15%; height:40px;  margin-right:10px;" 
					 onclick="document.location.href='noticeAList.bo?'">
					<input type="submit" value="수정"  style = "width:15%; height:40px;  margin-right:10px;" 
					onclick="document.location.href='anotice_updateForm.bo?num=${boardVO.num}'">
					<input type="button" value="삭제" style = "width:15%; height:40px;  margin-right:10px;"
					OnClick="deleteCode(${boardVO.num})">
					</td>
				</tr>
			</table>
							<br>
						</div>
						
					</div>

					<div class="header">
						<nav>
							<ul class="topnav" id="myTopnav">
								<li class="menu_a"><a href="#home"><img
										src="images/logo.png" id="logo" /></a></li>
								<li class="menu_a"><a href="#reserveHosp">병원예약</a></li>
								<li class="menu_a"><a href="#searchHosp">병원검색</a></li>
								<li class="menu_a"><a href="#myHosp">MY병원</a></li>
								<li class="menu_a"><a href="#cusCenter">고객센터</a></li>
								<li class="menu_a"><a href="#manageHosp">병원관리</a></li>
								<li class="space"></li>
								<li class="menu_a"><a href="#login">로그인</a></li>
								<li class="menu_a"><a href="#regist">회원가입</a></li>
								<li2 class="menu_a"> <a href="javascript:void(0);"
									class="icon" onclick="myFunction()"> <i class="fa fa-bars"></i>
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
		
		function deleteCode(getNum){
			
	         if (confirm("정말 삭제하시겠습니까??") == true){    //확인
	             location.href="http://localhost:8088/petcation/ANoticeDeleteContent.bo?num=" + getNum ;
				
	             document.form.submit();
	         }else{   //취소
	             return;
	         }
		}
	</script>
	
</body>
</html>