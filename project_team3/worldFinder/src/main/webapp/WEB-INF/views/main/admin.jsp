<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" href="../../../resources/css/base.css">
    <style>
        #menu {
            width: 80%;
            margin: auto;
            margin-top: 10px;
            background-color: #81fff2;
            text-align: center;
            padding-top: 5px;
            padding-bottom: 5px;
        }
        #menu span{
            cursor: pointer;
        }
        table{
            margin:auto;
            margin-top: 20px;
        }
        #commentReport th , #userReport th{
            width: 200px;
        }
        thead {
            border-bottom: 1px solid black;
        }
        #request th{
            width: 160px;
        }
        #request,#commentReport,#userReport{
            display: none;
        }
    </style>
</head>
<body>
    <div id="body">
        <%@include file="../include/logo.jsp"%>
        <div id="menu">
            <span style="border-right: 1px solid black" data-menu="report" data-report="userPost">게시글 신고 내용</span>
            <span style="border-right: 1px solid black" data-menu="report" data-report="comment">댓글 신고 내용</span>
            <span data-menu="request">건의 사항</span>
        </div>
        <div id="main">
            <div id="userPost">
                <div id="userReport">
                    <table>
                        <thead>
                            <tr>
                                <th>게시글 제목</th>
                                <th>신고 사유</th>
                                <th>신고 날짜</th>
                                <th>신고 삭제</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>테스트</td>
                                <td>테스트</td>
                                <td>테스트</td>
                                <td>테스트</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div id="commentReport">
                    <table>
                        <thead>
                        <tr>
                            <th>댓글 제목</th>
                            <th>신고 사유</th>
                            <th>신고 날짜</th>
                            <th>신고 삭제</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>테스트</td>
                            <td>테스트</td>
                            <td>테스트</td>
                            <td>테스트</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div id="request">
                    <table>
                        <thead>
                        <tr>
                            <th>유형</th>
                            <th>장소명</th>
                            <th>주소</th>
                            <th>전화 번호</th>
                            <th>URL</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>테스트</td>
                            <td>테스트</td>
                            <td>테스트</td>
                            <td>테스트</td>
                            <td>테스트</td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <script !src="">
        const menu = document.querySelector("#menu").getElementsByTagName("span");
        const userReport = document.getElementById("userReport");
        const commentReport = document.getElementById("commentReport");
        const request = document.getElementById("request");

        // 제이쿼리 말고도 자바스크립트로 구현

        [].forEach.call(menu, function(e){
            e.onclick = function () {
                if (userReport.style.display === "block" &&
                    this.dataset.report === "userPost") {
                    userReport.style.display = "none";

                } else if (request.style.display === "block" &&
                    this.dataset.menu === "request") {
                    request.style.display = "none";

                } else if (commentReport.style.display === "block" &&
                    this.dataset.report === "comment") {

                    commentReport.style.display = "none";
                } else {

                    if ( userReport.style.display == "block"){
                        userReport.style.display = "none";
                    } else if (request.style.display == "block") {
                        request.style.display = "none";
                    } else if (commentReport.style.display == "block"){
                        commentReport.style.display = "none";
                    }

                    if (this.dataset.report == "userPost"){
                        userReport.style.display = "block";
                    } else if (this.dataset.menu === "request") {
                        request.style.display = "block";
                    } else if (this.dataset.report == "comment"){
                        commentReport.style.display = "block";
                    }

                }

            }
        })

    /*    if ((report.style.display === "block" &&
                this.dataset.report === "userPost" &&
                reportTitle.innerHTML === "게시글 제목") ||
            (report.style.display === "block" &&
                this.dataset.report === "comment" &&
                reportTitle.innerHTML === "댓글 제목")) {

            report.style.display = "none";

        }*/

    </script>
</body>
</html>