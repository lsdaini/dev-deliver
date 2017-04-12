package net.luis.common.listener;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @CreateTime：2017年3月28日 下午4:52:49
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.listener.ContextFinalizer.java 
 * @Description：用于处理数据库连接/关闭异常监听
 */

@WebListener
public class ContextFinalizer implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent sce) {
	}

	public void contextDestroyed(ServletContextEvent sce) {
		Enumeration drivers = DriverManager.getDrivers();
		Driver d = null;
		while (drivers.hasMoreElements())
			try {
				d = (Driver) drivers.nextElement();
				DriverManager.deregisterDriver(d);
				System.out.println(String.format("---数据库驱动连接已关闭:driver %s deregistered", new Object[] { d }));
			} catch (SQLException ex) {
				System.out.println(String.format("---数据库驱动连接关闭异常:error deregistering driver %s", new Object[] { d }) + ":" + ex);
			}
		try {
			AbandonedConnectionCleanupThread.shutdown();
		} catch (InterruptedException e) {
			System.out.println("---数据库驱动连接出现严重问题:severe problem cleaning up: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
