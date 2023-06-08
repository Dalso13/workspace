<%@page import="java.io.File"%>
<%@page import="java.net.Inet4Address"%>
<%@page import="org.joonzis.ex.BDao"%>
<%@page import="org.joonzis.ex.BVO"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	bvo.setTitle(mr.getParameter("title"));
	bvo.setContent(mr.getParameter("content"));
	bvo.setB_idx(Integer.parseInt(mr.getParameter("b_idx")));
	bvo.setIp(Inet4Address.getLocalHost().getHostAddress()); //IPv4
	
	File newfile = mr.getFile("filename");
	String oldfile = mr.getParameter("oldfile");
	
	if(newfile != null){ // 새파일이 있을때
		if(oldfile != null){ // 기존파일이 있을때
			File removeFile = new File(realPath + "/" + oldfile);
			if(removeFile.exists()){ // 기존파일 유무 확인
				removeFile.delete();
			}
		}
		bvo.setFilename(newfile.getName());
	} else { // 새파일이 없을때
		if(oldfile != null){ // 기존파일이 있을때
			bvo.setFilename(oldfile);
		} else { // 기존파일이 없을때
			bvo.setFilename("");
		}
	}
	
	int result = BDao.getUpdate(bvo);
	
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
				alert("게시글이 수정되었습니다");
				location.href = 'index.jsp';
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("게시글 수정을 실패하였습니다");
				history.back();
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>