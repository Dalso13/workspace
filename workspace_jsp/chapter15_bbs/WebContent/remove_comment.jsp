<%@page import="org.joonzis.ex.BDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	
	BDao.removeComment(Integer.parseInt(request.getParameter("c_idx")));
	
	response.sendRedirect("view.jsp?b_idx="+request.getParameter("b_idx")+"&currentPage="+request.getParameter("currentPage"));
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