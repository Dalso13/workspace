<%@page import="java.net.Inet4Address"%>
<%@page import="org.joonzis.ex.BDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="org.joonzis.ex.BVO"%>
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
	
	BVO bvo = new BVO();
	
	String ip = Inet4Address.getLocalHost().getHostAddress(); // IPv4 ;
	// request.getRemoteAddr();  IPv6
	
	bvo.setWriter(mr.getParameter("writer"));
	bvo.setIp(ip);  // 작성자 ip 값;
	bvo.setPw(mr.getParameter("pw"));
	bvo.setTitle(mr.getParameter("title"));
	bvo.setContent(mr.getParameter("content"));
	bvo.setHit(0);
	
	if(mr.getFile("filename") != null){
		bvo.setFilename(mr.getFilesystemName("filename"));
	} else{
		bvo.setFilename("");
	}
	
	int result = BDao.getInsert(bvo);
	
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
				alert("게시글이 작성되었습니다");
				location.href = "index.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("게시글 작성을 실패하였습니다");
				history.back();
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>