<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 쿠키 만들기 (서버로 쿠키 만들기)
	// Cookie cookie = new Cookie ("쿠키 이름, "쿠키 값")
	Cookie cookie = new Cookie("id","admin");
	// 쿠키 유효시간 설정 (1일)
	cookie.setMaxAge(60*60*24);
	// "쿠키 값"에 공백, 콤마, 괄호 등을 저장하려면 인코딩을 해야 함
	Cookie biskert = new Cookie("name",URLEncoder.encode("김 씨", "utf-8")); // 김씨에 공백을 써줌
	// bisket 의 유효시간 20분으로 설정
	biskert.setMaxAge(60 * 20);
	
	// 만든 쿠키를 쿠기 저장소에 저장
	response.addCookie(cookie);
	response.addCookie(biskert);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		쿠기1 이름 : <%= cookie.getName() %>
		쿠기1 값 : <%= cookie.getValue() %>
		
		<br>
		
		쿠기2 이름 : <%= biskert.getName() %>
		쿠기2 값 : <%= URLDecoder.decode(biskert.getValue(), "utf-8") %> <%-- 위에서 인코딩을 해줘서 디코더해줘야함 --%>
	</h1>
</body>
</html>