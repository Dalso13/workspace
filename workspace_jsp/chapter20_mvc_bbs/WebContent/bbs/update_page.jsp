<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./CSS/main.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	function update(f) {
		
		if (f.title.value == '' || f.content.value == '' ) {
			alert("수정할 내용을 입력해주세요")
			return;
		}
		
		if (f.pw.value != '${bvo.pw}') {
			alert("비밀번호를 정확히 입력해주세요")
			return;
		}
		
		f.action = "/chapter20_mvc_bbs/BBSController?cmd=update";
		f.submit();
	}

</script>
</head>
<body>
	<div>
		<h1>${bvo.b_idx }번 게시글</h1>
		<form method="post" enctype="multipart/form-data">
			<table>
				<tbody>
					<tr>
						<th>작성자 </th>
						<td>${bvo.writer } </td>
					</tr>
					<tr>
						<th> 제목 </th>
						<td> <input type="text" name="title" value="${bvo.title }"></td>
					</tr>
					<tr>
						<th> 비밀번호 확인 </th>
						<td> <input type="password" name="pw"></td>
					</tr>
					<tr>
						<th> 첨부파일 </th>
						<td>
							<input type="file" name="filename">
							<c:choose>
								<c:when test="${empty bvo.filename }">
									[ 기존 첨부파일 : 없음 ]
								</c:when>
								<c:otherwise>
									[ 기존 첨부파일 : ${bvo.filename } ]
									<input type="hidden" name="oldFile" value="${bvo.filename }">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th> 내용 </th>
						<td colspan="3"> <textarea rows="10" cols="80" name="content">${bvo.content }</textarea> </td>
					</tr>
					<tr>
						<td colspan="2" id="btn"> 
							<input type="button" value="수정하기" onclick="update(this.form)">
							<input type="reset" value="다시작성">
							<input type="button" value="게시글로 이동" onclick="history.back()">
						</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="b_idx" value="${bvo.b_idx }">
		</form>
	</div>
</body>
</html>