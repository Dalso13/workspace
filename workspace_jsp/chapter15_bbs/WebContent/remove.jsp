<%@page import="org.joonzis.ex.BDao"%>
<%@page import="java.io.File"%>
<%@page import="org.joonzis.ex.BVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%
	// 삭제하기 위해 b_idx
	// 파일삭제
	
	BVO bvo = (BVO)session.getAttribute("bvo");

	int b_idx = bvo.getB_idx();
	String realPath = application.getRealPath("/upload");
	String filename = bvo.getFilename();
	
	File removeFile = new File(realPath + "/" + filename);
	if(removeFile.exists()){ // 경로에 파일이 있는지 물어보는 함수
		removeFile.delete(); // 첨부파일 삭제	
	}
	
	int result = BDao.getRemove(b_idx);
	
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
				alert("게시글이 삭제되었습니다");
				location.href = "index.jsp";
			</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("게시글 삭제를 실패하였습니다");
				history.go(-2);
			</script>
		</c:otherwise>
	</c:choose>
</body>
</html>