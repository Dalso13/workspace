<%@page import="org.joonzis.ex.BVO"%>
<%@page import="org.joonzis.ex.BDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setCharacterEncoding("utf-8");

	String currentPage = request.getParameter("currentPage");
	
	pageContext.setAttribute("currentPage", currentPage);
	
	BVO bvo = BDao.getBBS(Integer.parseInt(request.getParameter("b_idx")));
	session.setAttribute("bvo", bvo);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function update_page(f) {
		f.action = "update_page.jsp"
		f.submit();
	}
	function remove_page(f) {
		f.action = "remove_page.jsp"
		f.submit();
	}
	function view_all(f) {
		f.action = "index.jsp"
		f.submit();
	}
</script>
</head>
<body>
	<div>
		<h1>${bvo.b_idx }번 게시글</h1>
		<form method="post">
			<table>
				<tbody>
					<tr>
						<th>작성자 </th>
						<td>${bvo.writer } </td>
						<th> IP </th>
						<td>${bvo.ip } </td>
					</tr>
					<tr>
						<th> 제목 </th>
						<td>${bvo.title } </td>
					</tr>
					<tr>
						<th> 첨부파일 </th>
						<td colspan="3">
							<c:choose>
								<c:when test="${empty bvo.filename }">
									첨부파일 없음 
								</c:when>
								<c:otherwise>
									<a href="download.jsp?path=upload&filename=${bvo.filename }"> ${bvo.filename } </a>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th> 내용 </th>
						<td colspan="3">${bvo.content } </td>
					</tr>
					<tr>
						<td colspan="4" id="btn"> 
							<input type="button" value="게시판 수정" onclick="update_page(this.form)"> 
							<input type="button" value="게시판 삭제" onclick="remove_page(this.form)"> 
							<input type="button" value="목록으로 이동" onclick="view_all(this.form)"> 
							<input type="hidden" name="currentPage" value="${currentPage}">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>