package net.luis.common.utils.transftp;

import java.io.File;
import java.io.Serializable;
import java.util.Map;

import net.luis.common.utils.HelpUtil;

/**
 * @CreateTime：2017年3月28日 下午4:58:34
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.utils.ftp.FtpUse.java 
 * @Description：
 */

public class FtpUse implements Serializable {
	private static final long serialVersionUID = 8449234151836808005L;
	private String host;
	private int port;
	private int timeOut;
	private String userName;
	private String passWord;
	private static FtpUse instance = null;

	public static synchronized FtpUse getInstance() throws Exception {
		if (instance == null) {
			Map ftpMap = HelpUtil.getMapByPorpFile("properties" + File.separator + "ftpserver.properties");
			if (!ftpMap.isEmpty()) {
				String host = (String) ftpMap.get("SFTP_ADDRESS");
				String port = (String) ftpMap.get("SFTP_PORT");
				String timeout = (String) ftpMap.get("SFTP_TIMEOUT");
				String username = (String) ftpMap.get("SFTP_USERNAME");
				String password = (String) ftpMap.get("SFTP_PASSWORD");
				instance = new FtpUse(host, Integer.valueOf(port).intValue(), Integer.valueOf(timeout).intValue(),
						username, password);
			}
		}
		return instance;
	}

	public FtpUse() {
	}

	public FtpUse(String host, int port, int timeOut, String userName, String passWord) {
		this.host = host;
		this.port = port;
		this.timeOut = timeOut;
		this.userName = userName;
		this.passWord = passWord;
	}

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return this.port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getTimeOut() {
		return this.timeOut;
	}

	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
}