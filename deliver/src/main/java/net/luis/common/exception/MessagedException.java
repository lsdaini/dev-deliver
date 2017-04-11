package net.luis.common.exception;

import java.util.ArrayList;
import java.util.List;

/**
 * @CreateTime：2017年3月28日 下午4:49:27
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.exception.MessagedException.java 
 * @Description：
 */

public class MessagedException extends RuntimeException {
	
	private static final long serialVersionUID = -7607192617149998299L;
	private List messages = new ArrayList();

	public MessagedException() {
	}

	public MessagedException(String message, Throwable cause) {
		super(message, cause);
	}

	public MessagedException(String message) {
		super(message);
	}

	public MessagedException(Throwable cause) {
		super(cause);
	}

	public void addMessage(Object msg) {
		if ((msg instanceof Throwable))
			this.messages.add(((Throwable) msg).getMessage());
		else
			this.messages.add(msg);
	}

	public List getMessages() {
		return this.messages;
	}
}
