<%@page import="org.joonzis.ex.CVO"%>
<%@page import="java.util.List"%>
<%@page import="org.joonzis.ex.BVO"%>
<%@page import="org.joonzis.ex.BDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	request.setCharacterEncoding("utf-8");

	String currentPage = request.getParameter("currentPage");
	
	int b_idx = Integer.parseInt(request.getParameter("b_idx"));
	
	BVO bvo = BDao.getBBS(b_idx);
	session.setAttribute("bvo", bvo);
	
	
	// --------조회수 처리 ----------
	/* 
		처음으로 view를 열었을 때에만 조회수가 증가
		게시물을 열 때 session에 open이라는 값을 저장
		session에 open 값이 있으면 조회수를 증가시키지 않고, open 값이 없을 때에만 조회수 증가
	*/
	
	String open = (String)session.getAttribute("open");
	if(open == null){	// 처음 열었을때
		session.setAttribute("opne", "yes");
		int hit = bvo.getHit() + 1;
		bvo.setHit(hit);
		BDao.getUpdateHit(bvo);
	}
	
	
	// 댓글창 갖고오기
	List<CVO> cvo = BDao.getListComment(b_idx);
	pageContext.setAttribute("cvo", cvo);
	
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  div {
      width: 800px;
      margin:auto;
 
   }
   h1{
   	 text-align: center;  
   }
   table {
      width: 800px;
      border-collapse: collapse;   
   }
   
   td, th {
      border : 1px solid #1e90ff;
      padding: 10px;
   }
   th{
  	 background-color: #0078ff;
      color: white;  
      text-align: center; 
   }
   
</style>
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
	function insert_comment(f) {
		if (f.writer.value == '') {
			alert("작성자를 입력하세요.")
			return;
		}
		f.action = 'insert_comment.jsp';
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
							<input type="hidden" name="currentPage" value="${param.currentPage}">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<br> <hr> <br>
	<!-- 댓글 입력 폼  -->
		<form action="post">
			<table>
				<tbody>
					<tr>
						<th>댓글 작성자 </th>
						<td> <input type="text" name="writer"> </td >
						<th>댓글 비밀번호 </th>
						<td> <input type="password" name="pw"> </td >
					</tr>
					<tr>
						<th>댓글 내용 </th>
						<td colspan="3">
							<textarea rows="3" cols="80" name="content"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4" id="btn2"> 
							<input type="button" value="댓글 등록" onclick="insert_comment(this.form)">  
							<input type="reset" value="다시 작성"> 
						</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="b_idx" value="${bvo.b_idx }">
			<input type="hidden" name="currentPage" value="${param.currentPage}">
		</form>
		<br> <hr> <br>
	<!-- 댓글 창 -->
		<form method="post">
			<table>
				<tbody>
					<tr>
						<th id="num">번호 </th>
						<th id="writer">작성자 </th>
						<th id="con">내용 </th>
						<th id="date">날짜 </th>
						<th id="del">삭제 </th>
					</tr>
					<c:choose>
						<c:when test="${empty cvo }">
							<tr>
								<td colspan="5">댓글이 없습니다</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="cvo" items="${cvo }">
								<tr>
									<td>${cvo.c_idx }</td>
									<td>${cvo.writer }</td>
									<td>${cvo.content }</td>
									<td>${cvo.reg_date }</td>
									<td><input type="button" value="x"
										onclick="
									 	location.href = 'remove_comment.jsp?b_idx=${bvo.b_idx }&currentPage=${param.currentPage }&c_idx=${cvo.c_idx }'
									 	">
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>