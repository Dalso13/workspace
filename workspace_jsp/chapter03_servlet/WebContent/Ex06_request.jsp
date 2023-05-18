<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f) { 
		if (f.query.value == '') {
			alert("검색 내용을 입력하세요")
			return;
		}
		f.action = "Ex06_request"	// 서블릿 주소
		f.submit();
	}
</script>
</head>
<body>
	<form method="get">
		검색 <input type="text" name="query">
		<input type="button" value="전송" onclick="send(this.form);">
	</form>
</body>
</html>