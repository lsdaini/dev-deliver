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
	private Integer id;
	private String enabled;
	private Date createTime;
	private Date updateTime;
	private Date comfimTime;
	private String createBy;
	private String updateBy;
	private String comfimBy;
	private String definitionOne;
	private String definitionTwo;
	private String definitionThree;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 1)
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

	@Column(length = 64)
	public String getCreateBy() {
		return this.createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(length = 64)
	public String getUpdateBy() {
		return this.updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(length = 64)
	public String getComfimBy() {
		return this.comfimBy;
	}

	public void setComfimBy(String comfimBy) {
		this.comfimBy = comfimBy;
	}

	@Column(length = 64)
	public String getDefinitionOne() {
		return this.definitionOne;
	}

	public void setDefinitionOne(String definitionOne) {
		this.definitionOne = definitionOne;
	}

	@Column(length = 64)
	public String getDefinitionTwo() {
		return this.definitionTwo;
	}

	public void setDefinitionTwo(String definitionTwo) {
		this.definitionTwo = definitionTwo;
	}

	@Column(length = 64)
	public String getDefinitionThree() {
		return this.definitionThree;
	}

	public void setDefinitionThree(String definitionThree) {
		this.definitionThree = definitionThree;
	}
}