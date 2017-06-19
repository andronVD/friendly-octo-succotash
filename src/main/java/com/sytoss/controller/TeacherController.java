package com.sytoss.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sytoss.services.business.TeacherService;

@Controller
public class TeacherController {
	
	@Autowired
	TeacherService teacherService;
	
	@RequestMapping(value = "/teacherList", method = RequestMethod.GET)
	public ModelAndView getDescription(){
	    return new ModelAndView("teacherList", "university", teacherService.getFckingUniver());
	}
}
