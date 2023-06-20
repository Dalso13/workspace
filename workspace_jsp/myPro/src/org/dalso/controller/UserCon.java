package org.dalso.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dalso.service.User_service;
import org.dalso.service.User_serviceImpl;
import org.dalso.vo.UVO;


@WebServlet("/UserCon")
public class UserCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UserCon() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html; charset=UTF-8");
		
			String cmd = request.getParameter("cmd");
			if (cmd == null || cmd.isEmpty()) {
				cmd = "main";
			}
			
			boolean isForward = false;
			String path = "";
			
			User_service us = new User_serviceImpl();
		
			HttpSession session = request.getSession();
			
		 	if (cmd.equals("login_page")) {
				path = "main/login.jsp";
			} else if (cmd.equals("join_page")) {
				path = "main/join.jsp";
			} else if (cmd.equals("join")) {
				UVO uvo = new UVO();
				
				uvo.setU_writer(request.getParameter("u_writer"));
				uvo.setU_pw(request.getParameter("u_pw"));
				uvo.setU_power(request.getParameter("u_power"));
				
				int result = us.joinUser(uvo);
				
				request.setAttribute("result", result);

				isForward = true;
				path = "main/result.jsp";
			} else if (cmd.equals("login")) {
				UVO uvo = new UVO();
				
				uvo.setU_writer(request.getParameter("u_writer"));
				uvo.setU_pw(request.getParameter("u_pw"));
				
				UVO uvo2 = us.loginUser(uvo);
				
				isForward = true;	
				if (uvo2 == null || uvo2.equals("")) {
					request.setAttribute("result", "no");
					
					path = "main/result.jsp";
				}else {
					session.setAttribute("uvo", uvo2);
					path = "start.jsp";
				}
					
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
