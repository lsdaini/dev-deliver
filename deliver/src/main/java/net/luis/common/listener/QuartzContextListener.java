package net.luis.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.quartz.impl.StdScheduler;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@WebListener
public class QuartzContextListener implements ServletContextListener {  

	@Override  
    public void contextInitialized(ServletContextEvent sce) {  

    }
	
    @Override  
    public void contextDestroyed(ServletContextEvent sce) {  
    	WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());  
        StdScheduler startQuertz = (StdScheduler) webApplicationContext.getBean("getSchedulerFactoryBean");  
        if(startQuertz != null) {
            startQuertz.shutdown();  
        }
        try {
            Thread.sleep(1000);
        	System.out.println("---quartz定时任务线程:"+startQuertz.getSchedulerName()+"已经正常关闭!---");
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
    }  
}
