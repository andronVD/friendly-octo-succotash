package com.sytoss.enummapping;

public enum JSONObjectsEnum {
	
	INSTANCE;
	
	private String fullName = "full_name";
	
	private String shortName = "short_name";
	
	private String id = "id";
	
	private String faculty = "faculty";
	
	private String directionArray = "directions";
	
	private String facultyArray = "faculties";
	
	private String university = "university";
	
	private String groupArray = "groups";
	
	private String name = "name";
	
	private String departmentArray = "departments";
	
	private String specialityArray = "specialities";
	
	private String direction = "direction";
	
	private String teacherArray = "teachers";
	
	public String getFullName() {
		return fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public String getId() {
		return id;
	}

	public String getFaculty() {
		return faculty;
	}

	public String getDirectionArray() {
		return directionArray;
	}

	public String getFacultyArray() {
		return facultyArray;
	}

	public String getUniversity() {
		return university;
	}

	public String getGroupArray() {
		return groupArray;
	}

	public String getName() {
		return name;
	}

	public String getDepartmentArray() {
		return departmentArray;
	}

	public String getSpecialityArray() {
		return specialityArray;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getTeacherArray() {
		return teacherArray;
	}

	public void setTeacherArray(String teacherArray) {
		this.teacherArray = teacherArray;
	}
}
