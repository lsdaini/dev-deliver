package net.luis.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
* Created by sai.liu on 2017年4月22日  上午12:26:55
* net.luis.system.model.ModuleFun.java
*@Description：
*/
@Entity
@Table(name = "Tb_ModuleFun")
public class ModuleFun extends BaseModel{

	private static final long serialVersionUID = 5964967947601454859L;
	
	@Column(length = 128)
	private String ModuleFunName;//功能名称
	
	@Column(length = 64)
	private String ModuleFunValue;//功能值
	
	@Column(length = 256)
	private String Url;//功能URL
	
	@Column(length = 16)
	private String DisplayOrder;//功能排序
	
	@Column(length = 512)
	private String Remark;//功能描述
	
	@ManyToOne
	@JoinColumn(name = "moduleId", nullable = false, insertable = false, updatable = false)
	private Module module;//菜单功能

	public String getModuleFunName() {
		return ModuleFunName;
	}

	public void setModuleFunName(String moduleFunName) {
		ModuleFunName = moduleFunName;
	}

	public String getModuleFunValue() {
		return ModuleFunValue;
	}

	public void setModuleFunValue(String moduleFunValue) {
		ModuleFunValue = moduleFunValue;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

	public String getDisplayOrder() {
		return DisplayOrder;
	}

	public void setDisplayOrder(String displayOrder) {
		DisplayOrder = displayOrder;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

}
