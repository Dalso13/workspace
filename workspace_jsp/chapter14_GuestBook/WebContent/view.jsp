<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="org.joonzis.ex.GuestbookDao"%>
<%@page import="org.joonzis.ex.GuestbookVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setCharacterEncoding("utf-8");

	GuestbookVO vo = GuestbookDao.selectByIdx(Integer.parseInt(request.getParameter("idx")));
	
	// 수정, 삭제 기능에서 사용하기 편함
	session.setAttribute("vo", vo);


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
		text-align: left;
	}
	td, th{
	 	border: 1px solid black;
	 	padding: 10px;
	}
	th {
		width: 100px;
		background-color: gray;
		color: white;
		text-align: center;
	}
	tr:nth-of-type(7) {
		text-align: center;
	}
</style>
</head>
<body>
	<h2>${vo.writer }의 방명록</h2>
	<table>
		<tbody>
			<tr>
				<th> 제목 </th>
				<td>${vo.title } </td>
			</tr>
			<tr>
				<th> 이메일 </th>
				<td>${vo.email } </td>
			</tr>
			<tr>
				<th> 첨부파일 </th>
				<c:choose>
					<c:when test="${empty vo.filename }">
						<td>첨부파일 없음 </td>
					</c:when>
					<c:otherwise>
						<td> <a href="download.jsp?path=upload&filename=${vo.filename }"> ${vo.filename } </a></td>
					</c:otherwise>
				</c:choose>
			</tr>
			<tr>
				<th> 내용 </th>
				<td>${vo.content } </td>
			</tr>
			<tr>
				<th> 작성일 </th>
				<td>${vo.reg_date } </td>
			</tr>
			<tr>
				<td colspan="2"> 
					<input type="button" value="방명록 수정" onclick="location.href = 'update_page.jsp'"> 
					<input type="button" value="방명록 삭제" onclick="location.href = 'remove_page.jsp'"> 
					<input type="button" value="목록으로 이동" onclick="location.href = 'index.jsp'"> 
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>