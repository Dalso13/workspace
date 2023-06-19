<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function login(f) {
		if (f.u_writer.value == '' || f.u_pw.value == '') {
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
</script>
</head>
<body>
	<div>
		<h2>로그인</h2>
		<form method="post">
			<table>
				<tbody>
					<tr>
						<th>아이디</th>
						<td>
							<input type="text" name="u_writer" >
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
							<input type="button" value="로그인" onclick="login(this.form)"> 
							<input type="reset" value="다시 작성"> 
							<input type="button" value="목록으로 이동" onclick="location.href = '/myPro/UserCon'">
							<input type="hidden" name="cmd" value="login">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>