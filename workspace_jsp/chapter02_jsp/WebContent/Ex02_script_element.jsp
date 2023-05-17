<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>0~9 사이의 모든 정수 출력하기</h2>
	<% for(int i=0; i<10; i++){ %>		
			i
	<% } %>
	
	<h2>0~9 사이의 모든 정수 출력하기</h2>
	<% for(int i=0; i<10; i++){ %>		<%-- 안에 내용을 출력하려면 --%>
			<%= i %>
	<% } %>
	
	<h2>1~100 사이의 모든 정수의 합계를 구해서 출력하기</h2>
	<% 
		int total = 0;
		for(int j = 1; j <= 100; j++){
			total += j;
		}
	%>
	1~ 100 사이의 합 = <%= total %>
	
	<h2>1~100 사이의 모든 짝수의 합계를 리턴하는 even() 메소드</h2>
	<%! 
		public int even(){
		int sum1 = 0;
		for(int j = 0; j <= 100; j+=2){
			sum1 += j;
		}
		return sum1;
	}
	%>
	1~100 사이의 모든 짝수의 합 = <%= even() %>
	
	<h2>1~100 사이의 모든 홀수의 합계를 리턴하는 odd() 메소드</h2>
	<%! 
		public int odd(){
		int sum2 = 0;
		for(int j = 1; j <= 100; j+=2){
			sum2 += j;
		}
		return sum2;
	}
	%>
	1~100 사이의 모든 홀수의 합 = <%= odd() %>
	
	
</body>
</html>