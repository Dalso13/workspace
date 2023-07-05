package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.ReplyVO;
import org.joonzis.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	ReplyMapper mapper;
	
	@Override
	public List<ReplyVO> getListSer(long bno) {
		
		return mapper.getList(bno);
	}
	@Override
	public int insertSer(ReplyVO vo) {
		
		return mapper.insert(vo);
	}
	@Override
	public ReplyVO readSer(long rno) {
		
		return mapper.read(rno);
	}
	@Override
	public boolean deleteSer(long rno) {
		
		return mapper.delete(rno) > 0;
	}
	@Override
	public boolean updateSer(ReplyVO vo) {
	
		return mapper.update(vo) > 0;
	}
}
