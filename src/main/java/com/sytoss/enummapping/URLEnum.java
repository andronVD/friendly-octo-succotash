package com.sytoss.enummapping;

public enum URLEnum {
	
	INSTANCE;
	
	private String facultyRequest = "http://cist.nure.ua/ias/app/tt/P_API_FACULTIES_JSON";
	
	private String directionByFacultyRequest = "http://cist.nure.ua/ias/app/tt/P_API_DIRECTIONS_JSON?";
	
	private String groupByDirectionRequest = "http://cist.nure.ua/ias/app/tt/P_API_GRP_OF_DIRECTIONS_JSON?";
	
	private String scheduleRequest = "http://cist.nure.ua/ias/app/tt/WEB_IAS_TT_GNR_RASP.GEN_GROUP_POTOK_RASP?ATypeDoc=1";
	
	private String facultyIdParameter = "p_id_faculty=";
	
	private String directionParameter = "p_id_direction=";
	
	private String ampersand = "&";
	
	public String getDirectionByFacultyRequest() {
		return directionByFacultyRequest;
	}

	public String getGroupByDirectionRequest() {
		return groupByDirectionRequest;
	}

	public String getScheduleRequest() {
		return scheduleRequest;
	}

	public String getFacultyIdParameter() {
		return facultyIdParameter;
	}

	public String getDirectionParameter() {
		return directionParameter;
	}

	public String getAmpersand() {
		return ampersand;
	}

	public String getFacultyRequest() {
		return facultyRequest;
	}

}
