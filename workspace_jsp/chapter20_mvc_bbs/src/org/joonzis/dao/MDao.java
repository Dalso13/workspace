package org.joonzis.dao;

import java.util.List;

import org.joonzis.vo.MVO;

public interface MDao {
	public String join(MVO mvo);
	public String login(MVO mvo);
	public List<String> selectId();
}
