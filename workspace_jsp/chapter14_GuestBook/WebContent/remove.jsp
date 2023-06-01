<%@page import="org.joonzis.ex.GuestbookVO"%>
<%@page import="org.joonzis.ex.GuestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
	GuestbookVO vo = (GuestbookVO)session.getAttribute("vo");

	int result = GuestbookDao.remove(vo.getIdx());
	
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
				alert("방명록이 삭제되었습니다");
				location.href = "index.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("방명록 삭제를 실패하였습니다");
				history.back();
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>