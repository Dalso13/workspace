<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" href="../../../resources/css/main.css">
</head>
<body>
    <div id="body">
        <span id="join"> <button>로그인</button>  <button>회원가입</button>  <button id="adminGo">관리자 페이지 (임시)</button>
        <button id="requestGo">건의사항 페이지 (임시)</button> </span><br>
       <img src="../../../resources/image/logo.jpg"  id="logo"/>
            <div id="sch">
                <input type="text" name="search" placeholder="알고싶은 나라"
                       autocomplete="off"  id="searchBar">
                <div id="res">
                </div>
                <input type="button" style="display: none" id="btn">
                <label for="btn">
                    <img src="../../../resources/image/search.png" id="search">
                </label>
            </div>

        <img src="../../../resources/image/world.png" width="800px" />
    </div>
    <script !src="">const countrys = ${country};</script>
    <script src="../../../resources/js/main.js"></script>
    <script src="../../../resources/js/searchEngine.js"></script>
</body>
</html>