package com.pack.asif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "goodstab")
public class GRNote {

	@Id
	@GeneratedValue()
	@Column(name = "gid")
	private Integer grnId;
	@Column(name = "gcode")
	private Integer grnCode;
	@Column(name = "gtype")
	private String grnType;
	@Column(name = "gdesc")
	private String grnDesc;
	public GRNote() {
		super();
	}
	
	public GRNote(Integer grnId) {
		super();
		this.grnId = grnId;
	}

	public Integer getGrnId() {
		return grnId;
	}
	public void setGrnId(Integer grnId) {
		this.grnId = grnId;
	}
	public Integer getGrnCode() {
		return grnCode;
	}
	public void setGrnCode(Integer grnCode) {
		this.grnCode = grnCode;
	}
	public String getGrnType() {
		return grnType;
	}
	public void setGrnType(String grnType) {
		this.grnType = grnType;
	}
	public String getGrnDesc() {
		return grnDesc;
	}
	public void setGrnDesc(String grnDesc) {
		this.grnDesc = grnDesc;
	}
	@Override
	public String toString() {
		return "GRNote [grnId=" + grnId + ", grnCode=" + grnCode + ", grnType=" + grnType + ", grnDesc=" + grnDesc
				+ "]";
	}

}
