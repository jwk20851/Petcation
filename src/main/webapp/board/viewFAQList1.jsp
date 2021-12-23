<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
* {
   box-sizing: border-box;
}

.regist {
   text-align: center;
   margin-left: 49.5%;
}

html, body {
   height: 100%;
   margin: 0;
   font-family: Arial, Helvetica, sans-serif;
}

input[type=text] {
   width: 100%;
   margin: 0px 0 0px 0;
   display: inline-block;
   border: none;
   display: inline-block;
   border: none;
   background: none;
   border: none;
   display: inline-block;
   border: none;
}

/* Add a background color when the inputs get focus */
input[type=text]:focus {
   background-color: white;
   outline: none;
   text-align: top;
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
   width: 1%;
}

button:hover {
   opacity: 0.8;
}

/* Add padding to container elements */
.out_container {
   display: grid;
   grid-template-columns: 20% 80%;
   padding-right: 5%;
   padding-bottom: 5%;
   text-align: center;
   height: 100%;
}

.container {
   
}

/* The Modal (background) */
.modal {
   z-index: 1; /* Sit on top */
   left: 0;
   width: 100%; /* Full width */
   height: 100%; /* Full height */
   overflow: auto; /* Enable scroll if needed */
   padding-top: 100px;
}

.clearfix {
   display: inline-block;
   text-align: right;
}

.answer {
   width: 125px;
}

#name, #age, #kind {
   margin: 0;
   width: 200px;
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

#dogimage {
   width: 40%;
   float: left;
   margin-right: 2%;
   height: 180px;
}

h2 {
   text-align: left;
}

.topnav {
   width: 100%;
   height: 100px;
   position: fixed;
   top: 0;
   left: 0;
   overflow: hidden;
   background-color: rgba(98, 203, 203, 0.8);
   box-shadow: 0 1px 15px 0px gray;
}

.topnav a {
   width: 8%;
   height: 100%;
   float: left;
   color: #f2f2f2;
   text-align: center;
   padding: 36px 20px;
   text-decoration: none;
   font-size: 150%;
   line-height: 100%;
}

.topnav a:hover {
   background-color: rgba(100, 200, 150, 0.8);
}

.sidenav {
   width: 60%;
   position: relative;
   background: #eee;
   overflow-x: hidden;
   display: block;
   top: 300px;
   left: 50%;
   transform: translate(-50%, 0);
   text-align: left;
}

.sidenav a {
   padding: 6px 8px 6px 16px;
   text-decoration: none;
   font-size: 1vw;
   color: black;
   display: block;
}

.sidenav a:hover {
   color: gray;
}

.sidebar {
   height: 100%;
   width: 100%;
}

table {
   top: 0;
}

#detailinfo {
   height: 200px;
}

textarea {
   outline: none;
}
/* Change styles for span and cancel button on extra small screens */
@media screen and (min-width: 200px)and (max-width:800px) {
   .out_container {
      display: grid;
      grid-template-columns: 20% 80%;
      padding-bottom: 5%;
      text-align: center;
      height: 100%;
      padding-right: 0;
   }
   .sidenav {
      width: 100%;
      position: relative;
      background: #eee;
      overflow-x: hidden;
      padding: 8px 0;
      display: block;
      top: 300px;
      left: 50%;
      transform: translate(-50%, 0);
      text-align: left;
   }
   .topnav {
      width: 100%;
      height: 100px;
      position: fixed;
      top: 0;
      left: 0;
      overflow: hidden;
      background-color: rgba(98, 203, 203, 0.8);
      box-shadow: 0 1px 15px 0px gray;
   }
   .topnav a {
      width: 25%;
      height: 100px;
      float: left;
      color: #f2f2f2;
      text-align: center;
      padding: 36px 20px;
      text-decoration: none;
      font-size: 100%;
      line-height: 100%;
   }
   .topnav a:hover {
      background-color: rgba(100, 200, 150, 0.8);
   }
   input[type=text], #name, #age, #kind {
      width: 80%;
   }
   #name, #age, #kind {
      padding: 15px;
      display: inline-block;
      margin: 5px 0 10px 0;
   }
   #name {
      margin-top: 15px;
   }
   #kind {
      padding: 15px;
      margin-bottom: 0;
      display: inline-block;
   }
   .imagetext {
      width: 100%;
      margin-top: 2%;
      text-align: center;
      height: 100%;
   }
   #dogimage {
      width: 80%;
      margin-right: 0;
      margin-left: 10%;
      height: 100%;
   }
   .clearfix {
      width: 100%;
   }
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
   .sidenav {
      width: 100%;
      position: relative;
      background: #eee;
      overflow-x: hidden;
      padding: 8px 0;
      display: block;
      top: 300px;
      left: 50%;
      transform: translate(-50%, 0);
      text-align: left;
   }
   .topnav {
      width: 100%;
      height: 100px;
      position: fixed;
      top: 0;
      left: 0;
      overflow: hidden;
      background-color: rgba(98, 203, 203, 0.8);
      box-shadow: 0 1px 15px 0px gray;
   }
   .topnav a {
      width: 25%;
      height: 100px;
      float: left;
      color: #f2f2f2;
      text-align: center;
      padding: 36px 20px;
      text-decoration: none;
      font-size: 100%;
      line-height: 100%;
   }
   .topnav a:hover {
      background-color: rgba(100, 200, 150, 0.8);
   }
   input[type=text] {
      width: 95%;
   }
   #dogimage {
      width: 40%;
   }
   .imagetext {
      width: 95%;
      display: inline-block;
      text-align: right;
      margin-top: 2%;
      margin-bottom: 1%;
      height: 180px;
   }
   .clearfix {
      width: 95%;
      display: inline-block;
   }
}

input[type=text] {
   border-radius: 25px;
   width: 48%;
   padding: 15px;
   margin: 5px 0 10px 0;
   display: inline-block;
   border: none;
   background: #f1f1f1;
}
</style>
<title>고객센터 (FAQ목록조회)</title>
</head>
<body>
   <div id="id01" class="modal">
      <form class="modal-content" action="/action_page.php"
         onsubmit="return false">
         <nav class="topnav">
            <a href="#home" style="padding: 16px 20px;"> <img
               src="images/pet_logo.png" style="width: 90%; height: 70%;" /></a> <a
               href="#searchHosp">병원검색</a> <a href="#reserveHosp">병원예약</a> <a
               href="#myHosp">MY병원</a> <a href="#cusCenter">고객센터</a> <a
               href="#manageHosp">병원관리</a>
         </nav>
         <div class="out_container">
            <div class="sidebar">
               <div class="sidenav">
                  <a href="#about">회원정보</a> <a href="#services">반려동물정보</a> <a
                     href="#services">리뷰관리</a> <a href="#services">즐겨찾기관리</a> <a
                     href="#services">회원탈퇴</a>
               </div>
            </div>

            <div class="container">

               <h1 style="font-size: 50px">-PETCATION-</h1>
               <hr>
               <h2>고객센터</h2>
               

                  <table border="1" width="60%" cellpadding="0" cellspacing="0"
                     align="center"
                     style="text-align: center; margin-top: 80px; height: 150px;">
                     
                     <tr style="background-color: gray; height: 50px;"">
                        <th>번호</th>
                        <th colspan="2">제목</th>
                        <th>작성자</th>
                        <th>작성일</th>
                     </tr>

                     <tr style="height: 50px;">
                        <td>번호</td>
                        <td style="text-align: left; padding-left: 10px;">자주하는 질문 1

                        <td align="center" width="5%" style="cursor: pointer;"
                           id="maxmin" onclick="maxmin()">닫기</td>
                        <td>작성자</td>
                        <td>작성일</td>
                     </tr>
                     <tr style="padding: 10px, 10px;" id="answer1">
                        <td colspan="5" style="text-align: left; padding: 20px 10px;">답변</td>
                     </tr>
                     <tr style="height: 50px;">
                        <td>번호</td>
                        <td style="text-align: left; padding-left: 10px;">자주하는 질문 2
                        
                        <td align="center" width="5%" style="cursor: pointer;"
                           id="maxmin2" onclick="maxmin2()">닫기</td>
                        <td>작성자</td>
                        <td>작성일</td>
                     </tr>
                     <tr id="answer2">
                        <td colspan="5" style="text-align: left; padding: 20px 10px;">답변</td>
                     </tr>

                  </table>
                  <div class="clearfix" style="margin-top: 10px; float: right;">

                  </div>
               </div>
            </div>
      </form>
   </div>
   <script>
      function maxmin() {
         if (document.getElementById('maxmin').innerHTML == "닫기") {
            document.getElementById('answer1').style.display = 'none';
            document.getElementById('maxmin').innerHTML = "열기";
         } else {
            document.getElementById('answer1').style.display = '';
            document.getElementById('maxmin').innerHTML = "닫기";
         }
      }
      
      function maxmin2() {
         if (document.getElementById('maxmin2').innerHTML == "닫기") {
            document.getElementById('answer2').style.display = 'none';
            document.getElementById('maxmin2').innerHTML = "열기";
         } else {
            document.getElementById('answer2').style.display = '';
            document.getElementById('maxmin2').innerHTML = "닫기";
         }
      }
   </script>

</body>
</html>