<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이전 jsp 표현식</h1>
	<ul>
		<li>7 + 2 = <%= 7 + 2 %> </li>
		<li>7 - 2 = <%= 7 - 2 %> </li>
		<li>7 * 2 = <%= 7 * 2 %> </li>
		<li>7 / 2 = <%= 7 / 2 %> </li>
		<li>7 % 2 = <%= 7 % 2 %> </li>
	</ul>
	
	<h1>새로운 jsp 표현식</h1>
	<ul>
		<li>7 + 2 = ${7+2 } </li>
		<li>7 - 2 = ${7-2 } </li>
		<li>7 * 2 = ${7*2 } </li>
		<li>7 / 2 = ${7/2 } </li>
		<li>7 % 2 = ${7%2 } </li>
	</ul>
	
	<h1>이전 jsp 변수 저장</h1>
	<% int num = 100; %>
	num 의 값 : <%=num %>
	
	<h1>EL의 변수 저장</h1>
	<%pageContext.setAttribute("num", 100); %>
	num 의 값 ${num }
	
	<h1>EL 에서 사용되는 4가지 속성의 우선 순위</h1>
	<%
		pageContext.setAttribute("car", "s-class"); // 우선 순위  좁은 범위부터 1.
		request.setAttribute("car", "e-class");		// 2.
		session.setAttribute("car", "c-class");		// 3.
		application.setAttribute("car", "a-class"); // 4.
	%>
	
	<ul>
		<li>그냥 호출 : ${car }</li>
		<li>pageContext : ${pageScope.car }</li>	<!-- 스코프를 지정 -->
		<li>request : ${requestScope.car }</li>
		<li>session : ${sessionScope.car }</li>
		<li>application : ${applicationScope.car }</li>
	</ul>
</body>
</html>