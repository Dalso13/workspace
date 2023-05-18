package org.joonzis.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex05_servlet")
public class Ex05_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex05_servlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Calendar 객체를 이용하여 웹 브라우저에 
		// 2023년 05월 17일 출력
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter(); // 웹 브라우저에 출력하기 위한 객체
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("날짜 나타내는 웹페이지");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		// request 가 가지고 있는 기본 정보
		String url = request.getRemoteAddr();
		String host = request.getRemoteHost();
		String user = request.getRemoteUser();
		int port = request.getRemotePort();
		
		out.print("요청 주소 : " + url + "<br>");
		out.print("요청 호스트 : " + host + "<br>");
		out.print("요청 사용자 : " + user + "<br>");
		out.print("요청 포트 : " + port + "<br>");
		
		out.print("</body>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
