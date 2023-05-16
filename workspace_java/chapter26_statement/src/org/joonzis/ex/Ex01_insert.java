package org.joonzis.ex;

import java.sql.Connection;
import java.sql.Statement;

import org.joonzis.db.DBConnection;

public class Ex01_insert {
	public static void main(String[] args) {
		
		Connection conn = null;
		Statement st = null;
		
		
		try {
			conn = DBConnection.getConnection();
			
			// statement 생성
			st = conn.createStatement();
			
			// 쿼리 작성	-> 스콧, 99, 인천
			String sql = "";
			sql = "INSERT INTO person VALUES('스콧',99,'인천')";
			
			String sql2 = "INSERT INTO person VALUES('장동완',23,'시흥')";
			
			// 쿼리 날리기(DB로 SQL 전달)
			// executeUpdate : insert, update, delete문 사용
			// (메소드의 리턴 타입이 int라서 이렇게 작성)
			// ex) st : 버스, sql: 승객
			int result = st.executeUpdate(sql);
			
			// 1인 이유 : 하나의 행을 날리는거라서
			// 삽입 성공 : 1, 실패 : 0
			if(result == 1) {
				System.out.println("레코드의 삽입 성공!");
			} else {
				System.out.println("레코드의 삽입 실패!");
			}
			
			conn.commit();
			

			
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
