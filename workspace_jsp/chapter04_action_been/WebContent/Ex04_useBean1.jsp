<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Ex04_useBean2.jsp">
		<div>이름 <input type="text" name="name"> </div>	<%-- 자바빈 데이터와 name을 같게하면 알아서 연결됨 --%>
		<div>나이 <input type="text" name="age"> </div>
		<div>키 <input type="text" name="height"> </div>
		<div>주소 <input type="text" name="addr"> </div>
		<input type="submit" value="전송">
	</form>
</body>
</html>