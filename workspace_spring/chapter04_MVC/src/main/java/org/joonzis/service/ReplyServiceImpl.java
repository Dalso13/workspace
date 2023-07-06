package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.ReplyVO;
import org.joonzis.mapper.BoardMapper;
import org.joonzis.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	ReplyMapper mapper;
	
	@Autowired
	BoardMapper bMap;
	
	@Override
	public List<ReplyVO> getListSer(long bno) {
		
		return mapper.getList(bno);
	}
	
	@Transactional
	@Override
	public int insertSer(ReplyVO vo) {
		
		// 댓글 등록
		int result = mapper.insert(vo);
		log.info("clear1");
		
		// 댓글수 업데이트
		bMap.updateReplyCnt(vo.getBno(), 1);
		log.info("clear2");
		return result;
	}
	
	
	@Override
	public ReplyVO readSer(long rno) {
		
		return mapper.read(rno);
	}
	@Transactional
	@Override
	public boolean deleteSer(long rno) {
		
		// 댓글 등록
		ReplyVO vo = readSer(rno);
		
		boolean result = mapper.delete(rno) > 0;
		
		// 댓글수 업데이트
		bMap.updateReplyCnt(vo.getBno(), -1);
		
		return result;
		
		
	}
	@Override
	public boolean updateSer(ReplyVO vo) {
	
		return mapper.update(vo) > 0;
	}
}
