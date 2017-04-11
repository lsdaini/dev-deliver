package net.luis.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public final class RequestUtil {
	private static final Logger logger = Logger.getLogger(RequestUtil.class);

	private RequestUtil() {
		
	}

	public static void setCookie(HttpServletResponse response, String name, String value, String path) {

		Cookie cookie = null;
		try {
			cookie = new Cookie(name, URLEncoder.encode(value, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return;
		}
		cookie.setSecure(false);
		// cookie.setDomain(DataConstants.domain);
		cookie.setPath(path);
		cookie.setMaxAge(-1);

		response.addCookie(cookie);
	}

	public static Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		Cookie returnCookie = null;

		if (cookies == null) {
			return returnCookie;
		}
		for (final Cookie thisCookie : cookies) {
			if (thisCookie.getName().equals(name) && !"".equals(thisCookie.getValue())) {
				returnCookie = thisCookie;
				break;
			}
		}

		return returnCookie;
	}

	public static void deleteCookie(HttpServletResponse response, Cookie cookie, String path) {
		if (cookie != null) {
			// Delete the cookie by setting its maximum age to zero
			// cookie.setValue(null);
			cookie.setMaxAge(0);
			// cookie.setDomain(DataConstants.domain);
			cookie.setPath(path);
			response.addCookie(cookie);
		}
	}

	public static String getAppURL(HttpServletRequest request) {
		if (request == null)
			return "";

		StringBuffer url = new StringBuffer();
		int port = request.getServerPort();
		if (port < 0) {
			port = 80; // Work around java.net.URL bug
		}
		String scheme = request.getScheme();
		url.append(scheme);
		url.append("://");
		url.append(request.getServerName());
		if ((scheme.equals("http") && (port != 80)) || (scheme.equals("https") && (port != 443))) {
			url.append(':');
			url.append(port);
		}
		url.append(request.getContextPath());
		return url.toString();
	}

}
