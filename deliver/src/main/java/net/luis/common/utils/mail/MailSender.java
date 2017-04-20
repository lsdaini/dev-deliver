package net.luis.common.utils.mail;

import java.io.File;
import java.util.Date;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Encoder;

/**
 * @CreateTime：2017年3月28日 下午4:56:44
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.utils.mail.MailSender.java 
 * @Description：
 */

public class MailSender extends Thread {
	private Log log = LogFactory.getLog(this.getClass());
	
	private Email mail;
	private static MailServerInfo server = null;
	private static Transport transport = null;
	private static Session session = null;
	private static Properties props = new Properties();
	private BodyPart messageBodyPart = null;
	private MimeMultipart multipart = null;
	private MimeMessage mailMessage = null;
	public static final int NORMAL = 0;
	public static final int AUTOREPLY = 1;
	private int mailFlag = 0;
	private String mailType;
	private String attachPath;

	public String getAttachPath() {
		return this.attachPath;
	}

	public void setAttachPath(String attachPath) {
		this.attachPath = attachPath;
	}

	public void setMail(Email obj, String mailType, int mailFlag) {
		this.mail = obj;
		this.mailType = mailType;
		this.mailFlag = mailFlag;
	}

	public void setMail(Email obj, String mailType) {
		this.mail = obj;
		this.mailType = mailType;
	}

	public MailSender() {

	}

	public void run() {
		if (this.mailFlag == 1)
			sendMail(this.mail, this.mailType);
	}

	public boolean sendMailWithNocheck(Email obj, String mailType) {
		init();
		this.log.info("===========this Email is going to be send==========");
		this.log.info(obj);

		if (MailSender.server == null) {
			this.log.error("发送邮件服务器没有设置！");
			return false;
		}
		if (obj == null) {
			this.log.error("邮件对象为空！");
			return false;
		}

		if (session == null)
			this.log.error("无法与邮件服务器建立连接");
		try {
			if (mailType.equals("text")) {
				this.mailMessage = new MimeMessage(session);
				mailMessage.addHeader("X-Priority", "1");
				InternetAddress from = new InternetAddress(obj.getFromAddr());
				from.setPersonal(obj.getSender());
				mailMessage.setFrom(from);
				mailMessage.addRecipients(Message.RecipientType.TO, convertToAddress(obj.getToAddr()));
				if (obj.getCcAddr() != null) {
					mailMessage.addRecipients(Message.RecipientType.CC, convertToAddress(obj.getCcAddr()));
				}
				if (obj.getBccAddr() != null) {
					mailMessage.addRecipients(Message.RecipientType.BCC, convertToAddress(obj.getBccAddr()));
				}
				BASE64Encoder enc = new BASE64Encoder();
				mailMessage.setSubject("=?UTF-8?B?" + enc.encode(obj.getSubject().getBytes("utf-8")) + "?=");
				mailMessage.setSentDate(obj.getSendTime());
				this.multipart = new MimeMultipart("related");

				this.messageBodyPart = new MimeBodyPart();
				this.messageBodyPart.setContent(obj.getContentText(), "text/plain;charset=UTF-8");
				this.multipart.addBodyPart(this.messageBodyPart);

				if (obj.getAttachment() != null) {
					File fil = new File(obj.getAttachment());
					MimeBodyPart mbp2 = new MimeBodyPart();
					FileDataSource fds = new FileDataSource(fil);
					mbp2.setDataHandler(new DataHandler(fds));
					mbp2.setFileName(MimeUtility.encodeText(fds.getName(), "UTF-8", "B"));
					this.multipart.addBodyPart(mbp2);
				}

				mailMessage.setContent(this.multipart);
				mailMessage.saveChanges();
				transport = session.getTransport(server.getProtocol());
				
				// smtp验证，就是你用来发邮件的邮箱用户名密码
				if(!transport.isConnected()){
					if("true".equals(server.getSmtpAuth())){
						transport.connect(server.getHost(),Integer.valueOf(server.getPort()), server.getMailFrom(), server.getPassword());
					}else{
						transport.connect();
					}
					System.out.println("mail connect success!");
				}
				transport.sendMessage(mailMessage,mailMessage.getAllRecipients());
				System.out.println("恭喜你，TEXT邮件已经成功发送!");
				this.log.info("恭喜你，TEXT邮件已经成功发送!");

				return true;
			}
			if (mailType.equals("html")) {
				this.mailMessage = new MimeMessage(session);

				BASE64Encoder enc = new BASE64Encoder();
				this.mailMessage.setSubject("=?UTF-8?B?" + enc.encode(obj.getSubject().getBytes("utf-8")) + "?=");
				this.mailMessage.setSentDate(new Date());
				this.mailMessage.setFrom(new InternetAddress(obj.getFromAddr()));
				this.mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(obj.getToAddr()));
				if (obj.getCcAddr() != null) {
					this.mailMessage.addRecipients(Message.RecipientType.CC, convertToAddress(obj.getCcAddr()));
				}
				if (obj.getBccAddr() != null) {
					this.mailMessage.addRecipients(Message.RecipientType.BCC, convertToAddress(obj.getBccAddr()));
				}

				this.multipart = new MimeMultipart("related");

				this.messageBodyPart = new MimeBodyPart();

				Transport.send(this.mailMessage);

				this.log.info("恭喜你，HTML邮件已经成功发送!");
				return true;
			}
			return false;
		} catch (AddressException e) {
			this.log.error("邮件地址不正确:", e);
			return false;
		} catch (MessagingException e) {
			this.log.error("邮件不正确:", e);
			return false;
		} catch (Exception e) {
			this.log.error("其他错误:", e);
		}
		return false;
	}

	public boolean sendMail(Email obj, String mailType) {
		if (!"1".equals(MailServerInfo.getInstance().getMailFlag().trim())) {
			return false;
		}
		return sendMailWithNocheck(obj, mailType);
	}

	private InternetAddress[] convertToAddress(String strAddr) throws AddressException {
		StringTokenizer tmp = new StringTokenizer(strAddr, ",; ");
		int count = tmp.countTokens();
		InternetAddress[] address = new InternetAddress[count];
		int i = 0;
		while (tmp.hasMoreTokens()) {
			address[i] = new InternetAddress(tmp.nextToken());
			i++;
		}
		return address;
	}
	//初始化方法
	public static void init() {
		if (server == null) {
			server = MailServerInfo.getInstance();
		}
		props.put("mail.stmp.host", server.getHost());
		props.put("mail.protocol", server.getProtocol());
		props.put("mail.stmp.auth", server.getSmtpAuth());
		props.put("mail.stmp.port", server.getPort());
		props.put("mail.stmp.user", server.getMailFrom());
		props.put("mail.stmp.password", server.getPassword());
		session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(MailSender.server.getMailFrom(),
						MailSender.server.getPassword());
			}
		});
		session.setDebug(true);
	}
}
