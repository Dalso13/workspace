package org.joonzis.ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.joonzis.db.DBConnection;

public class Ex04_select {
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement ps = null;  // sql의 값을 변수 처리 할 수 있다.
		ResultSet rs = null;
		try {
			
			conn = DBConnection.getConnection();
			
			String sql = "select * from person " ;	// 나중에 setter로 채울 수 있다
			
			ps = conn.prepareStatement(sql);	// 미리 sql을 생성해야 함
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				System.out.print(rs.getString(1) + ",");
				System.out.print(rs.getInt(2) + ",");
				System.out.println(rs.getString(3));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				
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
