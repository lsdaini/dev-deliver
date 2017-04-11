package deliver;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;

import net.luis.common.utils.mail.Email;
import net.luis.common.utils.mail.MailSender;

/**
*@CreateTime：2017年3月31日 下午10:40:48
*@Author sai.liu
*@ProjectPackage：deliver.MailSendTest.java
*@Description：
*/
@RunWith(Log4jConfigurerRun.class)  
@ContextConfiguration(locations={"classpath:/config/applicationContext.xml"})  
public class MailSendTest {
	
	@Test
	public void searchTest(){
		MailSender ms = new  MailSender();
		Email email = new Email();
		email.setSendTime(new Date());
		email.setFromAddr("sai.liu@riking.net");
		email.setSender("sai.liu");
		email.setSubject("你好，中国！");
		email.setContentText("你好，中国！");
		email.setToAddr("2419131300@qq.com");
		ms.setMail(email, "1");
		ms.sendMail(email, "text");
	}

}
