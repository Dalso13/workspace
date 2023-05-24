<%@page import="org.joonzis.ex.GreenDao"%>
<%@page import="org.joonzis.ex.GreenDto"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");

	GreenDto dto = GreenDao.getInstance().getOneList(id,pw);

	pageContext.setAttribute("dto", dto);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function update(f) {
		if (f.pw.value == '' || f.name.value == '' || f.age.value == '' || f.addr.value == '') {
			alert("수정할 내용을 입력해 주세요");
			return;
		}
		f.action = "update.jsp"
		f.submit();
	}
</script>
</head>
<body>
	<jsp:include page="index.jsp"/>
	
	 <br> <hr> <br>
	
		
	<h1> ${dto.id } 님의 데이터</h1>
	<form method="post">
		<table>
			<thead>
				<tr>
					<th>회원 번호 </th>
					<th>아이디 </th>
					<th>비밀번호 </th>
					<th>이름 </th>
					<th>나이 </th>
					<th>주소 </th>
					<th>가입일 </th>
				</tr>
			</thead>
			<c:choose>
				<c:when test="${empty  dto }">
					<tbody>
						<tr>
							<td colspan="7"> ${id  } 님에 정보가 없습니다. </td>
						</tr>
					</tbody>
				</c:when>
				<c:otherwise>
					<tbody>
						<tr>
							<td>
								${dto.idx }
								<input type="hidden" name="idx" value="${dto.idx }">
							</td>
							<td>
								${dto.id }
								<input type="hidden" name="id" value="${dto.id }">
							</td>
							<td><input type="password" name="pw" value="${dto.pw }"></td>
							<td><input type="text" name="name" value="${dto.name }"></td>
							<td><input type="number" name="age" value="${dto.age }"></td>
							<td><input type="text" name="addr" value="${dto.addr }"></td>
							<td>
								${dto.reg_date }
								<input type="hidden" name="reg_date" value="${dto.reg_date }">
							</td>
						</tr>
					</tbody>
					<tfoot>
						<tr>
							<th colspan="7">
								<input type="button" value="수정" onclick="update(this.form)">&nbsp;&nbsp;
								<input type="reset" value="다시 작성">
							</th>
						</tr>
					</tfoot>
				</c:otherwise>
			</c:choose>
		</table>
	</form>
</body>
</html>