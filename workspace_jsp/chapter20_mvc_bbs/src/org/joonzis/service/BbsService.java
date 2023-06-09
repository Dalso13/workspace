package org.joonzis.service;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.BVO;

public interface BbsService {
	public List<BVO> getAll(Map<String, Integer> map);
	public int getCount();
	public int getInsert(BVO bvo);
	public BVO getView(int b_idx);
	public int getRemove(int b_idx);
	public int getUpdate(BVO bvo);
	public void setHit(BVO bvo);
}
