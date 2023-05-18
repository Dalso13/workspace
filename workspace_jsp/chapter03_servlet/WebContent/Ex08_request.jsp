<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function start(f) {
		if (f.name.value == '' || f.kor.value == '' || f.eng.value == '' || f.mat.value == '') {
			alert("값을 기입해주세요");
			return;
		}
		
		let reg = /^\b[0-9]{1,2}$|^100$/
		
		if (!reg.exec(f.kor.value)||!reg.exec(f.eng.value)||!reg.exec(f.mat.value)) {
			alert("점수 다시 입력");
			return;
		}
		
		f.action = '/chapter03_servlet/Ex08_request'
		f.submit()
		
	}
</script>
</head>
<body>
	 <form method="get">
 	 		<div>이름 : <input type="text" name="name"> </div>
 	 		<div>국어 : <input type="number" name="kor"> </div>
 	 		<div>영어 : <input type="number" name="eng"> </div>
 	 		<div>수학 : <input type="number" name="mat"> </div>
 	 	 	<input type="button" onclick="start(this.form)" value="결과학인"> 
 	 	 	<input type="reset" value="취소"> 
 	</form>
</body>
</html>