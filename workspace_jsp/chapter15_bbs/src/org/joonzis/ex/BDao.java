package org.joonzis.ex;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.DBService;

public class BDao {
	// 필드
		private static SqlSession sqlsession = null;
		
		// 싱글톤
		private synchronized static SqlSession getSqlSession() {
			if (sqlsession == null) {
				sqlsession = DBService.getFactory().openSession(false);
			}
			return sqlsession;
		}
		
		// 메소드
		// 전체 데이터 개수 가져오기
		public static int getTotalRecord() {
			return getSqlSession().selectOne("total_record");
		}
		
		
		
		
		public static List<BVO> getList(Map<String, Integer> map){
			return getSqlSession().selectList("list_bbs", map);
		}

		
		public static BVO getBBS(int idx){
			return getSqlSession().selectOne("view_bbs",idx);
		}
		
		public static int getInsert(BVO bvo) {
			int result = getSqlSession().insert("insert_bbs",bvo);
			
			if (result > 0) {
				getSqlSession().commit();
			}
			return result;
		}
		
		
}
