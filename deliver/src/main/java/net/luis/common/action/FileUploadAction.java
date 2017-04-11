package net.luis.common.action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @CreateTime：2017年3月28日 下午4:43:34
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.action.FileUploadAction.java @Description：
 */

@Results({ 
	@Result(name = "upload", location = "/common/uploadFile.jsp"),
	@Result(name = "ajax", location = "/common/ajaxloadFile.jsp"),
	@Result(name = "login", location = "index.action", type = "redirect") })
public class FileUploadAction extends ActionSupport {
	
	private static final long serialVersionUID = 2669236787748756519L;
	private File upload;
	private String uploadFileName;
	private String uploadContentType;
	private String result;

	@Action("fileUpload")
	public String fileUpload() {
		return "upload";
	}

	@Action("ajaxUpload")
	public String ajaxUpload() {
		return "ajax";
	}

	@Action("upload")
	public String execute() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		FileUtils.copyFile(this.upload, new File(file, this.uploadFileName));
		this.result = "文件上传成功";
		return result;
	}

	public File getUpload() {
		return this.upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return this.uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return this.uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
