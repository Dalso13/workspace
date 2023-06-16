<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	// 페이지 로드
	$(function () {
		$("#btn").click(function() {
			// jQuery.load()
			// 주어진 URL로부터 HTML 데이터를 받아서 선택된 객체에 넣어줌
			$("#content").load("jsp_data.jsp");
		});
	})

</script>
</head>
<body>
	<button id="btn">가져오기</button>
	<br> <br>
	
	<div>
		<h1 style="color: blue">jspReader.jsp 입니다.</h1>
		<div id="content"></div>
	</div>
</body>
</html>