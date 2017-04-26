package net.luis.system.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
* Created by sai.liu on 2017年4月21日  下午9:58:03
* net.luis.system.model.UserRole.java
*@Description：
*/
@Entity
@Table(name = "Tb_UserRole")
public class UserRole extends BaseModel{

	private static final long serialVersionUID = -8859765181333292792L;

	@ManyToOne
	@JoinColumn(name = "roleId", nullable = false, insertable = false, updatable = false)
	private Role role;//角色
	@ManyToOne
	@JoinColumn(name = "userId", nullable = false, insertable = false, updatable = false)
	private User user;//用户
	
	public Role getRole() {
		return role;
	}
	public User getUser() {
		return user;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
