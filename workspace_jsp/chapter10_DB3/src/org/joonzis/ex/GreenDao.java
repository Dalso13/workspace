package org.joonzis.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	// 1. DB와 연결하기
	
	private Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String user = "scott";
			String password = "tiger";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	// 2  select * 하는 메소드
	public List<GreenDto> getAllList() {
		List<GreenDto> list = new ArrayList<>();	// greenDto 클래스 타입에 리스트 배열을 만듬
		
		try {
			conn = getConnection();
			
			sql = "select * from green order by idx";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				GreenDto dto = new GreenDto();	// dto 객체 선언후
				
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
	
	// 데이터 insert 하는 메소드
	public int getInsert(GreenDto dto) {
		int result = 0;
		try {
			conn = getConnection();
			
			String sql = "insert INTO green "
						+ "(id, pw, name, age, addr, idx, reg_date) "
						+ "VALUES( ? , ? , ? , ? , ? , green_seq.nextval , SYSDATE) ";
					
	 		ps = conn.prepareStatement(sql);
	 		
	 		ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getAddr());
			
			result = ps.executeUpdate();	// 1 값을 넘긴다
			
			conn.setAutoCommit(false);
			
			
			if(result > 0) {
				conn.commit();
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
		return result;
	}
	
	// 데이터 remove 하는 메소드
	public int getRemove(GreenDto dto) {
		int result = 0;
		try {
			conn = getConnection();
			
			sql = " DELETE FROM green "
					+ " WHERE ID = ? and pw = ?" ;
					
	 		ps = conn.prepareStatement(sql);
	 		
	 		ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			
			result = ps.executeUpdate();	// 1 값을 넘긴다
			
			conn.setAutoCommit(false);
			
			
			if(result > 0) {
				conn.commit();
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
		return result;
	}
	
	
	// 2  특정 데이터 select 하는 메소드
	public GreenDto getOneList(String id, String pw) {
		GreenDto dto = new GreenDto();
		
		try {
			conn = getConnection();
			
			sql = "select * from green where id = ? and pw = ?";
			ps = conn.prepareStatement(sql);
			
	 		ps.setString(1, id);
			ps.setString(2, pw);
			
			rs = ps.executeQuery();
			if (rs.next()) {	
				dto.setIdx(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setAge(rs.getInt(5));
				dto.setAddr(rs.getString(6));
				dto.setReg_date(rs.getDate(7));
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
		return dto;
	
	}
	
	// 데이터 update 하는 메소드
	public int getUpdate(GreenDto dto) {
		int result = 0;
		try {
			conn = getConnection();
			
			String sql = "UPDATE green "
					+ " SET pw = ? , name = ? , age = ? , addr = ? "
					+ " where idx = ?";
			
	 		ps = conn.prepareStatement(sql);
	 		
	 		ps.setString(1, dto.getPw());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getAge());
			ps.setString(4, dto.getAddr());
			ps.setInt(5, dto.getIdx());
			
			result = ps.executeUpdate();	// 1 값을 넘긴다
			
			conn.setAutoCommit(false);
			
			
			if(result > 0) {
				conn.commit();
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
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
		return result;
	}
	
}
