<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$.ajax({
			url : "data1.js",		// 읽어올 경로
			dataType : "script",	// 읽어올 정보의 타입			
			type : "get",			// 요청 방식
			success : function() {	// 성공시
				alert("성공!")
				hi("ㅎㅇ")
			},
			error : function() {	// 에러 발생시
				alert("실패")
			}
		});
	})
</script>
</head>
<body>

</body>
</html>