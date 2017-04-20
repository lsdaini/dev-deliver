package net.luis.common.utils.mail;

import java.io.File;
import java.io.IOException;
import java.util.Properties;
import org.springframework.core.io.ClassPathResource;

/**
 * @CreateTime：2017年3月28日 下午4:57:18
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.utils.mail.MailServerInfo.java 
 * @Description：
 */

public class MailServerInfo {
	
	private String host; //mail服务地址
	private String protocol; //mail协议
	private String userId; //用户名
	private String password; //密码
	private String smtpAuth; //是否验证
	private String mailFrom; //用户邮箱名
	private String mailFlag; //是否发送	0：不发送	1：发送
	private int port; //邮件端口
	private static MailServerInfo instance = null;

	public static synchronized MailServerInfo getInstance() {
		if (instance == null) {
			instance = new MailServerInfo();
			instance.init();
		}
		return instance;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getProtocol() {
		return this.protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSmtpAuth() {
		return this.smtpAuth;
	}

	public void setSmtpAuth(String smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMailFrom() {
		return this.mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailFlag() {
		return this.mailFlag;
	}

	public void setMailFlag(String mailFlag) {
		this.mailFlag = mailFlag;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	private void init() {
		Properties properties = null;
		try {
			properties = new Properties();
			properties.load(new ClassPathResource("properties" + File.separator + "mailserver.properties").getInputStream());
			this.setHost(properties.getProperty("mail.stmp.host", "smtp.263.net"));
			this.setPort(Integer.valueOf(properties.getProperty("mail.stmp.port", "25")));
			this.setProtocol(properties.getProperty("mail.protocol", "smtp"));
			this.setSmtpAuth(properties.getProperty("mail.stmp.auth", "true"));
			this.setUserId(properties.getProperty("login_id", "lsdaini"));
			this.setMailFrom(properties.getProperty("mail.stmp.user", "sai.liu@riking.net"));
			this.setPassword(properties.getProperty("mail.stmp.password", "000000"));
			this.setMailFlag(properties.getProperty("mail.flag", "1"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}