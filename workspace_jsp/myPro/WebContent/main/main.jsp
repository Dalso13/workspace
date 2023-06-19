<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/myPro/css/main.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="body">
		<h1>동완 위키</h1>
		<c:if test="${not empty u_writer }">
			<button onclick="insert()">글 작성</button>
		</c:if>
		<c:if test="${empty u_writer }">
			<button onclick="move('login_page')">로그인</button>
			<button onclick="move('join_page')">회원 가입</button>
		</c:if>
		<form>
			<div class="search">
			  <input type="text" placeholder="검색어 입력">
			  <input type="button" style="display: none" id="btn" onclick="search(this.form)">
			  <label for="btn">
			 	 <img src="/myPro/image/search.png">		  
			  </label>
			</div>
			<input type="hidden" name="cmd" value="search">
		</form>
	</div>
<script type="text/javascript" src="/myPro/js/main.js"></script>
</body>
</html>