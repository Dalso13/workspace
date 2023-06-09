<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div{
		width: 800px;
		margin: auto;
		text-align: center;
	}
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
	function writeGuestbook(f) {
		if (f.writer.value == "" || f.title.value == "" || f.content.value == "") {
			alert("입력하세요");
			return;
		}
		f.submit();
	}
</script>
</head>
<body>
	<div>
		<h2>방명록 작성</h2>
		<form action="write.jsp" method="post" enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<th>작성자 </th>
						<td> <input type="text" name="writer" size="80"> </td>
					</tr>
					<tr>
						<th>제목 </th>
						<td> <input type="text" name="title" size="80"> </td>
					</tr>
					<tr>
						<th>이메일 </th>
						<td> <input type="text" name="email" size="80"> </td>
					</tr>
					<tr>
						<th>비밀번호 </th>
						<td> <input type="password" name="pw" size="80"> </td>
					</tr>
					<tr>
						<th>첨부파일 </th>
						<td> <input type="file" name="filename"> </td>
					</tr>
					<tr>
						<th>내용 </th>
						<td> <textarea rows="10" cols="80" name="content"></textarea> </td>
					</tr>
					<tr>
						<td colspan="2">
						 	<input type="button" value="방명록 저장" onclick="writeGuestbook(this.form)">
						 	<input type="reset" value="다시 작성">
						 	<input type="button" value="목록으로 이동" onclick="location.href='index.jsp'">
						</td>
					</tr>
				</tbody>
			</table>
		
		</form>
	</div>
</body>
</html>