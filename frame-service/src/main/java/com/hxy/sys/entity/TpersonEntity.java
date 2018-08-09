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
public class TpersonEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//人员编号
	private String pId;
	//姓名
	private String name;
	//身份证号
	private String card;
	//年龄
	private Integer age;
	//籍贯
	private String birthplace;
	//学历
	private String education;
	//军衔
	private String pRank;
	//担任职务
	private String pPosition;

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
	/**
	 * 设置：姓名
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：姓名
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：身份证号
	 */
	public void setCard(String card) {
		this.card = card;
	}
	/**
	 * 获取：身份证号
	 */
	public String getCard() {
		return card;
	}
	/**
	 * 设置：年龄
	 */
	public void setAge(Integer age) {
		this.age = age;
	}
	/**
	 * 获取：年龄
	 */
	public Integer getAge() {
		return age;
	}
	/**
	 * 设置：籍贯
	 */
	public void setBirthplace(String birthplace) {
		this.birthplace = birthplace;
	}
	/**
	 * 获取：籍贯
	 */
	public String getBirthplace() {
		return birthplace;
	}
	/**
	 * 设置：学历
	 */
	public void setEducation(String education) {
		this.education = education;
	}
	/**
	 * 获取：学历
	 */
	public String getEducation() {
		return education;
	}
	/**
	 * 设置：军衔
	 */
	public void setPRank(String pRank) {
		this.pRank = pRank;
	}
	/**
	 * 获取：军衔
	 */
	public String getPRank() {
		return pRank;
	}
	/**
	 * 设置：担任职务
	 */
	public void setPPosition(String pPosition) {
		this.pPosition = pPosition;
	}
	/**
	 * 获取：担任职务
	 */
	public String getPPosition() {
		return pPosition;
	}
}
