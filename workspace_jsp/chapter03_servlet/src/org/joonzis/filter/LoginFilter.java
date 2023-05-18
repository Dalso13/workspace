package org.joonzis.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/private/*")
public class LoginFilter implements Filter{
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)	// 여거는 서블릿만을위한 값들, 안들어가있음
			throws IOException, ServletException {
		
		System.out.println("로그인 필터 확인");
		
		// 1. 로그인된 클라이언트인지 확인(HttpSession 필요 => HttpServletRequest 필요)	// 형변환을 해줌으로써 사용하는게 가능해짐
		HttpServletRequest req = (HttpServletRequest)request;		// HttpServletRequest 는 서버간 통신하면서 생기는 데이터라 사용하는게 가능
		HttpSession session = req.getSession();						// HttpServletRequest 에는 세션이 담겨있어서 세션을 사용가능
		
		String id = (String)session.getAttribute("id");
		String pw = (String)session.getAttribute("pw");
		
		if (id != null && pw != null) {
			chain.doFilter(request, response);		// 이게 실행되면 정상적으로 흐름
		} else {
			HttpServletResponse rep = (HttpServletResponse)response;	// ServletResponse도 위와 같은 이유로 형변환
			String cPath = req.getContextPath();	// 페이지 실행을 위한 텍스트 정보 
			rep.sendRedirect(cPath + "/login/loginForm.jsp");	// 리다이렉트로 이동
		}
		
		
	}
	
	@Override
	public void destroy() {
	}
}
