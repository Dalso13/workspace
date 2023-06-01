<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="org.joonzis.mybatis.DBService"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="org.joonzis.ex.GreenVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정 </title>
<script type="text/javascript">
	function update( f ) {
		if ( f.pw.value == "" ) {
			alert("수정 할 회원의 비밀번호를 먼저 입력하세요.");
			f.pw.focus();
			return;
		}
		if ( f.name.value == "" ) {
			alert("수정 할 회원의 성명을 먼저 입력하세요.");
			f.name.focus();
			return;
		}
		if ( f.age.value == "" ) {
			alert("수정 할 회원의 나이를 먼저 입력하세요.");
			f.age.focus();
			return;
		}
		if ( f.addr.value == "" ) {
			alert("수정 할 회원의 주소를 먼저 입력하세요.");
			f.addr.focus();
			return;
		}
		f.action = "update.jsp";
		f.submit();
	}
</script>
</head>
<body>
	
	<jsp:include page="index.jsp" />
	
	<br /><hr /><br />
<%
	request.setCharacterEncoding("UTF-8");
	
	GreenVO vo = new GreenVO();
	vo.setId(request.getParameter("id"));
	vo.setPw(request.getParameter("pw"));
	
	//SqlSessionFactory factory = DBService.getFactory();
	//SqlSession sqlSession = factory.openSession();
		
	//GreenVO vo2 = sqlSession.selectOne("update_page",dto);

	GreenDao dao = GreenDao.getInstance();
	GreenVO vo2 = dao.update_page(vo);

	pageContext.setAttribute("vo2", vo2);
%>
	<div>
		<h1>${param.id } 회원의 정보</h1>
		<form method="post">
			<table>
				<tbody>
					<c:choose>
						<c:when test="${vo2 ne null }">
				
						<tr>
							<td>순번</td>
							<td>${vo2.idx }<input type="hidden" name="idx" value="${vo2.idx }" /></td>
						</tr>
						<tr>
							<td>아이디</td>
							<td>${vo2.id }<input type="hidden" name="id" value="${vo2.id }" /></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" name="pw" value="${vo2.pw }" size="50" /></td>
						</tr>
						<tr>
							<td>성명</td>
							<td><input type="text" name="name" value="${vo2.name }" size="50" /></td>
						</tr>
						<tr>
							<td>나이</td>
							<td><input type="text" name="age" value="${vo2.age }" size="50" /></td>
						</tr>
						<tr>
							<td>주소</td>
							<td><input type="text" name="addr" value="${vo2.addr }" size="50" /></td>
						</tr>
						<tr>
							<td>가입일</td>
							<td>${vo2.reg_date }<input type="hidden" name="reg_date" value="${vo2.reg_date }" /></td>
						</tr>
						</c:when>
						<c:otherwise>
						<tr>
							<td colspan="2">${param.id } 회원의 정보가 없습니다.</td>
						</tr>					
						</c:otherwise>					
					</c:choose>
				</tbody>
				<tfoot>
					<c:choose>
						<c:when test="${vo2 ne null }">
						<tr>
							<td colspan="2">
								<input type="button" value="회원 정보 수정" onclick="update(this.form)" />&nbsp;&nbsp;
								<input type="reset" value="다시 작성" />&nbsp;&nbsp;
							</td>
						</tr>
						</c:when>
					</c:choose>													
				</tfoot>
			</table>
		</form>
	</div>
 	<%  // sqlSession.close(); %>	
</body>
</html>