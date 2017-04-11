package net.luis.common.listener;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import net.luis.common.utils.Constants;
import net.luis.system.model.User;

/**
 * @CreateTime：2017年3月28日 下午4:53:30
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.listener.SessionListener.java 
 * @Description：用户登录session的监听
 */

@WebListener
public class SessionListener implements HttpSessionAttributeListener, HttpSessionListener, Constants {
	
	public static Map<HttpSession, User> loginUser = new HashMap();
	public static String SESSION_LOGIN_NAME = "sessionCurrentUser";

	public void sessionCreated(HttpSessionEvent arg0) {
	}

	public void sessionDestroyed(HttpSessionEvent se) {
		try {
			loginUser.remove(se.getSession());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void attributeAdded(HttpSessionBindingEvent se) {
		if (se.getName().equals(SESSION_LOGIN_NAME))
			loginUser.put(se.getSession(), (User) se.getValue());
	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		if (se.getName().equals(SESSION_LOGIN_NAME))
			try {
				loginUser.remove(se.getSession());
			} catch (Exception localException) {
			}
	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		if (se.getName().equals(SESSION_LOGIN_NAME))
			loginUser.put(se.getSession(), (User) se.getValue());
	}
}