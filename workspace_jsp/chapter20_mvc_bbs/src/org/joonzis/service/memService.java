package org.joonzis.service;

import java.util.List;

import org.joonzis.vo.MVO;

public interface memService {
	public String joinS(MVO mvo);
	public String logisS(MVO mvo);
	public List<String> getIds();
}
