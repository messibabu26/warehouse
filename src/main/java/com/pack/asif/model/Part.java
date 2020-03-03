package com.pack.asif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "partstab")
public class Part {

	@Id
	@GeneratedValue()
	@Column(name="pid")
	private Integer partId;
	@Column(name="pcode")
	private String partCode;
	@Column(name="pdimen")
	private String partDimension;
	@Column(name="pcost")
	private Double partBaseCost;
	@Column(name="pcurrency")
	private String partBaseCurrency;
	@Column(name="pdesc")
	private String partDesc;
	public Part() {
		super();
	}
	
	public Part(Integer partId) {
		super();
		this.partId = partId;
	}

	public Integer getPartId() {
		return partId;
	}
	public void setPartId(Integer partId) {
		this.partId = partId;
	}
	public String getPartCode() {
		return partCode;
	}
	public void setPartCode(String partCode) {
		this.partCode = partCode;
	}
	public String getPartDimension() {
		return partDimension;
	}
	public void setPartDimension(String partDimension) {
		this.partDimension = partDimension;
	}
	public Double getPartBaseCost() {
		return partBaseCost;
	}
	public void setPartBaseCost(Double partBaseCost) {
		this.partBaseCost = partBaseCost;
	}
	public String getPartBaseCurrency() {
		return partBaseCurrency;
	}
	public void setPartBaseCurrency(String partBaseCurrency) {
		this.partBaseCurrency = partBaseCurrency;
	}
	public String getPartDesc() {
		return partDesc;
	}
	public void setPartDesc(String partDesc) {
		this.partDesc = partDesc;
	}
	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partCode=" + partCode + ", partDimension=" + partDimension
				+ ", partBaseCost=" + partBaseCost + ", partBaseCurrency=" + partBaseCurrency + ", partDesc=" + partDesc
				+ "]";
	}

}
