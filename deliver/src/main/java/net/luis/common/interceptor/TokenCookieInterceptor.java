package net.luis.common.interceptor;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import net.luis.common.utils.RequestUtil;
import net.luis.common.utils.StringUtils;


public class TokenCookieInterceptor extends AbstractInterceptor {
	
	private static final long serialVersionUID = -9047205634689513002L;
	public static final String TOKEN_NAME = "token";
	public static final String TOKEN_NAME_REQUEST = "tokenRequest";
	public static final String TOKEN_COOKIE = "tokenCookie";
	public static final String TOKEN_COOKIE_MSG = "提交信息已过期, 请重新访问.";
	
	private static final  Logger logger = Logger.getLogger(TokenCookieInterceptor.class);
		
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		//重复提交检查
		ActionContext ac = invocation.getInvocationContext();
		
	    HttpServletRequest request = (HttpServletRequest) ac.get(ServletActionContext.HTTP_REQUEST);
	    HttpServletResponse response = (HttpServletResponse) ac.get(ServletActionContext.HTTP_RESPONSE);
	    
	    String token = request.getParameter(TOKEN_NAME);
	    String redirectUrl = "/errorpage/error-token-disable.jsp";
		Cookie tokenCookie = RequestUtil.getCookie(request, TOKEN_NAME);
		
		if (token == null || tokenCookie==null) {
			logger.error("token设置无效，请检查配置！");
			if (redirectUrl == null) {
				return TOKEN_COOKIE;
			} else {
				response.sendRedirect(URLDecoder.decode(redirectUrl,"utf-8") + "?msg=" + URLEncoder.encode(TOKEN_COOKIE_MSG,"utf-8"));
				return null;
			}
		}
		
		String invokeresult = null;
		if (!token.equals(tokenCookie.getValue())) {
			logger.warn("重复提交数据");
			if (redirectUrl == null) {
				return TOKEN_COOKIE;
			} else {
				response.sendRedirect(URLDecoder.decode(redirectUrl, "utf-8") + "?msg="
						+ URLEncoder.encode(TOKEN_COOKIE_MSG, "utf-8"));
				return null;
			}
		}
		String newToken = StringUtils.getToken();
		RequestUtil.setCookie(response, TokenCookieInterceptor.TOKEN_NAME, newToken, request.getContextPath());
		request.setAttribute(TOKEN_NAME_REQUEST, newToken);
	
		invokeresult = invocation.invoke();
        return invokeresult;
	}

}
