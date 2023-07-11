<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>Upload with Ajax</h1>
	
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple="multiple" >
	</div>
	
	<div class="uploadResult">
		<ul>
		
		</ul>
	</div>
	
	
	
	<button id="uploadBtn">upload</button>
	
	
	<script type="text/javascript">
			let regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			let maxSize = 5242880; // 약5000kb , 5mb
			let cloneObj = $(".uploadDiv input").clone();
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
	
	
			$("#uploadBtn").on('click', function(){
				let formdate = new FormData();
				let inputFile = $("input[name=uploadFile]");
				let files = inputFile[0].files;
				console.log(files);
				
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
						console.log(result)
						$(".uploadDiv").html(cloneObj);
						
						showUploadFile(result);
					},
					error : function() {
								
					}
				});	
			});
		
			function showUploadFile(result) {
				
				let texts = "";
				
				result.forEach(r => {
					let fileCallPath = encodeURIComponent(r.uploadPath+"/"+r.uuid + "_" + r.fileName);
					
					texts += `<li> <a href="/download?fileName=\${fileCallPath}">
						<img src="/resources/img/KakaoTalk_20230707_153525040.png" style="width:15px">
						\${r.fileName}
						</a> <span data-file="\${fileCallPath}.">X</span> </li>`; 
				})
				
				uli.html(texts);
			}
			
			// 위 span 클릭 이벤트 걸기
			uli.on('click','span', function() {
				let targetFile = $(this).attr("data-file");
				$.ajax({
					type : 'post',
					url : '/deleteFile',
					data : {fileName : targetFile} ,
					dataType : "text",
					success : function (result) {
						alert(result);
					},
					error : function() {
								
					}
				});	
			});
	</script>
</body>
</html>