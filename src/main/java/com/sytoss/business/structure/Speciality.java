package com.sytoss.business.structure;

import java.util.List;

import com.sytoss.cache.CacheableEntity;

public class Speciality implements CacheableEntity {
	
	private Integer id;
	
	private String fullName;
	
	private String shortName;
	
	private List<Group> groups;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public List<Group> getGroups() {
		return groups;
	}

	public void setGroups(List<Group> groups) {
		this.groups = groups;
	}
	
	@Override
	public String getCacheKey() {
		return id.toString();
	}
}
