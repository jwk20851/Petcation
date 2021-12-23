<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = (String)request.getAttribute("pageNum");
	System.out.println("num= " + num + "pageNum = " + pageNum);
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
#zipSearchArea{	/* 섹션 */
	width : 380px;
	margin : 50px;
	border : 3px solid black;
	text-align: center;
	}
	html{
	background-color : white;
	}
	body{
	background-color : white;
	height : 50%;
	}
	#yes_close{
	width:20;
	}
	.button {width: 20%; margin : 10px;}
	
	
</style>

<title>글삭제</title>
</head>

<body>
	<section id = "zipSearchArea">
			
		<h1>글을 삭제하시겠습니까?</h1>
		<form method="post" name="writeform" id = "test" action="boardDeletePro.bo" onsubmit="window.close();">
<input type="hidden" name="num" value="<%= num%>">
<input type="hidden" name="pageNum" value="<%=pageNum%>">

<input type="button" value="예" id = "yes_close" class = "button">  
<button onclick="pop_close()" class = "button">아니오</button>
		</form>
	</section>

<script>


	window.onload = function() {
		var pop_btn = document.getElementById('yes_close');
		pop_btn.onclick = function() {
			document.writeform.target = parent; //호출하고자하는 부모창의 이름
			document.writeform.submit(); // 폼 전송
			window.close(); //창 닫기 
		}
	};

	function pop_close() {
		self.close();
	}
</script>

	
</body>
</html>