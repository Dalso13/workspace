package org.joonzis.ex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;
import java.sql.SQLException;

/*
 * Oracle jdbc를 프로젝트에 등록
 * 	1. 프로젝트 우클릭
 * 	2. build path - configuer build path
 * 	3. libraries 탭
 * 	4. add external jars
 * 	5. ojdec6.jar 파일을 찾아서 선택
 */


public class Ex01_Connection {
	public static void main(String[] args) {
		
		// 1. connection 인스턴스
		Connection conn = null;
		
		try {
			
			// 2. oracle jdbc 드라이브 로드 	class.forName("드라이버 종류")
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 외우자	(오라클)
			//Class.forName("com.mysql.jdbc.Driver");								//MySQL
			//Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");		//Ms-SQL
			
			
			// 3. 접속 정보 생성
			String user = "scott";
			String password = "tiger";
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			/*	Oracle : jdbc:oracle://localhost:1521:SID
			 * 	MySQL : jdbc:mysql://localhost:3306:DB명
			 * 	Ms-SQL : jdbc:Microsoft:sqlserver://localhost:1433;databasename=DB명
			 * 
			 */
			
			// 4. DriverManager : 자바를 오라클 jdbc 에 연결 시켜주는 클래스
			conn = DriverManager.getConnection(url, user, password);
			
			// 5. 연결 확인 메세지
			System.out.println("DB 연결 성공");
			
			// 6. 접속 종료
			conn.close();
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결 오류");
		} catch (SQLException e1) {
			System.out.println("DB 연결 오류");
		}
		
		
	}
	
	
}
