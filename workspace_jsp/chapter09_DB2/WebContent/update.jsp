<%@page import="org.joonzis.db.DBConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%
	request.setCharacterEncoding("utf-8");
	
	int	idx = Integer.parseInt(request.getParameter("idx"));
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String addr = request.getParameter("addr");
	
	
	
	
 	Connection conn = null;
	PreparedStatement ps = null;
	
	try {
		conn = DBConnect.getConnection();
		
		String sql = "UPDATE member "
				+ " SET pw = ? , name = ? , age = ? , addr = ? "
				+ " where idx = ?";
 		ps = conn.prepareStatement(sql);
		
		ps.setString(1, pw);
		ps.setString(2, name);
		ps.setInt(3, age);
		ps.setString(4, addr);
		ps.setInt(5, idx);
		
		int result = ps.executeUpdate();	// 1 값을 넘긴다
		
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