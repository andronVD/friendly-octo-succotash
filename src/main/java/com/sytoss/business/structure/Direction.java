package com.sytoss.business.structure;

import java.util.List;

import com.sytoss.cache.CacheableEntity;

public class Direction implements CacheableEntity {

	private Integer id;
	
	private String shortName;
	
	private String fullName;
	
	private List<Speciality> specialityList;
	
	private List<Group> groupList;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String short_name) {
		this.shortName = short_name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String full_name) {
		this.fullName = full_name;
	}

	public List<Speciality> getSpecialityList() {
		return specialityList;
	}

	public void setSpecialityList(List<Speciality> specialities) {
		this.specialityList = specialities;
	}

	public List<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}

	@Override
	public String getCacheKey() {
		return id.toString();
	}

}
