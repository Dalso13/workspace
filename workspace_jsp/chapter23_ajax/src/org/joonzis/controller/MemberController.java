package org.joonzis.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.joonzis.dto.MemberDTO;
import org.joonzis.service.memService;
import org.joonzis.service.memServiceImpl;


@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String cmd = request.getParameter("cmd");
		
		
		memService ms = new memServiceImpl();
		List<MemberDTO> list = ms.getMemberList();
		
		PrintWriter out = response.getWriter();  // response 가 다시 index.jsp로 리턴
		String result = "";
		StringBuffer sb = new StringBuffer();
		
		if (cmd.equals("csv")) {
			
			for (MemberDTO dto : list) {
				sb.append(dto.getMidx() + ",");
				sb.append(dto.getMid() + ",");
				sb.append(dto.getmPw() + ",");
				sb.append(dto.getmName() + ",");
				sb.append(dto.getmEmail() + ",");
				sb.append(dto.getmPhone() + ",");
				sb.append(dto.getmAddr() + "/");
			}
			result = sb.toString().substring(0, sb.toString().length()-1);
			
		} else if (cmd.equals("xmlTag")){
			
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<!DOCTYPE members>");
			sb.append("<members>");
			for (MemberDTO dto : list) {
				sb.append("<member>");
				sb.append("<idx>" + dto.getMidx() + "</idx>");
				sb.append("<id>" + dto.getMid() + "</id>");
				sb.append("<pw>" + dto.getmPw() + "</pw>");
				sb.append("<name>" + dto.getmName() + "</name>");
				sb.append("<email>" + dto.getmEmail() + "</email>");
				sb.append("<phone>" + dto.getmPhone() + "</phone>");
				sb.append("<addr>" + dto.getmAddr() + "</addr>");
				sb.append("</member>");
			}
			sb.append("</members>");
			
			result = sb.toString();
		} else if (cmd.equals("xmlProp")) {
			
			sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
			sb.append("<!DOCTYPE members>");
			sb.append("<members>");
			for (MemberDTO dto : list) {  // 띄어쓰기 주의
				sb.append(" <member");
				sb.append(" idx = '" + dto.getMidx() +"'");
				sb.append(" id = '" + dto.getMid() +"'");
				sb.append(" pw = '" + dto.getmPw() +"'");
				sb.append(" name = '" + dto.getmName() +"'");
				sb.append(" email = '" + dto.getmEmail() +"'");
				sb.append(" phone = '" + dto.getmPhone() +"'");
				sb.append(" addr = '" + dto.getmAddr() +"'");
				sb.append(" /> ");
			}
			sb.append(" </members>");
			
			result = sb.toString();
		} else if (cmd.equals("JSON")) {
			// [{},{},{},{}]
			sb.append("[");
			
			
			for (MemberDTO dto : list) {  // 띄어쓰기 주의
				sb.append("{\"idx\": \""+dto.getMidx() + "\" , ");
				sb.append("\"id\": \""+dto.getMid() + "\", ");
				sb.append("\"pw\": \""+dto.getmPw() + "\", ");
				sb.append("\"name\" :\""+dto.getmName() + "\", ");
				sb.append("\"email\" :\""+dto.getmEmail() + "\", ");
				sb.append("\"phone\" :\""+dto.getmPhone() + "\", ");
				sb.append("\"addr\" :\""+dto.getmAddr() + "\"}, ");
			}
			result = sb.toString().substring(0, sb.toString().length()-2);
			result += "]";
			
		}
		
		
		out.println(result);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
