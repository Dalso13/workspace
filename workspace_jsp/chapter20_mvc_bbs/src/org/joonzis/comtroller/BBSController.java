package org.joonzis.comtroller;

import java.io.IOException;
import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joonzis.model.Paging;
import org.joonzis.model.Paging_hit;
import org.joonzis.service.BbsService;
import org.joonzis.service.BbsServiceImpl;
import org.joonzis.vo.BVO;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/BBSController")
public class BBSController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BBSController() {
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
		
		// 서비스 객체
		BbsService service = new BbsServiceImpl();
		
		// DML 값 리턴
		int result = -100;
		
		if (resultCmd.equals("allList")) {
			
			int count = service.getCount();
			
			Paging_hit page = new Paging_hit();
			String currentPage = request.getParameter("currentPage");
			Paging pvo = page.page(count,currentPage);
			
			
			Map<String, Integer> map = new HashMap<>();
			map.put("begin", pvo.getBegin());
			map.put("end", pvo.getEnd());
			
			List<BVO> list = service.getAll(map);
			
			request.setAttribute("list", list);
			request.setAttribute("pvo", pvo);
			
			isForward = true;
			path = "bbs/allList.jsp";
			
		} else if (resultCmd.equals("insert_page")) {
			path = "bbs/insert_page.jsp";
			
		} else if (resultCmd.equals("insert")) {
			
			BVO bvo = new BVO();
			
			String ip = Inet4Address.getLocalHost().getHostAddress(); // IPv4 ;
			// request.getRemoteAddr();  IPv6
			
			bvo.setWriter(request.getParameter("writer"));
			bvo.setIp(ip);  // 작성자 ip 값;
			bvo.setPw(request.getParameter("pw"));
			bvo.setTitle(request.getParameter("title"));
			bvo.setContent(request.getParameter("content"));
			bvo.setHit(0);
			bvo.setFilename("");
			
			
			result = service.getInsert(bvo);
			
			
			
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
