<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSON 데이터 타입</h1>
	<div id="output"></div>
	
	<script type="text/javascript">
		/* 
			JSON 데이터 타입
			- 문자열, 숫자, 객체(JSON 객체), 배열, 논리형, NULL
		*/
		
		// 문자열
		let str = {"name":"kim"};
		
		// 숫자
		let num = {"age":20};
		
		// 객체
		let obj = {
				"emp":{"name" : "kim","age": 20, "city" : "busan"}
		}
		
		// div 태그내에 직원의 이름과 나이 출력
		document.querySelector("#output").innerHTML = `이름 : \${str.name}  나이 : \${num.age} 지역 : \${obj.emp.city}`;
	</script>
</body>
</html>