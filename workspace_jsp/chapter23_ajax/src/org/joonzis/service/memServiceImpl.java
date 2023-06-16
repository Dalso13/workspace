package org.joonzis.service;

import java.util.List;

import org.joonzis.dao.MDao;
import org.joonzis.dao.MDaoImpl;
import org.joonzis.dto.MemberDTO;

public class memServiceImpl implements memService{
	private MDao md = MDaoImpl.GetInstance();
	
	@Override
	public List<MemberDTO> getMemberList() {
		
		return md.getList();
	}
}
