<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<%
		String[] hobbies = {"노래", "춤", "음주"};
		request.setAttribute("HOBBIES", hobbies);
		request.getRequestDispatcher("Ex06_EL2.jsp").forward(request, response); // 포와드 방식
	%> --%>
	
	<form action="Ex06_EL2.jsp">
		<input type="checkbox" name = "HOBBIES" value="노래">노래
		<input type="checkbox" name = "HOBBIES" value="춤">춤
		<input type="checkbox" name = "HOBBIES" value="음주">음주
		<br>
		<input type="submit" value="전송">
	</form>
</body>
</html>