package com.pack.asif.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="unittab")
public class UomType {
	
	@Id
	@GeneratedValue
	@Column(name="unid")
	private Integer unitId;
	@Column(name="untype")
	private String unitType;
	@Column(name="unmodel")
	private String unitModel;
	@Column(name="undesc")
	private String unitDesc;
	public UomType() {
		super();
	}
	
	public UomType(Integer unitId) {
		super();
		this.unitId = unitId;
	}

	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getUnitModel() {
		return unitModel;
	}
	public void setUnitModel(String unitModel) {
		this.unitModel = unitModel;
	}
	public String getUnitDesc() {
		return unitDesc;
	}
	public void setUnitDesc(String unitDesc) {
		this.unitDesc = unitDesc;
	}
	@Override
	public String toString() {
		return "UnitOfMeasurementType [unitId=" + unitId + ", unitType=" + unitType + ", unitModel=" + unitModel
				+ ", unitDesc=" + unitDesc + "]";
	}

}
