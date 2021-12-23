<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
@font-face {
	font-family: "SLEI";
	src: url('fonts/SLEIGothicTTF.ttf');
}

* {
	font-family: "SLEI";
	margin: 0;
	padding: 0;
}

html, body {
	position: relative;
	min-height: 100%;
	font-family: Arial, Helvetica, sans-serif;
}

#body-content {
	min-height: 10%;
	/* background-color: lightblue; */
	display: flex;
	flex-direction: column;
}

#footer-content {
	background-color: rgba(175, 237, 237, 0.8);
	width: 100%;
	height: 200px;
	display: flex;
	flex-direction: column;
	color:rgb(86,193,208);
}

.video-wrap {
	width: 100%;
	position: relative;
}

#video {
	position: relative;
	top: 0px;
	width: 100%;
	height: auto;
	filter: grayscale(80%) brightness(120%);
}

#search_in {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}

#search_in input:focus {
	outline: 6px solid rgba(255, 255, 255, 1);
}

#searchWord {
	width: 400px;
	height: 50px;
	padding-left: 20px;
	padding-right: 20px;
	background-color: rgba(255, 255, 255, 0.8);
	border-radius: 25px;
	border: 4px solid rgba(98, 203, 203, 1);
}

#search_icon {
	float: right;
	width: 40px;
	height: auto;
	position: absolute;
	top: 50%;
	left: 90%;
	transform: translate(-50%, -50%);
	cursor: pointer;
}

.topnav {
	width: 100%;
	height: auto;
	position: fixed;
	top: 0; /*상단 위치를 0으로 함으로서 위에 붙음*/
	display: flex;
	flex-direction: row;
	margin: 0; /*쓸 데 없는 공백 제거*/
	padding: 0; /*쓸 데 없는 공백 제거*/
	background-color: rgba(98, 203, 203, 0.8);
	box-shadow: 0 1px 15px 0px gray;
	list-style-type: none; /*목록 기호 제거*/
	overflow: hidden;
	position: fixed;
	z-index: 3;
}

.menu_a {
	height: 60px;
	min-width: 100px;
	cursor: pointer; /*마우스 커서를 pointer 모양으로 함*/
	text-align: center;
}

.menu_a a {
 	display: block;
	height: 60px;
	line-height: 60px;
	color: #f2f2f2;
	text-decoration: none;
}

.menu_a a>img {
	vertical-align: middle;
}

.menu_a:hover {
	background-color: rgba(100, 200, 150, 0.8);
}

.space {
	flex: 1;
}

#logo {
	width: auto;
	height: 60px;
}

li2 {
	display: none;
}

.title {
	text-align: center;
	padding: 5%;
}

.introContainer {
	/* background-color: yellow; */
	display: grid;
	width: 70%;
	height: 100%;
	grid-template-columns: 50% 50%;
	padding-left: 15%;
	padding-right: 15%;
	padding-bottom: 6%;
}

.boardContainer {
	/* background-color: yellow; */
	display: grid;
	width: 75%;
	height: 100%;
	grid-template-columns: 50% 50%;
	padding: 5% 12.5%;
}

.introItem {
	/* border: 1px solid black; */
	min-height: 10px;
	padding-left: 20px;
	padding-right: 20px;
	font-size: 30px;
	text-align: center;
}

.in-introContainer {
	/* background-color: green; */
	display: grid;
	height: 100%;
	grid-template-row: 33% 33% 33%;
	align-items: center; /* 수직 가운데 정렬 */
}

.in-introItem {
	width: 100%;
	float: left;
	margin: 10px 0;
	/* border: 1px solid red; */
	text-align: left;
	display: flex;
	flex-direction: row;
	align-items: center;
}

.introIcon {
	width: 130px;
	height: 130px;
	vetical-align: middle;
	border-radius: 70%;
	float: left;
	margin-right: 30px;
}

h4 {
	font-size: 24px;
}

p {
	font-size: 20px;
}

.rank, .board {
	position: relative;
}

/* .board::before {
	content: "";
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background-image: url('images/doctor.jpg');
	background-size: cover;
	opacity: 0.2;
	z-index: -1;
} */
.boardItem {
	min-height: 10px;
	padding-left: 0px;
	padding-right: 0px;
	font-size: 30px;
	text-align: center;
	color: gray;
	height: 100%;
}

.cont {
	padding-left: 5%;
}

.flist {
	white-space: normal;
	font-size: 16px;
	width: 100%;
	height: 100%;
}

.flist>li {
	line-height: 200%;
}

.flist>li>a {
	text-decoration-line: none;
	color: gray;
	padding: 5px 0;
	letter-spacing: 2px;
}

.flist>li>span {
	float: right;
	padding-right: 5%;
	letter-spacing: 2px;
}

.notice {
	text-align: left;
	margin-left: 7.5%;
	margin-right: 7.5%;
	border: solid 2px #DDD;
	padding: 5%;
	border-radius: 25px;
}

.notice>hr {
	color: rgb(103, 188, 175); /* IE */
	border-color: rgb(103, 188, 175); /* 사파리 */
	background-color: rgb(103, 188, 175);
}

.in-rankContainer {
	display: grid;
	height: 100%;
	grid-template-row: 12.5% 12.5% 12.5% 12.5% 12.5% 12.5% 12.5% 12.5%;
	align-items: center; /* 수직 가운데 정렬 */
}

@media screen and (max-width: 1200px) {
	.topnav .menu_a {
		height: 40px;
	}
	.topnav .menu_a>a {
		height: 40px;
		line-height: 40px;
	}
	.topnav .menu_a>a>#logo {
		height: 40px;
	}
	.topnav li:not(:first-child) {
		display: none;
	}
	.topnav li2 {
		display: block;
		position: absolute;
		right: 0;
		top: 0;
	}
	.introContainer, .boardContainer {
		grid-template-columns: 100%;
		grid-template-row: 50% 50%;
		padding: 0 15%;
	}
	.notice {
		margin: 10% 0;
	}
	.map_inner_wrap {
		flex-direction: column;
	}
	.map_inner_wrap>#menu_wrap {
		width: 100%;
		height: 50%;
		border-radius: 0;
		border: solid 2px #DDD;
		border-radius: 0;
	}
	.map_inner_wrap>.info_wrap {
		overflow-y: scroll;
		border-radius: 0;
		border: solid 2px #DDD;
	}
	.map_inner_wrap>.info_wrap>.option>#info_hosp {
		width: 100%;
		display: flex;
	}
	.map_inner_wrap>.info_wrap>.option>#info_hosp>#content_wrap {
		width: 100%;
		flex-direction: column;
		justify-content: center;
	}
	.map_inner_wrap>.info_wrap>.option>#info_hosp>#content_wrap>#common_info
		{
		width: 100%;
	}
	.map_inner_wrap>.info_wrap>.option>#info_hosp>#map {
		height: 200px;
	}
	.boardContainer {
		/* background-color: yellow; */
		width: 70%;
		padding: 5% 15%;
	}
	#searchWord {
		width: 300px;
	}
	#map {
		height: 200px;
	}
}

@media screen and (max-width: 1200px) {
	.topnav.responsive {
		position: fixed;
		flex-direction: column;
	}
	/* .topnav.responsive li2 {
		position: absolute;
		right: 0;
		top: 0;
	}
	.topnav.responsive li2>a {
		height: 40px;
	} */
	.topnav.responsive li {
		width: 100px;
	}
	.topnav.responsive li:not(:first-child) {
		width: 100%;
		height: 40px;
		float: none;
		display: block;
		text-align: left;
		padding-left: 10px;
	}
	.topnav.responsive li>a {
		height: 40px;
		line-height: 40px;
	}
}

#info_hosp {
	width: 80%;
	padding: 5%;
}

#map {
	margin-left: 5%;
	width: 100%;
	height: 360px;
	border: solid 1px gray;
	margin-bottom: 1%;
}

#common_info {
	text-align: left;
	width: 50%;
}

.menuNav>a {
	font-size: 0.8vw;
}


.menuNavIcon {
	width: 50%;
	height: auto;
	float: top;
	margin-bottom: 5px;
}

/* 지도검색 */
.map_wrap, .map_wrap * {
	margin: 0;
	padding: 0;
	font-family: 'Malgun Gothic', dotum, '돋움', sans-serif;
	font-size: 12px;
}

.map_wrap a, .map_wrap a:hover, .map_wrap a:active {
	color: #000;
	text-decoration: none;
}

.map_wrap {
	/* position: relative;
	width: 100%;
	height: 500px; */
	position: absolute;
	width: 100%;
	height: 500px;
}

#menu_wrap {
	position: ablsoluete;
	left: 0;
	width: 40%;
	border: solid 4px rgba(0,0,0,0);
	overflow-y: auto;
	background-color: rgba(255, 255, 255, 0.9);
	z-index: 1;
	font-size: 12px;
	border-radius: 30px 0 0 30px;
	box-shadow: 1px 1px 15px 0px #222;
}

.info_wrap {
	border: solid 4px rgba(0,0,0,0);
	overflow-y: auto;
	background-color: rgba(255, 255, 255, 0.9);
	z-index: 1;
	font-size: 12px;
	border-radius: 0 30px 30px 0;
	box-shadow: 1px 1px 15px 0px #222;
}

.bg_white {
	background-color: rgba(255, 255, 255, 0.9);
}

.map_inner_wrap {
	display: flex;
	width: 70%;
	height: 100%;
	padding: 0 15%;
}

#menu_wrap hr {
	display: block;
	height: 1px;
	border: 0;
	border-top: 2px solid #5F5F5F;
}

#menu_wrap .option {
	text-align: center;
}

#menu_wrap .option p {
	margin: 10px 0;
}

#menu_wrap .option button {
	margin-left: 5px;
}

#placesList li {
	list-style: none;
}

#placesList .item {
	position: relative;
	border-bottom: 1px solid #888;
	overflow: hidden;
	cursor: pointer;
	min-height: 60px;
}

#placesList .item:hover {
	background-color: rgba(235, 235, 235, 0.9);
}

#placesList .item span {
	display: block;
}

#placesList .item h5, #placesList .item .info {
	text-overflow: ellipsis;
	overflow: hidden;
	white-space: nowrap;
}

#placesList .item .info {
	padding: 10px 0 10px 55px;
}

#placesList .info .gray {
	color: #8a8a8a;
}

#placesList .info .jibun {
	padding-left: 26px;
	background:
		url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png)
		no-repeat;
}

#placesList .info .tel {
	color: #009900;
}

#placesList .item .markerbg {
	float: left;
	position: absolute;
	width: 36px;
	height: 37px;
	margin: 10px 0 0 10px;
	background:
		url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png)
		no-repeat;
}

#placesList .item .marker_1 {
	background-position: 0 -10px;
}

#placesList .item .marker_2 {
	background-position: 0 -56px;
}

#placesList .item .marker_3 {
	background-position: 0 -102px
}

#placesList .item .marker_4 {
	background-position: 0 -148px;
}

#placesList .item .marker_5 {
	background-position: 0 -194px;
}

#placesList .item .marker_6 {
	background-position: 0 -240px;
}

#placesList .item .marker_7 {
	background-position: 0 -286px;
}

#centerAddr {
	position: relative;
	top: 10px;
	width: 90%;
	height: 100%;
	word-break: break-all;
	/* padding-left: 20px;
	padding-right: 20px; */
	display: flex;
	flex-direction: column;
}

#title {
	text-align: center;
	margin: 20px 10px 0 0;
	width: 300px;
	min-height: 118px;
	padding-left: 20px;
	padding-right: 20px;
	font-size: 24px;
}

#content_wrap>p {
	font-size: 18px;
}

#content_wrap>p>span {
	color: orange;
	font-size: 18px;
}

#centerAddr>p {
	font-size: 22px;
}

.type0::-webkit-scrollbar {
	width: 6px;
}

/* 스크롤바 막대 설정*/
.type0::-webkit-scrollbar-thumb {
	height: 10%;
	background-color: rgba(205, 205, 205, 0.9);
	border-radius: 10px;
}

/* 스크롤바 뒷 배경 설정*/
.type0::-webkit-scrollbar-track {
	background-color: rgba(235, 235, 235, 0.9);
}

.type1::-webkit-scrollbar {
	display: none;
}

/* 스크롤바 막대 설정*/
.type1::-webkit-scrollbar-thumb {
	display: none;
}

/* 스크롤바 뒷 배경 설정*/
.type1::-webkit-scrollbar-track {
	display: none;
}
</style>
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

function search() {
	location.href = "searchHosp.jsp?searchWord=" + document.getElementById('searchWord').value;
}
</script>
</head>
<body>
	<div id = "body-content">
		<div class="video-wrap">
			<video id="video" preload="auto" autoplay loop muted>
				<source src="video/Dog.mp4">
			</video>
			<div id="search_in">
				<form action="searchHosp.jsp" method="get">
				<input type="text" id="searchWord" name="searchWord" placeholder="지역 또는 병원명을 입력해주세요." onkeyup="javascript:if(event.keyCode==13) {search()}"/>
				<img src="images/search_icon.png" id="search_icon" name = "searchWord" onclick="search()"/>
				</form>
			</div>
		</div>
		
		<div class = "intro">
			<div class="title">
				<h1>ABOUT PETCATION</h1><br>
				<p style="font-size:20px;">PETCATION을 이용하는 모든 펫오너들의 걱정이 사라질 때까지!</p>
			</div>

			<div class="introContainer">
				<div class="introItem">
					<div class="in-introContainer">
						<div class="in-introItem">
							<div><img src="images/intro_01.png" class = "introIcon"/></div>
							<div>
							<h4>손쉽고 빠른 <span style="color:rgb(0,183,183)">예약</span>으로</h4>
							<p><br>PETCATION에서 직접<br><span style="color:rgb(60,165,236)">예약정보를 관리</span>하고 병원으로 전송해요.</p>
							</div>
						</div>
						<div class="in-introItem">
							<div><img src="images/intro_03.png" class = "introIcon"/></div>
							<div>
							<h4>인증된 수의사들의 <span style="color:rgb(0,183,183)">믿음직한 진료</span>를</h4>
							<p><br><span style="color:rgb(60,165,236)">검증된 수의사</span>들은 전문성과 책임감으로<br>펫오너의 반려동물을 진료할거에요.</p>
							</div>
						</div>
						<div class="in-introItem">
							<div><img src="images/intro_02.png" class = "introIcon"/></div>
							<div>
							<h4>정확하고 확실한 <span style="color:rgb(0,183,183)">후기</span>와 <span style="color:rgb(0,183,183)">평점</span>으로</h4>
							<p><br>많은 펫오너들의 <span style="color:rgb(60,165,236)">생생하고 다양한<br>후기와 평점</span>으로 반려동물을 맡길 병원을 찾아요.</p>
							</div>						
						</div>
					</div>
				</div>
				<div class="introItem">
					<img src="images/intro_04.jpg" style="width: 100%; height: auto;" />
				</div>
			</div>
		</div>

		<div class="rank">
			<div class="title" style = "background-color:rgba(98,203,203,0.7);">
				<h1 style="color:#FFF">주변 병원</h1>
				<br>
				<p style="color:#FFF">현재 위치를 기준으로 주변 병원을 알려드립니다.</p>
			</div>
			
			<div id="map2">
			<span id="centerAddr2" style="display:none"></span>
			</div>
			
			<div id="roadview"
				style="width: 100%; height: 700px; position: absolute; z-index: -1; opacity:0.5;">
			</div>
			<!-- <div id="msg" style="color: yellow">이곳에 위치 정보 출력</div> -->
			
			<div id="road" ></div>

			<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=994eb3c853be7f84e75e533f72aa4dd6&libraries=services"></script>
			<script>
				if (!navigator.geolocation)
					alert("지원하지 않음");
				else
					// found() 콜백 함수 등록
					navigator.geolocation.getCurrentPosition(found);

				// 위치 파악 시 found() 호출.
				// 위치 정보 들어 있는 position 객체가 매개 변수로 넘어온다.
				function found(position) {
					var now = new Date(position.timestamp);
					var lat = position.coords.latitude; // 위도
					var lon = position.coords.longitude; // 경도
					var acc = position.coords.accuracy; // 정확도

					lat = lat.toPrecision();
					lon = lon.toPrecision();

					var text/*  = "현재 시간 " + now.toUTCString() + "<br>";
					text += "현재 위치 (위도: " + lat + ", 경도: " + lon + ")<br>";
					text += "정확도 " + acc + "m<br>" */;
				
					var mapContainer2 = document.getElementById('map2'), // 지도를 표시할 div 
				    mapOption2 = {
				        center: new kakao.maps.LatLng(lat, lon), // 지도의 중심좌표
				    };
					var map2 = new kakao.maps.Map(mapContainer2, mapOption2); 

					var geocoder = new kakao.maps.services.Geocoder();

					// 현재 지도 중심좌표로 주소를 검색해서 지도 좌측 상단에 표시합니다
					searchAddrFromCoords(map2.getCenter(), displayCenterInfo);

					function searchAddrFromCoords(coords, callback) {
					    // 좌표로 행정동 주소 정보를 요청합니다
					    geocoder.coord2RegionCode(coords.getLng(), coords.getLat(), callback);         
					}
 
					// 지도 좌측상단에 지도 중심좌표에 대한 주소정보를 표출하는 함수입니다
					function displayCenterInfo(result, status) {
					    if (status === kakao.maps.services.Status.OK) {
					        var infoDiv = document.getElementById('centerAddr2');
					        var infoDiv2 = document.getElementById('keyword');

					        for(var i = 0; i < result.length; i++) {
					            // 행정동의 region_type 값은 'H' 이므로
					            if (result[i].region_type === 'H') {
					                infoDiv.innerHTML = result[i].address_name;
					                keyword.value = result[i].address_name;
					             	
					                // 키워드로 장소를 검색합니다
					                searchPlaces();

					                // 키워드 검색을 요청하는 함수입니다
					                function searchPlaces() {
					                    var keyword = document.getElementById('keyword').value;
					                    if (!keyword.replace(/^\s+|\s+$/g, '')) {
					                        /* alert('키워드를 입력해주세요!'); */
					                        return false;
					                    }

					                    // 장소검색 객체를 통해 키워드로 장소검색을 요청합니다
					                    ps.keywordSearch(keyword + ' 동물병원', placesSearchCB); 
					                }
					                break;
					            }
					        }
					    }    
					}

					/* document.getElementById("msg").innerHTML = text; */

					var roadviewContainer = document.getElementById('roadview'); //로드뷰를 표시할 div

					var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
					var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

					var position = new kakao.maps.LatLng(lat, lon);

					// 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
					roadviewClient.getNearestPanoId(position, 50, function(panoId) {
						roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
					});
				}
			</script>
			<div class="mapContainer" style="margin-top:100px;">
				<div class="map_wrap" style ="position:absolute; left:0;">
					<div class="map_inner_wrap">
						<div id="menu_wrap" class="bg_white type0">
							<div class="option">
								<div style = "display:flex;margin-top:17px; margin-bottom:17px;">
									<p style = "width:20%; margin-left: 10%;">현위치: </p>
									<input type="text" id="keyword" value="" style="text-align:center; width:60%; margin-right:10%;" disabled>
								</div>
							</div>
							<hr noshade>
							<ul id="placesList"></ul>
						</div>

						<div id="info_wrap" class="info_wrap bg_white type1"
							style="position:ablsoluete; right:0;
							width: 100%; height: auto; background-color:rgba(255,255,255,0.8);">
							<div class="option">
								<div id="info_hosp">
									<div id="map"></div>
									<div id="content_wrap"
										style="display:flex; justify-content: space-between; width:100%; text-align:center; padding: 0 15%; margin-bottom: 10px;">
										<p id="common_info_sub" style = "display:none;">
											<span>★</span>1.11<span style="color: #AAA">/5</span><br>
											<span onclick="reivew_sub_button()" style="width:100%; cursor: pointer; color: rgb(0, 104, 195);">
											방문자리뷰 1,234
											</span>
										</p>
										<p>
											<div id="common_info"></div>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		<div class="board" style = "margin-top:600px;">
			<div class="boardContainer">
				<div class="boardItem">
					<div class="notice">
						<h6
							style="display: flex; justify-content: space-between; padding:0 5%; margin-bottom: 10px; line-height: 100%;
							color:rgb(103, 188, 175)">
							<span style="font-size:28px;">FAQ</span>
							<a class="current" href="/board/?code=notice" style ="text-decoration-line:none; color:black;"><span style="font-size: 16px;">더보기 +</span></a>
						</h6>
						<hr>
						<div class="cont">
							<ul class="flist">
								<li>
								<a href="/board/?tGet=Read&amp;code=news&amp;idx=5">전자진료의뢰시스템[리퍼시스템]
										서비스 개시</a>
								</li>
								<li><a href="/board/?tGet=Read&amp;code=news&amp;idx=5">전자진료의뢰시스템[리퍼시스템]
										서비스 개시</a></li>
								<li><a href="/board/?tGet=Read&amp;code=news&amp;idx=5">전자진료의뢰시스템[리퍼시스템]
										서비스 개시</a></li>
								<li><a href="/board/?tGet=Read&amp;code=news&amp;idx=5">전자진료의뢰시스템[리퍼시스템]
										서비스 개시</a></li>
								<li><a href="/board/?tGet=Read&amp;code=news&amp;idx=5">전자진료의뢰시스템[리퍼시스템]
										서비스 개시</a></li>
							</ul>
						</div>
					</div>
				</div>

				<div class="boardItem">
					<div class="notice">
						<h6
							style="display: flex; justify-content: space-between; padding: 0 5%; margin-bottom: 10px; line-height: 100%;
							color:rgb(103, 188, 175)">
							<span style="font-size:28px;">공지사항</span>
							<a class="current" href="/board/?code=notice" style ="text-decoration-line:none;"><span style="font-size: 16px;color:black">더보기 +</span></a>
						</h6>
						<hr noshade>
						<div class="cont">
							<ul class="flist">
								<li>
								<span>14/03/07</span>
								<a href="/board/?tGet=Read&amp;code=news&amp;idx=5">전자진료의뢰시스템[리퍼시스템]	서비스 개시</a>
								</li>
								<li>
								<span>14/03/07</span>
								<a href="/board/?tGet=Read&amp;code=news&amp;idx=5">전자진료의뢰시스템[리퍼시스템]	서비스 개시</a>
								</li>
								<li>
								<span>14/03/07</span>
								<a href="/board/?tGet=Read&amp;code=news&amp;idx=5">전자진료의뢰시스템[리퍼시스템]	서비스 개시</a>
								</li>
								<li>
								<span>14/03/07</span>
								<a href="/board/?tGet=Read&amp;code=news&amp;idx=5">전자진료의뢰시스템[리퍼시스템]	서비스 개시</a>
								</li>
								<li>
								<span>14/03/07</span>
								<a href="/board/?tGet=Read&amp;code=news&amp;idx=5">전자진료의뢰시스템[리퍼시스템]	서비스 개시</a>
								</li>
							</ul>
						</div>
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
		                <li class="menu_a"> <a href="bookMark_list.bo">MY병원</a> </li>
		                </c:if>
		                <c:if test="${empty userVO}">
		                <li class="menu_a"> <a href="javascript:void(0);" onclick="alert('회원이 아니면 사용하실 수 없습니다!')">MY병원</a> </li>
		                </c:if>
		                <li class="menu_a"> <a href="boardStart.jsp">고객센터</a> </li>
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

	<div id="footer-content"
		style="position: relative; display: flex; flex-direction: row; height: 220px; align-items: center; justify-content: center; padding-top: 2%; padding-bottom: 2%;">
		<div>
			<c:if test="${userVO.user_authority == 3 }">
			<a href ="systemupdate.pet">시스템 업데이트</a>
			</c:if>
			<img src="images/footer_logo.png" style="width: 100%; height: 148px;" />
		</div>
		<div style="padding: 0;">
			<p style="font-size: 2vh;">
				<strong>주소</strong> : 대구광역시 수성구 알파시티1로31길 24-5<br> <strong>대표</strong>
				: 스폰지밥<br> <strong>대표전화</strong> : <a href="tel:000-1111-2222"
					target="_blank" style="text-decoration-line: none; color: inherit;">000-111-2222</a><br>
				<br> Copyright ⓒ 2021 펫케이션. All rights reserved. Designed by Petcation.
			</p>
			<p style="font-size: 1vh;">
               ※ 본 웹사이트는 게시된 사진이 무단 수집되어 도용되는 것을 거부하며, 이를 위반 시 『저작권법』등에 의해 처벌 받을 수
               있습니다.<br> 사진을 기술적 장치를 사용하여 무단으로 복제, 공연, 공중송신, 전시, 배포, 대여,
               2차적저작물 작성의 방법으로 침해한 자는 [저작권법] 제 136조 제 1항에 의하여 5년 이하의 징역 또는 5천만원
               이하의 벌금에 처해집니다.
            </p>
         </div>
      </div>
      
<script type="text/javascript"
				src="//dapi.kakao.com/v2/maps/sdk.js?appkey=994eb3c853be7f84e75e533f72aa4dd6&libraries=services"></script>

			<script>
				// 마커를 담을 배열입니다
				var markers = [];

				var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
				mapOption = {
					center : new kakao.maps.LatLng(37.56682420267543,
							126.978652258823), // 지도의 중심좌표
					level : 3
				// 지도의 확대 레벨
				};

				// 지도를 생성합니다    
				var map = new kakao.maps.Map(mapContainer, mapOption);

				// 장소 검색 객체를 생성합니다
				var ps = new kakao.maps.services.Places();

				// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
				var infowindow = new kakao.maps.InfoWindow({
					zIndex : 1,
					removable : true
				});

				function placesSearchCB(data, status, pagination) {
					if (status === kakao.maps.services.Status.OK) {

						// 정상적으로 검색이 완료됐으면
						// 검색 목록과 마커를 표출합니다
						displayPlaces(data);

						// 페이지 번호를 표출합니다

					} else if (status === kakao.maps.services.Status.ZERO_RESULT) {

						alert('검색 결과가 존재하지 않습니다.');
						return;

					} else if (status === kakao.maps.services.Status.ERROR) {

						alert('검색 결과 중 오류가 발생했습니다.');
						return;

					}
				}

				// 검색 결과 목록과 마커를 표출하는 함수입니다
				function displayPlaces(places) {

					var listEl = document.getElementById('placesList'), menuEl = document
							.getElementById('menu_wrap'), fragment = document
							.createDocumentFragment(), bounds = new kakao.maps.LatLngBounds(), listStr = '';

					// 검색 결과 목록에 추가된 항목들을 제거합니다
					removeAllChildNods(listEl);

					// 지도에 표시되고 있는 마커를 제거합니다
					removeMarker();

					for (var i = 0; i < 7; i++) {

						// 마커를 생성하고 지도에 표시합니다
						var placePosition = new kakao.maps.LatLng(places[i].y,
								places[i].x), marker = addMarker(placePosition,
								i), itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

						// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
						// LatLngBounds 객체에 좌표를 추가합니다
						bounds.extend(placePosition);

						// 마커와 검색결과 항목에 mouseover 했을때
						// 해당 장소에 인포윈도우에 장소명을 표시합니다
						// mouseout 했을 때는 인포윈도우를 닫습니다
						(function(marker, title) {
							kakao.maps.event
									.addListener(
											marker,
											'click'/* 'mouseover' */,
											function() {
												displayInfowindow(marker, title);
												document
														.getElementsByClassName("info_wrap")[0].style.display = "block";
											});

							itemEl.onclick = function() {
								displayInfowindow(marker, title);
								map.setCenter(marker.getPosition());

								/* var hosp_url = places[markers.indexOf(marker)].place_url; */

								var level = map.getLevel();
								if (level >= 3) {
									map.setLevel(3);
								}
								document.getElementsByClassName("info_wrap")[0].style.display = "block";

								var roadviewContainer = document
										.getElementById('roadview'); //로드뷰를 표시할 div
								var roadview = new kakao.maps.Roadview(
										roadviewContainer); //로드뷰 객체
								var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체

								var str = marker.getPosition();

								var position = new kakao.maps.LatLng(str
										.getLat(), str.getLng());

								// 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
								roadviewClient
										.getNearestPanoId(position, 50,
												function(panoId) {
													roadview.setPanoId(panoId,
															position); //panoId와 중심좌표를 통해 로드뷰 실행
												});

								document.getElementById('common_info_sub').style.display = "block";

								var common_info = document
										.getElementById('common_info');
								
								common_info.innerHTML = '<p style="font-size:16px;">도로명주소: <strong style="font-size:18px;">'
										+ places[markers.indexOf(marker)].road_address_name
										+ '</strong><br>지번주소: <strong style="font-size:18px;">'
										+ places[markers.indexOf(marker)].address_name
										+ '</strong></p>';
							};

						})(marker, places[i].place_name);

						fragment.appendChild(itemEl);
					}

					// 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
					listEl.appendChild(fragment);
					menuEl.scrollTop = 0;

					// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
					map.setBounds(bounds);
				}

				// 검색결과 항목을 Element로 반환하는 함수입니다
				function getListItem(index, places) {
					var el = document.createElement('li'), itemStr = '<div class="info" style = "display: flex; justify-content: space-between; padding:10px 20px 10px 20px;">'
							+ '<p style = "font-size:20px; color:gray;">'
							+ (index + 1)
							+ '</p>'
							+ '<h2 style = "font-size:20px;">'
							+ places.place_name + '</h2></div>';

					el.innerHTML = itemStr;
					el.className = 'item';

					return el;
				}

				// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
				function addMarker(position, idx, title) {
					var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
					imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
					imgOptions = {
						spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
						spriteOrigin : new kakao.maps.Point(0, (idx * 46) + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
						offset : new kakao.maps.Point(13, 37)
					// 마커 좌표에 일치시킬 이미지 내에서의 좌표
					}, markerImage = new kakao.maps.MarkerImage(imageSrc,
							imageSize, imgOptions), marker = new kakao.maps.Marker(
							{
								position : position, // 마커의 위치
								image : markerImage
							});

					marker.setMap(map); // 지도 위에 마커를 표출합니다
					markers.push(marker); // 배열에 생성된 마커를 추가합니다

					return marker;
				}

				// 지도 위에 표시되고 있는 마커를 모두 제거합니다
				function removeMarker() {
					for (var i = 0; i < markers.length; i++) {
						markers[i].setMap(null);
					}
					markers = [];
				}

				function displayInfowindow(marker, title) {
					var content = '<div style="padding:5px;z-index:1;">'
							+ title + '</div>';

					infowindow.setContent(content);
					infowindow.open(map, marker);
				}

				// 검색결과 목록의 자식 Element를 제거하는 함수입니다
				function removeAllChildNods(el) {
					while (el.hasChildNodes()) {
						el.removeChild(el.lastChild);
					}
				}
			</script>
</body>
</html>