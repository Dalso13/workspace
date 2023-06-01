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
	
	// 싱글톤
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
	
	// 2. 테이블의 전체 목록을 가져오는 메소드
	public List<GreenDto> getAllList() {
		List<GreenDto> list = new ArrayList<>();
		
		try {
			conn = getConnection();
			sql = "select * from green order by idx";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				GreenDto dto = new GreenDto();
				dto.setIdx(rs.getInt(1));
				dto.setId(rs.getString(2));
				dto.setPw(rs.getString(3));
				dto.setName(rs.getString(4));
				dto.setAge(rs.getInt(5));
				dto.setAddr(rs.getString(6));
				dto.setReg_date(rs.getDate(7));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	
	// 데이터 삽입 메소드
	public int getInsert(GreenDto dto) {
		int result = 0;
		
		try {
			conn = getConnection();
			String sql = "insert into green" +
			" values(green_seq.nextval, ?, ?, ?, ?, ?, sysdate)";
			ps = conn.prepareStatement(sql);
			conn.setAutoCommit(false);// 자동 커밋 방지
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			ps.setString(3, dto.getName());
			ps.setInt(4, dto.getAge());
			ps.setString(5, dto.getAddr());
			
			result = ps.executeUpdate();
			if(result>0) {
				conn.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return result;
	}
	
	// id를 통한 유저 정보 가져오는 메소드
	public GreenDto getUserInfoById(String id) {
		GreenDto dto = null;
		
		try {
			conn = getConnection();
			sql = "select * from green where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();	// 실제 쿼리 작동
			
			if(rs.next()) {
				dto = new GreenDto();
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
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
			
		return dto;
	}
	
	// 데이터 삭제 메소드
	public int getRemove(GreenDto dto) {
		int result = 0;
		
		conn = null;
		ps = null;
		
		try {
			conn = getConnection();
			
			String sql = "delete from green where id=? and pw=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	// 업데이를 위한 유저 정보 메소드
	public GreenDto getUpdateView(GreenDto dto) {
		GreenDto returnDto = null;
		
		try {
			conn = getConnection();
			sql = "select * from green where id=? and pw=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getId());
			ps.setString(2, dto.getPw());
			rs = ps.executeQuery();	// 실제 쿼리 작동
			
			if(rs.next()) {
				returnDto = new GreenDto();
				returnDto.setIdx(rs.getInt(1));
				returnDto.setId(rs.getString(2));
				returnDto.setPw(rs.getString(3));
				returnDto.setName(rs.getString(4));
				returnDto.setAge(rs.getInt(5));
				returnDto.setAddr(rs.getString(6));
				returnDto.setReg_date(rs.getDate(7));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {rs.close();}
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
			
		return returnDto;
		
	}
	
	// 유저 정보 수정 메소드
	public int getUpdate(GreenDto dto) {
		int result = 0;
		
		try {
			conn = getConnection();
			String sql = "update green set pw=?, name=?, age=?, addr=? where idx=? ";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, dto.getPw());
			ps.setString(2, dto.getName());
			ps.setInt(3, dto.getAge());
			ps.setString(4, dto.getAddr());
			ps.setInt(5, dto.getIdx());
			
			result = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {ps.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
}






