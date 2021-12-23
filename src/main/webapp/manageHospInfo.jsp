<%@page import="vo.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="css/common2.css">
<link rel="stylesheet" href="css/reservetype/manageHosInfo.css">
<script src="js/reservation/reservation.js"></script>
<script src="js/jquery-3.6.0.min.js" type="text/javascript"></script>

<meta name="viewport" content="width=device-width, initial-scale=1">


<title>병원관리</title>
</head>
<body>
	<div style ="height:auto;width:100%;">
	<div id="id01" class="modal">
	<div id = "body-content">
		
		<form class="modal-content" name="mgHospInfoForm" action="#" onsubmit="return false">
			<div class="head">
						<h1 style="font-size: 3vw; text-align: center;">회원정보</h1>
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
				<div class="container">
					<div class="hostime">
						<div class = "hosdate">
							<div>
							<input type="text" name="hosname" id="hosname" placeholder="병원명" value="${hospVO.hosp_name}">
							<input type="text" name="phonenum" id="phonenum" placeholder="전화번호" maxlength="14" value="${hospVO.hosp_tel}">
							<input type="text" name="storetime1" id="storetime1" placeholder="영업시간" value="${fn:substring(hospVO.hosp_time,0,5) }" maxlength="5">
							~
							<input type="text" name="storetime2" id="storetime2" placeholder="영업시간" value="${fn:substring(hospVO.hosp_time,6,11) }" maxlength="5">
							<input type="text" name="location" id="location" placeholder="위치" value="${hospVO.hosp_address2}">
							
							<input type="text" name="stopdurset" id="stopdurset" value="영업중지기간설정">
							<input type="text" placeholder="영업중지기간" name="stopduration" id="stopduration" maxlength="10" value="${hospVO.hosp_stop}">
							<input type="text" name="stopreason" id="stopreason" placeholder="중지사유 입력"  value="${hospVO.hosp_reason }">
							
							<div class = "stopbutton">
								<input type="button" name = "stopset" id="stopset" value="영업중지설정" onclick="termstop()">
								<input type="button" name = "nonestopset" id="nonestopset" value="영업중지설정해제" onclick="termrestart()">
							</div>
							</div>				
					  </div>
						<div class = "timelist" style="text-align: right;">
						<div class = "reservetime">
						<input type="text" name="timesetname" id="timesetname" value="예약시간설정" readonly="readonly"/>			
						<input type="text" name="time" id="time" value="시간" readonly="readonly"/>
						
						</div>
						<div class = "listcontents">
							
       						
					  </div>
							<!-- <div style = "margin:0;margin-left:5%;width:80%;margin-top:5%;">
								<input type="button" name = "rsrvtime" id="rsrvtime" value="예약시간저장" onclick="alert('저장되었습니다!')">
							</div> -->
				  	  </div>
					</div>
					  <hr id="outconthr">
					  <input type="button" name="deletehosinfo" id="deletehosinfo" value="병원정보삭제" onclick="deletehosp()">
					  <input type="button" name="cancel" id="cancel" value="취소" onclick="location.href='main.jsp'">
					  <input type="button" name ="save" id = "save" value="저장" onclick="hospinfosave()">
					  
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
	var today = new Date();
	var year = today.getFullYear(); 

	// 월 getMonth() (0~11로 1월이 0으로 표현되기 때문에 + 1을 해주어야 원하는 월을 구할 수 있다.)
	var month = today.getMonth() + 1
	
	// 일 getDate()
	var date = today.getDate(); // 일
	if(date<10) {
		date='0'+date
	} 
	if(month<10) {
		month='0'+month
	} 
	
	today = year+'-' + month+'-'+date;
	document.getElementById('time').value = today;


	function myFunction() {
		  /* alert('성공'); */
	  var x = document.getElementById("myTopnav");
	  if (x.className === "topnav") {
	    x.className += " responsive";
	  } else {
	    x.className = "topnav";
	  }
	}
	
	function termstop(){
		var stopduration = document.getElementById("stopduration");
		var stopreason = document.getElementById("stopreason");
		
		if(parseInt(datecondi.substr(4, 2)) < 1 || parseInt(datecondi.substr(4, 2)) > 12){
	    	alert("날짜 형식에 맞게 적어주세요!(월)");
	  		$("#stopduration").val("");
	    }
	    else if(parseInt(datecondi.substr(6, 2)) < 1 || parseInt(datecondi.substr(6, 2)) > 31){
	    	alert("날짜 형식에 맞게 적어주세요!(일)");
	  		$("#stopduration").val("");
	    } 
	    else if(parseInt(datecondi.substr(0, 4)) < parseInt(year) - 3){
	  		alert("영업중지시작기간이 3년보다 이전일 수 없습니다!");
	  		$("#stopduration").val("");
	  	} 
	  	else if(parseInt(datecondi.substr(0, 4)) > parseInt(year) + 1){
	  		alert("영업중지기간은 1년만 일찍 등록할 수 있습니다!");
	  		$("#stopduration").val("");
	  	}else{
	  		stopduration.readOnly = true;
			stopreason.readOnly = true;
	  	}
	    
		
		
		
	}
	
	function termrestart(){
		var stopduration = document.getElementById("stopduration");
		var stopreason = document.getElementById("stopreason");
		
		stopduration.readOnly = false;
		stopreason.readOnly = false;
		
		var allData = { "stopduration": stopduration};
		$.ajax({
	        url:"cancelstop.pet",
	        type:"GET",
	        success:function(){
	            location.href = "watchmgHosInfo.pet";
	        },
	        error:function(jqXHR, textStatus, errorThrown){
	            alert("에러 발생");
	        }
	    });
	}
	
	
	
	  var RegNotNum = /[^0-9]/g;
	 var startstore;
	 var ssv;
	 var ssv2;
	 var valiSi;
	 var valiSi2;
	$("#storetime1").on("change keyup paste", function() {
			    //var currentVal = $(this).val();
			    //$("#hoslocat").html(currentVal);
			    var date = this.value;

			    date = date.replace(RegNotNum, ''); // 숫자만 남기기

			    if (date == "" || date == null || date.length > 4) {
			      this.value = date;
			      return;
			    }

			    var DataFormat;
			    var RegPhonNum;
			    
			    	if (date.length <= 2) {
					      DataFormat = "$1:"; // 포맷을 바꾸려면 이곳을 변경
					      RegPhonNum = /([0-9]{2})/;
					      
					}
				    else if (date.length <= 4) {
					      DataFormat = "$1:$2"; // 포맷을 바꾸려면 이곳을 변경
					      RegPhonNum = /([0-9]{2})([0-9]{2})/;
					}
			   
			    
			      startstore = this.value;

			    date = date.replace(RegPhonNum, DataFormat);

			    this.value = date;
			    valiSi = date;
			    
			        
	}); 
	
	$("#storetime2").on("change keyup paste", function() {
	    //var currentVal = $(this).val();
	    //$("#hoslocat").html(currentVal);
	    var date = this.value;

	    date = date.replace(RegNotNum, ''); // 숫자만 남기기

	    if (date == "" || date == null || date.length > 4) {
	      this.value = date;
	      return;
	    }

	    var DataFormat;
	    var RegPhonNum;
	    
	    	if (date.length <= 2) {
			      DataFormat = "$1:"; // 포맷을 바꾸려면 이곳을 변경
			      RegPhonNum = /([0-9]{2})/;
			      
			}
		    else if (date.length <= 4) {
			      DataFormat = "$1:$2"; // 포맷을 바꾸려면 이곳을 변경
			      RegPhonNum = /([0-9]{2})([0-9]{2})/;
			}
	   
	    
	      startstore = this.value;

	    date = date.replace(RegPhonNum, DataFormat);

	    this.value = date;
	    valiSi2 = date;
	    
	        
});
	
	
	$("#storetime1").on("change", function() {
		if(parseInt(valiSi.substr(0, 2)) > -1 && parseInt(valiSi.substr(0, 2)) <= 23){
			if(parseInt(valiSi.substr(3, 5)) > -1 && parseInt(valiSi.substr(3, 5)) <= 59){
				ssv = valiSi.replaceAll(":","");

				ssv2 = valiSi2.replaceAll(":","");
				$( "div[class=listcontents]" ).empty();
				
				for(var e = parseInt(ssv); e <= parseInt(ssv2); e= e+100){
 
					if(e >= parseInt(ssv2)){
						e= e - 30;
						break;
					}
					 var estr = "0".concat(e);
					 if(e < 1000){
						 addStaffText = '<div class="listcont">'+
			       			'<input id = "hoslocatcont" name="hoslocatcont" value="'+ estr.substr(0,2) + ":" + estr.substr(2,3) +'" readonly>'
       						+'</div>';
					 }else if(e >= 1200 && e<1300){
						 addStaffText = '<div class="listcont">'+
						 '<input id = "hoslocatcont" name="hoslocatcont" value="'+ "점심시간" +'" readonly>'
       						+'</div>';
					 }
					 else{
						 addStaffText = '<div class="listcont">'+
						 '<input id = "hoslocatcont" name="hoslocatcont" value="'+ String(e).substr(0,2) + ":" + String(e).substr(2,3) +'" readonly>'
       						+'</div>';
					 }
					 
					//var trHtml = $("div[class=listcont]:last"); //last를 사용하여 trStaff라는 명을 가진 마지막 태그 호출
					
					$('div[class=listcontents]').append(addStaffText);
					//trHtml.after(addStaffText); //마지막 trStaff명 뒤에 붙인다.
				 }
			}
			else{
				alert("시간 형식에 맞지 않습니다!");
				$("#storetime1").val("");
			}
			
		}else{
			alert("시간 형식에 맞지 않습니다!");
			$("#storetime1").val("");
		}
	        
}); 
	
	var addStaffText;
	$("#storetime2").on("change", function() {
		
		if(parseInt(valiSi2.substr(0, 2)) > -1 && parseInt(valiSi2.substr(0, 2)) <= 23){
			
			if(parseInt(valiSi2.substr(3, 5)) > -1 && parseInt(valiSi2.substr(3, 5)) <= 59){
				
				if(parseInt(valiSi2) >= parseInt(valiSi)){
					
					ssv2 = valiSi2.replaceAll(":","");
					$( "div[class=listcontents]" ).empty();
					
					for(var e = parseInt(ssv); e <= parseInt(ssv2); e= e+100){
						if(e >= parseInt(ssv2)){
							break;
						}
						 var estr = "0".concat(e);
						 if(e < 1000){
							 addStaffText = '<div class="listcont">'+
							 '<input id = "hoslocatcont" name="hoslocatcont" value="'+ estr.substr(0,2) + ":" + estr.substr(2,3) + '" readonly>'
	       						+'</div>';
						 }else if(e >= 1200 && e<1300){
							 addStaffText = '<div class="listcont">'+
							 '<input id = "hoslocatcont" name="hoslocatcont" value="'+ "점심시간" + '" readonly>'
	       						+'</div>';
						 }
						 else{
							 addStaffText = '<div class="listcont">'+
							 '<input id = "hoslocatcont" name="hoslocatcont" value="'+ String(e).substr(0,2) + ":" + String(e).substr(2,3) +'" readonly>'
	       						+'</div>';
						 }
						 
						
						$('div[class=listcontents]').append(addStaffText);
						
						 
						
					 }
				}
				else{
					alert("영업 끝나는 시간보다 시작하는 시간이 길 수 없습니다!");
					$("#storetime1").val("");
					$("#storetime2").val("");
					$("#hoslocat").html("시간");
				}
				
			}
			else{
				alert("시간 형식에 맞지 않습니다!");
				$("#storetime2").val("");
			}
			
		}else{
			alert("시간 형식에 맞지 않습니다!");
			$("#storetime2").val("");
		}
		

});   

	
	var datecondi;
	$("#stopduration").on("change keyup paste", function() {

	    var date = this.value;

	    date = date.replace(RegNotNum, ''); // 숫자만 남기기

	    if (date == "" || date == null || date.length < 5) {
	      this.value = date;
	      return;
	    }

	    var DataFormat;
	    var RegPhonNum;

	    // 날짜 포맷(yyyy-mm-dd) 만들기 
	    if (date.length <= 6) {
	      DataFormat = "$1-$2"; // 포맷을 바꾸려면 이곳을 변경
	      RegPhonNum = /([0-9]{4})([0-9]+)/;
	    } else if (date.length <= 8) {
	      DataFormat = "$1-$2-$3"; // 포맷을 바꾸려면 이곳을 변경
	      RegPhonNum = /([0-9]{4})([0-9]{2})([0-9]+)/;
	    }

	    date = date.replace(RegPhonNum, DataFormat);

	    
	    this.value = date;
		
	    datecondi = this.value;
	});
	
	$("#stopduration").on("change", function() {
		var now = new Date(); 
	  	var year=now.getFullYear();
	  	var month=now.getMonth()+1;
	  	var date=now.getDate();
	  	var total = String(year) + String(month) + String(date); 
	  	
	    datecondi = datecondi.replaceAll("-","");
	   	
	    
	   
	  	

	});
	function hospinfosave(){
		if($("#hosname").val() != "" && $("#phonenum").val() != "" &&
				$("#storetime1").val() != "" && $("#storetime2").val() != "" && 
				$("#location").val() != ""){
			document.mgHospInfoForm.target = "_self";
			document.mgHospInfoForm.action= "updatehospInfo.pet";
			mgHospInfoForm.submit();
		}
		else{
			alert("빈칸을 다 채워주세요!");
		}
		
	}
	
	function deletehosp(){
		document.mgHospInfoForm.target = "_self";
		document.mgHospInfoForm.action= "deletehospInfo.pet";
		mgHospInfoForm.submit();
	}

	$( document ).ready(function() {
		var t1 = $("#storetime1").val();
		var t2 = $("#storetime2").val();
		$( "div[class=listcontents]" ).empty();
		t1 = t1.replaceAll(":","");
		t2 = t2.replaceAll(":","");
		for(var e = parseInt(t1); e <= parseInt(t2); e= e+100){
			if(e >= parseInt(t2)){
				break;
			}
			 var estr = "0".concat(e);
			 if(e < 1000){
				 addStaffText = '<div class="listcont">'+
				 '<input id = "hoslocatcont" name="hoslocatcont" value="'+ estr.substr(0,2) + ":" + estr.substr(2,3) + '" readonly>'
						+'</div>';
			 }else if(e >= 1200 && e<1300){
				 addStaffText = '<div class="listcont">'+
				 '<input id = "hoslocatcont" name="hoslocatcont" value="'+ "점심시간" + '" readonly>'
						+'</div>';
			 }
			 else{
				 addStaffText = '<div class="listcont">'+
				 '<input id = "hoslocatcont" name="hoslocatcont" value="'+ String(e).substr(0,2) + ":" + String(e).substr(2,3) +'" readonly>'
						+'</div>';
			 }
			 
			
			$('div[class=listcontents]').append(addStaffText);
			
			 
			
		 }
		});


			
		
		 
	

	
</script>
	
</body>
</html>