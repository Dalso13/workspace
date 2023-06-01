<%@page import="org.joonzis.ex.GuestbookDao"%>
<%@page import="org.joonzis.ex.GuestbookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
	List<GuestbookVO> list = GuestbookDao.selectAll();
	
	pageContext.setAttribute("list", list);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{
		width: 800px;
		margin: auto;
		text-align: center;
	}
	table {
		width: 100%;
		border-collapse: collapse;
	}
	td, th{
	 	border: 1px solid black;
	 	padding: 10px;
	}
	thead{
		background-color: gray;
		color: white;
	}
	th:nth-of-type(1){
		width: 80px;
	}
	th:nth-of-type(2){
		width: 200px;
	}
	th:nth-of-type(3){
		width: 300px;
	}
	th:nth-of-type(4){
		width: 400px;
	}
	
</style>
</head>
<body>
	<div>
		<h2>방명록</h2>
		<p>
			<button onclick="location.href='write_page.jsp'">글쓰기</button>
		</p>
		<table>
			<thead>
				<tr>
					<th>번호</th>
					<th>작성자</th>
					<th>제목</th>
					<th>작성일</th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="4">작성된 방명록이 없습니다 </td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="vo" items="${list }">
							<tr>
							 	<td> ${vo.idx } </td>
							 	<td> ${vo.writer } </td>
							 	<td> <a href="view.jsp?idx=${vo.idx }"> ${vo.title } </a></td>
							 	<td> ${vo.reg_date } </td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
	</div>
</body>
</html>