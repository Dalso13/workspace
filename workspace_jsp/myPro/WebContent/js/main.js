	
	function insert(){
		location.href = '/myPro/TableCon?cmd=insert_page';
	}

	function move(a){
		location.href = '/myPro/UserCon?cmd='+a;
	}
	
	function find(f){
		if(f.search.value == ""){
			alert("검색할 나라를 입력해주세요")
			return;
		}
		f.action = '/myPro/TableCon';
		f.submit();
	}
	function clickSpan(s){
		location.href = `/myPro/TableCon?cmd=select&title=${s.innerText}`;
	}
	function sideBtn(d){
		let s = d.nextSibling;
		let a = s.nextSibling;
		if(a.style.display == "block") {
			a.style.display = 'none';
		} else {
			a.style.display = 'block';
		}
	}
	let semiCart = document.querySelectorAll(".semi_cartegory");
	
	semiCart.forEach((cart) => {
		cart.addEventListener("click", function(){
			location.href = `/myPro/TableCon?cmd=cart_table&semi_cartegory=${cart.innerText}`;
		});
	})
	function titleGo(s){
		location.href = `/myPro/TableCon?cmd=cart_table&semi_cartegory=${s.innerText}`;
	}
		
