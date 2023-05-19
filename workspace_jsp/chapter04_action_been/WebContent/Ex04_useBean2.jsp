<%@page import="org.joonzis.bean.PersonVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");	

	String name = request.getParameter("name");
	String age = request.getParameter("age");
	String height = request.getParameter("height");
	String addr = request.getParameter("addr");
	
	PersonVO vo = new PersonVO();
	
	vo.setName(request.getParameter("name"));
	vo.setAge(Integer.parseInt(request.getParameter("age")));
	vo.setHeight(Double.parseDouble(request.getParameter("height")));
	vo.setAddr(request.getParameter("addr"));

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li><%= name %></li>
		<li><%= age %></li>
		<li><% out.print(height); %></li>
		<li><% out.print(addr); %></li>
	</ul> 
	<br>
	<ul>
		<li><%= vo.getName() %></li>
		<li><%= vo.getAge() %></li>
		<li><%= vo.getHeight() %></li>
		<li><% out.print(vo.getAddr()); %></li>
	</ul> 
</body>
</html>