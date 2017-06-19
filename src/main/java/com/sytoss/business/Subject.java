package com.sytoss.business;

public class Subject {
	
	private Integer id;
	
	private String brief;
	
	private String title;
	
	private SubjectHours hours;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SubjectHours getHours() {
		return hours;
	}

	public void setHours(SubjectHours hours) {
		this.hours = hours;
	}
}
