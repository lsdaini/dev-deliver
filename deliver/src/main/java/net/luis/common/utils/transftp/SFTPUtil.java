package net.luis.common.utils.transftp;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Vector;
import org.apache.log4j.Logger;

/**
 * @CreateTime：2017年3月28日 下午4:59:08
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.utils.ftp.SFTPUtil.java 
 * @Description：
 */

public class SFTPUtil {
	private Logger logger = Logger.getLogger(SFTPUtil.class); /** 日志记录器  */

	private Session session = null;
	private ChannelSftp channel = null;

	private static SFTPUtil instance = null;

	public static synchronized SFTPUtil getInstance() throws Exception {
		if (instance == null) {
			instance = new SFTPUtil();
		}
		return instance;
	}
	
	/**
     * 登陆SFTP服务器
     * @return boolean
     */
	public boolean login() throws Exception {
		try {
			FtpUse sftp = FtpUse.getInstance();
			JSch jsch = new JSch();
			this.session = jsch.getSession(sftp.getUserName(), sftp.getHost(), sftp.getPort());
			if (sftp.getPassWord() != null) {
				this.session.setPassword(sftp.getPassWord());
			}
			Properties config = new Properties();
			config.put("StrictHostKeyChecking", "no");
			this.session.setConfig(config);
			this.session.setTimeout(sftp.getTimeOut());
			this.session.connect();
			this.logger.debug("sftp session connected");

			this.logger.debug("opening channel");
			this.channel = ((ChannelSftp) this.session.openChannel("sftp"));
			this.channel.connect();

			this.logger.debug("connected successfully");
			return true;
		} catch (JSchException e) {
			this.logger.error("sftp login failed", e);
		}
		return false;
	}

	 /**
     * 上传文件
     * 使用示例，SFTP服务器上的目录结构如下：/testA/testA_B/
     * @param pathName SFTP服务器目录
     * @param fileName 服务器上保存的文件名
     * @param input 输入文件流
     * @return boolean
     */
	public boolean uploadFile(String pathName, String fileName, InputStream input) {
		String currentDir = currentDir();
		if (!changeDir(pathName))
			return false;
		try {
			this.channel.put(input, fileName, 0);
			if (!existFile(fileName)) {
				this.logger.debug("upload failed");
				return false;
			}
			this.logger.debug("upload successful");
			return true;
		} catch (SftpException e) {
			this.logger.error("upload failed", e);
			return false;
		} finally {
			changeDir(currentDir);
		}
	}
	
	/**
     * 上传文件
     * 使用示例，SFTP服务器上的目录结构如下：/testA/testA_B/
     * @param pathName SFTP服务器目录
     * @param fileName 服务器上保存的文件名
     * @param localFile 本地文件
     * @return boolean
     */
	public boolean uploadFile(String pathName, String fileName, String localFile) {
		String currentDir = currentDir();
		if (!changeDir(pathName))
			return false;
		try {
			this.channel.put(localFile, fileName, 0);
			if (!existFile(fileName)) {
				this.logger.debug("upload failed");
				return false;
			}
			this.logger.debug("upload successful");
			return true;
		} catch (SftpException e) {
			this.logger.error("upload failed", e);
			return false;
		} finally {
			changeDir(currentDir);
		}
	}
	
	/**
     * 下载文件
     * 使用示例，SFTP服务器上的目录结构如下：/testA/testA_B/
     * @param remotePath SFTP服务器目录
     * @param fileName 服务器上需要下载的文件名
     * @param localPath 本地保存路径
     * @return boolean
     */
	public boolean downloadFile(String remotePath, String fileName, String localPath) {
		String currentDir = currentDir();
		if (!changeDir(remotePath))
			return false;
		try {
			String localFilePath = localPath + File.separator + fileName;
			this.channel.get(fileName, localFilePath);

			File localFile = new File(localFilePath);
			if (!localFile.exists()) {
				this.logger.debug("download file failed");
				return false;
			}
			this.logger.debug("download successful");
			return true;
		} catch (SftpException e) {
			this.logger.error("download file failed", e);
			return false;
		} finally {
			changeDir(currentDir);
		}
	}

	/**
     * 切换工作目录
     * 使用示例，SFTP服务器上的目录结构如下：/testA/testA_B/
     * @param pathName 路径
     * @return boolean
     */
	public boolean changeDir(String pathName) {
		if ((pathName == null) || (pathName.trim().equals(""))) {
			this.logger.debug("invalid pathName");
			return false;
		}
		try {
			this.channel.cd(pathName.replaceAll("\\\\", "/"));
			this.logger.debug("directory successfully changed,current dir=" + this.channel.pwd());
			return true;
		} catch (SftpException e) {
			this.logger.error("failed to change directory", e);
		}
		return false;
	}

	 /**
     * 切换到上一级目录
     * 使用示例，SFTP服务器上的目录结构如下：/testA/testA_B/
     * @return boolean
     */
	public boolean changeToParentDir() {
		return changeDir("..");
	}
	
	 /**
     * 切换到根目录
     * @return boolean
     */
	public boolean changeToHomeDir() {
		String homeDir = null;
		try {
			homeDir = this.channel.getHome();
		} catch (SftpException e) {
			this.logger.error("can not get home directory", e);
			return false;
		}
		return changeDir(homeDir);
	}
	
	  /**
     * 创建目录
     * 使用示例，SFTP服务器上的目录结构如下：/testA/testA_B/
     * <b>注意</b>，当<b>中间目录不存在</b>的情况下，不能够使用绝对路径的方式期望创建中间目录及目标目录。
     * @param dirName 目录
     * @return boolean
     */
	public boolean makeDir(String dirName) {
		try {
			this.channel.mkdir(dirName);
			this.logger.debug("directory successfully created,dir=" + dirName);
			return true;
		} catch (SftpException e) {
			this.logger.error("failed to create directory", e);
		}
		return false;
	}
	
	 /**
     * 删除文件夹
     * @param dirName
     * @return boolean
     */
	public boolean delDir(String dirName) {
		if (!changeDir(dirName)) {
			return false;
		}

		Vector<LsEntry> list = null;
		try {
			list = channel.ls(channel.pwd());
		} catch (SftpException e) {
			logger.error("can not list directory", e);
			return false;
		}
		for (LsEntry entry : list) {
			String fileName = entry.getFilename();
			if (!fileName.equals(".") && !fileName.equals("..")) {
				if (entry.getAttrs().isDir()) {
					delDir(fileName);
				} else {
					delFile(fileName);
				}
			}
		}
		if (!changeToParentDir()) {
			return false;
		}

		try {
			channel.rmdir(dirName);
			logger.debug("directory " + dirName + " successfully deleted");
			return true;
		} catch (SftpException e) {
			logger.error("failed to delete directory " + dirName, e);
			return false;
		}
	}
	
	 /**
     * 删除文件
     * @param fileName 文件名
     * @return boolean
     */
	public boolean delFile(String fileName) {
		if ((fileName == null) || (fileName.trim().equals(""))) {
			this.logger.debug("invalid filename");
			return false;
		}
		try {
			this.channel.rm(fileName);
			this.logger.debug("file " + fileName + " successfully deleted");
			return true;
		} catch (SftpException e) {
			this.logger.error("failed to delete file " + fileName, e);
		}
		return false;
	}
	
	  /**
     * 当前目录下文件及文件夹名称列表
     * @return String[]
     */
	public String[] ls() {
		return list(Filter.ALL);
	}
	
	 /**
     * 指定目录下文件及文件夹名称列表
     * @return String[]
     */
	public String[] ls(String pathName) {
		String currentDir = currentDir();
		if (!changeDir(pathName)) {
			return new String[0];
		}
		String[] result = list(Filter.ALL);
		if (!changeDir(currentDir)) {
			return new String[0];
		}
		return result;
	}
	
	 /**
     * 当前目录下文件名称列表
     * @return String[]
     */
	public String[] lsFiles() {
		return list(Filter.FILE);
	}
	
	/**
     * 指定目录下文件名称列表
     * @return String[]
     */
	public String[] lsFiles(String pathName) {
		String currentDir = currentDir();
		if (!changeDir(pathName)) {
			return new String[0];
		}
		String[] result = list(Filter.FILE);
		if (!changeDir(currentDir)) {
			return new String[0];
		}
		return result;
	}
	
	  /**
     * 当前目录下文件夹名称列表
     * @return String[]
     */
	public String[] lsDirs() {
		return list(Filter.DIR);
	}
	
	  /**
     * 指定目录下文件夹名称列表
     * @return String[]
     */
	public String[] lsDirs(String pathName) {
		String currentDir = currentDir();
		if (!changeDir(pathName)) {
			return new String[0];
		}
		String[] result = list(Filter.DIR);
		if (!changeDir(currentDir)) {
			return new String[0];
		}
		return result;
	}
	
	 /**
     * 当前目录是否存在文件或文件夹
     * @param name 名称
     * @return boolean
     */
	public boolean exist(String name) {
		return exist(ls(), name);
	}
	
	/**
     * 指定目录下，是否存在文件或文件夹
     * @param path 目录
     * @param name 名称
     * @return boolean
     */
	public boolean exist(String path, String name) {
		return exist(ls(path), name);
	}
	
	 /**
     * 当前目录是否存在文件
     * @param name 文件名
     * @return boolean
     */
	public boolean existFile(String name) {
		return exist(lsFiles(), name);
	}

	/**
     * 指定目录下，是否存在文件
     * @param path 目录
     * @param name 文件名
     * @return boolean
     */
	public boolean existFile(String path, String name) {
		return exist(lsFiles(path), name);
	}
	
	/**
     * 当前目录是否存在文件夹
     * @param name 文件夹名称
     * @return boolean
     */
	public boolean existDir(String name) {
		return exist(lsDirs(), name);
	}
	
	/**
     * 指定目录下，是否存在文件夹
     * @param path 目录
     * @param name 文家夹名称
     * @return boolean
     */
	public boolean existDir(String path, String name) {
		return exist(lsDirs(path), name);
	}
	
	/**
     * 当前工作目录
     * @return String
     */
	public String currentDir() {
		try {
			return this.channel.pwd();
		} catch (SftpException e) {
			this.logger.error("failed to get current dir", e);
		}
		return homeDir();
	}

	 /**
     * 登出
     */
	public void logout() {
		if (this.channel != null) {
			this.channel.quit();
			this.channel.disconnect();
		}
		if (this.session != null) {
			this.session.disconnect();
		}
		this.logger.debug("logout successfully");
	}

	 /**
     * 列出当前目录下的文件及文件夹
     * @param filter 过滤参数
     * @return String[] 
     */
	private String[] list(Filter filter) {
		Vector<LsEntry> list = null;
        try {
            //ls方法会返回两个特殊的目录，当前目录(.)和父目录(..)
            list = channel.ls(channel.pwd());
        } catch (SftpException e) {
            logger.error("can not list directory",e);
            return new String[0];
        }
        
        List<String> resultList = new ArrayList<String>();
        for(LsEntry entry : list){
            if(filter(entry, filter)){
                resultList.add(entry.getFilename());
            }
        }
        return resultList.toArray(new String[0]);
	}

	   /**
     * 判断是否是否过滤条件
     * @param entry LsEntry
     * @param f 过滤参数
     * @return boolean
     */
	private boolean filter(LsEntry entry, Filter f) {
		if (f.equals(Filter.ALL))
			return (!entry.getFilename().equals(".")) && (!entry.getFilename().equals(".."));
		if (f.equals(Filter.FILE))
			return (!entry.getFilename().equals(".")) && (!entry.getFilename().equals(".."))
					&& (!entry.getAttrs().isDir());
		if (f.equals(Filter.DIR)) {
			return (!entry.getFilename().equals(".")) && (!entry.getFilename().equals(".."))
					&& (entry.getAttrs().isDir());
		}
		return false;
	}

	/**
     * 根目录
     * @return String
     */
	private String homeDir() {
		try {
			return this.channel.getHome();
		} catch (SftpException e) {
		}
		return "/";
	}

	/**
     * 判断字符串是否存在于数组中
     * @param strArr 字符串数组
     * @param str 字符串
     * @return boolean
     */
	private boolean exist(String[] strArr, String str) {
		if ((strArr == null) || (strArr.length == 0)) {
			return false;
		}
		if ((str == null) || (str.trim().equals(""))) {
			return false;
		}
		for (String s : strArr) {
			if (s.equalsIgnoreCase(str)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		SFTPUtil sftpUtils = new SFTPUtil();
		sftpUtils.login();
		sftpUtils.changeToHomeDir();
	}
	
	 /** 枚举，用于过滤文件和文件夹  */
	private static enum Filter {
		ALL, FILE, DIR; /** 文件及文件夹 ALL , 文件 FILE ,文件夹   DIR  */
	}
}
