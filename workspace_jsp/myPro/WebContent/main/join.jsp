<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	onload = function () {
		let id_check = document.getElementById("#id_check")
	}
	function go(f) {
		if (id_check.innerText == "이미 사용중인 아이디 입니다.") {
			f.u_writer.focus()
			return;
		}
		if (f.u_pw.value == '' || f.u_writer.value == ''){
			alert("입력하세요.")
			return;
		}
		
		if (f.u_pw.value != f.u_pwr.value) {
			alert("비밀번호가 일치하지 않습니다.")
			return;
		}
		f.action = "/myPro/UserCon";
		f.submit();
	}
	function getID(f) {
		$.ajax({
			url : `/myPro/AjaxCon?cmd=getid&id=\${f.u_writer.value}`,		
			dataType : "JSON",				
			type : "post",			
			success : function(d) {	
				if (f.u_writer.value == "") {
					id_check.innerHTML = "";
				} else if (d.userId == "1") {
					id_check.innerHTML = "이미 사용중인 아이디 입니다.";
					id_check.style = "color:red"
				} else if (d.userId == "0") {
					id_check.innerHTML = "사용할수 있는 아이디 입니다.";
					id_check.style = "color:blue"
				}
					
				
			},
			error : function() {	
				alert("error")
			}
		});
	}
</script>
</head>
<body>
	<div>
		<h2>회원 가입</h2>
		<form method="post">
			<table>
				<tbody>
					<tr>
						<th>아이디</th>
						<td>
							<input type="text" name="u_writer" onkeyup="getID(this.form)"> 
							<span id="id_check"></span>
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="u_pw" ></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" name="u_pwr"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="회원가입" onclick="go(this.form)">
							<input type="reset" value="다시 작성"> 
							<input type="button" value="목록으로 이동" onclick="location.href = '/myPro/UserCon'">
							<input type="hidden" name="cmd" value="join">
						</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="u_power" value="admin">
		</form>
	</div>
</body>
</html>