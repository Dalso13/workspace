<%@page import="org.joonzis.db.DBConnect"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

<%
	request.setCharacterEncoding("utf-8");
	
	String id = "";
	
	
 	
 	Connection conn = null;
	PreparedStatement ps = null;
	
	try {
		String sql = "";
	
		if(request.getParameter("id").equals("") || request.getParameter("id") == null){
			id = request.getParameter("pw");
			
			sql = " DELETE FROM MEMBER "
						+ " WHERE PW = ?";
		} else {
			id = request.getParameter("id");
			
			sql = " DELETE FROM MEMBER "
					+ " WHERE ID = ?";
		}
			
		
		conn = DBConnect.getConnection();
		
		
				
 		ps = conn.prepareStatement(sql);
		
		ps.setString(1, id);


		
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