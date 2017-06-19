package com.sytoss.business.structure;

import java.util.List;

import com.sytoss.cache.CacheableEntity;

public class Faculty implements CacheableEntity {

	private Integer id;

	private String shortName;

	private String fullName;

	private List<Department> departmentList;

	private List<Direction> directionList;

	public Faculty() {
		super();
	}

	public Faculty(String shortName, String fullName, List<Department> department, Integer id) {
		this.shortName = shortName;
		this.fullName = fullName;
		this.departmentList = department;
		this.id = id;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<Department> getDepartment() {
		return departmentList;
	}

	public void setDepartment(List<Department> department) {
		this.departmentList = department;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Direction> getDirectionList() {
		return directionList;
	}

	public void setDirectionList(List<Direction> directionList) {
		this.directionList = directionList;
	}

	@Override
	public String getCacheKey() {
		return id.toString();
	}
}
