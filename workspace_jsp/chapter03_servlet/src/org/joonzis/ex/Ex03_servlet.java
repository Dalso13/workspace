package org.joonzis.ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex03_servlet")
public class Ex03_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Ex03_servlet() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 실제 코드가 작성되는 곳
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");	// 인코딩 jsp 맨위 임폴트 문장에 똑같은 문장이 있음
		
		PrintWriter out = response.getWriter(); // 웹 브라우저에 출력하기 위한 객체
		
		// 웹 브라우저에 출력하는 메소드 print()
		out.print("<html>");
		out.print("<head>");
		out.print("<title>");
		out.print("나의 첫 서블릿 페이지");
		out.print("</title>");
		out.print("</head>");
		out.print("<body>")
		;
		out.print("<h1> 나의 첫 서블릿 본문 내용</h1>");
		out.print("</body>");
		out.print("</html>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
