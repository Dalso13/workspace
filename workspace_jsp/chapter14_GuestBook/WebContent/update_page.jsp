<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	function update(f) {
		if (f.pw.value != "${vo.pw}") {
			alert("비밀번호 가 일치하지 않습니다");
			return;
		}
		
		if (f.title.value == "" || f.content.value == "") {
			alert("작성하셈");
			return;
		}
		
		f.action = "update.jsp"
		f.submit();
	}
</script>
</head>
<body>
	<div>
		<h2>${vo.writer }의 방명록</h2>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<th> 아이디 </th>
						<td>${vo.writer}</td>
					</tr>
					<tr>
						<th> 비밀번호 확인 </th>
						 <td> <input type="password" name="pw"> </td>
					</tr>
					<tr>
						<th> 제목 </th>
						<td> <input type="text" name="title" value=" ${vo.title }"> </td>
					</tr>
					<tr>
						<th> 이메일 </th>
						<td> <input type="text" name="email" value="${vo.email } "> </td>
					</tr>
					<tr>
						<th>첨부파일 </th>
						<td><input type="file" name="filename">  기존에 선택한 파일 : ${vo.filename } </td>
						
					</tr>
					<tr>
						<th> 내용 </th>
						<td> <textarea rows="10" cols="80" name="content">${vo.content }</textarea>  </td>
					</tr>
					<tr>
						<td colspan="2"> 
							<input type="button" value="수정 완료" onclick="update(this.form)"> 
							<input type="reset" value="다시 작성"> 
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		
	</div>
</body>
</html>
