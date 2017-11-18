package deliver;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import net.luis.activemq.JMSSender;

/**
* Created by sai.liu on 2017年4月29日  下午8:43:49
* deliver.ActiveMQTest.java
*@Description：
*/

@RunWith(Log4jConfigurerRun.class)  
@ContextConfiguration(locations={"classpath:/config/spring-activemq.xml"})  
public class ActiveMQTest {
	
    @Test  
    public void testSend() {
    	JMSSender jmsSender = new JMSSender();
        for (int i=0; i<2; i++) {
        	jmsSender.simpleSend("你好，生产者！这是消息：" + (i+1));  
        }  
    }  
}
