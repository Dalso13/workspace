<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	아이디 : ${param.id }  <br>	<!-- 파라미터 값을 쓰고싶을때 -->
	
	좋아하는 음식 :${paramValues.fav[0] } <br> <!-- 배열일경우 -->
</body>
</html>