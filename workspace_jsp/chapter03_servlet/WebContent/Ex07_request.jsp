<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function start(f) {
		if (f.id.value == '' || f.pw.value == '' || f.name.value == '' || f.email.value == '') {
			alert("값을 기입해주세요");
			return;
		}
		
		let count = 0;
		
	 	for (var i = 0; i <f.hobbies.length; i++) { // checkbox가 배열이라 배열마다 checked 여부를 물어서 카운트 증가
			if(f.hobbies[i].checked == false){
				count++;
			}
		}
	 	
	 	if (count == f.hobbies.length) {	// 카운트가 인덱스 길이만큼 이면 return;
	 		alert("취미를 선택해주세요");
			return; 
		}
		
		
		f.action = '/chapter03_servlet/Ex07_request'
		f.submit()
		
	}
</script>
</head>
<body>
	 <form method="get">
 	 	<fieldset>
 	 		<legend>회원가입</legend>
 	 		<div> 아이디 <input type="text" name="id"> </div>
 	 		<div> 비밀번호 <input type="password" name="pw"> </div>
 	 		<div> 이름 <input type="text" name="name"> </div>
 	 		<div> 이메일 <input type="email" name="email"> </div>
 	 		<div> 성별 <input type="radio" name="gender" value="남" checked="checked">남
 	 				<input type="radio" name="gender" value="여">여 
 	 		</div>
 	 	 	<div> 취미 <input type="checkbox" name="hobbies" value="영화">영화
 	 	 			<input type="checkbox" name="hobbies" value="음악">음악
 	 	 			<input type="checkbox" name="hobbies" value="독서">독서
 	 	 			<input type="checkbox" name="hobbies" value="없음">없음
 	 	 	</div>
 	 	 	<input type="button" onclick="start(this.form)" value="가입"> 
 	 	 	<input type="reset" value="취소"> 
 	 	</fieldset>
 	</form>
</body>
</html>