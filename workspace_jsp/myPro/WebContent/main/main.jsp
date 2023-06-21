<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/myPro/css/main.css" rel="stylesheet" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	onload = function () {
		let res = document.getElementById("res");
	}
	function getJSON(f) {
		$.ajax({
			url : "/myPro/AjaxCon?cmd=title",		
			dataType : "JSON",	
			type : "post",			
			success : function(d) {
				res.style = "display : inline-block"
				res.innerHTML = "";
				let count = 0;
				let count2 = [];
				for (var i = 0; i < d.length; i++) {
					if (d[i].title.indexOf(f.search.value) != -1) {
						count2.push(i);
					} else if (d[i].title.indexOf(f.search.value) == -1) {
						count++;
					}
				}
				
				if (count == d.length) {
					res.innerHTML = "검색결과가 없습니다";
				} else if (f.search.value == ""){
					res.style = "display : none"
					res.innerHTML = "";
				} else {
					for (var i = 0; i < count2.length; i++) {
						res.innerHTML += `<span class="clickSpan" onclick = "clickSpan(this)">\${d[count2[i]].title} </span> </br>`;
					}
				}
				
			},
			error : function() {	
			}
		});
	}
	function logout(){
		location.href = "/myPro/TableCon?cmd=logout";
	}
</script>
</head>
<body>
<script type="text/javascript" src="/myPro/js/main.js"></script>
	<div id="body">
		<h1>동완 위키</h1>
		<c:if test="${not empty uvo.u_writer }">
			<button onclick="insert()">글 작성</button>
			<button onclick="logout()">로그아웃</button>
		</c:if>
		<c:if test="${empty uvo.u_writer }">
			<button onclick="move('login_page')">로그인</button>
			<button onclick="move('join_page')">회원 가입</button>
		</c:if>
		<form>
			<div id="sch">
			  <input type="text" name="search" placeholder="검색어 입력" onkeydown="getJSON(this.form)">
			  <div id="res">
			  </div>
			  <input type="button" style="display: none" id="btn" onclick="find(this.form)">
			  <label for="btn">
			 	 <img src="/myPro/image/search.png">		  
			  </label>
			</div>
			<input type="hidden" name="cmd" value="find">
		</form>
	</div>
</body>
</html>