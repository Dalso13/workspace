<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	// 세션에 데이터 저장하기
	session.setAttribute("name", "장동완");		//세션에 데이터 저장 ("type" , "저장할 내용")
	session.setAttribute("age", "20");	
	
	response.sendRedirect("Ex07_01_session.jsp");	// 리다이렉트 방법으로 이동

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