<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	if ("${result}" != "no") {
		if (${result} == "0") {
			alert("회원 가입에 실패했습니다.")
			history.go(-1);
		} else if (${result} == "1") {
			alert("회원 가입에 성공했습니다.")
			location.href = '/myPro/UserCon?cmd=login_page';
		}
	} else {
		alert("로그인에 실패했습니다.")
		history.go(-1);
	}

	
</script>
</head>
<body>
</body>
</html>