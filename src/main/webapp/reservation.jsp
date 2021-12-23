<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/reservetype/reservation.css">
<link rel="stylesheet" href="css/common.css">
<script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>
<script src="js/reservation/reservation.js"></script>
<script type="text/javascript" src="js/reservation/hangjungdong.js"></script>
<script type="text/javascript" src="js/reservation/dongscript.js"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Insert title here</title>
</head>
<body>
   <div style ="height:auto;width:100%;">
   <div id="id01" class="modal">
   <div id = "body-content">
   
      <form class="modal-content" name="resvForm" id="resvForm" method="post" action="reservation.jsp" onsubmit="return false">
         <div class="head">
      <h1 style = "font-size:3vw; text-align: center">병원진료예약</h1>
      <input type="hidden" name="tt" id="tt" value="${tt }">
      <input type="hidden" name="hntt" id="hntt" value="${hntt }">
      <input type="hidden" name="adr" id="adr" value="${adr}">
      <input type="hidden" name="searchHospname" id="searchHospname" value="${param.searchHospname }">
      </div>
         <div class="out_container">
            <div class = "sidebar">
               <div class="sidenav">
                 <h1 style = "font-size:2vw; text-align:center; margin-top:10px; margin-bottom:10px">병원예약</h1>
                 <hr style= "margin-bottom:20px">
                 <a href="findpetName.pet">병원진료예약</a>
                 <a href="findselfresv.pet">진료예약조회</a>
               </div>
            </div>
            <div class="container" style="padding-bottom:5%;">
               <div class="hostime" style="margin-top:5%; padding-bottom:5%;">
                  <div class = "hospitalfind">
                     <div class = "hosfind" style="display:flex;">
                       	<div id="hn" style="width:90%;padding:1%">${hntt }</div>
                       	<input type="hidden" id="sendhn" name="sendhn" value="${hntt }"> 
                       	<button class = "find"  onclick="find()">찾기</button>
                     </div>
                  </div>
                  <div class = "hospetname">
                  <select name="petname" id="petname">
                  <option selected="selected">반려동물 선택</option>
                  
                  	<c:if test="${not empty findpetnameList}">
                      <c:forEach var="petList" items="${findpetnameList}" varStatus="status">
                      <c:if test="${petname == petList.pet_Name}">
                      <option selected="selected">${petList.pet_Name }</option>
                      </c:if>
                      <c:if test="${petname != petList.pet_Name}">
                      <option>${petList.pet_Name }</option>   
                      </c:if>
                      </c:forEach>
                     
                      <c:if test="${empty findpetnameList}">
                      <option>없음</option>
                      </c:if>
                      </c:if>
                  
                  
                  
                  
                      
                      
                 </select>
                 </div>
                 <div class = "hosdate">
                       <input type="text" name="date" id="date" value = "${pickdate }" readonly>
                     <table class="scriptCalendar">
                         <thead>
                             <tr style = "font-size:2vh;">
                                 <td colspan="2" onClick="prevCalendar();" style="cursor:pointer;">&#60;&#60;</td>
                                 <td colspan="3">
                                     <span id="calYear">YYYY</span>년
                                     <span id="calMonth">MM</span>월
                                 </td>
                                 <td colspan="2" onClick="nextCalendar();" style="cursor:pointer;">&#62;&#62;</td>
                             </tr>
                             <tr style="font-weight: bold;">
                                 <td>일</td><td>월</td><td>화</td><td>수</td><td>목</td><td>금</td><td>토</td>
                             </tr>
                         </thead>
                         <tbody></tbody>
               </table>
               <input type="hidden" id="pickdate" name="pickdate" value="${pickdate }">
                 </div>
                 <div class = "timelist">
                  <input type="text" name="time" id="time" readonly="readonly"/>
                  <div class="listcontents" style = "width: 80%; height:100%;overflow:auto; margin-left:5%;">
                  <c:if test="${not empty findHosResvList}">
                  <c:forEach var="rvList" items="${findHosResvList}" varStatus="status">
                  	<div class="listcont" onclick="showrv('${rvList.rt}', '${rvList.user_id}')" style="text-align:center;padding:1%;font-size:50%">
                  		<c:if test="${not empty rvList.user_id }">
						<p id="hoslocat" style="padding-top:1%;padding-bottom:1%; background-color:#E5E5E5;margin:-1%;width:102%;height:105%;">
						<span style="margin-right:10%;">${rvList.rt }</span>/<span style="margin-left:10%;">예약완료</span>
						</p>                     	
						</c:if>
                     	<c:if test="${empty rvList.user_id && rvList.rt!='점심시간'}">
                     	<p id="hoslocat"><span style="margin-right:10%;">${rvList.rt }</span>/<span style="margin-left:10%;">예약가능</span></p>
                     	</c:if>
                     	<c:if test="${rvList.rt=='점심시간'}">
                     	<p id="hoslocat">${rvList.rt }</p>
                     	</c:if>
                     </div>
                  </c:forEach>
                     
                  </c:if>
                  <c:if test="${empty findHosResvList}">
                  	<p>병원부터 선택해주세요~!</p>
                  </c:if>
                  </div>
                   </div>
                 <div class = "hospitalfind">
                    <input type="button" value="예약목록조회" class="selectres">
                 </div>
                 <div class = "hospetname">
                    <input type="button" value="예약" class="reservation" onclick="resv()">
                   </div>   
                 </div>
                 <br>
            </div>
         </div>
         
   <div id="id02" class="contentmodal">
     <div class = "contmodal-content">
    <div class="imgcontainer">
      <span onclick="closepop()" class="close" title="Close Modal">&times;</span>
      <h1 style="margin-bottom:2%;font-size:2.5vw">의료기관찾기</h1>
    </div>

    <div class="contentcontainer">
      <hr style="width:100%; margin-left: auto;margin-right: auto;">

     <input type="text" name="shos" id="shos" value="${param.shos }" style = "width:50%; margin-right: 5%;">
    
  
    <button type="button" id="searchhos" onclick="searchhospital()">동물병원검색</button>
    <p style="text-align: left;margin-left:4%;">총 검색결과 : </p>
    </div>
    <div class="contentcontainer2">
    
       <div style = "width: 100%; height:320px; border:1px solid;overflow:auto;">
       <input type="hidden" name="showpop" id="showpop" value="${showPop }">
       <c:if test="${not empty findHosList}">
       <c:set var="hosvar" value="0"></c:set>
       <c:forEach var="hosList" items="${findHosList}" varStatus="status">
              <c:set var="hosvar" value="${status.index}"></c:set>
             <div class="listcont" id="lt" onclick="showhospinfo('${hosList.dnum }','${hosList.hosp_name }', '${hosList.hosp_address2 }', '${hosList.hosp_time }', '${fn:substring(fn:replace(hosList.hosp_tel, '-',''),0,3)}-${fn:substring(fn:replace(hosList.hosp_tel, '-',''),3,7)}-${fn:substring(fn:replace(hosList.hosp_tel, '-',''),7,11)}')">
                <p id = "hoslocat">${hosList.hosp_address2 }</p>
                <p id = "hosname">${hosList.hosp_name }</p>
                <p id = "rating">평점</p>
             </div>
             
       </c:forEach>
       </c:if>
       <c:if test="${empty findHosList}">
             	해당 병원 정보가 없습니다!
             </c:if>     
       </div>
         <div id="hif" style = "width: 100%; height:100%">
             <div style = "width: 100%; height:100%; border:1px solid; overflow:auto; text-align:left; padding:10px;">
             <c:if test="${not empty findHosList}">
                <div style = "text-align:right;">
                
                <c:if test="${not empty findHosList}">
                    <button id = "choose" onclick="hoschos()">선택</button>
                 </c:if>
                
                </div>
                <p id="hosinfoname">${findHosList.get(0).hosp_name}</p>
               
                <div>
                   <input id = "address" readonly="readonly" value="${findHosList.get(0).hosp_address2}">
                   <b><a href="javascript:void(0);" onclick="copy()" style="text-decoration: underline;font-size:2.5vh;">주소복사</a></b>
                </div>
                
                <p id="hosinfotime">영업시간 : ${findHosList.get(0).hosp_time}</p>
                <p id="hosinfotel">전화번호 : ${fn:substring(fn:replace(findHosList.get(0).hosp_tel, '-',''),0,3)}-${fn:substring(fn:replace(findHosList.get(0).hosp_tel, '-',''),3,7)}-${fn:substring(fn:replace(findHosList.get(0).hosp_tel, '-',''),7,11)}
                </p>
                <p>평점 : 
                   <div class="rate">
                   <input type="radio" id="star5" name="rate" value="5" />
                   <label for="star5" title="text">5 stars</label>
                   <input type="radio" id="star4" name="rate" value="4" />
                   <label for="star4" title="text">4 stars</label>
                   <input type="radio" id="star3" name="rate" value="3" />
                   <label for="star3" title="text">3 stars</label>
                   <input type="radio" id="star2" name="rate" value="2" />
                   <label for="star2" title="text">2 stars</label>
                   <input type="radio" id="star1" name="rate" value="1" />
                   <label for="star1" title="text">1 star</label>
                </div>
                </p>
                <br><br>
                <b><a href="javascript:void(0);" onclick="showmap()" style="text-decoration: underline;font-size:2.5vh">지도에서 보기</a></b>
                
               </c:if>
             <c:if test="${empty findHosList}">
             	병원을 선택해주세요!
             </c:if>
             </div>
       </div>
    
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
   
     
     
      $(window).bind("pageshow", function (event) {
        
       if ($("#showpop").val() == "2" ) {
         
         
         document.getElementById('id02').style.display="block";
         lt.click();
         
      }else{
    	  if($("#searchHospname").val() != ""){
    		  document.getElementById('id02').style.display="block";
    		  document.getElementById('shos').value = document.getElementById('searchHospname').value
    		  location.href="searchHosp.pet?shos="+document.getElementById('shos').value;
    	  }
      }
       
      
     }); 

	
	
		
			

</script>
   
</body>
</html>