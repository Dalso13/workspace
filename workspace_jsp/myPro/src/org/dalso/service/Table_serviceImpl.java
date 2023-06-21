package org.dalso.service;

import java.util.List;

import org.dalso.dao.Table_dao;
import org.dalso.dao.Table_daoImpl;
import org.dalso.vo.CVO;
import org.dalso.vo.SearchVO;
import org.dalso.vo.TVO;
import org.dalso.vo.TitleVO;

public class Table_serviceImpl implements Table_service{
	private Table_dao dao = Table_daoImpl.GetInstance();
	
	@Override
	public int dao_table(TVO tvo) {
		return dao.insert_table(tvo);
	}
	@Override
	public List<TitleVO> dao_title() {
		return dao.select_title();
	}
	@Override
	public TVO select_table(String title) {
		return dao.select_table(title);
	}
	@Override
	public List<SearchVO> select_list(String title) {
		
		return dao.select_list(title);
	}
	@Override
	public int title_match(String title) {
		return dao.title_match(title);
	}
	@Override
	public int remove_page(CVO cvo) {
		return dao.removePage(cvo);
	}
	
}
