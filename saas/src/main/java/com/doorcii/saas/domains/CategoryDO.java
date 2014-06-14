package com.doorcii.saas.domains;

/**
 * 科室对象
 * @author chenjie
 */
public class CategoryDO {
	
	/**
	 * 唯一主键
	 */
	private String id;
	
	/**
	 * 科室名称
	 */
	private String name;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
