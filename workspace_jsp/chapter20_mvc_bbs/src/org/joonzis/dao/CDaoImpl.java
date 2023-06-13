package org.joonzis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.CVO;

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
	
	public  void getInsertComment(CVO cvo) {
		int result = getSqlSession().insert("insert_comment",cvo);
		
		if (result > 0) {
			getSqlSession().commit();
		}
		
	}
	
	public List<CVO> getListComment(int b_idx) {
		return getSqlSession().selectList("list_comment",b_idx);
	}
	
	public void removeComment(int c_idx) {
		int result = getSqlSession().delete("remove_comment",c_idx);
		
		if(result > 0) {
			getSqlSession().commit();
		}
	}
	
	@Override
	public void removeAll(int b_idx) {
		int result = getSqlSession().delete("remove_all",b_idx);
		
		if(result > 0) {
			getSqlSession().commit();
		}
		
	}
	
	

}
