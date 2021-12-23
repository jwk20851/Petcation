<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.add {
	border-radius: 25px;
	background-color: #04AA6D;
	color: white;
	padding: 10px 10px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 12%;
}

.delete {
	border-radius: 25px;
	background-color: #04AA6D;
	color: white;
	padding: 10px 10px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 12%;
}

input[type=text] {
	border-radius: 25px;
	width: 95%;
	padding: 15px;
	margin: 5px 0 10px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus {
	background-color: #ddd;
	outline: none;
}

@media screen and (min-width: 800px)and (max-width:1250px) {
	.out_container {
		display: grid;
		grid-template-columns: 20% 80%;
		padding-bottom: 5%;
		text-align: center;
		height: 100%;
		padding-right: 0;
	}
	input[type=text] {
		border-radius: 25px;
		width: 95%;
		padding: 15px;
		margin: 5px 0 10px 0;
		display: inline-block;
		border: none;
		background: #f1f1f1;
	}
	/* Add a background color when the inputs get focus */
	input[type=text]:focus {
		background-color: #ddd;
		outline: none;
	}
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
	width: 100%;
}

button:hover {
	opacity: 0.8;
}

.cancel, .save {
	width: 28%;
}

.cancel {
	margin-left: 3%;
}

#name, #age, #kind {
	margin: 0;
	width: 58%;
}

#age, #kind {
	margin-top: 22px;
}

.imagetext {
	width: 95%;
	display: inline-block;
	text-align: right;
	margin-top: 2%;
	margin-bottom: 1%;
	height: 180px;
}

.filebox label {
	width: 40%;
	float: left;
	margin-right: 2%;
	height: 180px;
	display: block;
	color: #999;
	font-size: inherit;
	line-height: normal;
	vertical-align: middle;
	background-color: #fdfdfd;
	cursor: pointer;
	border: 1px solid #ebebeb;
	border-bottom-color: #e2e2e2;
	border-radius: .25em;
}
.filebox label>img {
	width: 100%;
	height: 180px;
}

.filebox input[type="file"] { /* 파일 필드 숨기기 */
	width: 0px;
	height: 0px;
	padding: 0;
	overflow: hidden;
	clip: rect(0, 0, 0, 0);
	border: 0;
}

h2 {
	text-align: left;
}

.upload-box {
  width: 100%;
  margin-right: 30px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

 .upload-box .drag-file {
  position: relative;
  width: 100%;
  height: 180px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  border: 3px dashed #dbdbdb;
}

 .upload-box .drag-file .image {
  width: 40px;
}
 .upload-box .drag-file .message {
  margin-bottom: 0;
}
 .upload-box .drag-file .preview {
  display: none;
  position: absolute;
  left: 0;
  height: 0;
  width: 100%;
  height: 100%;
}
 .upload-box .file-label {
	  margin-top: 30px;
  background-color: #5b975b;
  color: #fff;
  text-align: center;
  padding: 10px 0;
  width: 65%;
  border-radius: 6px;
  cursor: pointer;
}
 .upload-box .file {
  display: none;
}

@media (max-width: 700px) {
   {
    display: flex;
    flex-direction: column;
    margin-top: 30px;
  }
   .upload-box {
    width: 100%;
    box-sizing: border-box;
    margin-right: 0;
  }
   .upload-box .drag-file {
    height: 100px;
  }
   .files {
    width: 100%;
    box-sizing: border-box;
    margin-right: 0;
    overflow: initial;
  }
}
</style>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-latest.min.js"
	type="application/javascript"></script>
<script type="application/javascript" src="js/hangjungdong.js"></script>

<link rel="stylesheet" href="css/common2.css">

<meta name="viewport" content="width=device-width, initial-scale=1">


<title>반려동물 정보입력</title>
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
	<div style="height: 100%; width: 100%;">
		<div id="id01" class="modal" style="min-height: 1200px;">
			<div id="body-content">

				<form class="modal-content" name="petinfo" id="petinfo"
					action="reservation.jsp" onsubmit="return false">
					<input type="hidden" name="user_Id" id="user_Id" value="<%=cookie %>">
					<div class="head">
						<h1 style="font-size: 3vw; text-align: center;">반려동물관리</h1>
					</div>
					<div class="out_container">
						<div class="sidebar">
							<div class="sidenav">
								<h1
									style="font-size: 2vw; text-align: center; margin-top: 10px; margin-bottom: 10px">마이페이지</h1>
								<hr style="margin-bottom: 20px">
								<a href="manageUserInfo">회원정보</a>
								<a href="petInfo_list.pets">반려동물관리</a>
								<a href="#services">리뷰관리</a>
								<a href="#services">즐겨찾기관리</a>
								<a href="deleteUserInfo.jsp">회원탈퇴</a>
							</div>
						</div>
						<div class="container"
							style="width: 100%; padding-bottom: 5%; min-height: 300px; margin-top: 50px;">
							<div class="container">
								<div class="regist" style="margin-left: 47%">
									<!-- <input type="button" id="addbutton" name="addbutton"
										class="add" value="추가" onclick="add()"> <input
										type="button" class="delete" id="deletebutton"
										name="deletebutton" value="삭제" onclick="recont()"> -->
								</div>
								<div style="padding-left: 20%; padding-right: 20%;">
									<table border="1" width="100%" cellpadding="0" cellspacing="0"
										align="center" id="pettable">
										<tr height="30" class="contmenu" name="contents">
											
											<td width="100%">반려동물정보</td>
											
										</tr>
										
										<tr height="30" class="contmenu">
											<th align="center" width="100%">반려동물 정보입력</th>
										</tr>

										<tr height="30" id="contents" name="contents">
											<td align="center" width="100%" colspan="3">
												<div class="imagetext">
													<div class="filebox">
														<label for="fileupload" onclick = "ok()">
															<div class="upload-box">
																<div id="drop-file" class="drag-file">
																	<img
																		src="https://img.icons8.com/pastel-glyph/2x/image-file.png"
																		alt="파일 아이콘" class="image">
																	<p class="message">Click here to upload</p>
																	<img src="" alt="미리보기 이미지" class="preview">
																</div>
															</div>
														</label>
														<input type="file" id="fileupload" onchange="dropFile.handleFiles(this.files)" accept="image/*" style="display:none;">
													</div>
													<input type="text" placeholder="이름" name="name" id="name">
													<input type="text" placeholder="나이" name="age" id="age">
													<input type="text" placeholder="종류" name="kind" id="kind">
												</div> <input type="text" placeholder="품종 입력" name="detailkind"
												id="detailkind"> <input type="text" placeholder="성별"
												name="gender" id="gender"> <input type="text"
												placeholder="몸무게" name="weight" id="weight"> <input
												type="text" placeholder="질병" name="disease" id="disease">
												<input type="text" placeholder="상세정보" name="detailinfo"
												id="detailinfo">
												<input type = "hidden" id="filename" name="filename" value = ""/>
											</td>
										</tr>

									</table>
								</div>
								<div class="clearfix">
									<button type="button" id="uploadClick" class="save">저장</button>
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
			style="position: relative; display: flex; flex-direction: row; height: 220px; align-items: center; justify-content: center; padding-top: 5%; padding-bottom: 5%;">
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
			var x = document.getElementById("myTopnav");
			if (x.className === "topnav") {
				x.className += " responsive";
			} else {
				x.className = "topnav";
			}
		}
		
		function DropFile(dropAreaId, fileListId) {
			  let dropArea = document.getElementById(dropAreaId);
			  let fileList = document.getElementById(fileListId);

			  function preventDefaults(e) {
			    e.preventDefault();
			    e.stopPropagation();
			  }

			  function handleDrop(e) {
			    unhighlight(e);
			    let dt = e.dataTransfer;
			    let files = dt.files;

			    handleFiles(files);

			    const fileList = document.getElementById(fileListId);
			    if (fileList) {
			      fileList.scrollTo({ top: fileList.scrollHeight });
			    }
			  }

			  function handleFiles(files) {
			    files = [...files];
			    // files.forEach(uploadFile);
			    files.forEach(previewFile);
			  }

			  function previewFile(file) {
			    renderFile(file);
			  }

			  function renderFile(file) {
			    let reader = new FileReader();
			    reader.readAsDataURL(file);
			    reader.onloadend = function () {
			      let img = dropArea.getElementsByClassName("preview")[0];
			      
			      img.src = reader.result;
			      img.style.display = "block";
			    };
			  }

			  dropArea.addEventListener("drop", handleDrop, false);

			  return {
			    handleFiles
			  };
			}

			const dropFile = new DropFile("drop-file", "files");
	</script>
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script>
		$('#uploadClick').on('click', function() {
			alert("확인");
			if($("#fileupload")[0].files[0] != null){
				alert("파일 있음");
			var file = $("#fileupload")[0].files[0];
			var filename = file.name;
			alert(filename);
			$('input[name=filename]').attr('value',filename);
			alert("확인");
			var reader = new FileReader();
			reader.onload = function(e) {
				// 변환이 끝나면 reader.result로 옵니다.
				var base64data = reader.result;
				console.log(base64data);
				// 여기서 구조가 중요합니다.
				// 구조는 「data: 파일 타입; base64, 데이터」입니다.
				var data = base64data.split(',')[1];
				//data가 이제 데이터 입니다.
				//사실 ajax로 넘길때는 큰 사이즈 설정해서 데이터를 넘기면 빠르게 되는데 예제이다보니 프로그래스바 구조를 나타내기 위해 문자 1개 단위로 보내겠습니다.
				var sendsize = 1024;
				var filelength = data.length;
				var pos = 0;
				var upload = function() {
					$.ajax({
						type : 'POST',
						dataType : 'json',
						data : {
							filename : filename,
							filelength : filelength,
							filepos : pos,
							data : data.substring(pos, pos + sendsize)
						},
						url : './upload',
						success : function(data) {
							// 전체가 전송될 때까지
							if (pos < filelength) {
								// 재귀
								setTimeout(upload, 1);
							}
							pos = pos + sendsize;
							if (pos > filelength) {
								pos = filelength;
							}
							$('#progress').text(pos + ' / ' + filelength);
							
						},
						error : function(jqXHR, textStatus, errorThrown) {
							console.log(jqXHR);
						},
						complete : function(jqXHR, textStatus) {
						}
					});
				};
				setTimeout(upload, 1);
			}
			// base64로 넘깁니다.
			reader.readAsDataURL(file);			
			
			setTimeout(function petInfo_submit(){
				document.petinfo.target = "_self";
				document.petinfo.action = "save.pet";
				document.petinfo.submit();
			}, 1000);
			}
			else{
				alert("파일 없음");
				document.petinfo.target = "_self";
				document.petinfo.action = "save.pet";
				document.petinfo.submit();
			}
		});
		
		function ok(){
			alert("ok");
		}
	</script>
</body>
</html>