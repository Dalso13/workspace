<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="org.joonzis.ex.GreenDto"%>
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
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String addr = request.getParameter("addr");
	
	GreenDto dto = new GreenDto();
	dto.setId(id);
	dto.setPw(pw);
	dto.setName(name);
	dto.setAge(Integer.parseInt(age));
	dto.setAddr(addr);
	
	int result = GreenDao.getInstance().getInsert(dto);

	pageContext.setAttribute("result", result);
%>
	<c:choose>
		<c:when test="${result gt 0 }">
			<script type="text/javascript">
				alert("회원이 추가되었습니다.");
				location.href='view_all.jsp';
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("회원이 추가를 실패했습니다.");
				location.href='view_all.jsp';
			</script>
		</c:otherwise>
	</c:choose>

</body>
</html>



