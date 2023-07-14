package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.BoardAttachVO;
import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;

public interface BoardSerivce {
	public List<BoardVO> getList(Criteria cri);
	public int getTotal();
	public void register(BoardVO vo);
	public BoardVO get(int bno);
	public boolean remove(int bno);
	public boolean modify(BoardVO vo);
	public List<BoardAttachVO> getAttachList(long bno);
}
