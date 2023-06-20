package org.dalso.service;

import org.dalso.dao.Chat_dao;
import org.dalso.dao.Chat_daoImpl;
import org.dalso.vo.CVO;

public class Chat_serviceImpl implements Chat_service{
	private Chat_dao dao = Chat_daoImpl.GetInstance(); 
	
	
	@Override
	public int insert_c(CVO cvo) {
		
		return dao.insert_comment(cvo);
	}
}
