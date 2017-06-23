package com.sytoss.services.business.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.sytoss.business.structure.Direction;
import com.sytoss.business.structure.Faculty;
import com.sytoss.business.structure.Group;
import com.sytoss.business.structure.University;
import com.sytoss.controller.URLConnection;
import com.sytoss.enummapping.JSONObjectsEnum;
import com.sytoss.enummapping.URLEnum;
import com.sytoss.services.business.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService {

	private static final Logger log = Logger.getLogger(UniversityServiceImpl.class);

	@Override
	public University getFacultyList() {
		List<Faculty> facList = new ArrayList<Faculty>();
		URL url;
		University university = null;
		try {
			log.info("Getting the list of faculties...");
			url = new URL(URLEnum.INSTANCE.getFacultyRequest());
			JSONObject obj = new JSONObject(URLConnection.parsedString(url));
			JSONObject univerObj = obj.getJSONObject(JSONObjectsEnum.INSTANCE.getUniversity());
			JSONArray facArray = univerObj.getJSONArray(JSONObjectsEnum.INSTANCE.getFacultyArray());
			for (int i = 0; i < facArray.length(); i++) {
				JSONObject result = facArray.getJSONObject(i);
				Faculty temp = new Faculty();
				temp.setShortName(result.getString(JSONObjectsEnum.INSTANCE.getShortName()));
				temp.setFullName(result.getString(JSONObjectsEnum.INSTANCE.getFullName()));
				temp.setId(result.getInt(JSONObjectsEnum.INSTANCE.getId()));
				facList.add(temp);
			}
			university = new University();
			university.setFacultyList(facList);
		} catch (Exception e) {
			log.error(e);
		}
		return university;
	}

	@Override
	public List<Direction> getDirectionListByFaculty(Integer idFaculty) {
		URL url;
		List<Direction> dirList = null;
		StringBuilder urlStringBuilder = new StringBuilder(URLEnum.INSTANCE.getDirectionByFacultyRequest())
				.append(URLEnum.INSTANCE.getFacultyIdParameter());
		urlStringBuilder.append(idFaculty);
		try {
			url = new URL(urlStringBuilder.toString());
			dirList = new ArrayList<Direction>();
			JSONObject obj = new JSONObject(URLConnection.parsedString(url));
			JSONObject facObject = obj.getJSONObject(JSONObjectsEnum.INSTANCE.getFaculty());
			JSONArray directArray = facObject.getJSONArray(JSONObjectsEnum.INSTANCE.getDirectionArray());
			log.info("Getting the direction list by faculty "
					+ facObject.getString(JSONObjectsEnum.INSTANCE.getShortName()));
			for (int i = 0; i < directArray.length(); i++) {
				JSONObject iterObject = directArray.getJSONObject(i);
				Direction direction = new Direction();
				direction.setId(iterObject.getInt(JSONObjectsEnum.INSTANCE.getId()));
				direction.setShortName(iterObject.getString(JSONObjectsEnum.INSTANCE.getFullName()));
				direction.setFullName(iterObject.getString(JSONObjectsEnum.INSTANCE.getShortName()));
				dirList.add(direction);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return dirList;
	}

	@Override
	public List<Group> getGroupListByDirection(Integer idDirection, Integer idFaculty) {
		URL url;
		List<Group> resultGroup = new ArrayList<Group>();
		StringBuilder urlStringBuilder = new StringBuilder(URLEnum.INSTANCE.getGroupByDirectionRequest())
				.append(URLEnum.INSTANCE.getDirectionParameter());
		urlStringBuilder.append(idDirection).append(URLEnum.INSTANCE.getAmpersand())
				.append(URLEnum.INSTANCE.getFacultyIdParameter()).append(idFaculty);
		try {
			log.info("Getting the group list by directionId - " + idDirection);
			url = new URL(urlStringBuilder.toString());
			JSONObject obj = new JSONObject(URLConnection.parsedString(url));
			JSONObject facObject = obj.getJSONObject(JSONObjectsEnum.INSTANCE.getFaculty());
			JSONArray dirArray = facObject.getJSONArray(JSONObjectsEnum.INSTANCE.getDirectionArray());
			for (int j = 0; j < dirArray.length(); j++) {
				JSONObject iterObjDir = dirArray.getJSONObject(j);
				JSONArray groupArray = iterObjDir.getJSONArray(JSONObjectsEnum.INSTANCE.getGroupArray());
				for (int i = 0; i < groupArray.length(); i++) {
					JSONObject iterObj = groupArray.getJSONObject(i);
					Group group = new Group();
					group.setId(iterObj.getInt(JSONObjectsEnum.INSTANCE.getId()));
					group.setName(iterObj.getString(JSONObjectsEnum.INSTANCE.getName()));
					resultGroup.add(group);
				}
			}
		} catch (Exception e) {
			log.error(e);
		}
		return resultGroup;
	}

	@Override
	public List<Group> getGroupListByDirection(Integer idDirection) {
		URL url;
		List<Group> resultGroup = new ArrayList<Group>();
		StringBuilder urlStringBuilder = new StringBuilder(URLEnum.INSTANCE.getGroupByDirectionRequest())
				.append(URLEnum.INSTANCE.getDirectionParameter());
		urlStringBuilder.append(idDirection);
		try {
			log.info("Getting the group list by directionId - " + idDirection);
			url = new URL(urlStringBuilder.toString());
			JSONObject obj = new JSONObject(URLConnection.parsedString(url));
			JSONObject dirObject = obj.getJSONObject(JSONObjectsEnum.INSTANCE.getDirection());
			JSONArray groupArray = dirObject.getJSONArray(JSONObjectsEnum.INSTANCE.getGroupArray());
			for (int j = 0; j < groupArray.length(); j++) {
				JSONObject iterObj = groupArray.getJSONObject(j);
				Group group = new Group();
				group.setId(iterObj.getInt(JSONObjectsEnum.INSTANCE.getId()));
				group.setName(iterObj.getString(JSONObjectsEnum.INSTANCE.getName()));
				resultGroup.add(group);
			}
		} catch (Exception e) {
			log.error(e);
		}
		return resultGroup;
	}

	@SuppressWarnings("deprecation")
	@Override
	public String getScheduleData(Integer idGroup, String startDate, String endDate) {
		URL url;
		String result = "";
		Date date = new Date();
		StringBuilder dateString = new StringBuilder();
		log.info("Getting schedule with groupId: " + idGroup + ", startDate: " + startDate + ", endDate: " + endDate);
		if (StringUtils.isEmpty(idGroup)) {
			log.error("Wrong request getting schedule with empty idGroup");
			return "<div class='alert alert-danger' role='alert'>Wrong request!</div>";
		}
		dateString.append(date.getDate()).append(".").append(date.getMonth() + 1).append(".")
				.append(date.getYear() + 1900);
		StringBuilder urlStringBuilder = new StringBuilder(URLEnum.INSTANCE.getScheduleRequest()).append("&Aid_group=")
				.append(idGroup).append("&Aid_potok=0&ADateStart=")
				.append(StringUtils.isEmpty(startDate) ? !StringUtils.isEmpty(endDate) ? endDate : dateString.toString()
						: startDate)
				.append("&ADateEnd=").append(StringUtils.isEmpty(endDate)
						? !StringUtils.isEmpty(startDate) ? startDate : dateString.toString() : endDate);
		try {
			url = new URL(urlStringBuilder.toString());
			result = URLConnection.parsedString(url);
			int index = result
					.indexOf(new String(new StringBuilder("<table class=").append('\u0022').append("MainTT")));
			int lastIndex = result 
					.indexOf(new String(new StringBuilder("<table class=").append('\u0022').append("bottom")));
			result = result.substring(index, lastIndex);
			result = result.replaceAll("MainTT", "table table-bordered"+new String(new StringBuilder().append('\u0022').append(" style='color:#333'")));
			result = result.replaceFirst("<tr>", "<thead>");
			result = result.replaceFirst("</tr>", "</thead><tbody>");
			result = "<div class='table-responsive' style='margin-right: 10%;margin-left: 10%;width:75%;height:20%'>" + result.concat("</div>");
		} catch (Exception e) {
			log.error(e);
		}
		return result;
	}

	/*@Override
	public List<Event> getScheduleOfEventType(Integer idGroup, String startDate, String endDate) {
		List<Event> eventList = null;
		List<Subject> subjectList = null;
		List<Group> groupList = null;
		List<Teacher> teacherList = null;
		List<SubjectType> typeList = null;
		URL url;
		log.info("Getting schedule with groupId: " + idGroup + ", startDate: " + startDate + ", endDate: " + endDate);
		if (StringUtils.isEmpty(idGroup)) {
			log.error("Wrong request getting schedule with empty idGroup");
			return null;
		}
		StringBuilder urlStringBuilder = new StringBuilder("http://cist.nure.ua/ias/app/tt/P_API_EVENTS_GROUP_JSON?")
				.append("p_id_group=").append(idGroup).append("&time_from=1487116800").append("&time_to=1497484800");
		try {
			eventList = new ArrayList<>();
			subjectList = new ArrayList<>();
			groupList = new ArrayList<>();
			teacherList = new ArrayList<>();
			typeList = new ArrayList<>();
			url = new URL(urlStringBuilder.toString());
			JSONObject obj = new JSONObject(URLConnection.parsedString(url));
			JSONArray eventArray = obj.getJSONArray("events");
			for (int i = 0; i < eventArray.length(); i++) {
				JSONObject iterObj = eventArray.getJSONObject(i);
				Event event = new Event();
				event.setSubjectId(iterObj.getInt("subject_id"));
				Long startTime = iterObj.getLong("start_time");
				Long endTime = iterObj.getLong("end_time");
				event.setStartTime(new Date(Long.parseLong(startTime.toString())));
				event.setEndTime(new Date(Long.parseLong(endTime.toString())));
				event.setType(iterObj.getInt("type"));
				event.setAuditory(iterObj.getString("auditory"));
				event.setNumberPair(iterObj.getInt("number_pair"));
				JSONArray teachers = iterObj.getJSONArray("teachers");
				List<Integer> teachersId = new ArrayList<>();
				for (int j = 0; j < teachers.length(); j++) {
					Integer id = teachers.getInt(j);
					teachersId.add(id);
				}
				JSONArray groups = iterObj.getJSONArray("groups");
				List<Integer> groupsId = new ArrayList<>();
				for (int j = 0; j < groups.length(); j++) {
					Integer id = groups.getInt(j);
					groupsId.add(id);
				}
				event.setGroupArray(groupsId);
				event.setTeacherArray(teachersId);
				eventList.add(event);
			}
			JSONArray subjectArray = obj.getJSONArray("subjects");
			for (int i = 0; i < subjectArray.length(); i++) {
				JSONObject iterObj = subjectArray.getJSONObject(i);
				Subject subject = new Subject();
				subject.setId(iterObj.getInt("id"));
				subject.setBrief(iterObj.getString("brief"));
				subject.setTitle(iterObj.getString("title"));
				subjectList.add(subject);
			}
			JSONArray groupArray = obj.getJSONArray("groups");
			for (int i = 0; i < groupArray.length(); i++) {
				JSONObject iterObj = groupArray.getJSONObject(i);
				Group group = new Group();
				group.setId(iterObj.getInt("id"));
				group.setName(iterObj.getString("name"));
				groupList.add(group);
			}
			JSONArray teacherArray = obj.getJSONArray("teachers");
			for (int i = 0; i < teacherArray.length(); i++) {
				JSONObject iterObj = teacherArray.getJSONObject(i);
				Teacher teacher = new Teacher();
				teacher.setId(iterObj.getInt("id"));
				teacher.setShortName(iterObj.getString("short_name"));
				teacher.setFullName(iterObj.getString("full_name"));
				teacherList.add(teacher);
			}
			JSONArray typeArray = obj.getJSONArray("types");
			for (int i = 0; i < typeArray.length(); i++) {
				JSONObject iterObj = typeArray.getJSONObject(i);
				SubjectType type = new SubjectType();
				type.setId(iterObj.getInt("id"));
				type.setShortName(iterObj.getString("short_name"));
				type.setFullName(iterObj.getString("full_name"));
				type.setIdBase(iterObj.getInt("id_base"));
				type.setType(iterObj.getString("type"));
				typeList.add(type);
			}

			for (Event e : eventList) {
				List<Teacher> tempListTeacher = new ArrayList<>();
				List<Group> tempListGroup = new ArrayList<>();
				for (Subject sub : subjectList) {
					if (e.getSubjectId().compareTo(sub.getId()) == 0) {
						e.setSubject(sub);
					}
				}
				for (SubjectType type : typeList) {
					if (e.getType().compareTo(type.getId()) == 0) {
						e.setSubjectType(type);
					}
				}
				for (Integer intT : e.getTeacherArray()) {
					for (Teacher teacher : teacherList) {
						if (intT.compareTo(teacher.getId()) == 0) {
							tempListTeacher.add(teacher);
						}
					}
				}
				e.setTeacherList(tempListTeacher);
				for (Integer grT : e.getGroupArray()) {
					for (Group group : groupList) {
						if (grT.compareTo(group.getId()) == 0) {
							tempListGroup.add(group);
						}
					}
				}
				e.setGroupList(tempListGroup);
			}

		} catch (Exception e) {
			log.error(e);
		}
		return eventList;
	}*/

	/*
	 * public University getFacultyCacheList() { University university = new
	 * University(); university.setFacultyList(new
	 * ArrayList<Faculty>(CacheFactory.INSTANCE.getFacultyCache().values()));
	 * return university; }
	 * 
	 * public List<Direction> getDirectionListByFacultyCache(Integer idFaculty)
	 * { return
	 * CacheFactory.INSTANCE.getDirectionCache().getDirectionByKey(idFaculty,
	 * CacheFactory.INSTANCE.getFacultyCache().values()); }
	 * 
	 * public List<Group> getGroupListByDirectionCache(Integer idDirection) {
	 * return new
	 * ArrayList<Group>(CacheFactory.INSTANCE.getGroupCache().getGroupByKey(
	 * idDirection, CacheFactory.INSTANCE.getDirectionCache().values())); }
	 */

}
