package org.joonzis.dao;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;

public class CDaoImpl implements CDao{
	// DAO 객체 생성
	private static CDaoImpl instance = null;

	public CDaoImpl() {
	}

	public static CDaoImpl GetInstance() {
		if (instance == null) {
			instance = new CDaoImpl();
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

}
