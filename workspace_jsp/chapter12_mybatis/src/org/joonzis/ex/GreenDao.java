package org.joonzis.ex;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
	// 싱글톤
	private GreenDao() {
		factory = DBService.getFactory();
	}
	private static GreenDao dao = new GreenDao();
	public static GreenDao getInstance() {
		return dao;
	}
	
	
	
	/*
	 * openSession()			select 문에서 사용(커밋을 하지 않음)
	 * openSession(true)		자동 커밋
	 * openSession(false)		수동 커밋
	 * 
	 * SqlSession의 메소드 종류
	 * 	1. selectList("mapper에서 사용할 id")				-- 검색 결과가 여러 개 일때 List(테이블)
	 * 	2. selectList("mapper에서 사용할 id", 파라미터)		-- 파라미터 전달 시
	 * 	3. selectOne("mapper에서 사용할 id")				-- 검색 결과가 한 개 일 때(테이블)
	 * 	4. selectOne("mapper에서 사용할 id", 파라미터)
	 * 	5. insert("mapper에서 사용할 id", 파라미터)
	 * 	6. update("mapper에서 사용할 id")
	 * 	7. delete("mapper에서 사용할 id")
	 * 
	 *   *** 각 메소드의 두번 째 인자 값으로 파라미터를 던질 수 있다.
	 *   던질 파라미터가 없을 시 생략
	 */

	// 메소드
	// 1. 전체 검색
	public List<GreenVO> getAllList(){
		SqlSession sqlSession = factory.openSession();
		List<GreenVO> list = sqlSession.selectList("select_all");
		sqlSession.close();
		return list;
	}
	// 2. 회원 추가
	public int getInsert(GreenVO vo) {
		SqlSession sqlSession = factory.openSession(false);
		int result = sqlSession.insert("insert", vo);
		if(result > 0 ) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	// 3. 회원 검색 (by id)
	public GreenVO getOneList(String id) {
		SqlSession sqlSession = factory.openSession();
		GreenVO dto = sqlSession.selectOne("select_by_id",id);
		sqlSession.close();
		return dto;
	}
	// 4. 회원 삭제
	public int remove(GreenVO vo) {
		SqlSession sqlSession = factory.openSession(false);
		int result = sqlSession.delete("remove", vo);
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
	
	// 5. 회원 정보 수정 페이지
	public GreenVO update_page(GreenVO vo) {
		SqlSession sqlSession = factory.openSession();
		GreenVO dto2 = sqlSession.selectOne("update_page", vo);
		sqlSession.close();
		return dto2;
	}	
	
	// 6. 회원 정보 수정
	public int update(GreenVO vo) {
		SqlSession sqlSession = factory.openSession(false);
		int result = sqlSession.update("update", vo);
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}
}






