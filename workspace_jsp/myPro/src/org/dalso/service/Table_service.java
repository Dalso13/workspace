package org.dalso.service;

import java.util.List;

import org.dalso.vo.TVO;
import org.dalso.vo.TitleVO;

public interface Table_service {
	public List<TitleVO> dao_title();
	public int dao_table(TVO tvo);
	public TVO select_table(String title);
}