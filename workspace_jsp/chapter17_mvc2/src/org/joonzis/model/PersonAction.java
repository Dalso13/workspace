package org.joonzis.model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.joonzis.vo.PersonVO;

public class PersonAction {
	public String process(HttpServletRequest request) {
		
		// 파리미터들 가져오기
		
		String name = request.getParameter("name");
		String age = request.getParameter("age");
		String phone = request.getParameter("phone");
		String addr = request.getParameter("addr");
		String self = request.getParameter("self");
		
		// 1. request 객체에 저장
		request.setAttribute("name", name);
		request.setAttribute("age", age);
		request.setAttribute("phone", phone);
		request.setAttribute("addr", addr);
		request.setAttribute("self", self);
		
		// 2. session 객체에 저장
		// session은 jsp의 내장객체라서 바로 사용할 수 없다.
		// java에서는 request를 통해서 session을 가져온다 (getSession() 이용)
		// ******* request와 session에 담기는 속성명을 같게 한다!!!********
		// session에 담을 때에는 결과를 확인하기 위해서 "session's " 명칭을 붙여보자
		
		HttpSession session = request.getSession();
		session.setAttribute("name","session's " + name);
		session.setAttribute("age","session's "+ age);
		session.setAttribute("phone","session's "+ phone);
		session.setAttribute("addr","session's "+ addr);
		session.setAttribute("self","session's "+ self);
		
		
		
		// 3. VO에 저장
		PersonVO vo = new PersonVO();
		
		vo.setName(name);
		vo.setAge(age);
		vo.setPhone(phone);
		vo.setAddr(addr);
		vo.setSelf(self);
		
		session.setAttribute("vo",vo);
		
		// 4. Map 에 저장
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("name", name);
		map.put("age", age);
		map.put("phone", phone);
		map.put("addr", addr);
		map.put("self", self);
		
		session.setAttribute("map",map);
		
		return "view/output.jsp";
	}
}
