/**
 * 
 */
package com.dewell.entity;

/**
 * @author Reborn.Wang
 * @createDate 创建时间：2018年8月23日 下午5:25:06
 * @Description 类描述:用户模型
 */
public class User {
	
	private int id;
	
	/**
	 * 用户名称
	 */
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
	
}
