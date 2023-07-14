package org.joonzis.mapper;

import java.util.List;

import org.joonzis.domain.ReplyVO;

public interface ReplyMapper {
	public int insert(ReplyVO vo);
	public List<ReplyVO> getList(long bno);
	public ReplyVO read(long rno);
	public int delete(long rno);
	public int update(ReplyVO vo);
	public void deleteAll(long bno);
}
