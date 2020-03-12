package com.pack.asif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "goodstab")
public class GRNote {

	@Id
	@GeneratedValue()
	@Column(name = "gid")
	private Integer grnId;
	@Column(name = "gcode")
	private String grnCode;
	@Column(name = "gtype")
	private String grnType;
	@Column(name = "gdesc")
	private String grnDesc;

	@OneToOne
	@JoinColumn(name = "purchaseIdFK")
	private PurchaseOrder purchaseOrder;

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

	public String getGrnCode() {
		return grnCode;
	}

	public void setGrnCode(String grnCode) {
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

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	@Override
	public String toString() {
		return "GRNote [grnId=" + grnId + ", grnCode=" + grnCode + ", grnType=" + grnType + ", grnDesc=" + grnDesc
				+ ", purchaseOrder=" + purchaseOrder + "]";
	}

}
