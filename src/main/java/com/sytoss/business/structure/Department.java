package com.sytoss.business.structure;

import java.util.List;

import com.sytoss.business.Teacher;
import com.sytoss.cache.CacheableEntity;

public class Department implements CacheableEntity {

	private String shortName;
	
	private Integer id;
	
	private String fullName;
	
	private List<Teacher> teacherArray;

	public List<Teacher> getTeacherArray() {
		return teacherArray;
	}

	public void setTeacherArray(List<Teacher> teacherArray) {
		this.teacherArray = teacherArray;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullname) {
		this.fullName = fullname;
	}

	@Override
	public String getCacheKey() {
		return id.toString();
	}
}
