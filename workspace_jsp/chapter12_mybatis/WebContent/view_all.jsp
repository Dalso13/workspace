<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="org.joonzis.ex.GreenVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>녹색 회원 목록보기</title>
</head>
<body>
	<jsp:include page="index.jsp"/> <br/><hr/><br/>
	
	<%
		// 전체 목록 가져오기
		GreenDao dao = GreenDao.getInstance();
		List<GreenVO> list = dao.getAllList();
		// == List<GreenVO> list = GreenDao.getInstance().getAllList(); --> 위처럼 두개로 나누는게 오류 날 확률이 훨씬 적다!!
	
		// EL은 4가지 영역(객체)에 저장된 데이터를 사용한다. list를 PageContext에 담았다!!
		pageContext.setAttribute("list", list );
	%>
	<div>
		<h1>전체 녹색 회원 목록</h1>
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
				 <c:if test="${not empty list }">		  	<%--  ${not empty list }: 리스트가 비어있지 않다. (== if(list.size() > 0) --%>
				 	<c:forEach var="vo" items="${list}" >	<%-- == for(GreenVO dto : list) --%> 
						<tr>
							<td>${vo.idx }</td>
							<td>${vo.id }</td>
							<td>${vo.pw }</td>
							<td>${vo.name }</td>
							<td>${vo.age }</td>
							<td>${vo.addr }</td>
							<td>${vo.reg_date }</td>
						</tr>
					</c:forEach>
				</c:if> 				 
				<c:if test="${empty list }">				<%--  ${empty list } : list가 비어있다. (== if(list.size() == 0) --%>
					<tr>
						<td colspan="7">녹색 회원이 없습니다.</td>
					</tr>
				</c:if>		 				
			</tbody>
		</table>
	</div>
	
</body>
</html>