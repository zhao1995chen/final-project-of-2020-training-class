package com.game.spring.vo;

import java.io.Serializable;
import java.util.List;

public class Permission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String code;

	/**
	 * 
	 */
	private List<String> pathList;

	public Permission(String code, List<String> pathList) {
		this.code = code;
		this.pathList = pathList;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getPathList() {
		return pathList;
	}

	public void setPathList(List<String> pathList) {
		this.pathList = pathList;
	}

}
