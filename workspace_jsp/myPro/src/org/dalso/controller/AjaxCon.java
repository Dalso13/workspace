package org.dalso.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.dalso.service.Table_service;
import org.dalso.service.Table_serviceImpl;
import org.dalso.service.User_service;
import org.dalso.service.User_serviceImpl;
import org.dalso.vo.CVO;
import org.dalso.vo.TitleVO;
import org.dalso.vo.UVO;
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
		Table_service ts = new Table_serviceImpl();
		
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
		 } else if (cmd.equals("title_match")) {
			 
			int result = ts.title_match(request.getParameter("title"));
			
					
			out.println(result+"");
			
		}  else if (cmd.equals("delete_page")) {
			// cvo를 쓰면 헷갈리겠지만 안쓰고 다른걸 만들기엔 낭비가 심해서
			// 헷갈리더라도 cvo를 쓰자
			
			
			CVO cvo = new CVO();
		
			cvo.setC_writer(request.getParameter("t_writer"));
			cvo.setT_idx(Integer.parseInt(request.getParameter("t_idx")));
			
	
			
			int result = ts.remove_page(cvo);
			
			out.println(result+"");
		}
	
	} 


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
