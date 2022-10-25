package com.premsh.jpaexperiment.data.userbase.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "subscription_status")
public class SubscriptionStatus {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "subscription_status_id")
	private Integer subscriptionStatusId;
	
	@NotNull
	@Column(name = "subscription_status")
	private String subscriptionStatus;

	public Integer getSubscriptionStatusId() {
		return subscriptionStatusId;
	}

	public void setSubscriptionStatusId(Integer subscriptionStatusId) {
		this.subscriptionStatusId = subscriptionStatusId;
	}

	public String getSubscriptionStatus() {
		return subscriptionStatus;
	}

	public void setSubscriptionStatus(String subscriptionStatus) {
		this.subscriptionStatus = subscriptionStatus;
	}
}
