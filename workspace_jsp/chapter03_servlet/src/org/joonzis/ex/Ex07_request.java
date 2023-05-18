package org.joonzis.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ex07_request")
public class Ex07_request extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Ex07_request() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobbies");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("ex06 웹페이지");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>");
		out.print("<ul>");
		out.print("<li> ID  : " + id + "</li> <li> 비밀번호 : "+ pw + " </li>");
		out.print("<li> 이름  : " + name + "</li>");
		out.print("<li> email  : " + email + "</li>");
		out.print("<li> gender  : " + gender + "</li>");
		out.print("<li> hobbies  : " ); 
		for(String hobbie : hobbies) {
			out.print(hobbie + " , ");
		} 
		out.print("</li>");
		out.print("</ul>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
