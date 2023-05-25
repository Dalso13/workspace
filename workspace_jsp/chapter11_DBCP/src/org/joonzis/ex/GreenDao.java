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

public class GreenDao {
	// 필드
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private String sql = "";
	
	// 싱글 톤
	private GreenDao() {}	// 기본 생성자(외부에서 접근할 수 없게 private 처리)
	private static GreenDao dao = new GreenDao();
	public static GreenDao getInstance() {
		return dao;
	}
	
	// DBCP 설정
	private static DataSource ds;
	static {
		try {
			Context context = new InitialContext();  //xml을 읽어온다
			ds = (DataSource)context.lookup("java:comp/env/jdbc/oracle");  // 톰캣위치/DataSource에 저장된 context 네임 
			// java:comp/env/ : 톰캣 (지정되어 있음)
			//	jdbc/oracle : Resource name(변경 가능)을 찾아서 DataSource 객체에 전달
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	// 2  select * 하는 메소드
	public List<GreenVO> getAllList() {
		List<GreenVO> list = new ArrayList<>();	// greenDto 클래스 타입에 리스트 배열을 만듬
		
		try {
			conn = ds.getConnection();
			
			sql = "select * from green order by idx";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				GreenVO dto = new GreenVO();	// dto 객체 선언후
				
				dto.setIdx(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setAge(rs.getInt(5));
				dto.setAddr(rs.getString(6));
				dto.setReg_date(rs.getDate(7));
				
				list.add(dto);	// list 에 넣어주기 배열하나를 사용
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
				if (rs != null) {
					rs.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
	
		return list;
	}
	
}
