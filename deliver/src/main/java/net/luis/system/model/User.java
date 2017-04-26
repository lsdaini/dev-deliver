package net.luis.system.model;

/**
*@CreateTime：2017年3月28日 下午5:08:38
*@Author sai.liu
*@ProjectPackage：net.luis.system.model.User.java
*@Description：
*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Tb_User")
public class User extends BaseModel{
	private static final long serialVersionUID = 3511251678437879915L;

	@Column(length = 64)
	private String username;//用户名

	@Column(length = 64)
	private String nickName;//昵称

	@Column(length = 128)
	private String password;//密码

	@Column(length = 128)
	private String email;//邮箱

	@Column(length = 8)
	private String errNumber;//密码错误次数

	@Column(length = 1)
	private char isfirstlogin;//是否第一次登录

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getErrNumber() {
		return this.errNumber;
	}

	public void setErrNumber(String errNumber) {
		this.errNumber = errNumber;
	}

	public char getIsfirstlogin() {
		return this.isfirstlogin;
	}

	public void setIsfirstlogin(char isfirstlogin) {
		this.isfirstlogin = isfirstlogin;
	}

}
