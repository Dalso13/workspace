<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="org.joonzis.ex.GreenDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	int idx = Integer.parseInt(request.getParameter("idx"));
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String addr = request.getParameter("addr");
	
	GreenDto dto = new GreenDto();
	
	dto.setIdx(idx);
	dto.setPw(pw);
	dto.setName(name);
	dto.setAge(age);
	dto.setAddr(addr);
	
 	int result = GreenDao.getInstance().getUpdate(dto);
	
	pageContext.setAttribute("result", result); 
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<c:choose>
		<c:when test="${result gt 0 }">
			<script type="text/javascript">
				alert("회원 업데이트 성공");
				location.href = "view_all.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("회원 업데이트 실패!");
				location.href = "index.jsp";
			</script>
		</c:otherwise>
	</c:choose> 
</body>
</html>