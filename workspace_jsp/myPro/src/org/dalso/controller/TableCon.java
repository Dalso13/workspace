package org.dalso.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.dalso.service.Table_service;
import org.dalso.service.Table_serviceImpl;
import org.dalso.vo.SearchVO;
import org.dalso.vo.TVO;
import org.dalso.vo.TitleVO;
import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/TableCon")
public class TableCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public TableCon() {
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
		
		
		HttpSession session = request.getSession();
		
		Table_service ts = new Table_serviceImpl();

		if(cmd.equals("main")) {
			List<TitleVO> tv = ts.dao_title();
			
			
			
			
			
			session.setAttribute("tv", tv);
			isForward = true;
			path = "main/main.jsp";
			
			
			
		} else if (cmd.equals("insert_page")) {
			path = "paper/insert.jsp";
		} else if (cmd.equals("insert")) {
			
			TVO tvo = new TVO();
			
			String realPath = request.getServletContext().getRealPath("/image");
			
			
			MultipartRequest mr  = new MultipartRequest(
				request,
				realPath,
				1024 * 1024 * 10,	
				"utf-8",
				new DefaultFileRenamePolicy()
			);
			
			tvo.setT_writer(mr.getParameter("t_writer"));
			tvo.setTitle(mr.getParameter("title"));
			tvo.setFirst_c_title(mr.getParameter("first_c_title"));
			tvo.setFirst_c(mr.getParameter("first_c"));
			tvo.setSecond_c_title(mr.getParameter("second_c_title"));
			tvo.setSecond_c(mr.getParameter("second_c"));
			tvo.setThird_c_title(mr.getParameter("third_c_title"));
			tvo.setThird_c(mr.getParameter("third_c"));
			tvo.setHit(0);
			tvo.setCartegory(mr.getParameter("cartegory"));
			tvo.setSemi_cartegory(mr.getParameter("semi_cartegory"));
			
			
			if(mr.getFile("emage") != null){
				tvo.setEmage(mr.getFilesystemName("emage"));
			} else{
				tvo.setEmage("");
			}
			
			int result = ts.dao_table(tvo);
			
			
			path = "start.jsp";

		}  else if (cmd.equals("select")) {
			String title = request.getParameter("title");
			
			
			// 조회수를 쿠키로 처리해보기
			  TVO tvo = ts.select_table(request.getParameter("title"));
			  Cookie cook = null;
			  Cookie cookies[] = request.getCookies();
			  
			  if (cookies != null && cookies.length > 0){ 
				  for (Cookie cookie : cookies) {
					  if (cookie.getValue().equals(title)) {
						  cook = cookie;
					  } 
				  } 
			  }
			
			if (cook == null || (cookies == null && cookies.length <= 0)) {
				String t_idx = tvo.getT_idx()+"";
				
				Cookie ck = new Cookie(t_idx, title);
				ck.setMaxAge(60 * 10);  
				int hit = tvo.getHit();
				tvo.setHit(hit+1); 
				ts.update_hit(tvo);
				
				response.addCookie(ck); 
			}
				 

			request.setAttribute("tvo", tvo);
			
			isForward = true;
			path = "paper/Table.jsp";
		} else if (cmd.equals("find")) {
			List<SearchVO> svo = ts.select_list(request.getParameter("search"));
			
			request.setAttribute("svo", svo);
			
			isForward = true;
			path = "paper/search.jsp";
		} else if (cmd.equals("cart_table")) {
			List<SearchVO> svo = ts.select_list(request.getParameter("semi_cartegory"));
			
			request.setAttribute("svo", svo);
			
			isForward = true;
			path = "paper/search.jsp";
		}else if (cmd.equals("logout")) {
			session.removeAttribute("uvo");
			
			path = "start.jsp";
		}   else if (cmd.equals("update_page")) {
			
			TVO tvo = ts.select_table(request.getParameter("title"));
			
			request.setAttribute("tvo", tvo);
			
			isForward = true;
			path = "paper/update_page.jsp";
		} else if (cmd.equals("update")) {
			TVO tvo = new TVO();
			
			String realPath = request.getServletContext().getRealPath("/image");
			
			
			MultipartRequest mr  = new MultipartRequest(
				request,
				realPath,
				1024 * 1024 * 10,	
				"utf-8",
				new DefaultFileRenamePolicy()
			);
			
			
			tvo.setT_idx(Integer.parseInt(mr.getParameter("t_idx")));
			tvo.setTitle(mr.getParameter("title"));
			tvo.setFirst_c_title(mr.getParameter("first_c_title"));
			tvo.setFirst_c(mr.getParameter("first_c"));
			tvo.setSecond_c_title(mr.getParameter("second_c_title"));
			tvo.setSecond_c(mr.getParameter("second_c"));
			tvo.setThird_c_title(mr.getParameter("third_c_title"));
			tvo.setThird_c(mr.getParameter("third_c"));
			
			
			if(mr.getFile("next_emage") != null && mr.getParameter("emage") != null){
				tvo.setEmage(mr.getFilesystemName("next_emage"));
			} else if(mr.getFile("next_emage") == null && mr.getParameter("emage") != null){
				tvo.setEmage(mr.getParameter("emage"));
			} else {
				tvo.setEmage("");
			}
			
			int result = ts.dao_update(tvo);
			
			request.setAttribute("result", result);
			isForward = true;
			path = "paper/result.jsp";
			
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
