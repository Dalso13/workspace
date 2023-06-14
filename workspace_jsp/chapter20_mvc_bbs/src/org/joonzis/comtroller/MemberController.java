package org.joonzis.comtroller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.joonzis.service.memService;
import org.joonzis.service.memServiceImpl;
import org.joonzis.vo.MVO;


@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public MemberController() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		
		memService mservice = new memServiceImpl();
		
		HttpSession session = request.getSession();
		
		// 단순 화면 이동 / 데이터 사용 구분 // true면 포워드 false면 리다이렉트
		boolean isForward = false;
		// 이동 경로
		String path = "";
		
		int result = 1;
		
		if (cmd.equals("joinpage")) {
			
			List<String> pvo = mservice.getIds();
			
			request.setAttribute("pvo", pvo);
			
			isForward = true;
			path = "member/join.jsp";
		}
		if (cmd.equals("loginpage")) {
			path = "member/login.jsp";
		}
		if (cmd.equals("join")) {
			MVO mvo = new MVO();
			
			mvo.setMid(request.getParameter("mid"));
			mvo.setMpw(request.getParameter("mpw"));
			mvo.setMname(request.getParameter("mname"));
			mvo.setMtel(request.getParameter("mtel"));
			mvo.setMage(Integer.parseInt(request.getParameter("mage")));
			
			String mid = mservice.joinS(mvo);
			
			session.setAttribute("mid", mid);
			
			if (mid == null || mid.equals("")) {
				result = 0;
			}
			
			isForward = true;
			path = "index.jsp";
		}
		if (cmd.equals("login")) {
			MVO mvo = new MVO();
			
			mvo.setMid(request.getParameter("mid"));
			mvo.setMpw(request.getParameter("mpw"));
			
			String mid = mservice.logisS(mvo);
			
			session.setAttribute("mid", mid);
			
			if (mid == null || mid.equals("")) {
				result = 0;
			}
			
			isForward = true;
			path = "index.jsp";
		} if (cmd.equals("logout")) {
			session.removeAttribute("mid");
			isForward = true;
			path = "index.jsp";
		}
		
		request.setAttribute("result", result);
		
		if (isForward) {
			request.getRequestDispatcher(path).forward(request, response);
		} else {
			response.sendRedirect(path);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
