<%--
  Created by IntelliJ IDEA.
  User: goott1
  Date: 2023-07-31
  Time: 오후 12:14
  To change this template use File | Settings | File Templates.
--%>
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

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" href="../../../resources/css/base.css">
</head>
<body>
<%@include file="../include/logoSerach.jsp"%>
<div id="body">
    <h1>나라 작성</h1>
    <div> 나라 이름
        <select id="continent">
            <option value="">대륙 선택</option>
        </select>
        <select id="details_continent"></select>
        <select id="county"></select>
    </div>
    <div id="imgBody">
        <label for="input-image" id="realImage">대표 이미지 선택</label> <br>
        <img style="width: 100px; margin-top: 10px" id="preview-image">
        <input type="file" name="emage" accept="image/*" id="input-image" style="display: none" >
    </div>
    <hr>


    <div>
        <div><div class="editor-menu">
            <button id="btn-bold">
                <b>B</b>
            </button>
            <button id="btn-italic">
                <i>I</i>
            </button>
            <button id="btn-underline">
                <u>U</u>
            </button>
            <button id="btn-strike">
                <s>S</s>
            </button>
            <button id="btn-ordered-list">
                OL
            </button>
            <button id="btn-unordered-list">
                UL
            </button>
            <button id="btn-image">
                IMG
            </button>
        </div></div>
        <hr>
        <div id="content" contenteditable="true"></div>
    </div>
</div>
<script>
    let set = new Set();

    const conts = ${cont};

    for (const cont of conts) {
        set.add(cont.continent);
    }

    const continent = document.getElementById("continent");
    const  details_continent = document.getElementById("details_continent");
    const country = document.getElementById("county");

    for (const c of set) {
        continent.innerHTML += `<option value="\${c}">\${c}</option>`
    }

    continent.onchange = function () {
        details_continent.innerHTML = '<option value="">세부 대륙 선택</option>';
        if (this.value == ""){
            details_continent.style.display = "none";
        } else {
            details_continent.style.display = "inline-block";
            details_select(this.value);
        }
    }

    function details_select(num) {
        for (const cont of conts) {
            if (cont.continent == num){
                details_continent.innerHTML += `<option value="\${cont.details_continent}">\${cont.details_continent}</option>;`
            }
        }
    }

    details_continent.addEventListener("change", () =>{
        country.innerHTML = '<option value="">나라 선택</option>';
        if (this.value == ""){
            country.style.display = "none";
        } else {
            country.style.display = "inline-block";
            $.ajax({
                url : `/countryWrite/countryList/\${details_continent.value}`  ,
                dataType : "json",
                type : "post",
                success : function (countrys) {
                    console.log(countrys)
                    for (const result of countrys) {
                        country.innerHTML += `<option value="\${result.COUNTRY}">\${result.COUNTRY}</option>`;
                    }

                }
            })
        }
    })

    // 이미지 보여주기 처리
    function readImage(input) {
        if(input.files && input.files[0]) {
            const reader = new FileReader()
            reader.onload = e => {
                const previewImage = document.getElementById("preview-image")
                previewImage.src = e.target.result
            }
            reader.readAsDataURL(input.files[0])
        }
    }

    const inputImage = document.getElementById("input-image")
    inputImage.addEventListener("change", e => {
        readImage(e.target)
    })

    document.getElementById("head").addEventListener("click", () =>{
        document.getElementById("content").innerHTML += "<h1>";
    })

</script>
<script>
    const editor = document.getElementById('editor');
    const btnBold = document.getElementById('btn-bold');
    const btnItalic = document.getElementById('btn-italic');
    const btnUnderline = document.getElementById('btn-underline');
    const btnStrike = document.getElementById('btn-strike');
    const btnOrderedList = document.getElementById('btn-ordered-list');
    const btnUnorderedList = document.getElementById('btn-unordered-list');

    btnBold.addEventListener('click', function () {
        setStyle('bold');
    });

    btnItalic.addEventListener('click', function () {
        setStyle('italic');
    });

    btnUnderline.addEventListener('click', function () {
        setStyle('underline');
    });

    btnStrike.addEventListener('click', function () {
        setStyle('strikeThrough')
    });

    btnOrderedList.addEventListener('click', function () {
        setStyle('insertOrderedList');
    });

    btnUnorderedList.addEventListener('click', function () {
        setStyle('insertUnorderedList');
    });

    function setStyle(style) {
        document.execCommand(style);
        focusEditor();
    }

    // 버튼 클릭 시 에디터가 포커스를 잃기 때문에 다시 에디터에 포커스를 해줌
    function focusEditor() {
        editor.focus({preventScroll: true});
    }

</script>
</body>
</html>
