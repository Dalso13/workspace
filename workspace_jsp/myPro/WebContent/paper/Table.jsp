<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	onload = function() {
		ajaxOut()
	}


	function ajaxIn(f) {
		$.ajax({
			url : "/myPro/AjaxCon",		
			dataType : "text",
			data : $(f).serialize(),
			type : "post",			
			success : function(d) {	
				if (d == "1") {
					ajaxOut(d);
				} else if (d == "0") {
					alert("작성에 실패했습니다")
				}
			},
			error : function() {	
				alert("error")
			}
		});
	}
		
	function ajaxOut() {
		$.ajax({
			url : "/myPro/AjaxCon?cmd=select_comment&t_idx="+${tvo.t_idx},		
			dataType : "JSON",
			type : "post",			
			success : function(d) {	
				
			},
			error : function() {	
				alert("error")
			}
		});
	}

</script>
</head>
<body>
	<div>
		<table>
			<thead>
				<tr>
					<td>작성자 : ${tvo.t_writer }</td>
				</tr>
				<tr>
					<td> <span>${tvo.title }</span> </td>
					<td>카테고리 : ${tvo.cartegory } => ${tvo.semi_cartegory }</td>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>${tvo.title }</td>
				</tr>
				<tr>
					<c:if test="${not empty tvo.emage }">
						<td>
							<img id="ur" src="http://localhost:8080/myPro/image/${tvo.emage }" width="150px">
						</td>
					</c:if>
				</tr>
				<tr>
					<td>서론 : ${tvo.first_c_title}</td>
				</tr>
				<tr>
					<td>${tvo.first_c}</td>
				</tr>
				<tr>
					<td>본론 : ${tvo.second_c_title}</td>
				</tr>
				<tr>
					<td>${tvo.second_c}</td>
				</tr>
				<tr>
					<td>결론 :  ${tvo.third_c_title}</td>
				</tr>
				<tr>
					<td>${tvo.third_c}</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td>${tvo.my_date}</td>
					<td>${tvo.hit}</td>
				</tr>
				<tr>
					<td><input type="button" value="수정하기"> 
						<input type="button" value="삭제하기"></td>
				</tr>
			</tfoot>
		</table>
		
		<form action="">
			<table>
				<thead>
					<tr>
						<th>댓글 작성자</th>
						<c:choose>
							<c:when test="${not empty uvo.u_writer }">
								<td><input type="text" name="c_writer" value="${uvo.u_writer}"
									readonly></td>
								<td><input type="hidden" name="c_pw" value=""></td>
							</c:when>
							<c:otherwise>
								<td><input type="text" name="c_writer"></td>
								<th>댓글 비밀번호</th>
								<td><input type="password" name="c_pw"></td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th>댓글 내용</th>
						<td colspan="3"><textarea rows="3" cols="80" name="content"></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="4" id="btn2">
							<input type="button" value="댓글 등록" onclick="ajaxIn(this.form)" > 
							<input type="reset" value="다시 작성">
							<input type="hidden" name="t_idx" value="${tvo.t_idx}">
							<input type="hidden" name="cmd" value="insert_comment">
						</td>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>