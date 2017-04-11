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
public class User extends BaseModel {
	private static final long serialVersionUID = 3511251678437879915L;
	private String userName;
	private String nickName;
	private String passWord;
	private String roleId;
	private String email;
	private String errNumber;
	private char isfirstlogin;

	@Column(length = 64)
	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(length = 128)
	public String getPassWord() {
		return this.passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Column(length = 8)
	public String getRoleId() {
		return this.roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	@Column(length = 64)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(length = 128)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 8)
	public String getErrNumber() {
		return this.errNumber;
	}

	public void setErrNumber(String errNumber) {
		this.errNumber = errNumber;
	}

	@Column(length = 1)
	public char getIsfirstlogin() {
		return this.isfirstlogin;
	}

	public void setIsfirstlogin(char isfirstlogin) {
		this.isfirstlogin = isfirstlogin;
	}
}
