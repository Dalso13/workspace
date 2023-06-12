package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.dao.BDao;
import org.joonzis.dao.BDaoImpl;
import org.joonzis.vo.BVO;

public class BbsServiceImpl implements BbsService{
	BDao dao = new BDaoImpl();
	
	@Override
	public List<BVO> getAll(Map<String, Integer> map) {
		
		return dao.getList(map);
	}
	@Override
	public int getCount() {
		return dao.getTotalRecord();
	}
	
	@Override
	public int getInsert(BVO bvo) {
		return dao.getInsert(bvo);
	}
}
