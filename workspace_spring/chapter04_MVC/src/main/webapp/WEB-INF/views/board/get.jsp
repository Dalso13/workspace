<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../include/header.jsp" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
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
				
				<!-- 댓글 권한에 따라 막아두기 -->
				<sec:authentication property="principal" var="pinfo"/>
				<sec:authorize access="isAuthenticated()">
					<c:if test="${pinfo.username eq  vo.writer }">
						<button  data-oper="modify" class="btn btn-primary">수정</button>	
					</c:if>		
				</sec:authorize>
				
				
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
            	<sec:authorize access="isAuthenticated()">				
		            <button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">댓글 달기</button>
				</sec:authorize>
         </div>
         <!-- /.panel-heading -->
         <div class = "panel-body">
            <ul class = "chat">
               <!-- start reply -->
               
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
              	 <input class = "form-control" name = 'replyer' value = "ss" >
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

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">첨부된 파일</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<div class="panel-body">
					<div class='uploadResult'>
						<ul></ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>

<script type="text/javascript">
	$(function() {
		let uli = $(".uploadResult ul");
		
		// ajax 로 파일 목록 받아오기
		// 받아온 리스트를 반복하여 동적 태그 생성 후 uploadResult ul 내부에 저장
		
		$.ajax({
			type : "get",
			url : '/board/getAttachList',
			data : {bno : '${vo.bno }'},
			contentType : 'application/json; charset=utf-8',   
			dataType : "JSON",
			success : function(r, stats) {
				
				console.log(r)
				
				showUploadFile(r);
			}
		})
		
		function showUploadFile(result) {
			
			let texts = "";
			
			result.forEach(r => {
				let fileCallPath = encodeURIComponent(r.uploadPath+"/"+r.uuid + "_" + r.fileName);
				
				console.log()
				
				texts += "<li> <a href='"+"/download?fileName="+fileCallPath+"' >";
				texts += `<img src="/resources/img/KakaoTalk_20230707_153525040.png" style="width:15px">
					\${r.fileName}
					</a> </li>`
			})
			
			uli.html(texts);
		}
	});
</script>
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
	
	// 시간 데이터 처리 함수  24시간이 지난 댓글은 날짜만 표기
	console.log("Reply Module...");
	function displayTime(timeValue){
	   var today = new Date();
	   var gap = today.getTime() - timeValue;
	   var dateObj = new Date(timeValue);
	   var str = "";
	   
	   if(gap < (1000 * 60 * 60 * 24)){
	      var hh = dateObj.getHours();
	      var mi = dateObj.getMinutes();
	      var ss = dateObj.getSeconds();
	      return [(hh>9 ? '' : '0') + hh, ':', (mi > 9 ? '' : '0') + mi, ':', (ss > 9 ? '' : '0') + ss].join('');
	   }else{
	      var yy = dateObj.getFullYear();
	      var mm = dateObj.getMonth() + 1; // getMonth() is zero-based
	      var dd = dateObj.getDate();
	      return [yy, '/', (mm > 9 ? '' : '0')+mm, '/', (dd > 9 ? '' : '0') + dd].join('');
	   }
	}
	
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
		 	
			function getList(p, cb) {
				console.log('get List...')
					$.ajax({
						type : 'get',
						url : `/replies/pages/\${p.bno}/\${p.page}`,
						dataType : "JSON",
						success : function (result, status, xhr) {
							if(cb) {
								cb(result);
							}
							
						},
						error : function(xhr, status, er) {
							
						}
					});
			}
			function get(p, cb) {
				console.log('get ...')
			      
					$.ajax({
						type : 'get',
						url : `/replies/\${p}`,
						dataType : "JSON",
						success : function (result, status, xhr) {
							if(cb) {
								cb(result);
							}
							
						},
						error : function(xhr, status, er) {
							
						}
					});
			}
			
			function remove(p, cb) {
				console.log('remove ...')
			      
					$.ajax({
						type : 'delete',
						url : `/replies/\${p}`,
						dataType : "text",
						success : function (result, status, xhr) {
							if(cb) {
								cb(result);
							}
							
						},
						error : function(xhr, status, er) {
							
						}
					});
			}
			function update(p, cb) {
				console.log('remove ...')
			      
					$.ajax({
						type : 'put',
						url : `/replies/\${p.rno}`,
						dataType : "text",
						data : JSON.stringify(p),
						contentType : 'application/json; charset=utf-8',
						success : function (result, status, xhr) {
							cb(result);
							
						},
						error : function(xhr, status, er) {
							
						}
					});
			}
			
			return {
				add : add,
				getList : getList,
				get : get,
				remove : remove,
				update : update
			}

	})();
	
	
	

</script>

<script type="text/javascript">
	console.log("=======================");
	console.log("js test")
	
	let bnoValue = '${vo.bno}';
	
	
	
	
	
	$(function() {
		showList();
	})
	
/* 	<div>
                     <div class = "header">
                        <strong class = "primary-font">user00</strong>
                        <small class = "pull-right text-muted">2018-01-01 13:13</small>                        
                     </div>
                     <p>Good job!</p>
                  </div>
 */
	
 	// 댓글 조회 이벤트
 	function showList() {
		replyService.getList({ bno : bnoValue , page : 1} , function(list) {
			console.log("showList")
			console.log(list.length)
			
			let result = "";
			
			if (list.length < 1) {
				$(".chat").html(`<li class = "left clearfix"> <div> 내용이 없습니다 </div> </li>`);
				
			} else {
				list.forEach(lists => {	
					let sss = lists.replydate;
					
					
					result += `<li class = "left clearfix" data-rno = \${lists.rno}>`;
					result += `<div> <div class = "header"> <strong class = "primary-font">\${lists.replyer}</strong> `;
					result += ` <small class = "pull-right text-muted">\${displayTime(sss)}</small> `;
					result += ` </div> <p>\${lists.reply}</p> </div> </li> `;
				});
				$(".chat").html(result);
				
			}
		}); 	
	}  
	
 
 	// 댓글 달기 버튼 클릭 이벤트
 	const modal = $(".modal");
 	const modalInputReply = modal.find("input[name='reply']");	// 댓글내용
 	const modalInputReplyer = modal.find("input[name='replyer']");	// 댓글 작성자
 	const modalInputReplydate = modal.find("input[name='replyDate']");	// 댓글 날짜
 	
 	const modalModBtn = $("#modalModBtn");				//수정
 	const modalRemoveBtn = $("#modalRemoveBtn");		//삭제
 	const modalRegisterBtn = $("#modalRegisterBtn");	//등록
 	const modalCloseBtn = $("#modalCloseBtn");			//취소 버튼
 	
 	$("#addReplyBtn").on('click', function() {
 		modal.find("input").val("");
 		modalInputReplydate.closest('div').hide();
 		modalModBtn.hide();
 		modalRemoveBtn.hide();
 		modalRegisterBtn.show();
 		modalInputReplyer.attr('readonly', false);
 		modal.modal('show');	//모달 창 보이기
 		
 		
	})
 
 	// 댓글 입력 버튼 클릭 이벤트
 	modalRegisterBtn.on('click', function() {
 		
 		
 		
 		replyService.add({reply:modalInputReply.val() , replyer:modalInputReplyer.val() , bno : bnoValue}, 
 				function(result){
 				alert(result)
 				modal.modal('hide');
 				showList();
 		}); 
	});
 
 	// 취소 버튼 클릭시 
 	modalCloseBtn.click(function() {
 		modal.modal('hide');
	})
 
 	// chat 클래스 (ul) 내의 li 객체 클릭 이벤트
 	// 클릭이 되면 눌려진 객체 (this) 가 가지고 있는 rno를 통해서 get 함수 호출
 	// 데이터 가져온 뒤 모달 창에 내용 출력
 		// 클릭한 li에 값
 		let s = "";
 		
 		$(".chat").on('click', 'li' ,function(){
			s = this.getAttribute("data-rno");
			
			replyService.get( s , function(result) {
			 
				modalInputReply.val(result.reply);
				modalInputReplyer.val(result.replyer);
				modalInputReplydate.val(displayTime(result.replydate))
				
				
				modalInputReplydate.closest('div').show();
		 		modalModBtn.show();
		 		modalRemoveBtn.show();
		 		modalRegisterBtn.hide();
				
		 		modalInputReplyer.attr('readonly', true);
		 		modalInputReplydate.attr('readonly', true);
		 		
		 		
		 		
				modal.modal('show'); 
			});
		})
		
		// 삭제
		modalRemoveBtn.on('click', function() {
			replyService.remove( s , function(result) {
				alert(result)
 				modal.modal('hide');
 				showList();
			}); 
		})
		
		// 수정
		modalModBtn.on('click', function() {
			replyService.update( {reply: modalInputReply.val() , rno: s} , function(result) {
				alert(result)
 				modal.modal('hide');
 				showList();
			}); 
		})
	
	
	
	
	
	
/* 	replyService.getList({ bno : bnoValue , page : 1}, function(result) {
		console.log(result)
	}); 
	replyService.get( 1 , function(result) {
		console.log(result)
	});
	
	 replyService.add({reply:"JS TEST" , replyer:"tester" , bno : bnoValue}, 
			function(result){
				alert("result : " + result )
	}); 
	
 	replyService.remove( 5 , function(result) {
		console.log(result)
	}); 
	
	replyService.update({ rno : 1 , reply:"JS TEST UPDATE"}, function(result) {
		console.log(result)
	}); */

</script>

<%@include file="../include/footer.jsp" %>