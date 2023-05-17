<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String tel = request.getParameter("tel");
	String gender = request.getParameter("gender");
	String hobbies[] = request.getParameterValues("hobbies");
	String addr = request.getParameter("addr");
	String foods = request.getParameter("foods");

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>이름 : <%= name %> </li>
		<li>나이 : <%= age %> </li>
		<li>전화번호 : <%= tel %> </li>
		<li>성별 : <%= gender %> </li>
		<li>취미 : <% if(hobbies != null){
			 for(int i = 0; i < hobbies.length; i++){%>
				<br> <%= hobbies[i] %>
				<% }
			} else { %>
				없음
		<% } %>  </li>
		  
		<li>지역 : <%= addr %> </li>
		<li>좋아하는 음식 : <%= foods %> </li>
	</ul>
	
	
</body>
</html>