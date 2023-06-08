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
	function remove() {
		let pw = document.querySelector("input[type='password']");
		if (pw.value != '${bvo.pw}') {
			alert("비밀번호를 정확히 입력해주세요")
			return;
		}
		
		location.href = 'remove.jsp';
	}
</script>
</head>
<body>
	<div>
		<h1>${bvo.b_idx } 번 게시글 삭제</h1>
		<table>
			<tbody>
				<tr> 
					<th>작성자 </th>
					<td>${bvo.writer} </td>
				</tr>
				<tr> 
					<th>제목 </th>
					<td>${bvo.title} </td>
				</tr>
				<tr> 
					<th>비밀번호 확인 </th>
					<td> <input type="password" name="pw" size="80"> </td>
				</tr>
				<tr> 
					<td colspan="2">
						<input type="button" value="게시글 삭제" onclick="remove()">
						<input type="reset" value="다시 작성">
						<input type="button" value="게시글로 이동" onclick="history.back()">
					</td>
				</tr>
				
			</tbody>
		</table>
	</div>
</body>
</html>