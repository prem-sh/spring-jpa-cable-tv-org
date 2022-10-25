package com.premsh.jpaexperiment.data.channelbase.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "channel")
public class Channel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="channel_id")
	private Integer channelId;
	
	@NotNull (message = "channel name cannot be null")
	@Column(name = "channel_name")
	private String channelName;
	
	@NotNull(message = "cost cannot be null")
	@Min(value = 10, message=" 10 is minimum cost")
	@Column(name = "cost")
	private Double cost;
	

	public Integer getChannelId() {
		return channelId;
	}

	public void setChannelId(Integer channelId) {
		this.channelId = channelId;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}
	
}
