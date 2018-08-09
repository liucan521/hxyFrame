package com.hxy.sys.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2018-08-04 14:56:52
 */
public class TrecommendofficerEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private String id;
	//方案编号
	private String caseId;
	//人员编号
	private String pId;

	/**
	 * 设置：
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public String getId() {
		return id;
	}
	/**
	 * 设置：方案编号
	 */
	public void setCaseId(String caseId) {
		this.caseId = caseId;
	}
	/**
	 * 获取：方案编号
	 */
	public String getCaseId() {
		return caseId;
	}
	/**
	 * 设置：人员编号
	 */
	public void setPId(String pId) {
		this.pId = pId;
	}
	/**
	 * 获取：人员编号
	 */
	public String getPId() {
		return pId;
	}
}
