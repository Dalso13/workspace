<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
		
		function buton() {
			document.getElementById("btn").style.display = 'block';
		}
		
		function update(f) {
				if(document.getElementById("title_match").innerText != ""){
					f.title.focus()
					return;
				}
				
				if(f.title.value == ""){
				   /*f.title.parentNode.innerHTML += "제목을 작성하세요";*/
					f.title.focus()
					return;
				}
				
				f.action = '/myPro/TableCon?cmd=update';
				f.submit();	
		}
</script>
</head>
<body>
	<form method="post" enctype="multipart/form-data">
		<div>
			<table>
				<thead>
					<tr>
						<td>작성자 :  ${tvo.t_writer }</td>
					</tr>
					<tr>
						<td> 
							<input type="text" name="title" value="${tvo.title }" onblur="evnT(this)" > 
							<span id="title_match" style="color: red"></span> 
						</td>
						<td>카테고리 : ${tvo.cartegory } => ${tvo.semi_cartegory }</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:if test="${not empty tvo.emage }">
							<td>
								<img id="ur" src="http://localhost:8080/myPro/image/${tvo.emage }" width="150px">
								<input type="hidden" name="emage" value="${tvo.emage }">
							</td>
						</c:if>
					</tr>
					<tr>
						<td>서론 : <input type="text" name="first_c_title" value="${tvo.first_c_title}"> </td>
					</tr>
					<tr>
						<td>  <textarea rows="8" cols="10" name="first_c">${tvo.first_c}</textarea> </td>
					</tr>
					<tr>
						<td>본론 :  <input type="text" name="second_c_title" value="${tvo.second_c_title}"> </td>
					</tr>
					<tr>
						<td>  <textarea rows="8" cols="10" name="second_c">${tvo.second_c}</textarea>  </td>
					</tr>
					<tr>
						<td>결론 :  <input type="text" name="third_c_title" value="${tvo.third_c_title}"> </td>
					</tr>
					<tr>
						<td>  <textarea rows="8" cols="10" name="third_c">${tvo.third_c}</textarea> </td>
					</tr>
					<tr>
						<td> <button type="button" onclick="buton()"> 사진 추가</button> </td>
					</tr>
					<tr id="btn" style="display: none">
						<td> <div><label for="input-image"> 이미지 선택</label></div></td>
		
						<td>  <img style="width: 100px;" id="preview-image"></td>
						<td>
							<input type="file" name="next_emage" accept="image/*"id="input-image" style="display: none">
						</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td>${tvo.my_date}</td>
						<td>${tvo.hit}</td>
					</tr>
					<tr>
						<td><input type="button" value="수정하기" onclick="update(this.form)"> 
							<input type="button" value="게시글로 가기" onclick="history.back()"></td>
					</tr>
				</tfoot>
			</table>
			<input type="hidden" name="t_idx" value="${tvo.t_idx }">
		</div>
	</form>
<script type="text/javascript">
function evnT(s){
	
	if (s.value == "") {
		return;
	}
	if (s.value == `${tvo.title }`) {
		return;
	}
	$.ajax({
		url : "/myPro/AjaxCon",		
		dataType : "JSON",
		data : {"title":`\${s.value}`,"cmd":"title_match"},
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

	function readImage(input) {
	    if(input.files && input.files[0]) {
	   
	        const reader = new FileReader()
	      
	        reader.onload = e => {
	            const previewImage = document.getElementById("preview-image")
	            previewImage.src = e.target.result
	        }
	        
	        reader.readAsDataURL(input.files[0])
	    }
	}
	const inputImage = document.getElementById("input-image")
	inputImage.addEventListener("change", e => {
	    readImage(e.target)
	})
</script>
</body>
</html>