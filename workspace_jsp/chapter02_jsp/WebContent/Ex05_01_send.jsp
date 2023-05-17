<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#guiter {
		visibility: hidden;
	}
</style>
<script type="text/javascript">
	function view() {
		if(document.getElementById("guiter").style.visibility == "visible"){
			document.getElementById("guiter").style = "visibility : hidden";
			return;
		}
			document.getElementById("guiter").style = "visibility : visible";
		
		
	}
	function start(f) {
		document.getElementById("kt").value = document.getElementById("guiter").value;
		f.action = '/chapter02_jsp/Ex05_02_receive.jsp';
		f.submit();
	}
</script>
</head>
<body>
 	<form method="post">
 	 	<fieldset>
 	 		<p> 이름 <input type="text" name="name"> </p>
 	 		<p> 나이 <input type="number" name="age"> </p>
 	 		<p> 전화 <input type="tel" name="tel"> </p>
 	 		<p> 성별 <input type="radio" name="gender" value="남" checked="checked">남
 	 				<input type="radio" name="gender" value="여">여 
 	 		</p>
 	 	 	<p> 취미 <input type="checkbox" name="hobbies" value="영화">영화
 	 	 			<input type="checkbox" name="hobbies" value="게임">게임
 	 	 			<input type="checkbox" name="hobbies" value="독서">독서
 	 	 			<input type="checkbox" name="hobbies" value="여행">여행
 	 	 			<input type="checkbox" name="hobbies" id="kt" onchange="view()">기타
 	 	 			<input type="text" id="guiter">
 	 	 	</p>
 	 	 	<p> 주소 <select name="addr">
 	 	 				<option value="서울">서울</option>
 	 	 				<option value="경기">경기</option>
 	 	 				<option value="제주">제주</option>
 	 	 			</select>
 	 	 	</p>
 	 	 	<p>좋아하는 음식</p>
 	 	 	<select name="foods" size="4">
 	 	 				<option value="한식">한식</option>
 	 	 				<option value="일식">일식</option>
 	 	 				<option value="중식">중식</option>
 	 	 				<option value="양식">양식</option>
 	 	 	</select>
 	 	 	<br>
 	 	 	<input type="button" onclick="start(this.form)" value="보내기"> 
 	 	 	<input type="button" onclick=""  value="작성취소"> 
 	 	</fieldset>
 	</form>
</body>
</html>