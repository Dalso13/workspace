<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 1. 최소 값, 최대 값, 최소값 ~ 최대 값 화면에 출력 -->
	<c:set var="min" value="${param.num1 lt param.num2 ? param.num1 : param.num2}"/>
	<c:set var="max" value="${param.num1 gt param.num2 ? param.num1 : param.num2}"/>
	
	최대 값 : ${min } <br>
	최소 값 : ${max } <br>
	
	<c:forEach var="i" begin="${min }"
	 	end="${max}" step="1">
	 		${i }
	 </c:forEach> 
	<br> <hr> <br>
	<!-- 2. 향상 forEach 이용하여 음식 종류들 출력 -->
	<c:forEach var="food" items="${paramValues.foods }">
		${food }
	</c:forEach>
	
</body>
</html>