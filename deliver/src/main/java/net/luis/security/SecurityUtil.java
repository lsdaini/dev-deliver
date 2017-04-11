package net.luis.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

/**
 * @CreateTime：2017年3月28日 下午5:05:02
 * @Author sai.liu
 * @ProjectPackage：net.luis.security.SecurityUtil.java @Description：
 */

public final class SecurityUtil {
	public static Authentication getAuth() {
		SecurityContext ctx = SecurityContextHolder.getContext();
		return ctx.getAuthentication();
	}

	public static WebAuthenticationDetails getWebAuthenticationDetails() {
		SecurityContext ctx = SecurityContextHolder.getContext();
		return (WebAuthenticationDetails) ctx.getAuthentication().getDetails();
	}

	public static String getIp() {
		SecurityContext ctx = SecurityContextHolder.getContext();
		WebAuthenticationDetails authDetails = (WebAuthenticationDetails) ctx.getAuthentication().getDetails();
		return authDetails.getRemoteAddress();
	}
}
