package net.luis.common.utils.transftp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

/**
*@CreateTime：2017年3月28日 下午5:00:44
*@Author sai.liu
*@ProjectPackage：net.luis.base.utils.ftp.FtpUtil.java
*@Description：
*/


public class FtpUtil extends FTPClient {
	private static Log log = LogFactory.getLog(FtpUtil.class);
	private FtpUse ftpUse;
	private FTPFile[] files;
	private static FtpUtil instance = null;

	public static synchronized FtpUtil getInstance() throws Exception {
		if (instance == null) {
			instance = new FtpUtil();
		}
		return instance;
	}

	public FtpUse getFtpUse() {
		return this.ftpUse;
	}

	public void setFtpUse(FtpUse ftpUse) {
		this.ftpUse = ftpUse;
	}

	public boolean ftpLogin() {
		boolean isLogined = false;
		try {
			log.debug("ftp login start ...");
			super.connect(this.ftpUse.getHost(), this.ftpUse.getPort());
			isLogined = super.login(this.ftpUse.getUserName(), this.ftpUse.getPassWord());
			if (isLogined)
				log.debug("ftp login successfully ...");
			else
				log.debug("ftp login failed ...");
			return isLogined;
		} catch (SocketException e) {
			log.error("", e);
			return false;
		} catch (IOException e) {
			log.error("", e);
			return false;
		} catch (RuntimeException e) {
			log.error("", e);
		}
		return false;
	}

	public void ftpLogOut() {
		if (super.isConnected())
			try {
				super.logout();
				super.disconnect();
				log.debug("ftp logout ....");
			} catch (Exception e) {
				log.error(e.getMessage());
				throw new RuntimeException(e.toString());
			}
	}

	public void uploadFile(InputStream inputStream, String fileName, String pathName) throws IOException {
		super.storeFile(pathName + fileName, inputStream);
	}

	public File downloadFile(String fileName, String localFileName, String pathName) throws IOException {
		File outfile = new File(localFileName);
		OutputStream oStream = null;
		try {
			oStream = new FileOutputStream(outfile);
			super.retrieveFile(pathName + fileName, oStream);
			File localFile1 = outfile;
			return localFile1;
		} finally {
			if (oStream != null)
				oStream.close();
		}
	}

	public FTPFile[] listFtpFiles(String pathName) throws IOException {
		return super.listFiles(pathName);
	}

	public void deleteFtpFiles(FTPFile[] ftpFiles, String pathName) throws IOException {
		for (FTPFile ff : ftpFiles) {
			if ((!ff.isFile()) || (super.deleteFile(pathName + ff.getName())))
				continue;
			throw new RuntimeException("delete File" + ff.getName() + " is n't seccess");
		}
	}

	public void deleteFtpFile(String fileName, String pathName) throws IOException {
		if (!super.deleteFile(pathName + fileName))
			throw new RuntimeException("delete File" + pathName + fileName + " is n't seccess");
	}

	public InputStream downFtpFile(String fileName, String pathName) throws IOException {
		return super.retrieveFileStream(pathName + fileName);
	}

	public FTPFile[] getFiles() {
		return this.files;
	}

	public void setFiles(FTPFile[] files) {
		this.files = files;
	}
}