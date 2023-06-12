package org.joonzis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.config.DBService;
import org.joonzis.vo.BVO;

public class BDaoImpl implements BDao{
	// DAO 객체 생성
		private static BDaoImpl instance = null;
		public BDaoImpl() {
		}
		public static BDaoImpl GetInstance() {
			if (instance == null) {
				instance = new BDaoImpl();
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
		public int getTotalRecord() {
			return getSqlSession().selectOne("total_record");
		}
		
		@Override
		public BVO getBBS(int idx) {
			
			return null;
		}
		
		@Override
		public int getInsert(BVO bvo) {
			
			int result = getSqlSession().insert("insert_bbs",bvo);
			
			if (result > 0) {
				getSqlSession().commit();
			}

			
			return result;
		}
		@Override
		public List<BVO> getList(Map<String, Integer> map) {
			
			return getSqlSession().selectList("list_bbs",map);
		}
		@Override
		public int getRemove(int idx) {
			
			return 0;
		}
		@Override
		public int getUpdate(BVO bvo) {
			
			return 0;
		}
}
