package com.sytoss.business;

import java.util.List;

public class SubjectHours {

	private Integer type;
	
	private Integer val;
	
	private List<Teacher> teacherArray;

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getVal() {
		return val;
	}

	public void setVal(Integer val) {
		this.val = val;
	}

	public List<Teacher> getTeacherArray() {
		return teacherArray;
	}

	public void setTeacherArray(List<Teacher> teacherArray) {
		this.teacherArray = teacherArray;
	}
}
