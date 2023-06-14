package org.joonzis.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.MVO;

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
	public String join(MVO mvo) {
		int result = getSqlSession().insert("join",mvo);
		
		if (result > 0) {
			getSqlSession().commit();
			return login(mvo);
		} else {
			return null;
		}
	}
	@Override
	public String login(MVO mvo) {
		return getSqlSession().selectOne("loginData",mvo);
	}
	
	@Override
	public List<String> selectId() {
		
		return getSqlSession().selectList("getId");
		
		
	}
}
