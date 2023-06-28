package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.BoardVO;

public interface BoardSerivce {
	public List<BoardVO> getList();
	public void register(BoardVO vo);
	public BoardVO get(int bno);
	public boolean remove(int bno);
	public boolean modify(BoardVO vo);
}
