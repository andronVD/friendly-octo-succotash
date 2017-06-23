package com.sytoss.services.cache;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.sytoss.enummapping.cache.CacheFactory;
import com.sytoss.services.business.TeacherService;
import com.sytoss.services.business.UniversityService;

public abstract class AbstractCacheService {

	@Value("${app.environment}")
	protected String environment;

	@Autowired
	protected UniversityService universityService;
	
	@Autowired
	protected TeacherService teacherService;

	protected final Logger log = Logger.getLogger(getClass());

	protected void setAllCachesFailed() {
		CacheFactory.INSTANCE.getFacultyCache().markAsFailed();
		CacheFactory.INSTANCE.getDirectionCache().markAsFailed();
		CacheFactory.INSTANCE.getGroupCache().markAsFailed();
		CacheFactory.INSTANCE.getFacultyCache().markAsFailed();
		CacheFactory.INSTANCE.markAsFailed();
	}

	protected void saveAllCaches() {
		CacheFactory.INSTANCE.getFacultyCache().saveToFileSystem();
		CacheFactory.INSTANCE.getDirectionCache().saveToFileSystem();
		CacheFactory.INSTANCE.getGroupCache().saveToFileSystem();
		CacheFactory.INSTANCE.getFacultyCache().saveToFileSystem();
	}

	protected void setAllCachesInit() {
		CacheFactory.INSTANCE.markAsInited();
		CacheFactory.INSTANCE.getFacultyCache().markAsInited();
		CacheFactory.INSTANCE.getDirectionCache().markAsInited();
		CacheFactory.INSTANCE.getGroupCache().markAsInited();
		CacheFactory.INSTANCE.getFacultyCache().markAsInited();
	}
}
