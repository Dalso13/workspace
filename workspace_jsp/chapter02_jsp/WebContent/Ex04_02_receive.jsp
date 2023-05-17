<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");	// 받는쪽에서 리퀘스트 객체들 인코딩
	
	// 리퀘스트로 받아올때 무조건 String 으로 받아옴
	
	
 	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age")); 	// 리퀘스트로 받아올때 문자열 타입임 그래서 형변환
	 String pet[] = request.getParameterValues("pet"); 			// 복수타입이면 배열로 받아오기  getParameterValues	null
	 String info = request.getParameter("info"); 
	 
%>
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <ul>
		<li>이름 : <%= name %></li>
		<li> 나이 : <%= age %> </li>
		<li> 
				<% if(pet != null){
					 for(int i = 0; i < pet.length; i++){%>
					<%= pet[i] %> 
				<%}} else {%>
					없음 
				<%}%>
		</li>
		
		<li><%= info %></li>
	</ul> 
</body>
</html> 