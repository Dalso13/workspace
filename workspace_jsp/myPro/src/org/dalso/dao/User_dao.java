package org.dalso.dao;

import org.dalso.vo.UVO;

public interface User_dao {
	public int join(UVO uvo);
	public String login(UVO uvo);
}
