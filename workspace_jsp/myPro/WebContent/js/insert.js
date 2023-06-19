	function insert(f){
	
		if(f.title.value == ""){
		   /*f.title.parentNode.innerHTML += "제목을 작성하세요";*/
			f.title.focus()
			return;
		}
		
		if(f.cart.value == ""){
		   f.cart.focus()
			return;
		}
		if(f.semi_cart.value == ""){
		   f.semi_cart.focus()
			return;
		}
		
		f.action = '/myPro/TableCon?cmd=insert';
		f.submit();	
	}

		let cart = document.querySelector("#cart");
		let semi = document.querySelector("#semi_cart");

		cart.addEventListener("click", function(){
			if (cart.value != ""){
				semi.style = "display : inline";
			} else {
				semi.style = "display : none";
			}
		});
		
		cart.addEventListener("change" , ()=> {
			country(cart.value, semi)
		});
		
		
		
		
		
		
				
		function readImage(input) {
		    // 인풋 태그에 파일이 있는 경우
		    if(input.files && input.files[0]) {
		        // 이미지 파일인지 검사 (생략)
		        // FileReader 인스턴스 생성
		        const reader = new FileReader()
		        // 이미지가 로드가 된 경우
		        reader.onload = e => {
		            const previewImage = document.getElementById("preview-image")
		            previewImage.src = e.target.result
		        }
		        // reader가 이미지 읽도록 하기
		        reader.readAsDataURL(input.files[0])
		    }
		}
		// input file에 change 이벤트 부여
		const inputImage = document.getElementById("input-image")
		inputImage.addEventListener("change", e => {
		    readImage(e.target)
		})
	
	
	
	
	
	
	 function country(a , semi){
		switch(a){
			case "아시아" :
				semi.innerHTML = `
				<option value="북아시아">북아시아</option>
				<option value="동아시아">동아시아</option> 
				<option value="동남아시아">동남아시아</option> 
				<option value="중앙아시아">중앙아시아</option> 
				<option value="남아시아">남아시아</option> 
				<option value="서아시아">서아시아</option>`;
			break;
			case "아메리카" :
				semi.innerHTML = `
				<option value="북미">북미</option> 
				<option value="남미">남미</option> 
				`;
			break;
			case "오세아니아" :
				semi.innerHTML = `
				<option value="오스트랄라시아">오스트랄라시아</option> 
				<option value="폴리네시아">폴리네시아</option>
				`;
			break;
			case "유럽" :
				semi.innerHTML = `
				<option value="서부유럽">서부 유럽</option>
				<option value="북부유럽">북부 유럽</option> 
				<option value="남부유럽">남부 유럽</option> 
				<option value="동부유럽">동부 유럽</option> 
				`;
			break;
			case "아프리카" :
				semi.innerHTML = `
				<option value="북아프리카">북아프리카</option>
				<option value="서아프리카">서아프리카</option> 
				<option value="중앙아프리카">중앙아프리카</option> 
				<option value="동아프리카">동아프리카</option> 
				<option value="남아프리카">남아프리카</option> 
				`;
			break;
			
		}	
	}
	
		