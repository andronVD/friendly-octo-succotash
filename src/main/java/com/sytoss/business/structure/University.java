package com.sytoss.business.structure;

import java.util.List;

import com.sytoss.cache.CacheableEntity;

public class University implements CacheableEntity{
	
	private String fullName;
	
	private String shortName;
	
	private List<Faculty> facultyList;

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

	public List<Faculty> getFacultyList() {
		return facultyList;
	}

	public void setFacultyList(List<Faculty> facultyList) {
		this.facultyList = facultyList;
	}

	@Override
	public String getCacheKey() {
		return shortName;
	}
	
	
}
