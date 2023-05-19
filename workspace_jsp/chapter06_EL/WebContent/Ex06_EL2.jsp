<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!--	EL로 표현할 수 있는 방법 크게 두 가지가 있다.  
		1. 속성
		2. 파라미터
	-->
	<ul>
		<li>${HOBBIES[0]} </li>
		<li>${HOBBIES[1]} </li>
		<li>${HOBBIES[2]} </li>
	</ul>
	<!-- 파라미터로 출력할거면 파라미터 값을 갖고오거나 만들어줘야한다.  -->
	
	<h1>parameter 에 저장된 hobbies</h1>
	
	<ul>
		<li>${paramValues.HOBBIES[0] } </li>
		<li>${paramValues.HOBBIES[1] } </li>
		<li>${paramValues.HOBBIES[2] } </li>
	</ul>
</body>
</html>