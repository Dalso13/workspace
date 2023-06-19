package org.dalso.dao;

import java.util.List;

import org.dalso.vo.TVO;
import org.dalso.vo.TitleVO;

public interface Table_dao {
	public List<TitleVO> select_title();
	public int insert_table(TVO tvo);
	public TVO select_table(String title);
}
