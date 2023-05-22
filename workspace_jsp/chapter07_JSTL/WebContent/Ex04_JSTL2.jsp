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
	<c:set var="avg" value="${(param.kor + param.eng + param.mat) / 3}"/>
	
	<c:choose>
		<c:when test="${avg gt 89} ">
			<c:set var="grade" value="A"/>
		</c:when>
		<c:when test="${avg gt 79}">
			<c:set var="grade" value="B"/>
		</c:when>
		<c:when test="${avg gt 69}">
			<c:set var="grade" value="C"/>
		</c:when>
		<c:when test="${avg gt 59}">
			<c:set var="grade" value="D"/>
		</c:when>
		<c:otherwise>
			<c:set var="grade" value="F"/>
		</c:otherwise>
	</c:choose>
	<c:if test="${avg gt 69}">
		<c:set var="pass" value="합격"/>
	</c:if>
	<c:if test="${avg lt 70}">
		<c:set var="pass" value="불합격"/>
	</c:if>
	
	<div>국어 : <c:out value="${param.kor }" />점 </div>
	<div>영어 : <c:out value="${param.eng }" />점 </div>
	<div>수학 : <c:out value="${param.mat }" />점 </div>
	<div>평균 : <c:out value="${avg }" />점 </div>
	<div>학점 : <c:out value="${grade }" /> </div>
	<div>합격여부 :${pass }</div>
</body>
</html>