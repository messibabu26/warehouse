package com.pack.asif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "partstab")
public class Part {

	@Id
	@GeneratedValue()
	@Column(name = "pid")
	private Integer partId;
	@Column(name = "pcode")
	private String partCode;
	@Column(name = "plen")
	private Double partLen;
	@Column(name = "pwitdh")
	private Double partWidth;
	@Column(name = "phgt")
	private Double partHgt;
	@Column(name = "pcost")
	private Double partBaseCost;
	@Column(name = "pcurrency")
	private String partBaseCurrency;
	@Column(name = "pdesc")
	private String partDesc;

	@ManyToOne
	@JoinColumn(name = "uomIdFK")
	private UomType uomOb;

	@ManyToOne
	@JoinColumn(name = "ordSaleIdFK")
	private OrderMethod ordObSale;
	
	@ManyToOne
	@JoinColumn(name = "ordPurchaseIdFK")
	private OrderMethod ordObPurchase;

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

	public Double getPartLen() {
		return partLen;
	}

	public void setPartLen(Double partLen) {
		this.partLen = partLen;
	}

	public Double getPartWidth() {
		return partWidth;
	}

	public void setPartWidth(Double partWidth) {
		this.partWidth = partWidth;
	}

	public Double getPartHgt() {
		return partHgt;
	}

	public void setPartHgt(Double partHgt) {
		this.partHgt = partHgt;
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

	public UomType getUomOb() {
		return uomOb;
	}

	public void setUomOb(UomType uomOb) {
		this.uomOb = uomOb;
	}

	public OrderMethod getOrdObSale() {
		return ordObSale;
	}

	public void setOrdObSale(OrderMethod ordObSale) {
		this.ordObSale = ordObSale;
	}

	public OrderMethod getOrdObPurchase() {
		return ordObPurchase;
	}

	public void setOrdObPurchase(OrderMethod ordObPurchase) {
		this.ordObPurchase = ordObPurchase;
	}

	@Override
	public String toString() {
		return "Part [partId=" + partId + ", partCode=" + partCode + ", partLen=" + partLen + ", partWidth=" + partWidth
				+ ", partHgt=" + partHgt + ", partBaseCost=" + partBaseCost + ", partBaseCurrency=" + partBaseCurrency
				+ ", partDesc=" + partDesc + ", uomOb=" + uomOb + ", ordObSale=" + ordObSale + ", ordObPurchase="
				+ ordObPurchase + "]";
	} 

}
