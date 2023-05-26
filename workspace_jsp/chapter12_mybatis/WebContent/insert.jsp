<%@page import="org.joonzis.ex.GreenVO"%>
<%@page import="org.joonzis.ex.GreenDao"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	int age = Integer.parseInt(request.getParameter("age"));
	String addr = request.getParameter("addr");
	
	GreenVO vo = new GreenVO();
	vo.setId(id);
	vo.setPw(pw);
	vo.setName(name);
	vo.setAge(age);
	vo.setAddr(addr);
	
	// dao로 dto 전달
	// dao에서 전달 받은 dto를 이용하여 데이터 삽입 후 결과 값 리턴
	// 전달 받은 데이터(삽입 후)를 판단하여 진행
	
	int result = GreenDao.getInstance().getInsert(vo);
	
	pageContext.setAttribute("result", result);
%>
	
	<c:choose>
		<c:when test="${result gt 0 }">
			<script type="text/javascript">
				alert("회원 추가 성공");
				location.href = "view_all.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("회원 추가 실패!");
				location.href = "index.jsp";
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>