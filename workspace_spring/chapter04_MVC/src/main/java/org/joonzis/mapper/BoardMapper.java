package org.joonzis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;

public interface BoardMapper {
	// 메퍼.xml이랑은 메소드명으로 매치
	public List<BoardVO> get(Criteria cri);
	public void insert(BoardVO vo);
	public BoardVO read(int bno);
	public int delete(int bno);
	public int update(BoardVO vo);
	public int getTotalCount();
	public void updateReplyCnt(@Param("bno") long bno, @Param("amount") long amount);
}
