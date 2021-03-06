package com.sytoss.controller;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sytoss.business.structure.Direction;
import com.sytoss.business.structure.Faculty;
import com.sytoss.business.structure.Group;
import com.sytoss.business.structure.Speciality;
import com.sytoss.business.structure.University;

@Controller
public class ScheduleController {
	
	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	public ModelAndView helloWorld() throws MalformedURLException {
		URL url = new URL("http://cist.nure.ua/ias/app/tt/P_API_GROUP_JSON");

		List<Faculty> facList = new ArrayList<Faculty>();
		List<Direction> dirList = new ArrayList<Direction>();
		List<Speciality> specList = new ArrayList<Speciality>();
		List<Group> groupSpecList = new ArrayList<Group>();
		List<Group> groupList = new ArrayList<Group>();

		JSONObject obj = new JSONObject(URLConnection.parsedString(url));
		JSONObject univerObj = obj.getJSONObject("university");
		JSONArray facArray = univerObj.getJSONArray("faculties");

		JSONArray directArray = null;
		JSONArray specialityArray = null;
		JSONArray groupSpecArray = null;
		JSONArray groupArray = null;
		
		for(int i = 0; i < facArray.length(); i++) {
			JSONObject iterObjFac = facArray.getJSONObject(i);
			directArray = iterObjFac.getJSONArray("directions");
			Faculty faculty = new Faculty();
			faculty.setFullName(iterObjFac.getString("full_name"));
			faculty.setId(iterObjFac.getInt("id"));
			faculty.setShortName(iterObjFac.getString("short_name"));
			facList.add(faculty);
			for(int j = 0; j < directArray.length(); j++) {
				JSONObject iterObjDir = directArray.getJSONObject(j);
				specialityArray = iterObjDir.getJSONArray("specialities");
				if(iterObjDir.has("groups")) {
					groupArray = iterObjDir.getJSONArray("groups");
				}
				Direction direction = new Direction();
				direction.setId(iterObjDir.getInt("id"));
				direction.setFullName(iterObjDir.getString("full_name"));
				direction.setShortName(iterObjDir.getString("short_name"));
				dirList.add(direction);
				for(int k = 0; k < specialityArray.length(); k++) {
					JSONObject iterObjSpec = specialityArray.getJSONObject(k);
					if(iterObjSpec.has("groups")) {
						groupSpecArray = iterObjSpec.getJSONArray("groups");
					}
					Speciality speciality = new Speciality();
					speciality.setId(iterObjSpec.getInt("id"));
					speciality.setFullName(iterObjSpec.getString("full_name"));
					speciality.setShortName(iterObjSpec.getString("short_name"));
					specList.add(speciality);
					for(int n = 0; n < groupSpecArray.length(); n++) {
						JSONObject iterObjGroup = groupSpecArray.getJSONObject(n);
						Group group = new Group();
						group.setId(iterObjGroup.getInt("id"));
						group.setName(iterObjGroup.getString("name"));
						groupSpecList.add(group);
					}
					speciality.setGroups(groupSpecList);
				}
				for(int h = 0; h < groupArray.length(); h++) {
					JSONObject iterObjGroup = groupArray.getJSONObject(h);
					Group group = new Group();
					group.setId(iterObjGroup.getInt("id"));
					group.setName(iterObjGroup.getString("name"));
					groupList.add(group);
				}
				direction.setGroupList(groupList);
				direction.setSpecialityList(specList);
			}
			faculty.setDirectionList(dirList);
		}
		University university = new University();
		university.setFullName(univerObj.getString("full_name"));
		university.setShortName(univerObj.getString("short_name"));
		university.setFacultyList(facList);
		return new ModelAndView("schedule", "university", university);
	}
}
