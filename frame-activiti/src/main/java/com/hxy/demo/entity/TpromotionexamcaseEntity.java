package com.hxy.demo.entity;

import com.hxy.activiti.annotation.ActField;
import com.hxy.activiti.annotation.ActTable;
import com.hxy.base.entity.ActivitiBaseEntity;
import org.hibernate.validator.constraints.NotEmpty;




/**
 * 
 * 
 * @author hxy
 * @email huangxianyuan@gmail.com
 * @date 2018-08-04 14:56:52
 */
@ActTable(tableName = "tpromotionexamcase",pkName="case_id")
public class TpromotionexamcaseEntity extends ActivitiBaseEntity {

	//方案编号
	private String caseId;
	//用户名
	private String userId;
	//方案名
//	@ActField(name = "方案名")
//	@NotEmpty(message = "方案名不能为空")
	private String caseName;
	//方案内容
	private String caseContent;

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
	 * 设置：用户名
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * 获取：用户名
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * 设置：方案名
	 */
	public void setCaseName(String caseName) {
		this.caseName = caseName;
	}
	/**
	 * 获取：方案名
	 */
	public String getCaseName() {
		return caseName;
	}
	/**
	 * 设置：方案内容
	 */
	public void setCaseContent(String caseContent) {
		this.caseContent = caseContent;
	}
	/**
	 * 获取：方案内容
	 */
	public String getCaseContent() {
		return caseContent;
	}

}
