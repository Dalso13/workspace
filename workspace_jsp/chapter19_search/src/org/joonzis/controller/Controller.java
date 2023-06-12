package org.joonzis.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joonzis.service.EmployeeService;
import org.joonzis.service.EmployeeServiceLmpl;
import org.joonzis.vo.EmployeeVO;

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
		
		
		// 서비스 객체 생성
		EmployeeService service = new EmployeeServiceLmpl();
		
		
		List<EmployeeVO> result;	
		
		if (resultCmd.equals("allList")) {
			// DB 사용
			result = service.getAll();
			request.setAttribute("result", result);
			isForward = true;
			path = "allList.jsp";
			
		} else if (resultCmd.equals("inputDept")) {
			// 단순 화면 이동
			path = "input_dept.jsp";
			
			
		} else if (resultCmd.equals("deptList")) {
			//DB 사용
			int department_id = Integer.parseInt(request.getParameter("department_id"));
			
			result = service.getDept(department_id);
			request.setAttribute("result", result);
			isForward = true;
			path = "deptList.jsp";
			
		} else if (resultCmd.equals("inputDynamic")) {
			path = "input_dynamic.jsp";
			
		} else if (resultCmd.equals("dynamicList")) {
			//DB 사용
			Map<String, String> map = new HashMap<String, String>();
			String key = request.getParameter("key");
			String value = request.getParameter("value");
			
			map.put("key", key);
			map.put("value", value);
			
			result = service.sDynamicList(map);
			request.setAttribute("key", key);
			request.setAttribute("result", result);
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
