package jp.co.sss.crud.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.sss.crud.bean.EmployeeBean;
@Component
public class AccountCheckFilter extends HttpFilter {
	@Override
	public void doFilter(HttpServletRequest request,HttpServletResponse response,FilterChain chain)throws IOException,ServletException{
		
		String requestURL=request.getRequestURI();
		
		if(requestURL.indexOf("/html/")!=-1||requestURL.indexOf("/css/")!=-1) {
			chain.doFilter(request,response);
			return;
		}
		
		HttpSession session=request.getSession();
		EmployeeBean loginUser=(EmployeeBean)session.getAttribute("loginUser");
		
		if(requestURL.contains("/regist") || requestURL.contains("/delete")){
			if(loginUser==null) {
				response.sendRedirect("/spring_crud/");
				session.invalidate();
				return ;
			}
			if(loginUser.getAuthority()==1) {
				response.sendRedirect("/spring_crud/");
				session.invalidate();
				return;
			} chain.doFilter(request, response);
		} else{
			chain.doFilter(request, response);
		}
	}
}
	