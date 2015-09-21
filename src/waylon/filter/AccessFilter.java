package waylon.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AccessFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) arg0;
		StringBuffer requestURI = request.getRequestURL();
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpSession session = request.getSession();
		String  token = (String)session.getAttribute("token");
		
		
		if(requestURI.indexOf("/loginValidate.action")>-1){
			arg2.doFilter(arg0, arg1);
			return;
		}else if(token == null){
			//response.sendRedirect("/loginValidate.action");
			System.out.println(requestURI);
			//return;
		}else{
			System.out.println("the value of token is:"+token);
			//arg2.doFilter(arg0, arg1);
		}
		
		arg2.doFilter(arg0, arg1);
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}



}
