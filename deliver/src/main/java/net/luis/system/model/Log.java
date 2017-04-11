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
	private String title;
	private String content;
	private Integer type;
	private String loginName;
	private String loginIP;
	private Date logintime;
	private String loginArea;
	private char diffAreaLogin;

	@Column(length = 64)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(length = 512)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(length = 16)
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(length = 64)
	public String getLoginName() {
		return this.loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Column(length = 16)
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

	@Column(length = 64)
	public String getLoginArea() {
		return this.loginArea;
	}

	public void setLoginArea(String loginArea) {
		this.loginArea = loginArea;
	}

	@Column(length = 1)
	public char getDiffAreaLogin() {
		return this.diffAreaLogin;
	}

	public void setDiffAreaLogin(char diffAreaLogin) {
		this.diffAreaLogin = diffAreaLogin;
	}
}