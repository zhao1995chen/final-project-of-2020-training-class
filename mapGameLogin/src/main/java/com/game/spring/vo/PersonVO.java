package com.game.spring.vo;

import java.io.Serializable;
import java.util.List;

public class PersonVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * name
	 */
	private String name;

	/**
	 * 
	 */
	private String password;

	/**
	 * 
	 */
	private List<Permission> permissionList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

}
