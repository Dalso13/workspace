package org.joonzis.comtroller;

import java.io.IOException;
import java.net.Inet4Address;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joonzis.service.ComService;
import org.joonzis.service.ComServiceImpl;
import org.joonzis.vo.CVO;

@WebServlet("/CommentController")
public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CommentController() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmd = request.getParameter("cmd");
		String resultCmd = null;
		
		if (cmd != null && !cmd.isEmpty()) {
			resultCmd = cmd;
		}
		
		// 단순 화면 이동 / 데이터 사용 구분 // true면 포워드 false면 리다이렉트
		boolean isForward = false;
		// 이동 경로
		String path = "";
		
		//댓글 서비스
		ComService comService = new ComServiceImpl();
		
		//
		int b_idx;
		if (resultCmd.equals("insertComment")) {
			CVO cvo = new CVO();
			
			b_idx = Integer.parseInt(request.getParameter("b_idx"));
			
			
			cvo.setWriter(request.getParameter("writer"));
			cvo.setContent(request.getParameter("content"));
			cvo.setPw(request.getParameter("pw"));
			cvo.setIp(Inet4Address.getLocalHost().getHostAddress());
			cvo.setB_idx(b_idx);
			
			
			comService.inCommnet(cvo);
			
			path = "/chapter20_mvc_bbs/BBSController?cmd=view&b_idx="+b_idx+"&currentPage="+request.getParameter("currentPage");
			
		} else if (resultCmd.equals("removeComment")) {
			int c_idx = Integer.parseInt(request.getParameter("c_idx"));
			b_idx = Integer.parseInt(request.getParameter("b_idx"));
			
			
			comService.removeComment(c_idx);
			
			path = "/chapter20_mvc_bbs/BBSController?cmd=view&b_idx="+b_idx+"&currentPage="+request.getParameter("currentPage");
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
