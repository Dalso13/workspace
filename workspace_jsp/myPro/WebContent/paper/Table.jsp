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
		if (f.c_writer.value == "" ) {
			f.c_writer.focus();
			return;
		}
		if (f.c_pw.value == "" ) {
			f.c_pw.focus();
			return;
		}
		if (f.content.value == "" ) {
			f.content.focus();
			return;
		}
		
		setTimeout(function() {
			 $.ajax({
				url : "/myPro/ChatCon",		
				dataType : "text",
				data : $(f).serialize(),
				type : "post",			
				success : function(d) {	
					if (d == 1) {
						f.c_writer.value = null ;
						f.c_pw.value = null;
						f.content.value = null;
						
						ajaxOut()
						
					} else if (d == 0) {
						alert("작성에 실패했습니다")
					}
				},
				error : function() {	
					alert("error")
				}
			}); 
		} , 1000)
	}	
		

		
	function ajaxOut() {
		$.ajax({
			url : `/myPro/ChatCon?cmd=select_comment&t_idx=${tvo.t_idx}`,		
			dataType : "JSON",
			type : "post",			
			success : function(d) {	
				if (d.c_idx == -1) {
					$("#comme").html("<tr><td>댓글이 없습니다</td></tr>");
				
				} else{
					$("#comme").html("<tr> <th>댓글 작성자 </th> <th>내용 </th> </tr>	");
					let text = "";
					let comment = "";
					let c_idx = "";
					d.forEach(function(d2) {
						$("#comme").append("<tr class='commentS'>");
						text =  "<td>"+d2.c_writer+"</td>"
						comment = "<td>"+d2.comment+"</td>"
						c_idx = `<td> <button onclick="remove(\${d2.c_idx})">X</button> </td> </tr>`
						$("#comme").append(text);
						$("#comme").append(comment);
						$("#comme").append(c_idx);
					}) 
						
					

				}
			},
			error : function() {	
				alert("error")
			}
		});
	}
	
	function remove(a) {
		window.open(`paper/remove_comment.jsp?idx=\${a}` , '본인확인', 'width=700px,height=600px,top=200px,left=500px');
		
	}
	function update_page() {
		location.href = `/myPro/TableCon?cmd=update_page&title=${tvo.title}`;

	}
	function delete_page() {

		$.ajax({
			url : "/myPro/AjaxCon",		
			dataType : "text",
			data : {"t_idx":  `${tvo.t_idx}`, "t_writer" : `${uvo.u_writer}` , "cmd" : "delete_page"},
			type : "post",			
			success : function(d) {	
				if (d == 0) {
					alert("정보가 일치하지 않습니다")
				} else {
					alert("삭제 하였습니다.")
					location.href = "/myPro/TableCon";
				}
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
				<c:if test="${uvo.u_writer eq  tvo.t_writer}">
						<td><input type="button" value="수정하기" onclick="update_page()"> 
							<input type="button" value="삭제하기" onclick="delete_page()"></td>
				</c:if>
					<td> <input type="button" value="목록으로 이동" onclick="location.href = '/myPro/TableCon'"> </td>
				</tr>
			</tfoot>
		</table>
		<br> <hr> <br>
		<form action="">
			<table>
				<thead>
					<tr>
						<th>댓글 작성자</th>
						<c:choose>
							<c:when test="${not empty uvo.u_writer }">
								<td><input type="text" name="c_writer" value="${uvo.u_writer}"
									readonly></td>
								<td><input type="hidden" name="c_pw" value="${uvo.u_pw}"></td>
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
			</table>
		</form>
			<br> <hr> <br>
			<table>
				<tbody id="comme">
					
				</tbody>
			</table>
	</div>
</body>
</html>