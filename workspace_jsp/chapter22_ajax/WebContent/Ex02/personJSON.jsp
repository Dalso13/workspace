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
				// 일반 텍스트 형식 결과 : responseText (html, jsp, txt 등)
				// xml의 결과 : responseXML (태그를 자동으로 파싱)
				
				let xmlData = xhr.responseXML;
				/* 
				let names = xmlData.getElementsByTagName("name");
				let ages = xmlData.getElementsByTagName("age");
				
				let msg = '<ul>';
				for (var i = 0; i < names.length; i++) {
					let name = names[i].childNodes[0].nodeValue;
					let age = ages[i].childNodes[0].nodeValue;
					
					msg += `<li> 이름 : \${name} </li>`;
					msg += `<li> 나이 : \${age} </li>`;
				}
				msg+= "</ul>";
				document.body.innerHTML = msg; */
				
				let people = xmlData.getElementsByTagName("person");
				let msg = '<ul>';
				msg += `<li> 이름 : \${people[2].getAttribute("name")} </li>`;
				msg += `<li> 나이 : \${people[2].getAttribute("age")} </li>`;
				msg += `<li> 이름 : \${people[3].getAttribute("name")} </li>`;
				msg+= "</ul>";
				document.body.innerHTML = msg;
			}
		}
		
		xhr.open("get","people.xml", true);
		xhr.send();
	</script>
</body>
</html>