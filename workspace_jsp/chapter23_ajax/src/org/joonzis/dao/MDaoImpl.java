package org.joonzis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.dto.MemberDTO;
import org.joonzis.mybatis.config.DBService;

public class MDaoImpl implements MDao{
	private static MDaoImpl instance = null;
	public MDaoImpl() {
	}
	public static MDaoImpl GetInstance() {
		if (instance == null) {
			instance = new MDaoImpl();
		}
		return instance;
	}
	
	// 필드
	private static SqlSession sqlsession = null;
	
	private synchronized static SqlSession getSqlSession() {
		if (sqlsession == null) {
			sqlsession = DBService.getFactory().openSession(false);
		}
		return sqlsession;
	}
	
	@Override
	public List<MemberDTO> getList() {
		return getSqlSession().selectList("select_all");
	}
}
