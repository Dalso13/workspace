package org.joonzis.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex06_request")
public class Ex06_request extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex06_request() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String query = request.getParameter("query");
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("ex06 웹페이지");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<h1> 전달된 이름은 : " + name + "이고 나이는 : "+ age + " 입니다</h1>");
		out.print("<h1> 전달된 값은 : " + query + "</h1>");
		out.print("</body>");
		out.print("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
