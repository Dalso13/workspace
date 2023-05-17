package org.joonzis.ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex04_servlet")
public class Ex04_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex04_servlet() {
        super();
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Calendar 객체를 이용하여 웹 브라우저에 
		// 2023년 05월 17일 출력
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		String month = "0"+ (cal.get(Calendar.MONTH)+1);
		int date = cal.get(Calendar.DATE);
		
		PrintWriter out = response.getWriter(); // 웹 브라우저에 출력하기 위한 객체
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("날짜 나타내는 웹페이지");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		out.print(year + "년 " + month + "월 " +date +"일");
		out.print("</body>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
