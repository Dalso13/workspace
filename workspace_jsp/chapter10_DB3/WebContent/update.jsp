<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="org.joonzis.ex.GreenDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="dto" class="org.joonzis.ex.GreenDto"/>
<jsp:setProperty property="*" name="dto"/>

<%
	int result = GreenDao.getInstance().getUpdate(dto);
	pageContext.setAttribute("result", result);
%>

	<c:choose>
		<c:when test="${result gt 0 }">
			<script type="text/javascript">
				alert("회원 정보가 수정되었습니다.");
				location.href='view_all.jsp';
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("회원 정보 수정을 실패했습니다.");
				//location.href='view_all.jsp';
				history.go(-1);
			</script>
		</c:otherwise>
	</c:choose>