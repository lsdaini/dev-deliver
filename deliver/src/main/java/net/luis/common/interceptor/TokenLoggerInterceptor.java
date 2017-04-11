package net.luis.common.interceptor;


import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sun.jmx.snmp.Timestamp;


public class TokenLoggerInterceptor extends AbstractInterceptor{

	private static final long serialVersionUID = 1L;
    
    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        
        System.out.println("---------------------日志拦截器已经开始启动-------------------------");
        ActionContext ai = invocation.getInvocationContext();
        Map map = ai.getSession(); 
        String user = (String)map.get("no");
        HttpServletRequest req = ServletActionContext.getRequest();
        System.out.println(user+"---"+req.getRequestURI()+"---"+new Timestamp(System.currentTimeMillis()));
        return invocation.invoke();
    }
}
