package org.joonzis.service;

import java.util.List;

import org.joonzis.vo.CVO;

public interface ComService {
	public List<CVO> getComment(int b_idx);
	public void inCommnet(CVO cvo);
	public void removeComment(int c_idx);
	public void removeAll(int b_idx);
}
