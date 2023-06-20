package org.dalso.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dalso.service.Chat_service;
import org.dalso.service.Chat_serviceImpl;
import org.dalso.service.User_service;
import org.dalso.service.User_serviceImpl;
import org.dalso.vo.CVO;
import org.dalso.vo.TitleVO;
import org.json.simple.JSONObject;

@WebServlet("/AjaxCon")
public class AjaxCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public AjaxCon() {
        super();
       
    }

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		
		String cmd = request.getParameter("cmd");
		PrintWriter out = response.getWriter();
		
		if (cmd.equals("title")) {
			List<TitleVO> tv = (List<TitleVO>)session.getAttribute("tv");
		
			
			
	
			
			List<String> tvo = new ArrayList<String>();
			
			if (!tv.isEmpty()) {
				for (TitleVO titleVO : tv) {
					String num = "{\""+"title\":\""+titleVO.getTitle() +"\" , " + "\"cartegory\""+":\""+titleVO.getCartegory()+"\"}";
					tvo.add(num);
				}
			}
			
			
			out.println(tvo.toString());
			
		} else if (cmd.equals("getid")) {
			
			User_service us = new User_serviceImpl();
			String joinId = request.getParameter("id");
			
			if (joinId.equals(null)||joinId.isEmpty()) {
				out.println("{" + "\"userId\":" + "\"-1" + "\"}");
			} else {
				int id = us.joinId(joinId);
			
				String result = "{" + "\"userId\":" + "\""+ id + "\"}";
	

			
				out.println(result);
			}
		} else if (cmd.equals("insert_comment")) {
			CVO cvo = new CVO();
			cvo.setC_writer(request.getParameter("c_writer"));	
			cvo.setC_pw(request.getParameter("c_pw"));
			cvo.setContent(request.getParameter("content"));
			cvo.setT_idx(Integer.parseInt(request.getParameter("t_idx")));
			
			Chat_service cs = new Chat_serviceImpl();
			
			int result = cs.insert_c(cvo);
			String res = result + "";
			
			out.println(res);
			
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
