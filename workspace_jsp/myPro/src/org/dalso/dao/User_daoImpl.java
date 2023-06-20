package org.dalso.dao;



import org.apache.ibatis.session.SqlSession;
import org.dalso.myb.config.DBService;
import org.dalso.vo.UVO;


public class User_daoImpl implements User_dao{
	
	private static User_daoImpl instance = null;
	public User_daoImpl() {
	}
	public static User_daoImpl GetInstance() {
		if (instance == null) {
			instance = new User_daoImpl();
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
	public int join(UVO uvo) {
		int result = getSqlSession().insert("join",uvo);
		if (result > 0) {
			getSqlSession().commit();
		}
		return result;
	}
	@Override
	public UVO login(UVO uvo) {
		return getSqlSession().selectOne("login",uvo);
	}
	@Override
	public int getId(String id) {
		return getSqlSession().selectOne("select_id",id);
	}
}
