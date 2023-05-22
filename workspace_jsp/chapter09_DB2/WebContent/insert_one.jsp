<%@page import="org.joonzis.db.DBConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%
	request.setCharacterEncoding("utf-8");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String addr = request.getParameter("addr");
	
	
	
 	Connection conn = null;
	PreparedStatement ps = null;
	
	try {
		conn = DBConnect.getConnection();
		
		String sql = "insert INTO member "
					+ "(id, pw, name, age, addr, idx, reg_date) "
					+ "VALUES( ? , ? , ? , ? , ? , MEMBER_SEQ.nextval , SYSDATE) ";
				
 		ps = conn.prepareStatement(sql);
		
		ps.setString(1, id);
		ps.setString(2, pw);
		ps.setString(3, name);
		ps.setInt(4, age);
		ps.setString(5, addr);
		
		int result = ps.executeUpdate();
		
		conn.commit();
		
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
			response.sendRedirect("view_all.jsp");
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	} 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>