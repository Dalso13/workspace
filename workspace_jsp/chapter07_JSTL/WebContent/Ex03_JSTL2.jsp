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
	<h1>EL을 이용하여 큰 수 출력하기</h1>
	 ${param.num1 }
	 ${param.num2 }
	 
	 ${param.num1 - param.num2 > 0 ? param.num1 : param.num2}
	 
	 <h1>jstl 을 이용해서 큰 수 구하기</h1>
	 <c:if test="${param.num1 - param.num2 gt 0 }">			<%-- gt: 크다 --%> 
	 	${param.num1 }
	 </c:if>		
	 <c:if test="${param.num1 - param.num2 lt 0 }">			<%-- lt: 작다 --%> 
	 	${param.num2 }
	 </c:if>		
	 
	 <h1>jstl 을 이용해서 큰 수 구하기 2</h1>
	 <c:choose>
	 	<c:when test="${param.num1 - param.num2 gt 0 }">
	 		${param.num1 }
	 	</c:when>
	 	<c:otherwise>
	 		${param.num2 }
	 	</c:otherwise>
	 </c:choose>
</body>
</html>