<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  div {
      width: 800px;
      margin:auto;
      text-align: center;   
   }
   
   table {
      width: 800px;
      border-collapse: collapse;   
   }
   
   td, th {
      border : 1px solid #1e90ff;
      padding: 10px;
   }
   
   thead { 
      background-color: #0078ff;
      color: white;   
   }
      
   th:nth-of-type(1) {
      width:50px;
   }
   
   th:nth-of-type(2) {
      width:300px;
   }
   
   th:nth-of-type(3) {
      width:100px;
   }
   
   th:nth-of-type(4) {
      width:100px;
   }   
   
   th:nth-of-type(5) {
      width:50px;
   }   
   
   h1 {
      color : #0078ff;   
   }
   a.view {
      text-decoration: none;
      color : black;
   }
   a.view:hover {
      font-weight:bold;
      color : tomato;
   }
   ul.paging {
      list-style-type: none;
      overflow: hidden;
      margin: auto;
      width:350px;
   }
   ul.paging li {
      float: left;
      margin:20px;
      color: #0078ff;
   
   }
   ul.paging li a{
      font-weight: bold;
      display : block;
      text-decoration: none;
      color:  #0078ff;
   }
   ul.paging a:hover {
       background: #1e90ff;
       color: white;       
   }
   ul.paging li.disable {
      color: silver;
   }
   ul.paging li.now{
      color: tomato;
      font-weight: bold;
   }
   tfoot tr {
      margin: auto;
   }
   .disable {
      color: silver;
   }
   .now{
      color: tomato;
      font-weight: bold;
   }
   #logout{
   		display: none;
   }
   #btn{
   		display: none;
   }
</style>
<script type="text/javascript">
	onload = function () {
		
		var btn = document.querySelector("#btn");
		
		if ("${mid}" != null && "${mid}" != "") {
			document.getElementById("logSet").style = "display : none";
			document.getElementById("logout").style = "display : inline";
			btn.style = "display : inline";;
		}
		
		
		btn.addEventListener('click',function(){
			location.href = '/chapter20_mvc_bbs/BBSController?cmd=insert_page';
		});
		
		
		
	}

</script>
</head>
<body>
	<div class="wrap">
		<div style="text-align: right;"> 
			<button onclick="location.href ='/chapter20_mvc_bbs/MemberController?cmd=loginpage'" id="logSet">로그인</button>
			<button onclick="location.href ='/chapter20_mvc_bbs/MemberController?cmd=logout'" id="logout">로그아웃</button>
			<button onclick="location.href ='/chapter20_mvc_bbs/MemberController?cmd=joinpage'">회원가입</button> 
		</div>
		<h1>BBS 게시판</h1>
		<table>
			<thead>
				<tr>
					<th>번호 </th>
					<th>제목 </th>
					<th>작성자 </th>
					<th>날짜 </th>
					<th>조회수 </th>
				</tr>
			</thead>
			<tbody>
				<!-- 게시물이 없으면 : 게시물이 없습니다 출력 -->
				<c:choose>
					<c:when test="${empty list }">
						<tr>
							<td colspan="5">게시물이 없습니다 </td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="bvo" items="${list }">
							<tr>
							 	<c:set var="b_idx" value="${bvo.b_idx }"/>
							 	<td> ${b_idx } </td>
							 	<td> <a href="/chapter20_mvc_bbs/BBSController?cmd=view&b_idx=${b_idx }&currentPage=${pvo.nowPage}">${bvo.title }</a>  </td>
							 	<td> ${bvo.writer } </td>
							 	<td> ${bvo.reg_date } </td>
							 	<td>${bvo.hit }</td>
							</tr>
						</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
			<tfoot>
				<tr>
                  <td colspan="5">
                     <%-- 페이징 처리예정 --%>      
                     <%-- 1. 이전 버튼 --%>            
                     <c:choose>
                        <c:when test="${pvo.beginBlock <= pvo.pagePerBlock }">
                              <span class ="disable"> ◀ &nbsp; </span>
                        </c:when>
                        <c:otherwise>
                              <a class="view" href="/chapter20_mvc_bbs/BBSController?cmd=allList&currentPage=${pvo.beginBlock - 1 }"> ◀ &nbsp; </a>
                        </c:otherwise>
                     </c:choose>      
                     <%-- 2. 페이지 번호 --%>         
                     <c:forEach var="p" begin="${pvo.beginBlock }" end="${pvo.endBlock }" step="1">
                        <c:choose>
                           <c:when test="${p eq pvo.nowPage }">
                              <span class="now">${p }&nbsp;</span>
                           </c:when>
                           <c:otherwise>
                               <a class="view" href="/chapter20_mvc_bbs/BBSController?cmd=allList&currentPage=${p}"> ${p }&nbsp;</a>
                           </c:otherwise>
                        </c:choose>   
                     </c:forEach>      
                     <%-- 3. 다음 버튼 --%>                  
                     <c:choose>
                        <c:when test="${pvo.endBlock >= pvo.totalPage  }">
                           <span class ="disable"> &nbsp;▶ </span>
                        </c:when>
                        <c:otherwise>
                           <a class="view" href="/chapter20_mvc_bbs/BBSController?cmd=allList&currentPage=${pvo.beginBlock + pvo.pagePerBlock }" > &nbsp;▶ </a>
                        </c:otherwise>
                     </c:choose>   
                  </td>
               </tr>
	             
			</tfoot>
			
		</table>
	</div>
	<div>
		<p>
			<button id="btn"> 게시글 작성</button>	
		</p>
	</div>
</body>
</html>