package org.dalso.service;

import org.dalso.dao.User_dao;
import org.dalso.dao.User_daoImpl;
import org.dalso.vo.UVO;

public class User_serviceImpl implements User_service{
	private  User_dao dao = User_daoImpl.GetInstance();
	
	@Override
	public int joinUser(UVO uvo) {
		return dao.join(uvo);
	}
	
	@Override
	public String loginUser(UVO uvo) {
		return dao.login(uvo);
	}
}
