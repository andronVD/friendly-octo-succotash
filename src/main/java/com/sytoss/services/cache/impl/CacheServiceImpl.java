package com.sytoss.services.cache.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sytoss.business.structure.Direction;
import com.sytoss.business.structure.Faculty;
import com.sytoss.business.structure.Group;
import com.sytoss.business.structure.University;
import com.sytoss.enummapping.cache.CacheFactory;
import com.sytoss.services.business.exception.CacheReloadException;
import com.sytoss.services.business.exception.CacheReloadInProgressException;
import com.sytoss.services.cache.AbstractCacheService;
import com.sytoss.services.cache.CacheService;

@Service
public class CacheServiceImpl extends AbstractCacheService implements CacheService {

	  @Override
	  public void reload() throws CacheReloadException {
	    if (CacheFactory.INSTANCE.isProgress()) {
	      throw new CacheReloadInProgressException();
	    }
	    log.info("Start Cache reset process...");
	    log.info("Read data in local buffers.");
	    try {
	      CacheFactory.INSTANCE.setProgress(true);
	      List<Faculty> facultyCache = universityService.getFacultyList().getFacultyList();
	      List<Direction> directionCache = new ArrayList<>();
	      List<Group> groupCache = new ArrayList<>();
	      University universityCache = new University();
	      
	      universityCache = teacherService.getUniversty();
	      
	      for(Faculty item : facultyCache) {
	    	  directionCache.addAll(universityService.getDirectionListByFaculty(item.getId()));
	      }
	      for(Direction item : directionCache) {
	    	  groupCache.addAll(universityService.getGroupListByDirection(item.getId()));
	      }
	      if ("local".equalsIgnoreCase(environment)) {
	        log.info("Save caches to local files.");
	        saveAllCaches();
	      }
	      log.info("Start of cache change.");
	      setAllCachesFailed();
	      CacheFactory.INSTANCE.getUniversityCache().setValue(universityCache);
	      CacheFactory.INSTANCE.getFacultyCache().setValues(facultyCache);
	      CacheFactory.INSTANCE.getDirectionCache().setValues(directionCache);
	      CacheFactory.INSTANCE.getGroupCache().setValues(groupCache);
	      setAllCachesInit();
	      log.info("Cache has been reloaded succesfully.");
	    } catch (Throwable t) {
	      log.error("Cache reloading has been failed.", t);
	      throw new CacheReloadException(t);
	    } finally {
	      CacheFactory.INSTANCE.setProgress(false);
	    }
	  }
}
