package net.luis.common.action;

import java.io.File;
import java.util.List;

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
	@Result(name = "login", location = "index.action", type = "redirect") })
public class FileUploadAction extends ActionSupport {
	
	private static final long serialVersionUID = 2669236787748756519L;
	private List<File> upload;//上传的文件,struts2会把文件封装为File对象
	private List<String> uploadFileName;//文件名,struts2会把文件名称设置到该变量
	private List<String> uploadContentType;//文件类型,struts2会把文件类型设置到该变量
	private String result;

	@Action("upload")
	public String execute() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath("/WEB-INF/upload");
		File file = new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		for (int i = 0; i < upload.size(); i++) {
			FileUtils.copyFile(this.upload.get(i), new File(file, this.uploadFileName.get(i)));
		}
		this.result = "文件上传成功";
		return result;
	}


	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
