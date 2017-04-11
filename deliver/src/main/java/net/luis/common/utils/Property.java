package net.luis.common.utils;

/**
 * @CreateTime：2017年3月28日 下午4:55:35
 * @Author sai.liu
 * @ProjectPackage：net.luis.base.utils.Property.java 
 * @Description：
 */

public class Property {
	private Class parentClass;
	private String name;	//键值Name
	private String type;	//键值Type
	private Object value;	//键值Value

	public Class getParentClass() {
		return this.parentClass;
	}

	public void setParentClass(Class parentClass) {
		this.parentClass = parentClass;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Object getValue() {
		return this.value;
	}

	public void setValue(Object value) {
		this.value = value;
	}
}