package org.dalso.dao;

import java.util.List;

import org.dalso.vo.CVO;

public interface Chat_dao {
	public int insert_comment(CVO cvo);
	public List<CVO> selectComment(int t_idx);
	public int removeChat(CVO cvo);

}
