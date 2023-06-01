<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="org.joonzis.ex.GreenVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
%>    
<jsp:useBean id="vo" class ="org.joonzis.ex.GreenVO" /><!-- GreenDto.java의  public GreenDto(){}를 사용한다. -->
<jsp:setProperty property="*" name="vo" />				<!-- GreenDto.java의 모든 setter를 사용한다. useBean의 id와 setProperty의 name은 같아야함-->

<%
	GreenDao dao = GreenDao.getInstance();
	int result = dao.getInsert(vo);
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
				history.go(-1);
			</script>
		</c:otherwise>
	</c:choose>
