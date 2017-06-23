package com.sytoss.business;

import java.util.List;

import com.sytoss.business.structure.Group;

public class Schedule {
	
	private List<Event> eventArray;
	
	private List<Group> groupArray;
	
	private List<Teacher> teacherArray;
	
	private List<Subject> subjectArray;
	
	private List<SubjectType> typeArray;

	public List<Event> getEventArray() {
		return eventArray;
	}

	public void setEventArray(List<Event> eventArray) {
		this.eventArray = eventArray;
	}

	public List<Group> getGroupArray() {
		return groupArray;
	}

	public void setGroupArray(List<Group> groupArray) {
		this.groupArray = groupArray;
	}

	public List<Teacher> getTeacherArray() {
		return teacherArray;
	}

	public void setTeacherArray(List<Teacher> teacherArray) {
		this.teacherArray = teacherArray;
	}

	public List<Subject> getSubjectArray() {
		return subjectArray;
	}

	public void setSubjectArray(List<Subject> subjectArray) {
		this.subjectArray = subjectArray;
	}

	public List<SubjectType> getTypeArray() {
		return typeArray;
	}

	public void setTypeArray(List<SubjectType> typeArray) {
		this.typeArray = typeArray;
	}
}
