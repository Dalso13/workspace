package org.dalso.service;

import java.util.List;

import org.dalso.dao.Chat_dao;
import org.dalso.dao.Chat_daoImpl;
import org.dalso.vo.CVO;

public class Chat_serviceImpl implements Chat_service{
	private Chat_dao dao = Chat_daoImpl.GetInstance(); 
	
	
	@Override
	public int insert_c(CVO cvo) {
		
		return dao.insert_comment(cvo);
	}
	@Override
	public List<CVO> select_c(int t_idx) {
		
		return dao.selectComment(t_idx);
	}
	@Override
	public int remove_chat(CVO cvo) {
		return dao.removeChat(cvo);
	}
}
