<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<style type="text/css">
	#semi_cart {
		display: none;
	}
	#writer {
		display: inline;
		width : 50px;
		border: 0px;
		background-color: none;
	}
	label{
		border: 1px solid black;
		border-radius : 5px;
		padding: 3px;
		padding-left: 5px;
		padding-right: 5px;
		background-color: #f0f0f0;
	}
	.write{
		padding: 10px;
		width : 100%;
	}
</style>
</head>
<body>
	<div>
		<form method="post" enctype="multipart/form-data">
			<table>
				<thead>
					<tr>
						<td> 작성자 : <input type="text" name="t_writer" value="${uvo.u_writer }" id="writer" readonly="readonly" ></td>
					</tr>
					<tr>
						<td > 
							<input type="text" name="title" placeholder="타이틀" id="titles" onblur="evnTitle(this)"> 
							<span id="title_match" st> </span>
						</td>
						
						<td>
							<select id="cart" name="cartegory"> 
								<option value=""> 카테고리 </option>
								<option value="아시아">아시아</option>
								<option value="아메리카">아메리카</option>
								<option value="오세아니아">오세아니아</option>
								<option value="유럽">유럽</option>
								<option value="아프리카">아프리카</option>
							</select>
							<select id="semi_cart" name="semi_cartegory">
							
							</select>
						</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>서론 : <input type="text" name="first_c_title"> </td>
					</tr>
					<tr> <td> <textarea rows="8" cols="50" class="write" name="first_c"></textarea> </td> </tr>
					<tr>
						<td>본론 : <input type="text" name="second_c_title"> </td>
					</tr>
					<tr> <td> <textarea rows="8" cols="50" class="write" name="second_c"></textarea> </td> </tr>
					<tr>
						<td>결론 : <input type="text" name="third_c_title"> </td>
					</tr>
					<tr> <td> <textarea rows="8" cols="50" class="write" name="third_c"></textarea> </td> </tr>
				</tbody>
				<tfoot>
					<tr>
						<td>
							<label for="input-image"> 이미지 선택</label>
					    </td>
				    </tr>
					<tr>
						<td> <img style="width: 100px;" id="preview-image"> </td>
						<td> <input type="file" name="emage" accept="image/*" id="input-image" style="display: none"> </td>
					</tr>
					<tr>
						<td> <input type="button" value="작성하기" onclick="insert(this.form)">
							 <input type="reset" value="다시 작성"> </td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
	<script type="text/javascript" src="/myPro/js/insert.js"></script>
	<script type="text/javascript">
		function evnTitle(s){
			if (s.value == "") {
				return;
			}
			
			$.ajax({
				url : "/myPro/AjaxCon",		
				dataType : "JSON",
				data : {"title":"\${s.value}","cmd":"title_match"},
				type : "post",			
				success : function(d) {
					if (d == 1) {
						
						$("#title_match").html("제목이 이미 사용중입니다.");
					} else {
						$("#title_match").html("");
					}

				},
				error : function() {
					alert("a")
				}
			});
			
		}
	
	</script>
</body>
</html>