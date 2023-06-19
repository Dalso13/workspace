package org.dalso.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.dalso.myb.config.DBService;
import org.dalso.vo.TVO;
import org.dalso.vo.TitleVO;

public class Table_daoImpl implements Table_dao{
	private static Table_daoImpl instance = null;
	public Table_daoImpl() {
	}
	public static Table_daoImpl GetInstance() {
		if (instance == null) {
			instance = new Table_daoImpl();
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
	public List<TitleVO> select_title() {
		return getSqlSession().selectList("select_title");
	}
	@Override
	public int insert_table(TVO tvo) {
		int result = getSqlSession().insert("insert_table",tvo);
		if (result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
	
	@Override
	public TVO select_table(String title) {
		return getSqlSession().selectOne("select_table",title);
	}
}
