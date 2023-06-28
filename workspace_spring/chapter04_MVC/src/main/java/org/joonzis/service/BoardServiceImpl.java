package org.joonzis.service;

import java.util.List;

import org.joonzis.domain.BoardVO;
import org.joonzis.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j;


@Log4j
@Service
public class BoardServiceImpl implements BoardSerivce{
	
	@Autowired
	private BoardMapper mapper;
	
	@Override
	public BoardVO get(int bno) {
		log.info("get");
		return mapper.read(bno);
	}
	@Override
	public List<BoardVO> getList() {
		log.info("getList...");
		return mapper.getList();
	}
	@Override
	public boolean modify(BoardVO vo) {
	
		return mapper.update(vo) > 0 ? true : false;
	}
	@Override
	public void register(BoardVO vo) {
	
		mapper.insert(vo);
	}
	@Override
	public boolean remove(int bno) {
	
		return mapper.delete(bno) > 0;
	}
	
}
