package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.joonzis.vo.BVO;



public interface BDao {
	public List<BVO> getList(Map<String, Integer> map);
	public BVO getBBS(int idx);
	public int getInsert(BVO bvo);
	public int getRemove(int idx);
	public int getUpdate(BVO bvo);
	public int getTotalRecord();
	public void getUpdateHit(BVO bvo);
}
