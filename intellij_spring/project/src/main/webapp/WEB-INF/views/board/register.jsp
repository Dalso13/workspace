<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">게시글 등록</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">게시글 등록</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<form action="/board/register" method="post" role="form">
					<div class="form-group">
						<label>제목</label>
						<input class="form-control" name="title">
					</div>
					<div class="form-group">
						<label>내용</label>
						<textarea class="form-control" rows="3" name="content"></textarea>
					</div>
					<div class="form-group">
						<label>작성자</label>
						<input class="form-control" name="writer" value='<sec:authentication property="principal.username"/>' readonly="readonly"> 
					</div>
					<button type="button"  data-oper="register" class="btn btn-primary">등록</button>
 					<button type="reset" class="btn btn-warning">취소</button>
 					<button type="button" data-oper="list" class="btn btn-danger">목록으로</button>
 					<input type="hidden" name="pageNum" value="${cri.pageNum }">
					<input type="hidden" name="amount" value="${cri.amount }">
					 <input type="hidden" name="${_csrf.parameterName}" value="${_csfr.token }">
				</form>
			</div>
			<!-- 첨부파일 -->
			<!-- /.panel-body -->
		</div>
		<div class="row">
			<div class="col-lg-12">
				<div class="panel panel-default">
					<div class="panel-heading">파일 첨부</div>
					<!-- /.panel-heading -->
					<div class="panel-body">
						<div class="panel-body">
							<div class="form-group uploadDiv">
								<input type="file" name='uploadFile' multiple>
							</div>
							<div class='uploadResult'>
								<ul></ul>
							</div>
						</div>
					</div>
				</div>
			</div>
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
			let operation = $(this).data("oper");

			if (operation == 'list') {
				formObj.attr('action', '/board/list')
				
				formObj.attr('method', 'get')
				formObj.find(".form-control").remove();
				formObj.submit();
			} else if (operation == 'register'){
				if ($(".uploadResult ul li")) {
						$(".uploadResult ul li").each(function(i, obj) {
						
						
						let str ='';
						
						
						let jobj = $(obj);
						
						console.log(jobj)
						
						str +=`<input type="hidden" name="attachList[\${i}].fileName" value='\${jobj.data('filename')}' >
								<input type="hidden" name="attachList[\${i}].uuid" value='\${jobj.data('uuid')}'>
								<input type="hidden" name="attachList[\${i}].uploadPath" value=\${jobj.data('path')}>`;
						formObj.append(str);
						
						console.log(formObj[0])
					})
				}
				
				
			 	formObj.submit(); 
				
			}

		})
	})
</script>
<script type="text/javascript">
	$(function() {
		// input=file 변경시 fileInputChage() 함수 실행
		$(".uploadDiv").on('change','input' ,function() {
			fileInputChage();
		})
		
		
		// 파일 삭제 버튼 클릭 이벤트	
			
		
		
		
		
	})
	let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	let maxSize = 5242880; // 약5000kb , 5mb
	let uli = $(".uploadResult").children("ul");
		
	function checkExtenSion(name, size) {
		if (size >= maxSize) {
			alert("크기 초과")
			return false;
		}
			
		if (regex.test(name)) {
			alert("잘못된 파일종류");
			 return false;
		}
		return true;
	}
	
	function fileInputChage() {
		uli.empty();
		let formdate = new FormData();
		let inputFile = $("input[name=uploadFile]");
		let files = inputFile[0].files;
		
		for (var i = 0; i < files.length; i++) {
			if(!checkExtenSion(files[i].name , files[i].size)){
				return false;
			}
			formdate.append('uploadFile' , files[i])
		}
		
		$.ajax({
			type : 'post',
			url : '/uploadAjaxAction',
			data : formdate ,
			dataType : "JSON",
			contentType : false ,
			processData : false ,
			success : function (result) {
				console.log(result);
				$(".uploadDiv").children("input").val(''); 
				
				showUploadFile(result);
			},
			error : function() {
						
			}
		});
		
		function showUploadFile(result) {
			
			let texts = "";
	
			result.forEach(r => {
				let fileCallPath = encodeURIComponent(r.uploadPath+"/"+r.uuid + "_" + r.fileName);
				
				let fileName = encodeURIComponent(r.fileName)
				
				
				texts += "<li data-path='"+ r.uploadPath + "' data-uuid='" + r.uuid  + "' data-filename='" + r.fileName +"' >"; 
				texts += `<div> <img src="/resources/img/KakaoTalk_20230707_153525040.png" style="width:15px" />
						<span> \${r.fileName} </span>
						<button type="button" data-file=\${fileCallPath} data-type="file" 
						class="btn btn-warning btn-circle"> 
						<i class="fa fa-times"></i></button> </div>
						</li>`; 
			})
			
			uli.html(texts);
		}
		
		
		
		
		// 위 span 클릭 이벤트 걸기
		uli.on('click','button', function() {
			 let targetFile = $(this).attr("data-file");
			 let targetLi = $(this).closest("li");
			 
			 
			 $.ajax({
				type : 'post',
				url : '/deleteFile',
				data : {fileName : targetFile} ,
				dataType : "text",
				success : function (result) {
					targetLi.remove();
				}
			}); 	
		});
	} 
</script>

<%@include file="../include/footer.jsp" %>