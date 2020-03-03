package com.pack.asif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usertab")
public class WhUserType {
	
	@Id
	@GeneratedValue
	@Column(name="whuid")
	private Integer userId;
	@Column(name="whutype")
	private String userType;
	@Column(name="whucode")
	private String userCode;
	@Column(name="whucuser")
	private String userUser;
	@Column(name="whumail")
	private String userMail;
	@Column(name="whucontact")
	private Long userContact;
	@Column(name="whuidtype")
	private String userIdType;
	@Column(name="whuother")
	private String userOther;
	@Column(name="whunumber")
	private Long idNumber;
	public WhUserType() {
		super();
	}
	public WhUserType(Integer userId) {
		super();
		this.userId = userId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getUserCode() {
		return userCode;
	}
	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	public String getUserUser() {
		return userUser;
	}
	public void setUserUser(String userUser) {
		this.userUser = userUser;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public Long getUserContact() {
		return userContact;
	}
	public void setUserContact(Long userContact) {
		this.userContact = userContact;
	}
	public String getUserIdType() {
		return userIdType;
	}
	public void setUserIdType(String userIdType) {
		this.userIdType = userIdType;
	}
	public String getUserOther() {
		return userOther;
	}
	public void setUserOther(String userOther) {
		this.userOther = userOther;
	}
	public Long getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(Long idNumber) {
		this.idNumber = idNumber;
	}
	@Override
	public String toString() {
		return "WhUserType [userId=" + userId + ", userType=" + userType + ", userCode=" + userCode + ", userUser="
				+ userUser + ", userMail=" + userMail + ", userContact=" + userContact + ", userIdType=" + userIdType
				+ ", userOther=" + userOther + ", idNumber=" + idNumber + "]";
	}

}
	
	