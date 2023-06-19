<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

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
					<td>
						<img id="ur" src="http://localhost:8080/myPro/image/${tvo.emage }">
					</td>
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
					<td><input type="button" value="수정하기" onclick=""> 
						<input type="button" value="삭제하기"></td>
				</tr>
			</tfoot>
		</table>
	</div>
</body>
</html>