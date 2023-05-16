package org.joonzis.ex;

import java.sql.Connection;
import java.sql.Statement;

import org.joonzis.db.DBConnection;

public class Ex02_update {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		
		try {
			conn = DBConnection.getConnection();
			
			// statement 생성
			st = conn.createStatement();
			
			// 스콧의 나이를 21살로 변경
			String sql = "";
			sql = "UPDATE person set age = 21 WHERE NAME = '스콧'";
	
			
			
			int result = st.executeUpdate(sql);
			
			// 삽입 성공 : 1, 실패 : 0
			if(result > 0) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}
			
			conn.commit();
			
			// 가끔 멈출떄가 있는데 디벨로퍼에서 커밋을 안해줘서 그럼
			
		} catch (Exception e) {
			e.printStackTrace();
			
			// 롤백
			try {
				if(conn != null) {
					conn.rollback();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} finally {
			try {
				if(st != null) {
					st.close();
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

