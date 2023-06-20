package org.dalso.dao;

import org.dalso.vo.UVO;

public interface User_dao {
	public int join(UVO uvo);
	public UVO login(UVO uvo);
	public int getId(String id);
}
