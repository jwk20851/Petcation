<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="vo.PageVO"%>
<%@ page contentType = "text/html; charset=UTF-8" %>
<%@ page import = "vo.BoardVO" %>
<%@ page import = "java.util.List" %>
<%@ page import = "java.text.SimpleDateFormat" %>


<%!SimpleDateFormat sdf = 
        new SimpleDateFormat("yyyy-MM-dd");
    //2021-01-12 09:17%>

<%
	List<BoardVO> articleList = (List<BoardVO>)request.getAttribute("articleList");
	PageVO pageVO = (PageVO)request.getAttribute("pageVO");
	int count = pageVO.getCount();
	int currentPage = pageVO.getCurrentPage();
	int startPage = pageVO.getStartPage();
	int number = pageVO.getNumber();
	int endPage = pageVO.getEndPage();
	int pageCount = pageVO.getPageCount();
%>
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

</style>
<title>병원관리(병원리뷰조회)</title>
</head>
<body>
	<div style ="height:100%;width:100%;">
	<div id="id01" class="modal">
	<div id = "body-content">


				<form class="modal-content" action="reservation.jsp"
					onsubmit="return false">
					<div class="head">
						<h1 style="font-size: 3vw; text-align: center;">병원관리</h1>
					</div>

					<div class="out_container">
						<div class="sidebar">
							<div class="sidenav">
								<h1
									style="font-size: 2vw; text-align: center; margin-top: 10px; margin-bottom: 10px">병원리뷰조회</h1>
								<hr style="margin-bottom: 20px">
								<a href="#about">병원정보관리</a>
					  <a href="viewReserveList.bo">진료예약조회</a>
					  <a href="viewReviewList.bo">병원리뷰조회</a>
							</div>
						</div>
						<div class="container" style="padding-bottom: 5%; margin-top: 5%;">
							 
 
<%
if (count == 0) {
%>

<table border="1" width="100%" cellpadding="0" cellspacing="0" align="center" id = "board">
<tr>
    <td align="center">
    게시판에 저장된 글이 없습니다.
    </td>
</table>

<%
	} else {
%>

<table border="1" width="100%" cellpadding="0" cellspacing="0" align="center" id = "board"> 
    <tr height="30"> 
      <td align="center"  width="50"  >번 호</td> 
      <td align="center"  width="250" >내용</td> 
      <td align="center"  width="50" >평점</td>    
      <td align="center"  width="100" >아이디</td>
      <td align="center"  width="150" >작성일</td> 
    </tr>
<%
for (int i = 0 ; i < articleList.size() ; i++) {
          BoardVO article = (BoardVO)articleList.get(i);
%>

   <tr height="30">
    <td align="center"  width="50" > <%=article.getNum()%></td>	
    <td align="center"  width="50" > <%=article.getContent()%></td>	
    <td align="center"  width="50" > 평점 </td>	
    
    <td align="center"  width="50"><%=article.getWriter()%> </td>
    <td align="center"  width="100">
       <%= sdf.format(article.getReg_date())%></td>
    	
  </tr>
	     <%}%>

</table>				<!-- 여기까지가 글 목록 작업 -->

<%}%>


<%
    if (count > 0) {			/* 여기 부턴 페이징 작업 */
        
        if (startPage > 10) { //첫번째 페이지 그룹이 아니면...  이전그룹의 startPage로 이동 %>
  		
      	  <a href="viewReviewList.bo?pageNum=<%= startPage - 10 %>">">[이전]</a>
        
<%      }
        for (int i = startPage ; i <= endPage ; i++) {  
     	%>
     	
        <a href="viewReviewList.bo?pageNum=<%= i %>">[<%= i %>]</a>	<!-- 해당번호를 클릭하면 클린한 페이지로 이동한다. -->
        
<%
        }
        if (endPage < pageCount) { //현재 페이지그룹이 마지막 페이지 그룹이 아닐때 다음 페이지그룹의 startPage로 이동 
     		%>
     		
        <a href="viewReviewList.bo?pageNum=<%= startPage + 10 %>">[다음]</a>
        
<%
        }
    }
%>
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
	</script>
	
</body>
</html>