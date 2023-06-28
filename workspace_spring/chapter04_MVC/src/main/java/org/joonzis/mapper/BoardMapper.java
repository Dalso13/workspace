package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.BoardVO;

public interface BoardMapper {
	// 메퍼.xml이랑은 메소드명으로 매치
	public List<BoardVO> getList();
	public void insert(BoardVO vo);
	public BoardVO read(int bno);
	public int delete(int bno);
	public int update(BoardVO vo);
	
}
