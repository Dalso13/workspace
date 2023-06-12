package org.joonzis.model;

public class Paging_hit {
	public Paging_hit() {
	}
	public Paging page(int total , String currentPage) {
		// 1. paging 객체 생성
		Paging pvo = new Paging();
		
		// 2. 전체 게시글의 개수 구하기
		
		pvo.setTotalRecord(total);

		
		// 3. 전체 페이지 수 구하기
		pvo.setTotalPage();
		
		// 4. 현재 페이지 번호 구하기
		if(currentPage != null && !currentPage.isEmpty()){
			pvo.setNowPage(Integer.parseInt(currentPage));
		}
		
		// 5. 현재 페이지 번호에 따른 begin, end 구하기
		pvo.setBegin((pvo.getNowPage()-1) * pvo.getRecordPerPage() + 1);
		pvo.setEnd(pvo.getBegin() + pvo.getRecordPerPage() -1);
		
		// -------------------- begin, end 사이의 게시글을 DB에서 가져오기
		
		// ------------- 페이징 처리를 위한 block 계산
		// 1. beginBlock, endBlock 계산
		pvo.setBeginBlock( (pvo.getNowPage()-1)  /
			pvo.getPagePerBlock() * pvo.getPagePerBlock() + 1 );
		pvo.setEndBlock(pvo.getBeginBlock() + pvo.getPagePerBlock() - 1);
		
		// 2. endBlcok 조정하기
		if(pvo.getEndBlock() > pvo.getTotalPage()){
			pvo.setEndBlock(pvo.getTotalPage());
		}
		
		
		return pvo;
	}	
}
