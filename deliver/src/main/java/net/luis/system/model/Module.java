package net.luis.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
* Created by sai.liu on 2017年4月7日  下午5:11:27
* net.luis.system.model.Module.java
*@Description：
*/

@Entity
@Table(name = "Tb_Module")
public class Module extends BaseModel {

	private static final long serialVersionUID = -5396204643385221447L;
	
	@Column(length = 64)
	private String ModuleName;
	@Column(length = 128)
	private String ModuleUrl;
	@Column(length = 8)
	private int DisplayOrder;
	@Column(length = 8)
	private int parentId;
	@Column(length = 512)
	private String remark;//备注
	
	public String getModuleName() {
		return ModuleName;
	}
	public void setModuleName(String moduleName) {
		ModuleName = moduleName;
	}
	public String getModuleUrl() {
		return ModuleUrl;
	}
	public void setModuleUrl(String moduleUrl) {
		ModuleUrl = moduleUrl;
	}
	public int getDisplayOrder() {
		return DisplayOrder;
	}
	public void setDisplayOrder(int displayOrder) {
		DisplayOrder = displayOrder;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
