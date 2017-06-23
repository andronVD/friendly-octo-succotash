package com.sytoss.services.business;

import java.util.List;

import com.sytoss.business.structure.Direction;
import com.sytoss.business.structure.Group;
import com.sytoss.business.structure.University;

public interface UniversityService {
	University getFacultyList();
	List<Direction> getDirectionListByFaculty(Integer idFaculty);
	List<Group> getGroupListByDirection(Integer idDirection,Integer idFaculty);
	String getScheduleData(Integer idGroup, String startDate, String endDate);
	List<Group> getGroupListByDirection(Integer idDirection);
	/*List<Event> getScheduleOfEventType(Integer idGroup, String startDate, String endDate);*/
}
