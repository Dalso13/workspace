package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.BoardAttachVO;
import org.joonzis.domain.BoardVO;
import org.joonzis.domain.Criteria;
import org.joonzis.mapper.BoardAttachMapper;
import org.joonzis.mapper.BoardMapper;
import org.joonzis.mapper.ReplyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;


@Log4j
@Service
public class BoardServiceImpl implements BoardSerivce{
	
	@Autowired
	private BoardMapper mapper;
	
	@Autowired
	private BoardAttachMapper attMapper;
	
	@Autowired
	private ReplyMapper replyMapper;
	
	@Override
	public BoardVO get(int bno) {
		log.info("get");
		return mapper.read(bno);
	}
	@Override
	public List<BoardVO> getList(Criteria cri) {
		log.info("getList...");
		
		return mapper.get(cri);
	}
	@Override
	public boolean modify(BoardVO vo) {
	
		return mapper.update(vo) > 0 ? true : false;
	}
	
	@Transactional
	@Override
	public void register(BoardVO vo) {
	
		mapper.insert(vo);
		if (vo.getAttachList() != null && vo.getAttachList().size() > 0) {
			for (BoardAttachVO vos : vo.getAttachList()) {
				vos.setBno(mapper.getBno());
				attMapper.insert(vos);
				
			}
		}
		
	}
	@Transactional
	@Override
	public boolean remove(int bno) {
		
		attMapper.deleteAll(bno);
		replyMapper.deleteAll(bno);
		
		return mapper.delete(bno) > 0;
	}
	
	@Override
	public int getTotal() {
		return mapper.getTotalCount();
	}
	
	@Override
	public List<BoardAttachVO> getAttachList(long bno) {
		log.info("getAttachList : " + bno);
		return attMapper.findByBno(bno);
	}
}
