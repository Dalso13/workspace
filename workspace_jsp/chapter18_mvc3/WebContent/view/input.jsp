<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send1() {
		location.href = '/chapter18_mvc3/hangeul.do';
	}
	function send2() {
		location.href = '/chapter18_mvc3/english.do';
	}
</script>
</head>
<body>
	<div>
		<button onclick="send1()">안녕</button>
		<button onclick="send2()">Hello</button>
	</div>
</body>
</html>