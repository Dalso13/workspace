package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.ReplyVO;

public interface ReplyService {
	public int insertSer(ReplyVO vo);
	public List<ReplyVO> getListSer(long bno);
	public ReplyVO readSer(long rno);
	public boolean deleteSer(long rno);
	public boolean updateSer(ReplyVO vo);
}
