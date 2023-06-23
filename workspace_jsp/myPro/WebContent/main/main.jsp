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
	function view(a) {
		$.ajax({
			url : `/myPro/AjaxCon?cmd=view&cmd2=\${a}`,		
			dataType : "JSON",	
			type : "post",			
			success : function(d) {
				$("#view").html("");
				
				if (d.length == 0) {
					$("#view").html("<tr><td>게시글이 없습니다</td></tr>");
				} else {
					$("#view").html("<tr> <th>카테고리 </th> <th>제목 </th> <th>조회수 </th> </tr>	");
					let semi_cartegory = "";
					let title = "";
					let hit = "";
					d.forEach(function(d2) {
						$("#view").append("<tr class='commentS'>");
						semi_cartegory =  "<td>"+d2.semi_cartegory+"</td>"
						title = "<td>"+ "<a onclick='titleGo(this)' class='titleg'>"+ d2.title+ "</a>"+ "</td>"
						hit = "<td>"+d2.hit+"</td>"
						$("#view").append(semi_cartegory);
						$("#view").append(title);
						$("#view").append(hit);
						$("#view").append("</tr>");
					}) 
				}
				
				
			},
			error : function() {	
			}
		});
	}
</script>
</head>
<body>
	<ul id="side">
		<li><a onclick="sideBtn(this)">아시아</a>
			<ul class="semi_side">
				<li> <a class="semi_cartegory"> 북아시아 </a></li>
				<li><a class="semi_cartegory"> 동아시아 </a></li>
				<li><a class="semi_cartegory"> 동남아시아 </a> </li>
				<li><a class="semi_cartegory"> 중앙아시아 </a> </li>
				<li><a class="semi_cartegory"> 남아시아 </a> </li>
				<li><a class="semi_cartegory"> 서아시아 </a> </li>
			</ul>
		</li>
		<li>
			<a onclick="sideBtn(this)"> 아메리카 </a>
			<ul class="semi_side">
				<li> <a class="semi_cartegory"> 북미 </a></li>
				<li><a class="semi_cartegory"> 남미 </a></li>
			</ul>	
		</li>
		<li>
			<a onclick="sideBtn(this)"> 오세아니아 </a>
			<ul class="semi_side">
				<li> <a class="semi_cartegory"> 오스트랄라시아 </a></li>
				<li><a class="semi_cartegory"> 폴리네시아 </a></li>
			</ul>	
		</li>
		<li>
			<a onclick="sideBtn(this)"> 유럽 </a>
			<ul class="semi_side">
				<li> <a class="semi_cartegory"> 서부유럽 </a></li>
				<li><a class="semi_cartegory"> 북부유럽 </a></li>
				<li><a class="semi_cartegory"> 남부유럽 </a> </li>
				<li><a class="semi_cartegory"> 동부유럽 </a> </li>
			</ul>
		</li>
			<li>
			<a onclick="sideBtn(this)"> 아프리카 </a>
			<ul class="semi_side">
				<li> <a class="semi_cartegory"> 북아프리카 </a></li>
				<li><a class="semi_cartegory"> 서아프리카 </a></li>
				<li><a class="semi_cartegory"> 중앙아프리카 </a> </li>
				<li><a class="semi_cartegory"> 동아프리카 </a> </li>
				<li><a class="semi_cartegory"> 남아프리카 </a> </li>
			</ul>
		</li>
	</ul>
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
		<br> <br>
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
		
		<div id="right_side">
			<h3>테마 게시글들</h3>
			<div>
				<button onclick="view('hit')">조회수 순</button>
				<button onclick="view('today')">오늘 생성된 게시글</button>
				<button onclick="view('rec')">오늘의 추천 게시글</button>
			</div>
			<table id="view">
				
			</table>
		</div>
	</div>
	
</body>
</html>