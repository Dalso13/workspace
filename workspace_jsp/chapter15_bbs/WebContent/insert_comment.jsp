<%@page import="org.joonzis.ex.BDao"%>
<%@page import="java.net.Inet4Address"%>
<%@page import="org.joonzis.ex.CVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// BDao..getInsertComment 메소드
	// 결과 확인 없이 view 화면으로 이동
	
	request.setCharacterEncoding("utf-8");
	
	CVO cvo = new CVO();
	int b_idx = Integer.parseInt(request.getParameter("b_idx"));
	
	
	cvo.setWriter(request.getParameter("writer"));
	cvo.setContent(request.getParameter("content"));
	cvo.setPw(request.getParameter("pw"));
	cvo.setIp(Inet4Address.getLocalHost().getHostAddress());
	cvo.setB_idx(b_idx);
	
	int result = BDao.getInsertComment(cvo);
	
	
	response.sendRedirect("view.jsp?b_idx="+b_idx +"&currentPage="+request.getParameter("currentPage"));

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