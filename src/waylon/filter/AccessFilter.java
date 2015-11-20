package waylon.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.User;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import waylon.domain.TokenInfo;
import waylon.service.TokenInfoService;

public class AccessFilter implements Filter {
	
	
	private TokenInfoService tokenInfoService;
	
	private WebApplicationContext wac;
	

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
		String token = request.getParameter("token");
		TokenInfo tokenInfo = tokenInfoService.getTokenInfoByMobile(request.getParameter("mobile"));
		if(tokenInfo!= null && tokenInfo.getTokenValue().equals(token)){
			arg2.doFilter(arg0, arg1);
		}else{
			request.setAttribute("tokenStatus", "NO");
			arg2.doFilter(arg0, arg1);
		}
		/*if(requestURI.indexOf("/loginValidate.action")>-1||requestURI.indexOf("/getProductInfo.action")>-1){
			arg2.doFilter(arg0, arg1);
			//return;
		}else{
			request.setAttribute("tokenStatus", "NO");
			arg2.doFilter(arg0, arg1);
		}*/
			
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		ServletContext sc = arg0.getServletContext(); 
		WebApplicationContext wac = (WebApplicationContext) sc.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE); 
		//获得WebApplicationContext还可以调用 //WebApplicationContextUtils.getWebApplicationContext(sc); 
		//当然最后Spring都是调用getAttribute方法. 
		this.tokenInfoService = (TokenInfoService) wac.getBean("tokenInfoService"); 
		
	}

	public TokenInfoService getTokenInfoService() {
		return tokenInfoService;
	}

	public void setTokenInfoService(TokenInfoService tokenInfoService) {
		this.tokenInfoService = tokenInfoService;
	}



}
