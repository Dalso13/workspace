package org.joonzis.model;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

public class Now {
	public String process(HttpServletRequest request) {
		// 매개변수로 리퀘스트를 받는 이유
		// 자바와 jsp는 영역이 다르기에
		// jsp에서 서블릿으로 넘길때 받는 리퀘스트를 매개변수로 넘겨줘 
		// 기존 jsp에서 쓰던 리퀘스트를 매개변수로 받아서 그 매개변수에 저장하는것
		// 안써주면 자바에서만 쓸수있는 리퀘스트에 담겨짐
		// session에 써주면 걍 해결되지만 좋은 습관은 아님
	
		Calendar cal = Calendar.getInstance();
		
		int h = cal.get(Calendar.HOUR);
		int m = cal.get(Calendar.MINUTE);
		int s = cal.get(Calendar.SECOND);
		
		String now = h + "시 " + m + "분 " + s + "초 ";
		
		request.setAttribute("now", now);
		
		return "view/output.jsp";
	}
}
