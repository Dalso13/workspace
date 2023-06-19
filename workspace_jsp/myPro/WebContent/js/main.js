	
	function insert(){
		location.href = '/myPro/TableCon?cmd=insert_page';
	}

	function move(a){
		location.href = '/myPro/UserCon?cmd='+a;
	}
	
	function search(f){
		f.action = '/myPro/TableCon';
		f.submit();
	}
