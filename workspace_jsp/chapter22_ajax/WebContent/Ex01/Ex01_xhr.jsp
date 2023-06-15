<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Ex01_xhr.jsp 페이지 입니다.</h1>
	<hr>
	
	<script type="text/javascript">
		// 1. XMLHttpRequest 객체 생성
		let xhr = new XMLHttpRequest();
		
		// 2. open(스트림 열기)
		// open(전송 방식, 경로, 비동기유무)
		// 1) 전송 방식 : get, post
		// 2) 비동기 유무 : true(비동기), false(동기)
		xhr.open("get", "data.jsp" , false);
		
		// 3. send
		xhr.send();
		
		// 4. responseText(결과)
		document.body.innerHTML += xhr.responseText;

	</script>

	
</body>
</html>