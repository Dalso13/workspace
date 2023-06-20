	
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
		location.href = `/myPro/TableCon?cmd=select&title=${s.innerText}`
	}
	

		