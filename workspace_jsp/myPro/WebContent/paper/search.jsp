<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/myPro/css/table.css" rel="stylesheet" type="text/css">
<script type="text/javascript">
	
</script>
</head>
<body>
	<div>
		<h1>검색 결과</h1>
		<table>
			<tr>
				<th>작성자</th>
				<th>제목</th>
				<th>조회수</th>
				<th>작성 날짜</th>
			</tr>
			<c:choose>
				<c:when test="${empty svo }">
				<tr>
					<td colspan="4">
						검색결과가 없습니다
					</td>
				</tr>
				</c:when>
				<c:otherwise>
					<c:forEach var="vo" items="${svo }">
						<tr>
							<td>${vo.t_writer }</td>
							<td class="ti"> <a href="/myPro/TableCon?cmd=select&title=${vo.title }"> ${vo.title }</a></td>
							<td>${vo.hit }</td>
							<td>${vo.my_date }</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</div>
</body>
</html>