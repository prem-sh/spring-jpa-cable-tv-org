package com.premsh.jpaexperiment.data.userbase.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "purchase_order_status")
public class PurchaseOrderStatus {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "po_status_id")
	private Integer poStatusId;
	
	@NotNull
	@Column(name = "po_status")
	private String poStatus;

	public Integer getPoStatusId() {
		return poStatusId;
	}

	public void setPoStatusId(Integer poStatusId) {
		this.poStatusId = poStatusId;
	}

	public String getPoStatus() {
		return poStatus;
	}

	public void setPoStatus(String poStatus) {
		this.poStatus = poStatus;
	}
	
}
