package org.joonzis.ex;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.joonzis.db.DBConnection;

public class Ex04_select {
	public static void main(String[] args) {
		
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; // select의 결과(table)은 ResultSet 이다
		 
		
		try {
			
			conn = DBConnection.getConnection();
			st = conn.createStatement();
			
			String sql = "SELECT * FROM PERSON";

			// executeQuery : select 문에서 사용
			rs = st.executeQuery(sql);
			

			// rs에 저장된 데이터 출력
			// 1. row 단위로 데이터를 읽는다.
			// 2. 남아있는 row의 확인 next() 메소드 이용(true : 남아있다)
			// 3. row는 colmun의 집합이므로 각 column별로 분리하기 위한 getter가 존재
			// name varchar2(10) : rs.getString(1) 또는 rs.getString("name")
			// 		-> column의 인덱스는 1부터 시작
			// age number : rs.getInt(2) 또는 rs.getInt("age")

			
			while(rs.next()) {
				System.out.print(rs.getString(1) + ",");
				System.out.print(rs.getInt(2) + ",");
				System.out.println(rs.getString("region"));
			}
			
			// select는 commit이 필요없다.
			
			
		} catch (Exception e) {
			e.printStackTrace();
			// 커밋이 없으닌 롤백도 필요없음
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
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
