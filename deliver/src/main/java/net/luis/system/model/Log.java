package net.luis.system.model;

/**
*@CreateTime：2017年3月28日 下午5:07:13
*@Author sai.liu
*@ProjectPackage：net.luis.system.model.Log.java
*@Description：
*/
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Tb_Log")
public class Log extends BaseModel {
	private static final long serialVersionUID = 8535595678660759063L;
	
	@Column(length = 64)
	private String title;//日志主题
	
	@Column(length = 512)
	private String content;//内容
	
	@Column(length = 16)
	private Integer type;//类型
	
	@Column(length = 64)
	private String loginName;//登录名
	
	@Column(length = 16)
	private String loginIP;//登录ip
	
	private Date logintime;//登录时间
	
	@Column(length = 64)
	private String loginArea;//登录地点
	
	@Column(length = 1)
	private char diffAreaLogin;//是否异地登录

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginIP() {
		return this.loginIP;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	public Date getLogintime() {
		return this.logintime;
	}

	public void setLogintime(Date logintime) {
		this.logintime = logintime;
	}

	public String getLoginArea() {
		return this.loginArea;
	}

	public void setLoginArea(String loginArea) {
		this.loginArea = loginArea;
	}

	public char getDiffAreaLogin() {
		return this.diffAreaLogin;
	}

	public void setDiffAreaLogin(char diffAreaLogin) {
		this.diffAreaLogin = diffAreaLogin;
	}
}