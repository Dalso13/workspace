<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		let xhr = new XMLHttpRequest();
		
		xhr.onreadystatechange = function () {
			if (xhr.readyState == 4 && xhr.status == 200) {
			
				let jsonObj = JSON.parse(xhr.responseText);
				// 만약 JSON.pares 가 동작하지 않으면
				// json2.js 파일을 포함하여 사용할 수 있다.
				// json,org > JavaScript > json2.js 다운로드
				// WebVontent/js 폴더 생성 후 json2.js 저장
				// <script src="../js/json2.js"> 추가하여 사용
				
				document.body.innerHTML += `\${jsonObj.name} <br>`; 
				document.body.innerHTML += `\${jsonObj.age} <br>`; 
				
			}
		}
		
		xhr.open("get","people.js", true);
		xhr.send();
	</script>
</body>
</html>