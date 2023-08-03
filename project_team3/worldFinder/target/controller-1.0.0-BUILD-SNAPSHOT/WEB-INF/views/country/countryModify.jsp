<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <style>
    #details_continent, #county{
      display: none;
    }
    #realImage{
      border: 1px solid black;
      border-radius : 5px;
      padding: 3px 5px;
      background-color: #f0f0f0;
    }
    #imgBody{
      margin-top: 20px;
      height: 100px;
    }
    #content{
      padding: 10px;
      outline: none;
      border: 2px solid gray;
      border-radius: 5px;
      width: 100%;
      height: 100%;
    }
    #preview_image
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <link rel="stylesheet" href="../../../resources/css/base.css">
</head>
<body>
<%@include file="../include/logoSerach.jsp"%>
<div id="body">
  <h1>${countryPage.country}게시글 수정</h1>
  <div id="imgBody">
    <label for="input_image" id="realImage">대표 이미지 선택</label> <br>
    <span id="oldImg"></span>
    <img style="width: 100px; margin-top: 10px" id="preview_image">
    <input type="file" name="emage" accept="image/*" id="input_image" style="display: none" >
  </div>
  <hr>
  <div>
    <div><div class="editor-menu">
      <button id="btn-bold">
        <b>글씨 굵게</b>
      </button>
    </div></div>
    <hr>
    <div id="content" contenteditable="true">${countryPage.content} </div>
  </div>
  <button id="update">수정하기</button> <button id="delete">삭제하기</button>
</div>
<form action="/country/modify/{${countryPage.country}}" style="display: none" method="post" id="realForm">

</form>
<script>

  // 이미지 보여주기 처리
  function readImage(input) {
    if(input.files && input.files[0]) {
      const reader = new FileReader()
      reader.onload = e => {
        const previewImage = document.getElementById("preview_image")
        previewImage.src = e.target.result
      }
      reader.readAsDataURL(input.files[0])
    }
  }

  const inputImage = document.getElementById("input_image");
  inputImage.addEventListener("change", e => {
    document.getElementById("oldImg").innerHTML = "";
    readImage(e.target)
  })

  const sub = document.getElementById("sub");

  sub.addEventListener("click", () =>{
    imageForm();
  })

  function imageForm() {
     if (content.innerHTML == ""){
      alert("내용을 작성해주세요")
      content.focus()

      return;
    }


    let formdata = new FormData();
    let inputFile = inputImage;

    let files = inputFile.files;

    for (let i = 0; i < files.length; i++) {
      formdata.append('uploadFile' , files[i])
    }

    $.ajax({
      type : 'post',
      url : '/country/imgAjax',
      data : formdata ,
      dataType: "JSON",
      contentType : false ,
      processData : false ,
      success : function (r) {
        writePage(r.c_img)
      }
    });

    function writePage(img) {
      let realForm = document.getElementById("realForm");

      realForm.innerHTML += `<input type="text" name="c_img" value="\${img}" >`;
      realForm.innerHTML += `<input type="text" name="content" value="\${content.innerHTML}" >`;
      realForm.innerHTML += `<input type="text" name="country" value="\${country.value}" >`;

      realForm.submit();
    }
  }
</script>
<script>

  // 특정 영역 글씨 굵게만드는 이벤트 만들기
  const content = document.getElementById('content');
  const bold = document.getElementById('btn-bold');

  bold.addEventListener('click', function () {
    setStyle('bold');
  });

  // 포커스 해주기
  function focusContent() {
    content.focus({preventScroll: true});
  }

  function setStyle(style) {
    document.execCommand(style);
    focusContent();
  }
</script>
<script !src="">
  const imgEncodeUrl = '${countryPage.c_img}';

  document.getElementById("oldImg").innerHTML =
          `<img src="/country/viewImg?filename=\${encodeURIComponent(imgEncodeUrl)}" width="100px" style="margin-top: 10px">`;

</script>
</body>
</html>
