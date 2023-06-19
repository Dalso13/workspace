package org.dalso.service;

import org.dalso.vo.UVO;

public interface User_service {
	public int joinUser(UVO uvo);
	public String loginUser(UVO uvo);
}
