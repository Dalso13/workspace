<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function remove(f) {
		if (f.c_witer.value == "") {
			f.c_witer.focus()
		}
		if (f.c_pw.value == "") {
			f.c_pw.focus()
		}
		
			$.ajax({
				url : "/myPro/ChatCon",		
				dataType : "text",
				data : $(f).serialize(),
				type : "post",			
				success : function(d) {	
					if (d == 0) {
						alert("정보가 일치하지 않습니다")
					} else {
						window.opener.ajaxOut();
						window.close()
					}
				},
				error : function() {	
					alert("error")
				}
			});
		
	}
	function out() {
		window.close()
	}
</script>
</head>
<body>
<form>
	<h3>본인 확인</h3>
	<table>
		<tr>
			<th> 작성자 </th>
			<td> <input type="text" name="c_witer"> </td>
		</tr>
		<tr>
			<th> 비밀번호 </th>
			<td> <input type="text" name="c_pw"> </td>
		</tr>
		<tr>
			<td> 
				<input type="button" value="삭제하기" onclick="remove(this.form)">
				<input type="button" value="창닫기" onclick="out()">
			</td>
		</tr>
	</table>
	<input type="hidden" name="c_idx" value="${param.idx }">
	<input type="hidden" name="cmd" value="remove">
</form>
</body>
</html>