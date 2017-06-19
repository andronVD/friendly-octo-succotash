package com.sytoss.business;

import java.util.Date;
import java.util.List;

import com.sytoss.business.structure.Group;

public class Event {

	private Integer subjectId;
	
	private Date startTime;
	
	private Date endTime;
	
	private Integer type;
	
	private Integer numberPair;
	
	private String auditory;
	
	private List<Integer> teacherArray;
	
	private List<Integer> groupArray;
	
	private Subject subject;
	
	private SubjectType subjectType;
	
	private List<Teacher> teacherList;
	
	private List<Group> groupList;

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public SubjectType getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(SubjectType subjectType) {
		this.subjectType = subjectType;
	}

	public List<Teacher> getTeacherList() {
		return teacherList;
	}

	public void setTeacherList(List<Teacher> teacherList) {
		this.teacherList = teacherList;
	}

	public List<Group> getGroupList() {
		return groupList;
	}

	public void setGroupList(List<Group> groupList) {
		this.groupList = groupList;
	}

	public Integer getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}

	public String getStartTime() {
		StringBuilder dateString = new StringBuilder();
		dateString.append(startTime.getDate()).append(".").append(startTime.getMonth()).append(".")
		.append(startTime.getYear());
		return dateString.toString();
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		StringBuilder dateString = new StringBuilder();
		dateString.append(endTime.getDate()).append(".").append(endTime.getMonth()).append(".")
		.append(endTime.getYear());
		return endTime.toString();
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getNumberPair() {
		return numberPair;
	}

	public void setNumberPair(Integer numberPair) {
		this.numberPair = numberPair;
	}

	public String getAuditory() {
		return auditory;
	}

	public void setAuditory(String auditory) {
		this.auditory = auditory;
	}

	public List<Integer> getTeacherArray() {
		return teacherArray;
	}

	public void setTeacherArray(List<Integer> teacherArray) {
		this.teacherArray = teacherArray;
	}

	public List<Integer> getGroupArray() {
		return groupArray;
	}

	public void setGroupArray(List<Integer> groupArray) {
		this.groupArray = groupArray;
	}
}
