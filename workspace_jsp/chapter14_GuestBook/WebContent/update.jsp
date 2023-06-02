<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="org.joonzis.ex.GuestbookVO"%>
<%@page import="org.joonzis.ex.GuestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
	GuestbookVO vo = (GuestbookVO)session.getAttribute("vo");
	
	String realPath = request.getServletContext().getRealPath("/upload");
	
	MultipartRequest mr  = new MultipartRequest(
			request,
			realPath,
			1024 * 1024 * 10,	
			"utf-8",
			new DefaultFileRenamePolicy()
		);
	
	vo.setEmail(mr.getParameter("email"));
	vo.setTitle(mr.getParameter("title"));
	vo.setContent(mr.getParameter("content"));
	
	// 첨부파일 유무에 따라서 filename 값을 결정하자
	if(mr.getFile("filename") != null){
		vo.setFilename(mr.getFilesystemName("filename"));
	}

	int result = GuestbookDao.update(vo);
	
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
				alert("방명록이 수정되었습니다");
				location.href = "index.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("방명록 수정을 실패하였습니다");
				history.back();
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>