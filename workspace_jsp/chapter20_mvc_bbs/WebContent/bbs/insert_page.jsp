<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  div {
      width: 800px;
      margin:auto;
   }
   h2{
   	text-align: center;
   }
   
   table {
      width: 800px;
      border-collapse: collapse;   
   }
   
   td, th {
      border : 1px solid #1e90ff;
      padding: 10px;
   }
   th{
  	 background-color: #0078ff;
      color: white;  
      text-align: center; 
   }
   
</style>
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
						<td><input type="text" name="writer" size="80"></td>
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