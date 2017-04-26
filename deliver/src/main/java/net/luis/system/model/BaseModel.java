package net.luis.system.model;

/**
*@CreateTime：2017年3月28日 下午5:06:43
*@Author sai.liu
*@ProjectPackage：net.luis.system.model.BaseModel.java
*@Description：
*/

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseModel implements Serializable {
	private static final long serialVersionUID = 3500193360545333681L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;//主键ID
	
	@Column(length = 1)
	private String enabled;//是否启用
	
	@Column(length = 64)
	private String createBy;//创建人
	private Date createTime;//创建时间
	
	@Column(length = 64)
	private String updateBy;//修改人
	private Date updateTime;//修改时间
	
	@Column(length = 64)
	private String comfimBy;//审核人
	private Date comfimTime;//审核时间
	
	@Column(length = 64)
	private String definitionOne;//备用字段
	
	@Column(length = 64)
	private String definitionTwo;//备用字段
	
	@Column(length = 64)
	private String definitionThree;//备用字段

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnabled() {
		return this.enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getComfimTime() {
		return this.comfimTime;
	}

	public void setComfimTime(Date comfimTime) {
		this.comfimTime = comfimTime;
	}

	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public String getComfimBy() {
		return this.comfimBy;
	}

	public void setComfimBy(String comfimBy) {
		this.comfimBy = comfimBy;
	}

	public String getDefinitionOne() {
		return this.definitionOne;
	}

	public void setDefinitionOne(String definitionOne) {
		this.definitionOne = definitionOne;
	}

	public String getDefinitionTwo() {
		return this.definitionTwo;
	}

	public void setDefinitionTwo(String definitionTwo) {
		this.definitionTwo = definitionTwo;
	}

	public String getDefinitionThree() {
		return this.definitionThree;
	}

	public void setDefinitionThree(String definitionThree) {
		this.definitionThree = definitionThree;
	}
}