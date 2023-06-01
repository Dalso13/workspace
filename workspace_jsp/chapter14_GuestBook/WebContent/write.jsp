
<%@page import="org.joonzis.ex.GuestbookDao"%>
<%@page import="org.joonzis.ex.GuestbookVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String realPath = request.getServletContext().getRealPath("/upload");
	
	MultipartRequest mr  = new MultipartRequest(
			request,
			realPath,
			1024 * 1024 * 10,	
			"utf-8",
			new DefaultFileRenamePolicy()
		);
	
	GuestbookVO vo = new GuestbookVO();
	
	vo.setWriter(mr.getParameter("writer"));
	vo.setEmail(mr.getParameter("email"));
	vo.setPw(mr.getParameter("pw"));
	vo.setTitle(mr.getParameter("title"));
	vo.setContent(mr.getParameter("content"));
	
	// 첨부파일 유무에 따라서 filename 값을 결정하자
	if(mr.getFile("filename") != null){
		vo.setFilename(mr.getFilesystemName("filename"));
	} else{
		vo.setFilename("");
	}
	
	int result = GuestbookDao.insert(vo);
	
	pageContext.setAttribute("result", result);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${result gt 0 }">
			<script type="text/javascript">
				alert("방명록이 작성되었습니다");
				location.href = "index.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("방명록 작성을 실패하였습니다");
				history.back();
			</script>
		</c:otherwise>
	</c:choose>
	
	
</body>
</html>