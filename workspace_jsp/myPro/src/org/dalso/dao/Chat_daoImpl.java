package org.dalso.dao;

import org.apache.ibatis.session.SqlSession;
import org.dalso.myb.config.DBService;
import org.dalso.vo.CVO;

public class Chat_daoImpl implements Chat_dao{
	private static Chat_daoImpl instance = null;
	public Chat_daoImpl() {
	}
	public static Chat_daoImpl GetInstance() {
		if (instance == null) {
			instance = new Chat_daoImpl();
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
	public int insert_comment(CVO cvo) {
		int result = getSqlSession().insert("insert_comment",cvo);
		
		if (result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
}
