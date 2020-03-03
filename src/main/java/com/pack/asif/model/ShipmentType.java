package com.pack.asif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shiptab")
public class ShipmentType {
	
	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer shipId;
	@Column(name="smode")
	private String shipMode;
	@Column(name="scode")
	private String shipCode;
	@Column(name="senable")
	private String shipEnable;
	@Column(name="sgrade")
	private String shipGrade;
	@Column(name="sdesc")
	private String shipDesc;
	public ShipmentType() {
		super();
	}
	public ShipmentType(Integer shipId) {
		super();
		this.shipId = shipId;
	}
	public Integer getShipId() {
		return shipId;
	}
	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}
	public String getShipMode() {
		return shipMode;
	}
	public void setShipMode(String shipMode) {
		this.shipMode = shipMode;
	}
	public String getShipCode() {
		return shipCode;
	}
	public void setShipCode(String shipCode) {
		this.shipCode = shipCode;
	}
	public String getShipEnable() {
		return shipEnable;
	}
	public void setShipEnable(String shipEnable) {
		this.shipEnable = shipEnable;
	}
	public String getShipGrade() {
		return shipGrade;
	}
	public void setShipGrade(String shipGrade) {
		this.shipGrade = shipGrade;
	}
	public String getShipDesc() {
		return shipDesc;
	}
	public void setShipDesc(String shipDesc) {
		this.shipDesc = shipDesc;
	}
	@Override
	public String toString() {
		return "ShipmentType [shipId=" + shipId + ", shipMode=" + shipMode + ", shipCode=" + shipCode + ", shipEnable="
				+ shipEnable + ", shipGrade=" + shipGrade + ", shipDesc=" + shipDesc + ", getShipId()=" + getShipId()
				+ ", getShipMode()=" + getShipMode() + ", getShipCode()=" + getShipCode() + ", getShipEnable()="
				+ getShipEnable() + ", getShipGrade()=" + getShipGrade() + ", getShipDesc()=" + getShipDesc()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
