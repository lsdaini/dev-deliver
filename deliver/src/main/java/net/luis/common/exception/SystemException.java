package net.luis.common.exception;

/**
 * @CreateTime：2017年3月28日 下午4:50:06
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.exception.SystemException.java 
 * @Description：
 */

public class SystemException extends RuntimeException {
	private static final long serialVersionUID = -1246064547154444788L;

	public SystemException(String frdMessage) {
		super(createFriendlyErrMsg(frdMessage));
	}

	public SystemException(Throwable throwable) {
		super(throwable);
	}

	public SystemException(Throwable throwable, String frdMessage) {
		super(throwable);
	}

	private static String createFriendlyErrMsg(String msgBody) {
		String prefixStr = "抱歉。";
		String suffixStr = "请稍后再试或与管理员联系！";
		StringBuffer friendlyErrMsg = new StringBuffer();
		friendlyErrMsg.append(prefixStr);
		friendlyErrMsg.append(msgBody);
		friendlyErrMsg.append(suffixStr);
		return friendlyErrMsg.toString();
	}
}
