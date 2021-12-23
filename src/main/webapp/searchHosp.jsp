<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.jsoup.Jsoup" %>
<%@ page import="org.jsoup.nodes.Document" %>
<%@ page import="org.jsoup.nodes.Element" %>
<%@ page import="org.jsoup.select.Elements" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">

<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <title>병원검색</title>
<style>
@font-face{
   font-family:"SLEI";
   src: url('fonts/SLEIGothicTTF.ttf');
}
* {
    font-family:"SLEI";
   margin: 0px;
   padding: 0px;
}

::-webkit-scrollbar {
   display: none;
}

body {
   max-width: 100%;
   height: 100%;
}

/* 사이드바 */
.sidenav {
   height: 100%;
   width: 5%;
   position: fixed;
   z-index: 1;
   top: 0;
   left: 0;
   background-color: #fff;
   overflow-x: hidden;
   transition: 0.5s ease-in-out;
   padding-top: 60px;
   /* flex-direction: row; */
}

.sidenav a {
   padding: 8px 0px;
   text-decoration: none;
   color: #000;
   display: block;
   transition: 0.2s ease-in-out;
}

.sidenav a:hover, .offcanvas a:focus {
   color: rgba(81,158,164,0.9);
   -webkit-text-stroke: 1px rgba(98, 203, 203, 0.8);
}

.closebtn {
   position: absolute;
   top: 0;
   right: 25px;
   font-size: 36px !important;
   margin-left: 50px;
}

.openmenu:hover {
   color: rgb(0, 154, 200);
   transition: 0.5s ease-in-out;
}

.openmenu {
   position: absolute;
   top: 0;
   font-size: 2vw;
   cursor: pointer;
   transition: 0.5s ease-in-out;
}

.openmenu>i {
   font-size: 2vw;
}

#map {
   margin-left: 5%;
   transition: 0.5s ease-in-out;
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
   height: 100%;
}

#menu_wrap {
   position: absolute;
   top: 0;
   left: 0;
   bottom: 0;
   width: 250px;
   margin: 80px 50px 30px 10px;
   margin-left: 6%;
   padding: 5px;
   overflow-y: auto;
   background-color: rgba(255, 255, 255, 0.9);
   z-index: 1;
   font-size: 12px;
   border-radius: 10px;
   transition: 0.5s ease-in-out;
}

.info_wrap {
   border-left: solid 1px;
   border-right: solid 1px;
   position: absolute;
   top: 0;
   left: 260px;
   bottom: 0;
   width: 340px;
   margin: 80px 0 30px 0;
   margin-left: 6%;
   overflow-y: auto;
   background-color: rgba(255, 255, 255, 0.9);
   z-index: 1;
   font-size: 12px;
   border-radius: 10px;
   transition: 0.5s ease-in-out;
}

.info_x {
   position: absolute;
   color:white;
   background-color:#222;
   top:1%;
   right: 4%;
   width: 20px;
   height: 20px;
   border-radius: 5px;
   z-index:10;
}

.bg_white {
   background-color: rgba(255, 255, 255, 0.9);
}

#menu_wrap hr {
   display: block;
   height: 1px;
   border: 0;
   border-top: 2px solid #5F5F5F;
   margin: 3px 0;
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
   min-height: 65px;
}

#placesList .item span {
   display: block;
   margin-top: 4px;
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

#placesList .item .marker_8 {
   background-position: 0 -332px;
}

#placesList .item .marker_9 {
   background-position: 0 -378px;
}

#placesList .item .marker_10 {
   background-position: 0 -423px;
}

#placesList .item .marker_11 {
   background-position: 0 -470px;
}

#placesList .item .marker_12 {
   background-position: 0 -516px;
}

#placesList .item .marker_13 {
   background-position: 0 -562px;
}

#placesList .item .marker_14 {
   background-position: 0 -608px;
}

#placesList .item .marker_15 {
   background-position: 0 -654px;
}

#pagination {
   margin: 10px auto;
   text-align: center;
}

#pagination a {
   display: inline-block;
   margin-right: 10px;
}

#pagination .on {
   font-weight: bold;
   cursor: default;
   color: #777;
}

#centerAddr {
   position: absolute;
   top: 10px;
   width: 300px;
   height: 100%;
   word-break: break-all;
   padding-left: 20px;
   padding-right: 20px;
   display: flex;
   flex-direction: column;
}

#title {
   text-align:center;
   margin: 20px 10px 0 0;
   width: 300px;
   min-height:118px;
   
   padding-left: 20px;
   padding-right: 20px;
   font-size:24px;
}

#content_wrap > p{
   font-size: 18px;
}
#content_wrap > p > span{
   color:orange;
   font-size: 18px;
}

#centerAddr > p {
   font-size:22px;
}

.tablink {
  background-color:rgb(131,208,214);
  color: white;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
  padding: 14px 16px;
  font-size: 17px;
  width: 33.33%;
}

.tablink_sub {
  color: white;
  float: left;
  border: none;
  outline: none;
  cursor: pointer;
}
.tablink:hover {
  background-color:rgb(81,158,164);
}
.tabcontent {
  color: black;
  display: none;
  padding: 0px;
  text-align: center;
  position:relative;
  width:340px;
}
</style>
<%
String searchWord = request.getParameter("searchWord");
%>
</head>
<body>
   <%
      String cookie = "";
      Cookie[] cookies = request.getCookies(); //쿠키생성
      if (cookies != null && cookies.length > 0)
         for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("id")) { // 내가 원하는 쿠키명 찾아서 값 저장
         cookie = cookies[i].getValue();
            }
         }
      System.out.println("불러오기 성공, 아이디는 :" + cookie);
   %>
<div id="mysidenav" class="sidenav">
   <div class = "menuNav" style = "text-align:center; display:flex; flex-direction:column">
      <a href="main.jsp" style = "position:absolute; top:0px; background-color:rgb(161,238,244);"><img src="images/logo_icon.png" class = "menuNavIcon" style = "width:90%;"/></a>
      <a href="#reserveHosp" style = "margin-top:30px;"><img src="images/reserve_icon.jpg" class = "menuNavIcon"/><p>병원예약</p></a>
      <a href="#myHosp"><img src="images/myHosp_icon.jpg" class = "menuNavIcon"/><p>MY병원</p></a>
      <a href="#cusCenter"><img src="images/customer_icon.jpg" class = "menuNavIcon"/><p>고객센터</p></a>
      <a href="#manageHosp"><img src="images/manageHosp_icon .jpg" class = "menuNavIcon"/><p>병원관리</p></a>
      
      <c:if test="${not empty userVO}">
         <a href="logout.pet"><img src="images/login_icon.jpg" class = "menuNavIcon"/><p>로그아웃</p></a>
         <a href="checkpw.jsp"><img src="images/regist_icon.jpg" class = "menuNavIcon"/><p>마이페이지</p></a>
      </c:if>
      <c:if test="${empty userVO}">
         <a href="login.jsp"><img src="images/login_icon.jpg" class = "menuNavIcon"/><p>로그인</p></a>
         <a href="joinAgree.jsp"><img src="images/regist_icon.jpg" class = "menuNavIcon"/><p>회원가입</p></a>
      </c:if>      
   </div>
</div>

<div class="map_wrap">
      <div id="map" style="width:100%;height:100%;position:relative;overflow:hidden;"></div>

   <div style = "display:flex; flex-direction:row;">
      <div id="menu_wrap" class="bg_white">
         <div class="option">
            <div id="map2">
               <form onsubmit="searchPlaces(); return false;">
                  키워드 : <input type="text" value="${param.searchWord}" id="keyword" size="15">
                  <button type="submit">검색</button>
               </form>
            </div>
         </div>
         <hr>
         <ul id="placesList"></ul>
         <div id="pagination"></div>
      </div>
      <div class="info_wrap" class="bg_white" style="display: none;
      width: 340px; height: auto;">
         <div class="option">
            <div id="info_hosp" style = "width:340px;">
               <button class="info_x" onclick="info_close()">X</button>
               <div id="roadview" style="width:100%;height:200px;"></div>
                  <div id="title"></div>
                  <div id="content_wrap" style = " display: flex; justify-content: space-between; padding: 0 15%; margin-bottom: 10px;">
                     <p><span>★</span>0<span style="color:#AAA">/5</span></p>
                     <p onclick="reivew_sub_button()" style = "cursor: pointer; color:rgb(0,104,195);">방문자리뷰 0</p>
                  </div>
                  <c:if test="${not empty userVO}">
                     <form action = "/bookMark_regist.bo">
                        <input type="hidden" name="user_Id" id="user_Id" value="<%=cookie %>">
                        <button type="button" onclick="myUser()" style="margin:0 auto; display:block; width:160px;height:40px; font-size:18px;">MY병원등록</button>
                     </form>
                  </c:if>
                  <c:if test="${empty userVO}">
                     <button type="button" onclick="notMyUser()" style="margin:0 auto; display:block; width:160px;height:40px; font-size:18px;">MY병원등록</button>
                  </c:if>
               </div>
               <div id="tab_info" style = "position:relative;width:340px; min-height:47px; margin-top:10px;">
                  <button class="tablink" onclick="category('detail_info', this, 'rgba(81,158,164,0.9)')" id="defaultOpen">정보</button>
                  <button id="review_sub" class="tablink" onclick="category('review_info', this, 'rgba(81,158,164,0.9)')">리뷰</button>
                  <button class="tablink" onclick="category('reserve_info', this, 'rgba(81,158,164,0.9)')">예약</button>
               </div>            
               
               
               <div id="detail_info" class="tabcontent">
                  <div id="centerAddr"></div>
               </div>            
               <div id="review_info" class="tabcontent">
                  <div style = "padding:10%;">
                  <br>
                     <p style = "font-size: 20px;">등록된 리뷰 정보를</p><br>
                     <p style = "font-size: 20px;">불러오지 못했습니다.</p>
                  </div>
               </div>            
               <div id="reserve_info" class="tabcontent">
                  <form action="main.jsp" method="get" id ="frm">
                     <input type="hidden" name="user_Id" id="user_Id" value="<%=cookie %>">
                     <div id="reserve_content">
                        <br><br><br>
                        <p style="font-size:20px;">해당 병원에</p><br>
                        <p style="font-size:20px;">예약하시겠습니까?</p>
                        <input type = "hidden" id="submit_hosp" name="name">
                        <input type = "hidden" id="addr1" name = "addr1">
                        <input type = "hidden" id="addr2" name = "addr2">
                        <br><br><br><br>
                        <button type="button" onclick="data()" style = "width:50%; height:30px;">지금 예약하기</button>
                     </div>
                  </form>
               </div>                           
            </div>
         </div>
      </div>
   </div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=994eb3c853be7f84e75e533f72aa4dd6&libraries=services"></script>

<script>
// 마커를 담을 배열입니다
var markers = [];

var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();  

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({zIndex:1, removable:true});

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

// 장소검색이 완료됐을 때 호출되는 콜백함수 입니다
function placesSearchCB(data, status, pagination) {
    if (status === kakao.maps.services.Status.OK) {

        // 정상적으로 검색이 완료됐으면
        // 검색 목록과 마커를 표출합니다
        displayPlaces(data);

        // 페이지 번호를 표출합니다
        displayPagination(pagination);

    } else if (status === kakao.maps.services.Status.ZERO_RESULT) {

        alert('검색 결과가 존재하지 않습니다.');
        return;

    } else if (status === kakao.maps.services.Status.ERROR) {

        alert('검색 결과 중 오류가 발생했습니다.');
        return;

    }
}

var hosp_data;
var hosp_addr1;
var hosp_addr2;
var hosp_tel;

function myUser(){
	alert("즐겨찾기 등록되었습니다.");
	/* location.href = "searchHosp.jsp?searchWord=" + document.getElementById('searchWord').value; */
	window.location.href="bookMark_regist.bo?name="+hosp_data+"&addr="+hosp_addr1+"&tel="+hosp_tel;
}

function notMyUser(){
   alert("로그인 후 이용해주세요.");
}

// 검색 결과 목록과 마커를 표출하는 함수입니다
function displayPlaces(places) {

    var listEl = document.getElementById('placesList'), 
    menuEl = document.getElementById('menu_wrap'),
    fragment = document.createDocumentFragment(), 
    bounds = new kakao.maps.LatLngBounds(), 
    listStr = '';
    
    // 검색 결과 목록에 추가된 항목들을 제거합니다
    removeAllChildNods(listEl);

    // 지도에 표시되고 있는 마커를 제거합니다
    removeMarker();
    
    for ( var i=0; i<places.length; i++ ) {

        // 마커를 생성하고 지도에 표시합니다
        var placePosition = new kakao.maps.LatLng(places[i].y, places[i].x),
            marker = addMarker(placePosition, i), 
            itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다

        // 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
        // LatLngBounds 객체에 좌표를 추가합니다
        bounds.extend(placePosition);

        // 마커와 검색결과 항목에 mouseover 했을때
        // 해당 장소에 인포윈도우에 장소명을 표시합니다
        // mouseout 했을 때는 인포윈도우를 닫습니다
        (function(marker, title) {
            kakao.maps.event.addListener(marker, 'click'/* 'mouseover' */, function() {
                displayInfowindow(marker, title);
                document.getElementsByClassName("info_wrap")[0].style.display = "block";
            });

            /* kakao.maps.event.addListener(marker, 'mouseout', function() {
                infowindow.close();
            }); */

            itemEl.onclick = function () {               
               displayInfowindow(marker, title);
                map.setCenter(marker.getPosition());
                
                /* var hosp_url = places[markers.indexOf(marker)].place_url; */
                
                var level = map.getLevel();
                if(level>=3){
                   map.setLevel(3);
                }
                document.getElementsByClassName("info_wrap")[0].style.display = "block";
                
                var roadviewContainer = document.getElementById('roadview'); //로드뷰를 표시할 div
                var roadview = new kakao.maps.Roadview(roadviewContainer); //로드뷰 객체
                var roadviewClient = new kakao.maps.RoadviewClient(); //좌표로부터 로드뷰 파노ID를 가져올 로드뷰 helper객체
            
                var str = marker.getPosition();
                
                var position = new kakao.maps.LatLng(str.getLat(), str.getLng());

                // 특정 위치의 좌표와 가까운 로드뷰의 panoId를 추출하여 로드뷰를 띄운다.
                roadviewClient.getNearestPanoId(position, 50, function(panoId) {
                    roadview.setPanoId(panoId, position); //panoId와 중심좌표를 통해 로드뷰 실행
                });
                
                var infoTitle = document.getElementById('title');
                var infoRegion = document.getElementById('region');
                var infoDiv = document.getElementById('centerAddr');
                var region = places[markers.indexOf(marker)].address_name;
                var regionArr = region.split(" ");
                hosp_data = places[markers.indexOf(marker)].place_name;
                hosp_addr1 = places[markers.indexOf(marker)].road_address_name;
                hosp_addr2 = places[markers.indexOf(marker)].address_name;
                hosp_tel = places[markers.indexOf(marker)].phone;
                   
                infoTitle.innerHTML = '<strong style = "font-size:28px;">'+places[markers.indexOf(marker)].place_name + '</strong><br>'+
                /* infoRegion.innerHTML =  */'<p style = "font-size:16px; margin-top:16px; color:gray">'+ "("+regionArr[0] + " " + regionArr[1] + " " + regionArr[2] + ")" +'</p>'                
                infoDiv.innerHTML = /* '<strong>'+places[markers.indexOf(marker)].place_name + '</strong><br><br>'
                +  */'<hr><h1>'+"도로명주소: "+'</h1><br><p>'+ places[markers.indexOf(marker)].road_address_name + '</p><br><br><h1>'
                + "지번주소: "+'</h1><br><p>' + places[markers.indexOf(marker)].address_name + '</p><br><br><h1>'
                + "전화번호: "+'</h1><br><p>' + places[markers.indexOf(marker)].phone + '</p><br><br>';
                
                };

                

            /* itemEl.onmouseout =  function () { //마우스 클릭 시 정보출력 고정
                infowindow.close();
            }; */
        })(marker, places[i].place_name);

        fragment.appendChild(itemEl);
    }

    // 검색결과 항목들을 검색결과 목록 Elemnet에 추가합니다
    listEl.appendChild(fragment);
    menuEl.scrollTop = 0;

    // 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
    map.setBounds(bounds);
}

function data(){
   document.getElementById('submit_hosp').value = hosp_data;
   document.getElementById('addr1').value = hosp_addr1;
   document.getElementById('addr2').value = hosp_addr2;
   
   location.href = "findpetName.pet?searchHospname="+document.getElementById('submit_hosp').value;
}

// 검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, places) {

    var el = document.createElement('li'),
    itemStr = '<span class="markerbg marker_' + (index+1) + '"></span>' +
                '<div class="info">' +
                '   <h5>' + places.place_name + '</h5>';

    if (places.road_address_name) {
        itemStr += '    <span>' + places.road_address_name + '</span>' +
                    '   <span class="jibun gray">' +  places.address_name  + '</span>';
    } else {
        itemStr += '    <span>' +  places.address_name  + '</span>'; 
    }
                 
      itemStr += '  <span class="tel">' + places.phone  + '</span>' +
                '</div>';           

    el.innerHTML = itemStr;
    el.className = 'item';

    return el;
}

// 마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
    var imageSrc = 'https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png', // 마커 이미지 url, 스프라이트 이미지를 씁니다
        imageSize = new kakao.maps.Size(36, 37),  // 마커 이미지의 크기
        imgOptions =  {
            spriteSize : new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
            spriteOrigin : new kakao.maps.Point(0, (idx*46)+10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
            offset: new kakao.maps.Point(13, 37) // 마커 좌표에 일치시킬 이미지 내에서의 좌표
        },
        markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
            marker = new kakao.maps.Marker({
            position: position, // 마커의 위치
            image: markerImage 
        });

    marker.setMap(map); // 지도 위에 마커를 표출합니다
    markers.push(marker);  // 배열에 생성된 마커를 추가합니다

    return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
    for ( var i = 0; i < markers.length; i++ ) {
        markers[i].setMap(null);
    }   
    markers = [];
}

// 검색결과 목록 하단에 페이지번호를 표시는 함수입니다
function displayPagination(pagination) {
    var paginationEl = document.getElementById('pagination'),
        fragment = document.createDocumentFragment(),
        i; 

    // 기존에 추가된 페이지번호를 삭제합니다
    while (paginationEl.hasChildNodes()) {
        paginationEl.removeChild (paginationEl.lastChild);
    }

    for (i=1; i<=pagination.last; i++) {
        var el = document.createElement('a');
        el.href = "#";
        el.innerHTML = i;

        if (i===pagination.current) {
            el.className = 'on';
        } else {
            el.onclick = (function(i) {
                return function() {
                    pagination.gotoPage(i);
                }
            })(i);
        }

        fragment.appendChild(el);
    }
    paginationEl.appendChild(fragment);
}

// 검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
// 인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title) {
    var content = '<div style="padding:5px;z-index:1;">' + title + '</div>';
    
    infowindow.setContent(content);
    infowindow.open(map, marker);
}

 // 검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {   
    while (el.hasChildNodes()) {
        el.removeChild (el.lastChild);
    }
}

//////////////////////////////사이드바 관련
function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            var addr = data.address; // 최종 주소 변수

            // 주소 정보를 해당 필드에 넣는다.
            document.getElementById("address").value = addr;
            // 주소로 상세 정보를 검색
            geocoder.addressSearch(data.address, function(results, status) {
                // 정상적으로 검색이 완료됐으면
                if (status === kakao.maps.services.Status.OK) {

                    var result = results[0]; //첫번째 결과의 값을 활용

                    // 해당 주소에 대한 좌표를 받아서
                    var coords = new kakao.maps.LatLng(result.y, result.x);
                    // 지도를 보여준다.
                    container.style.display = "block";
                    map.relayout();
                    // 지도 중심을 변경한다.
                    map.setCenter(coords);
                    // 마커를 결과값으로 받은 위치로 옮긴다.
                    marker.setPosition(coords)
                }
            });
        }
    }).open();
}

function openNav() {
   document.getElementById('mysidenav').style.width = '5%';
   document.getElementById('map').style.marginLeft = '5%';
   document.getElementById('menu_wrap').style.marginLeft = '6%';
   document.getElementsByClassName('info_wrap')[0].style.marginLeft = '6%';
   document.getElementById('openmenu').style.marginLeft = '5%';
}
function closeNav() {
   document.getElementById('mysidenav').style.width = '0';
   document.getElementById('map').style.marginLeft = '0';
   document.getElementById('menu_wrap').style.marginLeft = '0';
   document.getElementsByClassName('info_wrap')[0].style.marginLeft = '0';
   document.getElementById('openmenu').style.marginLeft = '0';
}

function info_close(){
    document.getElementsByClassName("info_wrap")[0].style.display = "none";
}

function category(cateName, elmnt, color) {
   var i, tabcontent, tablinks;
   tabcontent = document.getElementsByClassName("tabcontent");
   for (i = 0; i < tabcontent.length; i++) {
      tabcontent[i].style.display = "none";
   }
   tablinks = document.getElementsByClassName("tablink");
   for (i = 0; i < tablinks.length; i++) {
      tablinks[i].style.backgroundColor = "";
   }
   document.getElementById(cateName).style.display = "block";
   elmnt.style.backgroundColor = color;
}
// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();

function reivew_sub_button() {
   document.getElementById("review_sub").click();
}
</script>
</body>
</html>