package net.luis.system.model;

/**
*@CreateTime：2017年3月28日 下午5:07:39
*@Author sai.liu
*@ProjectPackage：net.luis.system.model.Role.java
*/

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "Tb_Role")
public class Role extends BaseModel {
	private static final long serialVersionUID = 7090520035380600700L;
	
	@Column(length = 64)
	private String roleName;//角色名称
	
	@Column(length = 512)
	private String remark;//备注

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}