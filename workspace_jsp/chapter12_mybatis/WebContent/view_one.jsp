<%@page import="org.joonzis.ex.GreenVO"%>
<%@page import="org.joonzis.ex.GreenDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 보기</title>
</head>
<body>
	<jsp:include page="index.jsp"/> <br /><hr /><br />
	
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		
		GreenDao dao = GreenDao.getInstance();
		GreenVO vo = dao.getOneList(id);
		
		pageContext.setAttribute("vo", vo);
	%>
	<div>
		<h1>${param.id } 회원의 정보</h1>					<!-- 리퀘스트로 전달받았으니 param으로 읽어온다!! -->
		<table>
			<thead>
				<tr>
					<th>순번</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>성명</th>
					<th>나이</th>
					<th>주소</th>
					<th>가입일</th>
				</tr>
			</thead>
			<tbody>
				 <c:if test="${vo ne null}">		  	 <%-- == if(dto != null) --%>
				 	<tr>
						<td>${vo.idx }</td>
						<td>${vo.id }</td>
						<td>${vo.pw }</td>
						<td>${vo.name }</td>
						<td>${vo.age }</td>
						<td>${vo.addr }</td>
						<td>${vo.reg_date }</td>
					</tr>
				</c:if> 				 
				<c:if test="${vo eq null}">			<%-- == if(dto == null) --%>	 
					<tr>
						<td colspan="7">${param.id } 회원의 정보가 없습니다.</td>
					</tr>
				</c:if>		 				
			</tbody>
		</table>
	</div>
</body>
</html>