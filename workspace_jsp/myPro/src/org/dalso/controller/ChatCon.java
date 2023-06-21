package org.dalso.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.dalso.service.Chat_service;
import org.dalso.service.Chat_serviceImpl;
import org.dalso.vo.CVO;


@WebServlet("/ChatCon")
public class ChatCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ChatCon() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		
		String cmd = request.getParameter("cmd");
		PrintWriter out = response.getWriter();
		
		Chat_service cs = new Chat_serviceImpl();
		
		if (cmd.equals("insert_comment")) {
			CVO cvo = new CVO();
			cvo.setC_writer(request.getParameter("c_writer"));	
			cvo.setC_pw(request.getParameter("c_pw"));
			cvo.setContent(request.getParameter("content"));
			cvo.setT_idx(Integer.parseInt(request.getParameter("t_idx")));
			
			
			int result = cs.insert_c(cvo);
			String res = result + "";
			
			out.println(res);
			
		} else if (cmd.equals("select_comment")) {
			int t_idx = Integer.parseInt(request.getParameter("t_idx"));
			
			
			List<CVO> cvo = cs.select_c(t_idx);
			
			
			
			StringBuffer str = new StringBuffer();
			
			str.append("[");
			
			
			
			String result = "";
			
			if (cvo.isEmpty()) {
				result = "{\"c_idx\":\"-1\"}";
				
				
			} else {
				for (CVO cvo2 : cvo) {
					str.append("{\"c_idx\": \""+cvo2.getC_idx() + "\" , ");
					str.append("\"c_writer\": \""+cvo2.getC_writer() + "\", ");
					str.append("\"comment\": \""+cvo2.getContent() + "\"} ,");
				}
				
				result = str.toString().substring(0, str.toString().length()-1);
				result += "]";
			} 
			

			
			out.println(result);
			
		} else if (cmd.equals("remove")){
			CVO cvo = new CVO();
			
			
			cvo.setC_idx(Integer.parseInt(request.getParameter("c_idx")));
			cvo.setC_writer(request.getParameter("c_witer"));
			cvo.setC_pw(request.getParameter("c_pw"));
			
			int result = cs.remove_chat(cvo);
			
			out.print(result+"");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
