package org.joonzis.dao;

import java.util.List;

import org.joonzis.vo.CVO;

public interface CDao {
	public void getInsertComment(CVO cvo);
	
	public List<CVO> getListComment(int b_idx);
	
	public void removeComment(int c_idx);
	
	public void removeAll(int b_idx);
}
