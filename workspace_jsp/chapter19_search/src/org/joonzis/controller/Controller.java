package org.joonzis.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Controller() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmd = request.getParameter("cmd");
		String resultCmd = "allList";
		if (cmd != null && !cmd.isEmpty()) {
			resultCmd = cmd;
		}
		
		// 단순 화면 이동 / 데이터 사용 구분 // true면 포워드 false면 리다이렉트
		boolean isForward = false;
		// 이동 경로
		String path = "";
		
		
		if (resultCmd.equals("allList")) {
			isForward = true;
			path = "allList.jsp";
		}
			
			
			
		if (isForward) {
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			response.sendRedirect(path);
		}
			
			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
