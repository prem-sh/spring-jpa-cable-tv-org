package com.premsh.jpaexperiment.data.channelbase.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.premsh.jpaexperiment.data.userbase.models.Subscription;

@Entity
@Table(name = "package")
public class Package {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "package_id")
	private Integer packageId;
	
	@NotNull
	@Column(name = "package_name")
	private String packageName;

	@Column(name = "Description")
	private String description;	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "package_channel",
			joinColumns =  @JoinColumn(name = "package_id", referencedColumnName = "package_id"),
			inverseJoinColumns =  @JoinColumn(name = "channel_id", referencedColumnName = "channel_id")
	)
	private List<Channel> channels;
	
	public Integer getPackageId() {
		return packageId;
	}

	public void setPackageId(Integer packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}
}
