<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if ("${result}" != "" || "${result}" != null) {
		if ("${result}" > 0) {
			alert("성공")
		} else if ("${result}" == "0") {
			alert("실패")
		}
	}
	
	
	
	location.href = '/chapter20_mvc_bbs/BBSController?cmd=allList&currentPage=1'
	
</script>
</head>
<body>
</body>
</html>