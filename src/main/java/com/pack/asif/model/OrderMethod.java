package com.pack.asif.model;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ordtab")
public class OrderMethod {
	
	@Id
	@GeneratedValue(generator="oidgen")
	@GenericGenerator(name="oidgen",strategy="increment")
	@Column(name="oid")
	private Integer ordId;
	@Column(name="omode")
	private String ordMode;
	@Column(name="ocode")
	private String ordCode;
	@Column(name="otype")
	private String ordType;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="oaccepttab",joinColumns=@JoinColumn(name="oid"))
	@OrderColumn(name="pos")
	@Column(name="oaccept")
	private List<String> ordAccept;
	@Column(name="odesc")
	private String ordDesc;
	public OrderMethod() {
		super();
	}
	
	public OrderMethod(Integer ordId) {
		super();
		this.ordId = ordId;
	}

	public Integer getOrdId() {
		return ordId;
	}
	public void setOrdId(Integer ordId) {
		this.ordId = ordId;
	}
	public String getOrdMode() {
		return ordMode;
	}
	public void setOrdMode(String ordMode) {
		this.ordMode = ordMode;
	}
	public String getOrdCode() {
		return ordCode;
	}
	public void setOrdCode(String ordCode) {
		this.ordCode = ordCode;
	}
	public String getOrdType() {
		return ordType;
	}
	public void setOrdType(String ordType) {
		this.ordType = ordType;
	}
	public List<String> getOrdAccept() {
		return ordAccept;
	}
	public void setOrdAccept(List<String> ordAccept) {
		this.ordAccept = ordAccept;
	}
	public String getOrdDesc() {
		return ordDesc;
	}
	public void setOrdDesc(String ordDesc) {
		this.ordDesc = ordDesc;
	}
	@Override
	public String toString() {
		return "OrderMethod [ordId=" + ordId + ", ordMode=" + ordMode + ", ordCode=" + ordCode + ", ordType=" + ordType
				+ ", ordAccept=" + ordAccept + ", ordDesc=" + ordDesc + "]";
	}
	
	

}
