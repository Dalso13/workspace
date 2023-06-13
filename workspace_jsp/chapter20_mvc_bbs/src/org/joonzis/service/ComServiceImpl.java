package org.joonzis.service;

import java.util.List;

import org.joonzis.dao.CDao;
import org.joonzis.dao.CDaoImpl;
import org.joonzis.vo.CVO;

public class ComServiceImpl implements ComService{
	CDao cdao = new CDaoImpl();
	
	@Override
	public List<CVO> getComment(int b_idx) {
		
		return cdao.getListComment(b_idx);
	}
	@Override
	public void inCommnet(CVO cvo) {
		cdao.getInsertComment(cvo);
		
	}
	
	@Override
	public void removeComment(int c_idx) {
		cdao.removeComment(c_idx);
		
	}
	@Override
	public void removeAll(int b_idx) {
		cdao.removeAll(b_idx);
		
	}
}
