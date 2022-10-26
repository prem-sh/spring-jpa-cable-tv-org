package com.premsh.jpaexperiment.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SubscriptionInputDto {
	private Integer packageId;
	private String validity;
	private Double price;
	private Integer status;
	private Integer customerId;
	
	
	public Integer getPackageId() {
		return packageId;
	}
	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}
	public Date getValidity() {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(validity);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public void setValidity(String validity) {
		this.validity = validity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	
	
}
