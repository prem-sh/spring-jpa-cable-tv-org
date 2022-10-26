package com.premsh.jpaexperiment.dto;

import java.util.List;

public class PurchaseOrderInputDto {
	private Integer customerId;
	private List<Integer> subscriptions;
	private Integer status;
	private Double price;
	private Double tax;
	private Double grandTotal;
	
	
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public List<Integer> getSubscriptions() {
		return subscriptions;
	}
	public void setSubscriptions(List<Integer> subscriptions) {
		this.subscriptions = subscriptions;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getTax() {
		return tax;
	}
	public void setTax(Double tax) {
		this.tax = tax;
	}
	public Double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(Double grandTotal) {
		this.grandTotal = grandTotal;
	}
	
	
}
