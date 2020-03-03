package com.pack.asif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="saletab")
public class SaleOrder {
	
	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer saleId;
	@Column(name="scode")
	private Integer saleCode;
	@Column(name="snumber")
	private Integer refNumber;
	@Column(name="smode")
	private String stockMode;
	@Column(name="ssource")
	private String stockSource;
	@Column(name="sstatus")
	private String defStatus;
	@Column(name="sdesc")
	private String saleDesc;
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
	public Integer getSaleCode() {
		return saleCode;
	}
	public void setSaleCode(Integer saleCode) {
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
	@Override
	public String toString() {
		return "SaleOrder [saleId=" + saleId + ", saleCode=" + saleCode + ", refNumber=" + refNumber + ", stockMode="
				+ stockMode + ", stockSource=" + stockSource + ", defStatus=" + defStatus + ", saleDesc=" + saleDesc
				+ "]";
	}
	
}
