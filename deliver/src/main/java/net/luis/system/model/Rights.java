package net.luis.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
* Created by sai.liu on 2017年4月7日  下午5:11:27
* net.luis.system.model.Rights.java
*@Description：
*/

@Entity
@Table(name = "Tb_Rights")
public class Rights extends BaseModel {

	private static final long serialVersionUID = 5065083251463595082L;
	@Column(length = 512)
	private String remark;//备注
	
	@ManyToOne
	@JoinColumn(name = "roleId", nullable = false, insertable = false, updatable = false)
	private Role role;//角色
	@ManyToOne
	@JoinColumn(name = "moduleFunId", nullable = false, insertable = false, updatable = false)
	private ModuleFun moduleFun;//权限功能
	
	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public ModuleFun getModuleFun() {
		return moduleFun;
	}

	public void setModuleFun(ModuleFun moduleFun) {
		this.moduleFun = moduleFun;
	}
	
}
