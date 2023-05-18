package org.joonzis.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex08_request")
public class Ex08_request extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex08_request() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("ex06 웹페이지");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<ul>");
		out.print("<li> 이름  : " + name + "</li>");
		out.print("<li> 국어  : " + kor + "</li>");
		out.print("<li> 영어  : " + eng + "</li>");
		out.print("<li> 수학  : " + mat + "</li>");
		//
			double avg = Math.round(((kor + eng + mat) / 3.0)*100)/100.0;
			String grade = "";
			
			if (avg >= 90 && avg <= 100) {
				grade = "A";
			} else if (avg >= 80) {
				grade = "B";
			} else if (avg >= 70) {
				grade = "C";
			} else if (avg >= 60) {
				grade = "D";
			} else {
				grade = "F";
			}
		
		//
		out.print("<li> 평균  : " + avg + "</li>");	
		out.print("<li> 학점  : " + grade + "</li>");	
		out.print("</li>");
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
