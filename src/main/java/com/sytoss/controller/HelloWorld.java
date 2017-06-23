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

import com.sytoss.business.structure.Department;
import com.sytoss.business.structure.Faculty;

@Controller
public class HelloWorld {

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView helloWorld() throws MalformedURLException {

		List<Department> depList = new ArrayList<Department>();
		URL url = new URL("http://cist.nure.ua/ias/app/tt/P_API_DEPARTMENTS_JSON?p_id_faculty=95");

		JSONObject obj = new JSONObject(URLConnection.parsedString(url));
		JSONObject facObj = obj.getJSONObject("faculty");
		JSONArray depArray = facObj.getJSONArray("departments");
		
		for (int i = 0; i < depArray.length(); i++) {
			JSONObject result = depArray.getJSONObject(i);
			Department department = new Department();
			department.setShortName(result.getString("short_name"));
			department.setFullName(result.getString("full_name"));
			department.setId(result.getInt("id"));
			depList.add(department);
		}
		
		Faculty faculty = new Faculty(facObj.getString("short_name"), facObj.getString("full_name"), depList, null);

		return new ModelAndView("welcome", "faculty", faculty);
	}
}
