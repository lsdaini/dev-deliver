package net.luis.common.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.xml.ws.Endpoint;

import net.luis.platform.webservice.impl.CommonWebServiceImpl;


/**
*@CreateTime：2017年3月29日 下午4:55:55
*@Author sai.liu
*@ProjectPackage：net.luis.common.listener.WebServiceListener.java
*@Description：使用监听来发布webservice服务
*/
@WebListener
public class WebServiceListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //WebService的发布地址
        String address = "http://localhost:8085/deliver/WebService";
        //发布WebService，WebServiceImpl类是WebServie接口的具体实现类
        Endpoint.publish(address , new CommonWebServiceImpl());
        System.out.println("使用WebServiceListener发布webservice成功!");
    }
}
