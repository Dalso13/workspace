package org.joonzis.service;

import java.util.List;

import org.joonzis.dao.MDao;
import org.joonzis.dao.MDaoImpl;
import org.joonzis.vo.MVO;

public class memServiceImpl implements memService{
	MDao mdao = new MDaoImpl();
	
	public memServiceImpl() {
	}
	


	@Override
	public String joinS(MVO mvo) {
		return mdao.join(mvo);
	}
	@Override
	public String logisS(MVO mvo) {
		return mdao.login(mvo);
	}
	
	@Override
	public List<String> getIds() {
		
		return mdao.selectId();
	}
}
