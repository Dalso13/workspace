<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/* 
		jsp에서 controller(서블릿)	호출 (요청)
		
		1. /프로젝트명/서블릿명   비추.
		2. /프로젝트명/URL매핑명
	*/
	function req_date() {
		location.href = '/chapter16_mvc/Controller1'
	}
	function req_titme() {
		location.href = '/chapter16_mvc/Controller2'
	}
</script>
</head>
<body>
	<div>
		<h1>원하는 정보의 버튼을 클릭하시오</h1>
		<button onclick="req_date()">현재 날짜 확인</button> <br>
		<button onclick="req_titme()">현재 시간 확인</button> <br>
	</div>
</body>
</html>