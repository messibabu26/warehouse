package com.pack.asif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "purchasetab")
public class PurchaseOrder {

	@Id
	@GeneratedValue
	@Column(name = "oid")
	private Integer ordId;
	@Column(name = "ocode")
	private String ordCode;
	@Column(name = "onumber")
	private Integer refNumber;
	@Column(name = "ocheck")
	private String quaCheck;
	@Column(name = "ostatus")
	private String defStatus;
	@Column(name = "odesc")
	private String ordDesc;

	@ManyToOne
	@JoinColumn(name = "shipIdFK")
	private ShipmentType shipOb;

	@ManyToOne
	@JoinColumn(name = "whuserVendorIdFK")
	private WhUserType whuserOb;

	public PurchaseOrder() {
		super();
	}

	public PurchaseOrder(Integer ordId) {
		super();
		this.ordId = ordId;
	}

	public Integer getOrdId() {
		return ordId;
	}

	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}

	public String getOrdCode() {
		return ordCode;
	}

	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}

	public Integer getRefNumber() {
		return refNumber;
	}

	public void setRefNumber(Integer refNumber) {
		this.refNumber = refNumber;
	}

	public String getQuaCheck() {
		return quaCheck;
	}

	public void setQuaCheck(String quaCheck) {
		this.quaCheck = quaCheck;
	}

	public String getDefStatus() {
		return defStatus;
	}

	public void setDefStatus(String defStatus) {
		this.defStatus = defStatus;
	}

	public String getOrdDesc() {
		return ordDesc;
	}

	public void setOrdDesc(String ordDesc) {
		this.ordDesc = ordDesc;
	}

	public ShipmentType getShipOb() {
		return shipOb;
	}

	public void setShipOb(ShipmentType shipOb) {
		this.shipOb = shipOb;
	}

	public WhUserType getWhuserOb() {
		return whuserOb;
	}

	public void setWhuserOb(WhUserType whuserOb) {
		this.whuserOb = whuserOb;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [ordId=" + ordId + ", ordCode=" + ordCode + ", refNumber=" + refNumber + ", quaCheck="
				+ quaCheck + ", defStatus=" + defStatus + ", ordDesc=" + ordDesc + ", shipOb=" + shipOb + ", whuserOb="
				+ whuserOb + "]";
	}

}
