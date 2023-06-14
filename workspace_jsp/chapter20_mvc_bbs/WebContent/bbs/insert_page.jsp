<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../CSS/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function insert(f) {
		if (f.writer.value == "" || f.title.value == "" || f.pw.value == "" || f.content.value == "") {
			alert("입력하세요");
			return;
		}
		f.action="/chapter20_mvc_bbs/BBSController?cmd=insert";
		f.submit();
	}
</script>
</head>
<body>
	<div>
		<h2>BBS 게시글 작성</h2>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<th>작성자</th>
						<td><input type="text"name="writer" value="${mid}" readonly size="80"></td>
					</tr>
					<tr>
						<th>제목</th>
						<td><input type="text" name="title" size="80"></td>
					</tr>
					<tr>
						<th>비밀번호</th>
						<td><input type="password" name="pw" size="80"></td>
					</tr>
					<tr>
						<th>첨부파일</th>
						<td><input type="file" name="filename"></td>
					</tr>
					<tr>
						<th>내용</th>
						<td><textarea rows="10" cols="80" name="content"></textarea></td>
					</tr>
					<tr>
						<td colspan="2">
							<input type="button" value="게시글 저장" onclick="insert(this.form)"> 
							<input type="reset" value="다시 작성"> 
							<input type="button" value="목록으로 이동" onclick="">
						</td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>