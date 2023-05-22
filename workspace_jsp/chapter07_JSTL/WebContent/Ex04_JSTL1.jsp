<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		성적 입력 화면 (FORM)
		국어 : kor
		영어 : eng
		수학 : mat
		action : Ex04_JSTL2.jst
	 -->
	 
	 <form action="Ex04_JSTL2.jsp">
	 	국어 <input type="number" name="kor"> <br>
	 	영어 <input type="number" name="eng"> <br>
	 	수학 <input type="number" name="mat"> <br>
	 	<input type="submit" value="전송">
	 </form>
</body>
</html>