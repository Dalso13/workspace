<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
   h1{
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
	
	function update_page(f) {
		f.cmd2.value = 'update';
		f.action = "/chapter20_mvc_bbs/BBSController"
		f.submit();
	}
	function remove_page(f) {
		f.cmd2.value = 'remove';
		f.action = "/chapter20_mvc_bbs/BBSController"
		f.submit();
	}
	function view_all(f) {
		f.action = "/chapter20_mvc_bbs/BBSController?cmd=allList"
		f.submit();
	}
	function insert_comment(f) {
		if (f.writer.value == '') {
			alert("작성자를 입력하세요.")
			return;
		}
		f.action = '/chapter20_mvc_bbs/CommentController';
		f.submit();
	}
	function remove(a,b,c) {
		location.href = `/chapter20_mvc_bbs/CommentController?b_idx=\${a}&currentPage=\${b }&c_idx=\${c }&cmd=removeComment`;
		
		/* location.href = "/chapter20_mvc_bbs/CommentController?b_idx="+a+"&currentPage="+b+"&c_idx="+c+"&cmd=removeComment"; */
	}
</script>
</head>
<body>
	<div>
		<h1>${bvo.b_idx }번 게시글</h1>
		<form method="post">
			<table>
				<tbody>
					<tr>
						<th>작성자 </th>
						<td>${bvo.writer } </td>
						<th> IP </th>
						<td>${bvo.ip } </td>
					</tr>
					<tr>
						<th> 제목 </th>
						<td>${bvo.title } </td>
					</tr>
					<tr>
						<th> 첨부파일 </th>
						<td colspan="3">
							<c:choose>
								<c:when test="${empty bvo.filename }">
									첨부파일 없음 
								</c:when>
								<c:otherwise>
									<a href="bbs/download.jsp?path=upload&filename=${bvo.filename }"> ${bvo.filename } </a>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th> 내용 </th>
						<td colspan="3">${bvo.content } </td>
					</tr>
					<tr>
						<td colspan="4" id="btn"> 
							<input type="button" value="게시판 수정" onclick="update_page(this.form)"> 
							<input type="button" value="게시판 삭제" onclick="remove_page(this.form)"> 
							<input type="button" value="목록으로 이동" onclick="view_all(this.form)"> 
							<input type="hidden" name="currentPage" value="${param.currentPage}">
							<input type="hidden" name="cmd" value="view">
							<input type="hidden" name="cmd2" value="">
							<input type="hidden" name="comment" value="yes" id="comment">
							<input type="hidden" name="b_idx" value="${bvo.b_idx }" >
						</td>
					</tr>
				</tbody>
			</table>
		</form>
		<br> <hr> <br>
		<!-- 댓글 입력 폼  -->
		<form action="post">
			<table>
				<tbody>
					<tr>
						<th>댓글 작성자 </th>
						<td> <input type="text" name="writer"> </td >
						<th>댓글 비밀번호 </th>
						<td> <input type="password" name="pw"> </td >
					</tr>
					<tr>
						<th>댓글 내용 </th>
						<td colspan="3">
							<textarea rows="3" cols="80" name="content"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4" id="btn2"> 
							<input type="button" value="댓글 등록" onclick="insert_comment(this.form)">  
							<input type="reset" value="다시 작성"> 
						</td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="b_idx" value="${bvo.b_idx }">
			<input type="hidden" name="cmd" value="insertComment">
			<input type="hidden" name="currentPage" value="${param.currentPage}">
		</form>
		<br> <hr> <br>
	<!-- 댓글 창 -->
		<form method="post">
			<table>
				<tbody>
					<tr>
						<th id="num">번호 </th>
						<th id="writer">작성자 </th>
						<th id="con">내용 </th>
						<th id="date">날짜 </th>
						<th id="del">삭제 </th>
					</tr>
					<c:choose>
						<c:when test="${empty cvo }">
							<script type="text/javascript">
								document.querySelector("#comment").value = "";
							</script>
							<tr>
								<td colspan="5">댓글이 없습니다</td>
							</tr>
						</c:when>
						<c:otherwise>
							<c:forEach var="cvo" items="${cvo }">
								<tr>
									<td>${cvo.c_idx }</td>
									<td>${cvo.writer }</td>
									<td>${cvo.content }</td>
									<td>${cvo.reg_date }</td>
									<td><input type="button" value="x"
										onclick=" remove(${bvo.b_idx },${param.currentPage },${cvo.c_idx })">
									</td>
								</tr>
							</c:forEach>
						</c:otherwise>
					</c:choose>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>