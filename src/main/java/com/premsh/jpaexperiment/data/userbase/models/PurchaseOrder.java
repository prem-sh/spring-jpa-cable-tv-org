package com.premsh.jpaexperiment.data.userbase.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="purchase_order")
public class PurchaseOrder {
	@Id
	@GeneratedValue()
	@Column(name = "po_id")
	private Integer purchaseOrderId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
	private Customer customer;
	

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(
			name = "subscription_po",
			joinColumns = @JoinColumn(name = "sub_id"),
			inverseJoinColumns = @JoinColumn(name = "po_id")
	)
	private Set<Subscription> subscriptions;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "tax")
	private Double tax;

	@Column(name = "grand_total")
	private Double grandTotal;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "status", referencedColumnName = "po_status_id")
	private PurchaseOrderStatus status;

	public Integer getPurchaseOrderId() {
		return purchaseOrderId;
	}

	public void setPurchaseOrderId(Integer purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Subscription> getSubscriptions() {
		return subscriptions;
	}

	public void setSubscriptions(Set<Subscription> subscriptions) {
		this.subscriptions = subscriptions;
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

	public Double getGrand_total() {
		return grandTotal;
	}

	public void setGrand_total(Double grand_total) {
		this.grandTotal = grand_total;
	}

	public PurchaseOrderStatus getStatus() {
		return status;
	}

	public void setStatus(PurchaseOrderStatus status) {
		this.status = status;
	}
}
