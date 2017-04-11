package net.luis.common.utils.mail;

import java.io.File;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Vector;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @CreateTime：2017年3月28日 下午4:56:09
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.utils.mail.Email.java 
 * @Description：
 */

public class Email implements Serializable {
	private static final long serialVersionUID = 2800189504447483257L;
	
	private String sender;
	private String receiver;
	private String subject;
	private String fromAddr;
	private String toAddr;
	private String ccAddr;
	private String bccAddr;
	private String contentText;
	private String contentHtml;
	private Date sendTime;
	private Date acceptTime;
	private String attachment;
	private String emlFileName;
	private Vector<File> attachments;

	public void setSender(String sender) {
		if (sender == null)
			this.sender = "";
		else
			this.sender = sender.trim();
	}

	public String getSender() {
		return this.sender;
	}

	public Timestamp getBeginTime() {
		return null;
	}

	public void setBeginTime(Timestamp obj) {
	}

	public void setReceiver(String receiver) {
		if (receiver == null)
			this.receiver = "";
		else
			this.receiver = receiver.trim();
	}

	public String getReceiver() {
		return this.receiver;
	}

	public void setSubject(String subject) {
		if (subject == null)
			this.subject = "";
		else
			this.subject = subject.trim();
	}

	public String getSubject() {
		return this.subject;
	}

	public void setFromAddr(String fromAddr) {
		if (fromAddr == null)
			this.fromAddr = "";
		else
			this.fromAddr = fromAddr.trim();
	}

	public String getFromAddr() {
		return this.fromAddr;
	}

	public void setToAddr(String toAddr) {
		if (toAddr == null)
			this.toAddr = "";
		else
			this.toAddr = toAddr.trim();
	}

	public String getToAddr() {
		return this.toAddr;
	}

	public void setCcAddr(String ccAddr) {
		if (ccAddr == null)
			this.ccAddr = "";
		else
			this.ccAddr = ccAddr.trim();
	}

	public String getCcAddr() {
		return this.ccAddr;
	}

	public void setBccAddr(String bccAddr) {
		if (bccAddr == null)
			this.bccAddr = "";
		else
			this.bccAddr = bccAddr.trim();
	}

	public String getBccAddr() {
		return this.bccAddr;
	}

	public void setContentText(String contentText) {
		if (contentText == null)
			this.contentText = "";
		else
			this.contentText = contentText.trim();
	}

	public String getContentText() {
		return this.contentText;
	}

	public void setContentHtml(String contentHtml) {
		if (contentHtml == null)
			this.contentHtml = "";
		else
			this.contentHtml = contentHtml.trim();
	}

	public String getContentHtml() {
		return this.contentHtml;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getSendTime() {
		return this.sendTime;
	}

	public void setAcceptTime(Date acceptTime) {
		this.acceptTime = acceptTime;
	}

	public Date getAcceptTime() {
		return this.acceptTime;
	}

	public void setAttachment(String attachment) {
		if (attachment == null)
			this.attachment = "";
		else
			this.attachment = attachment;
	}

	public String getAttachment() {
		return this.attachment;
	}

	public void setEmlFileName(String emlFileName) {
		if (emlFileName == null)
			this.emlFileName = "";
		else
			this.emlFileName = emlFileName.trim();
	}

	public String getEmlFileName() {
		return this.emlFileName;
	}

	public Vector<File> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(Vector<File> attachments) {
		this.attachments = attachments;
	}

	public void validate() {
		if ((this.sender != null) && (this.sender.length() > 100)) {
			this.sender = this.sender.substring(0, 100);
		}
		if ((this.receiver != null) && (this.receiver.length() > 100)) {
			this.receiver = this.receiver.substring(0, 100);
		}
		if ((this.subject != null) && (this.subject.length() > 500)) {
			this.subject = this.subject.substring(0, 500);
		}
		if ((this.fromAddr != null) && (this.fromAddr.length() > 350)) {
			this.fromAddr = this.fromAddr.substring(0, 350);
		}
		if ((this.toAddr != null) && (this.toAddr.length() > 350)) {
			this.toAddr = this.toAddr.substring(0, 350);
		}
		if ((this.ccAddr != null) && (this.ccAddr.length() > 350)) {
			this.ccAddr = this.ccAddr.substring(0, 350);
		}
		if ((this.bccAddr != null) && (this.bccAddr.length() > 350)) {
			this.bccAddr = this.bccAddr.substring(0, 350);
		}
		if ((this.emlFileName != null) && (this.emlFileName.length() > 150))
			this.emlFileName = this.emlFileName.substring(0, 150);
	}

	public String toString() {
		return new ToStringBuilder(this).append("toAddr", this.toAddr).append("fromAddr", this.fromAddr)
				.append("subject", this.subject).append("contentHtml", this.contentHtml)
				.append("attachments", this.attachments).append("ccAddr", this.ccAddr)
				.append("contentText", this.contentText).append("sendTime", this.sendTime).append("sender", this.sender)
				.append("bccAddr", this.bccAddr).append("attachment", this.attachment)
				.append("acceptTime", this.acceptTime).append("beginTime", getBeginTime())
				.append("emlFileName", this.emlFileName).append("receiver", this.receiver).toString();
	}
}