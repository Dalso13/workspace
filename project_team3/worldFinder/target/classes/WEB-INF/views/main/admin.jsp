<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            width: 160px;
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
                                <th>신고된 게시글 본문</th>
                                <th>신고 사유</th>
                                <th>신고 날짜</th>
                                <th>신고 당한 횟수</th>
                                <th>신고 삭제</th>
                            </tr>
                        </thead>
                        <tbody id="userReportTbody">
                            <tr>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div id="commentReport">
                    <table>
                        <thead>
                        <tr>
                            <th>신고된 댓글 본문</th>
                            <th>신고 사유</th>
                            <th>신고 날짜</th>
                            <th>신고 당한 횟수</th>
                            <th>신고 삭제</th>
                        </tr>
                        </thead>
                        <tbody id="commentTbody">
                            <tr>
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
                            <c:choose>
                                <c:when test="${empty request}">
                                    <tr>
                                        <td colspan="5">
                                            건의 사항이 없습니다.
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="req" items="${request}">
                                        <tr>
                                            <td>${req.rq_category}</td>
                                            <td>${req.rq_name}</td>
                                            <td>${req.rq_address}</td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${empty req.rq_tel}">
                                                        없음
                                                    </c:when>
                                                    <c:otherwise>
                                                        ${req.rq_tel}
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                            <td>
                                                <c:choose>
                                                    <c:when test="${empty value.rq_url}">
                                                        없음
                                                    </c:when>
                                                    <c:otherwise>
                                                        ${value.rq_url}
                                                    </c:otherwise>
                                                </c:choose>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
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
                        reportAjax("유저");
                        userReport.style.display = "block";
                    } else if (this.dataset.menu === "request") {
                        request.style.display = "block";
                    } else if (this.dataset.report == "comment"){
                        reportAjax("comment");
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


        function reportAjax(a) {
            $.ajax({
                url: "/adminPage/getReport/"+a ,
                dataType : "json",
                type : "post",
                success : function (datas) {
                    console.log(datas)
                    if (datas.length == 0){
                        reportTbody.html(emptyValue);
                        commentTbody.html(emptyValue);
                    } else {
                        userReportTable(datas, a)
                    }
                },
            })
        }

        const reportTbody = $("#userReportTbody");
        const commentTbody = $("#commentTbody");
        const emptyValue = "<tr> <td colspan='5'> 신고된 항목이 없습니다 </td> </tr>";

        function userReportTable(datas, a) {

            let texts = "";

            datas.forEach(d , () => {
                    texts += `<tr>`;
                    texts += `<td> <a>본문 보기</a> </td>
                    <td> <a>신고 사유</a> </td>
                    <td> <a>신고 당한 날짜</a> </td>
                    <td> \${d.r_count} </td>
                    <td> <a>X</a> </td>
                    </tr>`;

            })

            if (a == "유저"){
                reportTbody.html(emptyValue)
            } else if (a == "comment") {
                commentTbody.html(emptyValue)
            }

        }
    </script>
</body>
</html>