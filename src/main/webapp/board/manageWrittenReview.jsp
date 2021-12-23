<%@page import="vo.PageVO"%>
<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ page import = "vo.BoardVO" %>
<%@ page import = "java.util.List" %>
<%@page import="vo.PageVO"%>
<%@ page import = "vo.BoardVO" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-latest.min.js" type="application/javascript"></script>
<script type="application/javascript" src="js/hangjungdong.js"></script>


<link rel="stylesheet" href="css/common.css">

<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
	#click:hover {
  background: rgba(98, 203, 203, 0.5);
}
#wordline{
word-spacing:10px
}


</style>
<title>리뷰관리_작성리뷰</title>
</head>
<body>
	<div style ="height:100%;width:100%;">
	<div id="id01" class="modal" style = "min-height : 1300px;">
	<div id = "body-content">


				<form class="modal-content" name = "test" id = "test" action="reservation.jsp"
					onsubmit="return false">
					<div class="head">
						<h1 style="font-size: 3vw; text-align: center;">작성리뷰</h1>
					</div>

					<div class="out_container">
						<div class="sidebar">
							<div class="sidenav">
								<h1
									style="font-size: 2vw; text-align: center; margin-top: 10px; margin-bottom: 10px">마이페이지</h1>
								<hr style="margin-bottom: 20px">
								  <a href="#about">회원정보</a> 
									<a href="#services">반려동물정보</a> 
									<a href="manageReview.bo">리뷰관리</a> 
									<a href="bookMark_list.bo">즐겨찾기관리</a> 
									<a href="#services">회원탈퇴</a>
							</div>
						</div>
						<div class="container" style="padding : 5%">
							
 
<c:if test="${empty manageWrittenReview}">
	<table width="700" border="1" cellpadding="0" cellspacing="0">
	<tr>
	    <td align="center">
	    게시판에 저장된 글이 없습니다.
	    </td>
	</table>
</c:if>


<c:if test="${not empty articleList}">
<table border="1" width="100%" cellpadding="0" cellspacing="0" align="center" id = "board"> 

    <tr height="35" > 
     <td align="center"  width="150" id = "click" > <a href = "manageReview.bo">진료 기록</a></td> 
	  <td align="center"  width="150" id = "click" > <a href = "writeAfter.bo">작성한 리뷰</a></td> 
    </tr>  

<c:set var = "number" value = "${pageVO.number}"></c:set>
<c:forEach var = "written" items = "${articleList}">

 <table border="1" width="100%" cellpadding="0" cellspacing="0" align="center" id = "board">  
    <tr>
    <p height="30" align="left"  width="50" style="padding-left:10px;">
     <font size = "4px">   ##병원, 진료반려동물종류 </font>
  </p>

  <p height="30" align="left"  width="300" style="padding-left:10px; float:left;" id = "wordline">

     진료일 : ####.##.## <div style="float:right; padding-right:20px;" id = "wordline">

		  <a href="boardUpdateForm.bo?num=${written.num}&pageNum=${pageVO.currentPage}">		<!-- 현재페이지로 돌아오기 -->
           수정</a>
		   <%-- <a href="boardDeleteForm.bo?num=${written.num}&pageNum=${pageVO.currentPage}" target = "_blank">		<!-- 현재페이지로 돌아오기 -->
           삭제</a>  --%>
           
           <a href = "#" onclick="deleteCode(${written.num},${pageVO.currentPage})">삭제</a>
           
           </div>
   </p>
   
 <br> <p height="30" align="left"  width="300" style="padding-left:10px;  margin-bottom: 5px; ">
	 
   별점 : 
   			<c:if test="${written.rate==1}"> ★ </c:if>
   			<c:if test="${written.rate==2}"> ★★ </c:if>
   			<c:if test="${written.rate==3}"> ★★★ </c:if>
   			<c:if test="${written.rate==4}"> ★★★★ </c:if>
   			<c:if test="${written.rate==5}"> ★★★★★ </c:if>
	
    작성일 :  <fmt:formatDate pattern="yyyy-MM-dd " value="${written.reg_date}"/>
  
   </p>
     </tr>
     </table>
				<!-- 여기까지가 글 목록 작업 -->
		</c:forEach>
</table>				<!-- 여기까지가 글 목록 작업 -->
<%-- <%}%> --%>
</c:if>
<br>
<c:if test="${pageVO.count > 0}">
        <c:if test="${pageVO.startPage > 10}">
        	<a href="writeAfter.bo?pageNum=<%-- <%= startPage - 10 %> --%>${pageVO.startPage - 10}">[이전]</a>
     	</c:if>

        <c:forEach begin="${pageVO.startPage}" end="${pageVO.endPage}" var = "i">
        <a href="writeAfter.bo?pageNum=<%-- <%= i %> --%>${i}">[<%-- <%= i %> --%>${i}]</a>	<!-- 해당번호를 클릭하면 클린한 페이지로 이동한다. -->
		</c:forEach>

     	<c:if test="${pageVO.endPage < pageVO.pageCount}">
        <a href="writeAfter.bo?pageNum=<%-- <%= startPage + 10 %> --%>${pageVO.startPage + 10}">[다음]</a>
        </c:if>
</c:if>
							
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
	             location.href="http://localhost:8088/petcation/boardDeleteForm.bo?num=" + getNum ;

	             document.form.submit();
	         }else{   //취소
	             return;
	         }
		}
		
		
	</script>
	
</body>
</html>