<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./CSS/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function join(f) {
		if (f.mpw.value != f.mpwR.value) {
			alert("비밀번호가 일치하지 않습니다.")
			return;
		}
		f.action = "/chapter20_mvc_bbs/MemberController";
		f.submit();
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
						<td style="text-align: left; padding-left: 45px;">
							<input type="text" name="mid" size="40" id="mid">
						</td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="mpw" size="80"></td>
					</tr>
					<tr>
						<th>비밀번호 확인</th>
						<td><input type="password" name="mpwR" size="80"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="mname" size="80"></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><input type="tel" name="mtel" size="80"></td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type="number" name="mage" size="80"></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="회원가입" onclick="join(this.form)"> 
							<input type="reset" value="다시 작성"> 
							<input type="button" value="목록으로 이동" onclick="/chapter20_mvc_bbs/BBSController">
							<input type="hidden" name="cmd" value="join">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>

</body>
</html>