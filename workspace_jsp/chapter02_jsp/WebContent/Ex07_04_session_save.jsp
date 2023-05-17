<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 세션에 데이터 저장하기
	session.setAttribute("name", "장동완");
	session.setAttribute("age", "20");	
	
	response.sendRedirect("Ex07_01_session.jsp");

%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>