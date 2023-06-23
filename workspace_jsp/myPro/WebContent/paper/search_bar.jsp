<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
#body{

	 margin-top : 100px;
}
	#sch {
  margin: auto;
  position: relative;
  width: 500px;
}

input {

  width: 100%;
  border: 1px solid #bbb;
  border-radius: 8px;
  padding: 10px 12px;
  font-size: 14px;
}

#im {
	cursor : pointer;
	  position : absolute;
	  width: 17px;
	  top: 10px;
	  right: 12px;
	  margin: 0px;
}
#res{
	text-align : left;
	display : none;
	margin: auto;
 	 position: relative;
	width: 496px;
	padding: 10px 12px;
	 border: 3px solid black;
	 border-top : 0px;
  	border-radius: 8px;
	
}
.clickSpan {
	cursor : pointer;
	display : inline-block;
	width : 100%;
	height: auto;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
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

function find(f){
	if(f.search.value == ""){
		alert("검색할 나라를 입력해주세요")
		return;
	}
	f.action = '/myPro/TableCon';
	f.submit();
}
function clickSpan(s){
	location.href = `/myPro/TableCon?cmd=select&title=\${s.innerText}`;
}
</script>
</head>
<body>
	<div id="body">

		<form>
			<div id="sch">
			  <input type="text" name="search" placeholder="검색어 입력" onkeydown="getJSON(this.form)">
			  <div id="res">
			  </div>
			  <input type="button" style="display: none" id="btn" onclick="find(this.form)">
			  <label for="btn">
			 	 <img id="im" src="/myPro/image/search.png">		  
			  </label>
			</div>
			<input type="hidden" name="cmd" value="find">
		</form>
	</div>
</body>
</html>