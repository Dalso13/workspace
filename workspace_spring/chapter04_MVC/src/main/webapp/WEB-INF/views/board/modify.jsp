<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시글 수정-삭제 화면</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">게시글 수정 삭제</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form action="/board/modify" method="post" role="form">
					<div class="form-group">
						<label>글번호</label>
						<input class="form-control" name="bno" value="${vo.bno }" readonly="readonly">
					</div>
					<div class="form-group">
						<label>글번호</label>
						<input class="form-control" name="title" value="${vo.title}">
					</div>
					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="3" name="content">${vo.content }</textarea>
					</div>
					<div class="form-group">
						<label>작성자</label>
						<input class="form-control" name="writer" value="${vo.writer }" readonly="readonly">
					</div>
					<button  data-oper="modify" class="btn btn-primary">글 수정</button>
 					<button  data-oper="remove" class="btn btn-warning">글 삭제</button>
 					<button  data-oper="list" class="btn btn-danger">목록으로</button>
				</form>
			</div>
			<!-- /.panel-body -->
		</div>
		<!-- /.panel -->
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<script type="text/javascript">
	$(function() {
		
		const formObj = $("form");
		
		$("button").click(function(e) {
			e.preventDefault();
			
			let operation = $(this).data("oper");
			
			if (operation == 'remove') {
				formObj.attr('action','/board/remove')
			} else if (operation == 'list'){
				formObj.attr('action','/board/list')
				formObj.attr('method','get')
			}
			formObj.submit();
		})
	})
</script>


<%@include file="../include/footer.jsp" %>