package com.pack.asif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shiptab")
public class Shipping {

	@Id
	@GeneratedValue()
	@Column(name = "sid")
	private Integer shipId;
	@Column(name = "scode")
	private Integer shipCode;
	@Column(name = "srefnum")
	private String shipRefNum;
	@Column(name = "scourefnum")
	private String courRefNum;
	@Column(name = "sdetail")
	private Long contDetails;
	@Column(name = "sdesc")
	private String shipDesc;

	public Shipping() {
		super();
	}

	public Shipping(Integer shipId) {
		super();
		this.shipId = shipId;
	}

	public Integer getShipId() {
		return shipId;
	}

	public void setShipId(Integer shipId) {
		this.shipId = shipId;
	}

	public Integer getShipCode() {
		return shipCode;
	}

	public void setShipCode(Integer shipCode) {
		this.shipCode = shipCode;
	}

	public String getShipRefNum() {
		return shipRefNum;
	}

	public void setShipRefNum(String shipRefNum) {
		this.shipRefNum = shipRefNum;
	}

	public String getCourRefNum() {
		return courRefNum;
	}

	public void setCourRefNum(String courRefNum) {
		this.courRefNum = courRefNum;
	}

	public Long getContDetails() {
		return contDetails;
	}

	public void setContDetails(Long contDetails) {
		this.contDetails = contDetails;
	}

	public String getShipDesc() {
		return shipDesc;
	}

	public void setShipDesc(String shipDesc) {
		this.shipDesc = shipDesc;
	}

	@Override
	public String toString() {
		return "Shipping [shipId=" + shipId + ", shipCode=" + shipCode + ", shipRefNum=" + shipRefNum + ", courRefNum="
				+ courRefNum + ", contDetails=" + contDetails + ", shipDesc=" + shipDesc + "]";
	}

}
