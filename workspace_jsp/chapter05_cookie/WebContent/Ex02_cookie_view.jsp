<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		// 쿠키 저장소의 모든 데이터 확인하기
		Cookie[] cookieBox = request.getCookies();		// 쿠키 값 가져오기
	
		if(cookieBox != null && cookieBox.length > 0){
			for(int i = 0; i < cookieBox.length; i++){
				out.print("쿠기 이름 : " + cookieBox[i].getName() + "<br>");	
				out.print("쿠기 값 : " + URLDecoder.decode(cookieBox[i].getValue(), "utf-8") + "<br>"); // 인코딩이 돼있을때 디코더써줌
			}
		} else {
			out.print("쿠키가 존재하지 않습니다. ");
		}
	
	
	%>
</body>
</html>