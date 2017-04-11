package net.luis.common.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import java.util.Map;

/**
 * @CreateTime：2017年3月28日 下午4:52:09
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.interceptor.LoginInterceptor.java 
 * @Description：
 */

public class LoginInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 4947198534136934514L;

	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = invocation.getInvocationContext();
		Map session = ctx.getSession();
		String user = (String) session.get("sessionCurrentUser");

		if (user != null) {
			return invocation.invoke();
		}
		ctx.put("tip", "你还没有登录");
		return "login";
	}
}
