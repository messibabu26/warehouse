package com.pack.asif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "saletab")
public class SaleOrder {

	@Id
	@GeneratedValue
	@Column(name = "sid")
	private Integer saleId;
	@Column(name = "scode")
	private String saleCode;
	@Column(name = "snumber")
	private Integer refNumber;
	@Column(name = "smode")
	private String stockMode;
	@Column(name = "ssource")
	private String stockSource;
	@Column(name = "sstatus")
	private String defStatus;
	@Column(name = "sdesc")
	private String saleDesc;

	@ManyToOne
	@JoinColumn(name = "shipIdFK")
	private ShipmentType shipOb;

	@ManyToOne
	@JoinColumn(name = "whusrIdFK")
	private WhUserType whuserOb;

	public SaleOrder() {
		super();
	}

	public SaleOrder(Integer saleId) {
		super();
		this.saleId = saleId;
	}

	public Integer getSaleId() {
		return saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
	}

	public String getSaleCode() {
		return saleCode;
	}

	public void setSaleCode(String saleCode) {
		this.saleCode = saleCode;
	}

	public Integer getRefNumber() {
		return refNumber;
	}

	public void setRefNumber(Integer refNumber) {
		this.refNumber = refNumber;
	}

	public String getStockMode() {
		return stockMode;
	}

	public void setStockMode(String stockMode) {
		this.stockMode = stockMode;
	}

	public String getStockSource() {
		return stockSource;
	}

	public void setStockSource(String stockSource) {
		this.stockSource = stockSource;
	}

	public String getDefStatus() {
		return defStatus;
	}

	public void setDefStatus(String defStatus) {
		this.defStatus = defStatus;
	}

	public String getSaleDesc() {
		return saleDesc;
	}

	public void setSaleDesc(String saleDesc) {
		this.saleDesc = saleDesc;
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
		return "SaleOrder [saleId=" + saleId + ", saleCode=" + saleCode + ", refNumber=" + refNumber + ", stockMode="
				+ stockMode + ", stockSource=" + stockSource + ", defStatus=" + defStatus + ", saleDesc=" + saleDesc
				+ ", shipOb=" + shipOb + ", whuserOb=" + whuserOb + "]";
	}
}
