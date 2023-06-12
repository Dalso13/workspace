<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	div {
		width: 800px;
		text-align: center;
		margin: auto;
	}
	table {
		width: 100%;
		border-collapse: collapse;
	}
	th, td {
		border: 1px solid gray;
	}
	th {
		padding: 5px;
		background-color: gray;
		color: white;
	}
</style>
</head>
<body>
	<div>
		<h1>부서별 직원 목록</h1>
		
		<table>
			<thead>
				<tr>
					<th>직원ID </th>
					<th>성명 </th>
					<th>연락처 </th>
					<th>연봉 </th>
					<th>부서ID </th>
					<th>고용일 </th>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty result }">
						<tr> <td>장버기 없습니다.</td> </tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="vo" items="${result }">
							<tr>
								<td>${vo.employee_id }</td>
								<td>${vo.first_name }${vo.last_name }</td>
								<td>${vo.phone_number }</td>
								<td>${vo.salary }만원</td>
								<td>${vo.department_id }</td>
								<td>
									<fmt:formatDate value="${vo.hire_date }" pattern="yyyy년 MM월 dd일 E요일"/>		
								</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>
		
	</div>
</body>
</html>