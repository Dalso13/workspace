<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시글</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">게시글</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="form-group">
					<label>글번호</label> <input class="form-control" name="bno"
						value="${vo.bno }" readonly="readonly">
				</div>
				<div class="form-group">
					<label>글번호</label> <input class="form-control" name="title"
						value="${vo.title}" readonly="readonly">
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea class="form-control" rows="3" name="content"
						readonly="readonly">${vo.content }</textarea>
				</div>
				<div class="form-group">
					<label>작성자</label> 
					<input class="form-control" name="writer" value="${vo.writer }" readonly="readonly">
				</div>
				<button  data-oper="modify" class="btn btn-primary">수정</button>
				<button  data-oper="list" class="btn btn-danger">목록으로</button>

				<form action="/board/modify" method="get" id="operForm">
					<input type="hidden" name="bno" id="bno" value="${vo.bno }">
					<input type="hidden" name="pageNum" value="${cri.pageNum }">
					<input type="hidden" name="amount" value="${cri.amount }">
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class = 'row'>
   <div class = "col-lg-12">
      <!-- /.panel -->
      <div class = "panel panel-default">
         <div class= "panel-heading">
            <i class = "fa fa-comments fa-fw"></i> 댓글
            <button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">댓글 달기</button>
         </div>
         <!-- /.panel-heading -->
         <div class = "panel-body">
            <ul class = "chat">
               <!-- start reply -->
               <li class = "left clearfix" data-rno = '12'>
                  <div>
                     <div class = "header">
                        <strong class = "primary-font">user00</strong>
                        <small class = "pull-right text-muted">2018-01-01 13:13</small>                        
                     </div>
                     <p>Good job!</p>
                  </div>
               </li>
               <!-- end reply -->
            </ul>
            <!-- ./ end ul -->
         </div>
         <!-- /.panel .chat-panel -->
      </div>
   </div>
   <!-- ./end row -->
</div>

<!-- Modal -->
<div class="modal fade" id = "MyModal" tabindex = "-1" role = "dialog"
   aria-labelledby = "myModalLabel" aria-hidden = "true">
   <div class = "modal-dialog">
      <div class = "modal-content">
         <div class = "modal-header">
            <button type = "button" class = "close" data-dismiss = "modal" ari-hidden = "true">&times;</button>
            <h4 class = "modal-title" id = "myModalLabel">새 게시글 등록</h4>
         </div>
         <div class = "modal-body">
            <div class = "form-group">
               <label>댓글</label>
               <input class = "form-control" name = 'reply' value = 'New Reply!!!!'>
            </div>
            <div class = "form-group">
               <label>작성자</label>
               <input class = "form-control" name = 'replyer' value = 'replyer'>
            </div>
            <div class = "form-group">
               <label>등록 날짜</label>
               <input class = "form-control" name = 'replyDate' value = '' >
            </div>
         </div>
         <div class = "modal-footer">
            <button id = 'modalModBtn' type = "button" class = "btn btn-warning">수정</button>
            <button id = 'modalRemoveBtn' type = "button" class = "btn btn-danger">삭제</button>
            <button id = 'modalRegisterBtn' type = "button" class = "btn btn-primary">등록</button>
            <button id = 'modalCloseBtn' type = "button" class = "btn btn-default">취소</button>
         </div>
      </div>
   </div>
</div>

<script type="text/javascript">
	$(function() {
		const operForm = $("#operForm");
		
		$("button[data-oper='modify']").click(function() {
			operForm.submit();
		})
		
		// 목록 화면 이동 버튼 클릭시 bno 값 없이 이동 --> 기존 내부 input 태그 삭제후 이동
		$("button[data-oper='list']").click(function() {
			operForm.find("#bno").remove();	
			operForm.attr('action', '/board/list');
			operForm.submit();
		})
		
	});
	
</script>
<script type="text/javascript">
	console.log('Reply Module...');
	
	let replyService = (function(){
			function add(reply, callback, error) {
	    		console.log('add reply...')
	      
	      			$.ajax({
							type : 'post',
							url : '/replies/new',
							data : JSON.stringify(reply),
							contentType : 'application/json; charset=utf-8',
							success : function (result, status, xhr) {
								if(callback) {
									callback(result);
								}
								console.log(error);
							},
							error : function(xhr, status, er) {
								if(error){
									error(er);
								}
							}
						});
	    	}
	
		 	return {add : add};
	
	
	
	})();
	console.log("=======================");
	console.log("js test")
	
	let bnoValue = '${vo.bno}';
	
	replyService.add({reply:"JS TEST" , replyer:"tester" , bno : bnoValue}, 
			function(result){
				alert("result : " + result )
	});
</script>

<%@include file="../include/footer.jsp" %>