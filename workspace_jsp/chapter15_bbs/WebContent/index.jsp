<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="org_joonzis.model.Paging"%>
<%@page import="org.joonzis.ex.BVO"%>
<%@page import="java.util.List"%>
<%@page import="org.joonzis.ex.BDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	// 1. paging 객체 생성
	Paging pvo = new Paging();
	
	// 2. 전체 게시글의 개수 구하기
	
	pvo.setTotalRecord(BDao.getTotalRecord());

	
	// 3. 전체 페이지 수 구하기
	pvo.setTotalPage();
	
	// 4. 현재 페이지 번호 구하기
	String currentPage = request.getParameter("currentPage");
	if(currentPage != null && !currentPage.isEmpty()){
		pvo.setNowPage(Integer.parseInt(currentPage));
	}
	
	// 5. 현재 페이지 번호에 따른 begin, end 구하기
	pvo.setBegin((pvo.getNowPage()-1) * pvo.getRecordPerPage() + 1);
	pvo.setEnd(pvo.getBegin() + pvo.getRecordPerPage() -1);
	
	// -------------------- begin, end 사이의 게시글을 DB에서 가져오기
	// 1. begin, end 변수 저장
	int begin = pvo.getBegin();
	int end = pvo.getEnd();
	
	// 2. beigin, end를 저장하는 Map 생성
	Map<String, Integer> map = new HashMap<>();
	map.put("begin", begin);
	map.put("end", end);
	
	
	// ------------- 페이징 처리를 위한 block 계산
	// 1. beginBlock, endBlock 계산
	pvo.setBeginBlock( (pvo.getNowPage()-1)  /
		pvo.getPagePerBlock() * pvo.getPagePerBlock() + 1 );
	pvo.setEndBlock(pvo.getBeginBlock() + pvo.getPagePerBlock() - 1);
	
	// 2. endBlcok 조정하기
	if(pvo.getEndBlock() > pvo.getTotalPage()){
		pvo.setEndBlock(pvo.getTotalPage());
	}
	
	// 3. 화면에서 페이징을 사용할 수 있도록 객체에 저장
	pageContext.setAttribute("pvo", pvo);
	
	
	// 4. 게시물이 열린 경우 session에 저장되어야 되는데...
	String open = (String)session.getAttribute("open");
	if(open != null){
		session.removeAttribute("open");
	}
	
	
	
	
	
	List<BVO> bvo  = BDao.getList(map);

	pageContext.setAttribute("bvo", bvo);
%>
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
</style>
<script type="text/javascript">
	onload = function () {
		var btn = document.querySelector("#btn");
		
		btn.addEventListener('click',function(){
			location.href = 'insert_page.jsp';
		});
	}
</script>
</head>
<body>
	<div class="wrap">
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
					<c:when test="${empty bvo }">
						<tr>
							<td colspan="5">게시물이 없습니다 </td>
						</tr>
					</c:when>
					<c:otherwise>
						<c:forEach var="bvo" items="${bvo }">
							<tr>
							 	<c:set var="b_idx" value="${bvo.b_idx }"/>
							 	<td> ${b_idx } </td>
							 	<td> <a href="view.jsp?b_idx=${b_idx }&currentPage=${pvo.nowPage}">${bvo.title }</a>  </td>
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
                              <a class="view" href="index.jsp?currentPage=${pvo.beginBlock - 1 }"> ◀ &nbsp; </a>
                        </c:otherwise>
                     </c:choose>      
                     <%-- 2. 페이지 번호 --%>         
                     <c:forEach var="p" begin="${pvo.beginBlock }" end="${pvo.endBlock }" step="1">
                        <c:choose>
                           <c:when test="${p eq pvo.nowPage }">
                              <span class="now">${p }&nbsp;</span>
                           </c:when>
                           <c:otherwise>
                               <a class="view" href="index.jsp?currentPage=${p}"> ${p }&nbsp;</a>
                           </c:otherwise>
                        </c:choose>   
                     </c:forEach>      
                     <%-- 3. 다음 버튼 --%>                  
                     <c:choose>
                        <c:when test="${pvo.endBlock >= pvo.totalPage  }">
                           <span class ="disable"> &nbsp;▶ </span>
                        </c:when>
                        <c:otherwise>
                           <a class="view" href="index.jsp?currentPage=${pvo.beginBlock + pvo.pagePerBlock }" > &nbsp;▶ </a>
                        </c:otherwise>
                     </c:choose>   
                  </td>
               </tr>
			</tfoot>
		</table>
		<p>
			<button id="btn"> 게시글 작성</button>
		</p>
	</div>
</body>
</html>