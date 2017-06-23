package com.sytoss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sytoss.business.structure.Faculty;
import com.sytoss.business.structure.Group;
import com.sytoss.business.structure.University;
import com.sytoss.services.business.impl.UniversityServiceImpl;

@Controller
public class IndexController {

	@Autowired
	UniversityServiceImpl universityService;
	
	@RequestMapping(value = "/groupSchedule", method = RequestMethod.GET)
	public ModelAndView groupSchedule() {
		University university = universityService.getFacultyList();
		return new ModelAndView("groupSchedule", "university", university);
	}
	
	@PostMapping(value = "/directionsByFaculty")
	public ModelAndView directionListByFaculty(@RequestParam(value = "idFaculty") Integer idFaculty) {
		Faculty faculty = new Faculty();
		faculty.setId(idFaculty);
		faculty.setDirectionList(universityService.getDirectionListByFaculty(idFaculty));
		return new ModelAndView("directionsByFaculty", "faculty", faculty);
	}
	
	@PostMapping(value = "/groupsByDirection")
	public ModelAndView groupListByDirection(@RequestParam(value = "idDirection") Integer idDirection, @RequestParam(value = "idFaculty") Integer idFaculty) {
		List<Group> groupList = universityService.getGroupListByDirection(idDirection, idFaculty);
		return new ModelAndView("groupsByDirection", "groupList", groupList);
	}
	
	@PostMapping(value = "/scheduleData", produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getScheduleData(@RequestParam(value = "idGroup") Integer idGroup, @RequestParam(value = "startDate") String startDate, @RequestParam(value = "endDate") String endDate) {
		return universityService.getScheduleData(idGroup, startDate, endDate);
	}
	
	/*@RequestMapping(value = "/scheduleWithJson", method = RequestMethod.GET)
	public ModelAndView groupScheduleWithJson() {
		List<Event> event = universityService.getScheduleOfEventType(4801956, StringUtils.EMPTY, StringUtils.EMPTY);
		return new ModelAndView("scheduleWithJson", "event", event);
	}*/
	
}
