<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	// 페이지 로드
	$(function () {
			
			
			
			$(function(){
				$.ajax({
					url : "xml_data.xml",		// 읽어올 경로
					dataType : "xml",	// 읽어올 정보의 타입			
					type : "get",			// 요청 방식
					success : function(d) {	// 성공시
						let msg = '<ul>';
						$(d).find("person").each(function() {
							let name = $(this).find("name").text();
							let age = $(this).find("age").text();
							
							msg += `<li>이름 : \${name} </li>`;
							msg += `<li>나이 : \${age} </li>`;
						});
						msg += '</ul>'
						$("#content").html(msg);
					},
					error : function() {	// 에러 발생시
						
					}
				});
			})
			
			
			
	})

</script>
</head>
<body>
	<div>
		<h1 style="color: blue">xmlReader.jsp 입니다.</h1>
		<div id="content"></div>
	</div>
</body>
</html>