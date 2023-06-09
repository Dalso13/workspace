package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.joonzis.db.DBConnection;

public class Ex03_delete {
	public static void main(String[] args) {
		
		
		Connection conn = null;
		PreparedStatement ps = null;  // sql의 값을 변수 처리 할 수 있다.
		
		try {
			
			conn = DBConnection.getConnection();
			
			// 김씨 데이터 삭제
			String sql = "delete person where name = ?";	// 나중에 setter로 채울 수 있다
			
			ps = conn.prepareStatement(sql);	// 미리 sql을 생성해야 함
			
			// ? 에 데이터 set
			ps.setString(1, "김씨");	// 숫자에 의미는 sql에서 물음표에 숫자
			
			int result = ps.executeUpdate();
			
			if (result > 0) {
				System.out.println("완료");
			} else {
				System.out.println("실패");
			}
		
			conn.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				if(conn != null) {
				conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
	}
}
