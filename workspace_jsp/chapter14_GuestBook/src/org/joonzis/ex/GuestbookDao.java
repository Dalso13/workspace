package org.joonzis.ex;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.joonzis.mybatis.DBService;

import oracle.net.aso.l;

public class GuestbookDao {
	
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
	// 모든 메소드를 static 처리해서 별도 과정 없이 GuestbookDao.메소드명() 으로
	// 메소드를 사용할 수 있다.
	// sqlsession이 필요하면 위에 정의된 getSqlSession() 을 호출하면 된다.
	
	// 1. 전체 검색
	
	public static List<GuestbookVO> selectAll(){
		return getSqlSession().selectList("select_all");
	}
	
	 // 2. 방명록 추가
	
	public static int insert(GuestbookVO vo) {
		int result = getSqlSession().insert("insert", vo);
		
		if (result > 0) {
			getSqlSession().commit();
		}
		
		return result;
	}
	
	// 3. 특정 정보 검색
	public static GuestbookVO selectByIdx(int idx){
		return getSqlSession().selectOne("select", idx);
	}
	
	// 4. 특정 정보 삭제
	public static int remove(int idx) {
		int result = getSqlSession().delete("remove", idx);
		
		if (result > 0) {
			getSqlSession().commit();
		}
		
		return result;
	}
}
