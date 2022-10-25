package com.premsh.jpaexperiment.dto;
import java.util.List;

public class CreatePackageDto {
	private String packageName;
	private String description;
	private List<Integer> channels;
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
	public List<Integer> getChannels() {
		return channels;
	}
	public void setChannels(List<Integer> channels) {
		this.channels = channels;
	}
	
	
}
