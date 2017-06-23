package com.sytoss.services.cache.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sytoss.business.structure.Direction;
import com.sytoss.business.structure.Faculty;
import com.sytoss.business.structure.Group;
import com.sytoss.business.structure.University;
import com.sytoss.enummapping.cache.CacheFactory;
import com.sytoss.services.cache.AbstractCacheService;
import com.sytoss.services.cache.CacheInitializationService;

@Service
public class CacheInitializationServiceImpl extends AbstractCacheService implements CacheInitializationService {

	//@PostConstruct
	public void init() {
		try {
			List<Faculty> facultyCache = new ArrayList<>();
			List<Direction> directionCache = new ArrayList<>();
			List<Group> groupCache = new ArrayList<>();
			University universityCache = new University();
			if ("local".equalsIgnoreCase(environment)) {
				if (!CacheFactory.INSTANCE.getUniversityCache().loadFromFileSystem()) {
					CacheFactory.INSTANCE.getUniversityCache()
							.setValue(teacherService.getUniversty());
					universityCache = teacherService.getUniversty();
				}
				if (!CacheFactory.INSTANCE.getFacultyCache().loadFromFileSystem()) {
					CacheFactory.INSTANCE.getFacultyCache()
							.setValues(universityService.getFacultyList().getFacultyList());
					facultyCache = universityService.getFacultyList().getFacultyList();
				}
				if (!CacheFactory.INSTANCE.getDirectionCache().loadFromFileSystem()) {
					for (Faculty item : facultyCache) {
						directionCache.addAll(universityService.getDirectionListByFaculty(item.getId()));
					}
					CacheFactory.INSTANCE.getDirectionCache().setValues(directionCache);
				}
				if (!CacheFactory.INSTANCE.getGroupCache().loadFromFileSystem()) {
					for (Direction item : directionCache) {
						groupCache.addAll(universityService.getGroupListByDirection(item.getId()));
					}
					CacheFactory.INSTANCE.getGroupCache().setValues(groupCache);
				}
				saveAllCaches();
			} else {
				universityCache = teacherService.getUniversty();
				CacheFactory.INSTANCE.getUniversityCache().setValue(universityCache);
				facultyCache = universityService.getFacultyList().getFacultyList();
				CacheFactory.INSTANCE.getFacultyCache().setValues(facultyCache);
				for (Faculty item : facultyCache) {
					directionCache.addAll(universityService.getDirectionListByFaculty(item.getId()));
				}
				CacheFactory.INSTANCE.getDirectionCache().setValues(directionCache);
				for (Direction item : directionCache) {
					groupCache.addAll(universityService.getGroupListByDirection(item.getId()));
				}
				CacheFactory.INSTANCE.getGroupCache().setValues(groupCache);
			}
			setAllCachesInit();
			log.info("Cache initialized succesfully.");
		} catch (Throwable t) {
			CacheFactory.INSTANCE.markAsFailed();
			log.error("Cache initialization failed.", t);
			throw new IllegalStateException(t);
		}
	}

}