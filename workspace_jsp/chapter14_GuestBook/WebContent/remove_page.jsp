<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		width: 100%;
		border-collapse: collapse;
		text-align: left;
	}
	td, th{
	 	border: 1px solid black;
	 	padding: 10px;
	}
	th {
		width: 100px;
		background-color: gray;
		color: white;
		text-align: center;
	}
	tr:nth-of-type(7) {
		text-align: center;
	}
</style>
<script type="text/javascript">
	function remove(f) {
		if (f.pw.value != "${vo.pw }") {
			alert("비밀번호가 틀렸습니다");
			return;
		}
		let sum = confirm("정말 삭제하시겠습니까?")
		
		if (sum) {
			f.submit();
		}
		
	}
</script>
</head>
<body>
	<h2>${vo.writer }의 방명록 삭제 확인</h2>
	<form action="remove.jsp">
		<table>
			<tbody>
				<tr>
					<th>제목 </th>
					<td>${vo.title } </td>
				</tr>
				<tr>
					<th>비밀번호 확인 </th>
					<td> <input type="password" name="pw" size="80"> </td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="방명록 삭제" onclick="remove(this.form)">
						<input type="button" value="목록으로 이동" onclick="location.href = 'index.jsp'">
					</td>
				</tr>
			</tbody>
		</table>
	</form>
</body>
</html>