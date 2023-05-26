package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.joonzis.mybatis.DBService;

public class GreenDao {
	// 필드
	private SqlSessionFactory factory = null;
	
	// 싱글 톤
	private GreenDao() {// 기본 생성자(외부에서 접근할 수 없게 private 처리)
		factory = DBService.getFactory(); // db서비스 라는 클래스에 담긴 커넥션 정보를 담아준 conn역할
	}	
	private static GreenDao dao = new GreenDao();
	public static GreenDao getInstance() {
		return dao;
	}
	
	
	/*
	 * openSession()		select 문에서 사용 (커밋을 하지 않음)
	 * openSession(true)	자동 커밋
	 * openSession(false)	수동 커밋
	 * 
	 * SqlSession의 메소드 종류
	 * 	1. selectList("mapper에서 사용할 id")			-- 검색 결과가 여러 개 일때 list
	 * 	2. selectList("mapper에서 사용할 id" , 파라미터)	-- 파라미터 전달시
	 * 	3. selectOne("mapper에서 사용할 id")			-- 검색 결과가 한 개 일 때 (테이블)
	 * 	4. selectOne("mapper에서 사용할 id", 파라미터)	
	 * 	5. insert	("mapper에서 사용할 id", 파라미터)	
	 * 	6. update	("mapper에서 사용할 id", 파라미터)	
	 * 	7. delete	("mapper에서 사용할 id", 파라미터)	
	 * 
	 * 	파라미터는 옵션 안써도됨
	 */
	
	
	// 메소드
	
	// select
	public List<GreenVO> getAllList(){
		SqlSession sqlSession = factory.openSession(); //쿼리를 날려주기 위한 작업 쿼리 날릴곳을 가져옴
		List<GreenVO> list = sqlSession.selectList("select_all"); // 리스트에 넣어줌 selectList 안에 값은 별명(id)값
		sqlSession.close();
				
		return list;	// 빈값이 들어오면 null로 들어감
	}
	
	// insert 추가
	public int getInsert(GreenVO vo) {
		SqlSession sqlSession = factory.openSession(false);
		int result = sqlSession.insert("insert",vo);
		
		if (result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		return result;
	}
	
	// select 데이터 한줄만
	public GreenVO getOneList(String id){
		SqlSession sqlSession = factory.openSession(); 
		GreenVO vo = sqlSession.selectOne("select_one", id); 
		sqlSession.close();
				
		return vo;	// 빈값이 들어오면 null로 들어감
	}
	
	// 데이터 delete 
	public int getRemove(GreenVO vo) {
		SqlSession sqlSession = factory.openSession(false);
		int result = sqlSession.delete("delete",vo);
		
		if (result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		return result;
	}
	
	// 데이터 업데이트 
	public int getUpdate(GreenVO vo) {
		SqlSession sqlSession = factory.openSession(false);
		int result = sqlSession.update("update",vo);
		
		if (result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		return result;
	}
	
}
