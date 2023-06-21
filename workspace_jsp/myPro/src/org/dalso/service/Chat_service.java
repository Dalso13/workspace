package org.dalso.service;

import java.util.List;

import org.dalso.vo.CVO;

public interface Chat_service {
	public int insert_c(CVO cvo);
	public List<CVO> select_c(int t_idx);
	public int remove_chat(CVO cvo);
}
