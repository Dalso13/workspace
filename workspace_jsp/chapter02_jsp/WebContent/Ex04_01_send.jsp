<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function send(f) {
		f.action = '/chapter02_jsp/Ex04_02_receive.jsp';
		f.submit(); // 함수
	}
</script>
</head>
<body>
	<form method="get">
		<fieldset>
			<legend>개인 정보 전송</legend>
			<p>이름 <input type="text" name="name"> </p>
			<p>나이 <input type="number" name="age"> </p>
			<p>
				반려동물(
					<input type="checkbox" name="pet" value="강아지" >강아지
					<input type="checkbox" name="pet" value="고양이">고양이
					<input type="checkbox" name="pet" value="돼지">돼지
				)
			</p>
			<p> <textarea rows="5" cols="30" name="info" placeholder="자기소개"></textarea> </p>
			<input type="button" value="전송" onclick="send(this.form)">
		</fieldset>
	</form>
</body>
</html>