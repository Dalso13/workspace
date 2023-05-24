<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="org.joonzis.ex.GreenDto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	GreenDto dto = GreenDao.getInstance().getOneList(id,pw);

	pageContext.setAttribute("dto", dto);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="index.jsp"/>
	
	 <br> <hr> <br>
	 
	 
	 <h1>${param.id } 님의 데이터</h1>
	<table>
		<thead>
			<tr>
				<th>회원 번호 </th>
				<th>아이디 </th>
				<th>비밀번호 </th>
				<th>이름 </th>
				<th>나이 </th>
				<th>주소 </th>
				<th>가입일 </th>
			</tr>
		</thead>
		<tbody>
			<c:choose>
				<c:when test="${empty  dto }">
					<tr>
						<td colspan="7"> ${param.id  } 님에 정보가 없습니다. </td>
					</tr>
				</c:when>
				<c:otherwise>	
					<tr>
						<td>${dto.idx }</td>	<%-- 리턴 메소드를 (getter) 를 알아서 호출한다 --%>
						<td>${dto.id }</td>
						<td>${dto.pw }</td>
						<td>${dto.name }</td>
						<td>${dto.age }</td>
						<td>${dto.addr }</td>
						<td>${dto.reg_date }</td>
					</tr>	
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>