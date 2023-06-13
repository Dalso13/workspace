package org.joonzis.comtroller;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.joonzis.model.Download;
import org.joonzis.model.Paging;
import org.joonzis.model.Paging_hit;
import org.joonzis.service.BbsService;
import org.joonzis.service.BbsServiceImpl;
import org.joonzis.service.ComService;
import org.joonzis.service.ComServiceImpl;
import org.joonzis.vo.BVO;
import org.joonzis.vo.CVO;

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
		int result = -1;
		
		//b_idx 값
		int b_idx = 0;
		
		// session
		HttpSession session;
		
		// comment service 값
		ComService comService;
		
		// 파일 경로
		String realPath;
		
		if (resultCmd.equals("allList")) {
			// 전체 보기
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
			// 인설트
			realPath = request.getServletContext().getRealPath("/upload");
			
			MultipartRequest mr  = new MultipartRequest(
				request,
				realPath,
				1024 * 1024 * 10,	
				"utf-8",
				new DefaultFileRenamePolicy()
			);
			
			
			
			BVO bvo = new BVO();
			
			bvo.setWriter(mr.getParameter("writer"));
			bvo.setIp(Inet4Address.getLocalHost().getHostAddress());  // 작성자 ip 값;
			bvo.setPw(mr.getParameter("pw"));
			bvo.setTitle(mr.getParameter("title"));
			bvo.setContent(mr.getParameter("content"));
			bvo.setHit(0);
			
			if(mr.getFile("filename") != null){
				bvo.setFilename(mr.getFilesystemName("filename"));
			} else{
				bvo.setFilename("");
			}
			
			
			result = service.getInsert(bvo);
			
			
			
			isForward = true;
			path = "index.jsp";
		} else if (resultCmd.equals("view")) {
			// view
			b_idx =	Integer.parseInt(request.getParameter("b_idx"));
			
			BVO bvo = service.getView(b_idx);
			
			request.setAttribute("bvo", bvo);
			
			// 댓글 처리
			comService = new ComServiceImpl();
			
			List<CVO> cvo = comService.getComment(b_idx);
			
			request.setAttribute("cvo", cvo);
			
			isForward = true;
			path = "bbs/view.jsp";
			
			if (request.getParameter("cmd2") != null) {
				if (request.getParameter("cmd2").equals("update")) {
					path = "bbs/update_page.jsp";
				} else if (request.getParameter("cmd2").equals("remove")) {
					request.setAttribute("comment", request.getParameter("comment"));
					path = "bbs/remove_page.jsp";
				}
			}
			
			// 조회수 처리
			session = request.getSession();
			String open = (String)session.getAttribute("open");
			if(open == null){	// 처음 열었을때
				session.setAttribute("opne", "yes");
				int hit = bvo.getHit() + 1;
				bvo.setHit(hit);
				service.setHit(bvo);
			}
			
			
		} else if (resultCmd.equals("remove")) {
			// 삭제
			b_idx = Integer.parseInt(request.getParameter("b_idx"));
			
			if (request.getParameter("comment").equals("yes")) {
				comService = new ComServiceImpl();
				
				comService.removeAll(b_idx);
			}
			
			result = service.getRemove(b_idx);
			
			
					
			isForward = true;
			path = "index.jsp";
		} else if (resultCmd.equals("update")) {
			// 업데이트
			
			realPath = request.getServletContext().getRealPath("/upload");
			
			MultipartRequest mr  = new MultipartRequest(
				request,
				realPath,
				1024 * 1024 * 10,	
				"utf-8",
				new DefaultFileRenamePolicy()
			);
			
			BVO bvo = new BVO();
			
			bvo.setTitle(mr.getParameter("title"));
			bvo.setContent(mr.getParameter("content"));
			bvo.setB_idx(Integer.parseInt(mr.getParameter("b_idx")));
			bvo.setIp(Inet4Address.getLocalHost().getHostAddress());
			
			File newfile = mr.getFile("filename");
			String oldfile = mr.getParameter("oldfile");
			
			if(newfile != null){ // 새파일이 있을때
				if(oldfile != null){ // 기존파일이 있을때
					File removeFile = new File(realPath + "/" + oldfile);
					if(removeFile.exists()){ // 기존파일 유무 확인
						removeFile.delete();
					}
				}
				bvo.setFilename(newfile.getName());
			} else { // 새파일이 없을때
				if(oldfile != null){ // 기존파일이 있을때
					bvo.setFilename(oldfile);
				} else { // 기존파일이 없을때
					bvo.setFilename("");
				}
			}
			
			result = service.getUpdate(bvo);
			
			isForward = true;
			path = "index.jsp";
		} else if (resultCmd.equals("Download")) {
			/*
			 * String filename = request.getParameter("filename"); Download down = new
			 * Download(); filename = URLEncoder.encode(filename, "utf-8"); 
			 * String paths = request.getParameter("paths");
			 * 
			 * down.download(request,response,filename,paths); 
			 * path="index.jsp";
			 */
			
			
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
