<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="org.apache.ibatis.session.SqlSessionFactory"%>
<%@page import="org.joonzis.mybatis.DBService"%>
<%@page import="org.joonzis.ex.GreenVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	request.setCharacterEncoding("utf-8");
	
	GreenVO vo = new GreenVO();
	vo.setId(request.getParameter("id"));
	vo.setPw(request.getParameter("pw"));
	vo.setName(request.getParameter("name"));
	vo.setAge(Integer.parseInt(request.getParameter("age")));
	vo.setAddr(request.getParameter("addr"));
%>
<!--  
	// update문의 커밋 처리 
	// 1. 수동 커밋을 사용 : openSession(false)
	// 2. 커밋		  : commit()
	// 3. 닫기		  : close()	
	
	
	SqlSessionFactory factory = DBService.getFactory();
	SqlSession sqlSession = factory.openSession(false);
	
	/*
	update문의 메소드
	1. update("sql문의 id")				- 
	2. update("sql문의 id", 파라미터) 
	
	*/	
	
	int result = sqlSession.update("update", vo);
	if( result > 0 ){
		sqlSession.commit();
		sqlSession.close();
		response.sendRedirect("view_all.jsp");
	} else {
		sqlSession.close();
%>
	<script type="text/javascript">
		alert("회원 삭제가 실패했습니다.");
		history.back();
	</script>
<%  // } %>
 -->
 
 <%
 	GreenDao dao = GreenDao.getInstance();
 	int result = dao.update(vo);
 	
 	if (result > 0) {
		out.println("<script>");
		out.println("alert('회원 정보 수정 성공!')");
		out.println("location.href='view_all.jsp'");
		out.println("</script>");
	} else {
		out.println("<script>");
		out.println("alert('회원 정보 수정 실패!')");
		out.println("history.back()");
		out.println("</script>");
	}
 
 %>
 
 