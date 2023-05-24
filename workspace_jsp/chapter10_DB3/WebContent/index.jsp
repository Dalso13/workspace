<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
		margin: 0 auto;
		border: 1px solid black;
	}
	thead {
		background-color: gray;
		color: white;
	}
	tfoot{
		background-color: gray;
	}
	td {
		text-align: center;
		padding: 3px;
	}
	th{
		height: 30px;
		padding: 5px;
	}
	input[type=button], input[type=reset] {
		background: gray;
		border: 1px solid white;
		padding: 5px;
		color: white;
	}
	input[type=button]:hover, input[type=reset]:hover {
		background-color: white;
		color: gray;
		font-weight: bold;
		cursor: pointer;
	}
</style>
<script type="text/javascript">
	function view_all() {
		location.href = "view_all.jsp";
	}
	
	function insert_one(f) {
		// 모든 데이터 삽입 후 전송
		if (f.id.value == '' || f.pw.value == '' || f.name.value == '' || f.age.value == '' || f.addr.value == '') {
			alert("모두 입력해주세요");
			
			return;
		}
		
		
		f.action  = "insert.jsp";
		f.submit();
	}
	function remove_one(f) {
		// id & pw 확인 - 삭제
		if (f.id.value == '' && f.pw.value == ''){
			alert("id 또는 pw를 입력해주세요");
			
			return;
		}
		
		f.action  = "remove.jsp";
		
		f.submit();
	}
	function update_one(f) {
		if (f.id.value == '' || f.pw.value == ''){
			alert("id 와 pw를 입력해주세요");
			
			return;
		}
		
		f.action  = "update_page.jsp";
		
		f.submit();
	}
	function view_one(f) {
		// 해당 id 정보 - 데이터 한 개
		if (f.id.value == '' || f.pw.value == ''){
			alert("id 와 pw를 입력해주세요");
			
			return;
		}
		
		f.action  = "view_one.jsp";
		f.submit();
	}
</script>
</head>
<body>
	<form method="post">
		<table>
			<thead>
				<tr>
					<th colspan="2">회원 정보 관리 </th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>아이디 </td>
					<td> <input type="text" name="id"></td>
				</tr>
				<tr>
					<td>비밀번호 </td>
					<td> <input type="password" name="pw"></td>
				</tr>
				<tr>
					<td>이름 </td>
					<td> <input type="text" name="name"></td>
				</tr>
				<tr>
					<td>나이 </td>
					<td> <input type="number" name="age"></td>
				</tr>
				<tr>
					<td>주소 </td>
					<td> <input type="text" name="addr"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<th colspan="2">
						<input type="button" value="전체보기" onclick="view_all()">&nbsp;&nbsp;
						<input type="button" value="검색" onclick="view_one(this.form)">&nbsp;&nbsp;
						<input type="button" value="삽입" onclick="insert_one(this.form)">&nbsp;&nbsp;
						<input type="button" value="삭제" onclick="remove_one(this.form)">&nbsp;&nbsp;
						<input type="button" value="수정" onclick="update_one(this.form)">&nbsp;&nbsp;
						<input type="reset" value="다시 작성">
					</th>
				</tr>
			</tfoot>
		</table>
	</form>
</body>
</html>