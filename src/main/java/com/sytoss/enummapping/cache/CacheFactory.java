package com.sytoss.enummapping.cache;

import com.sytoss.business.structure.Direction;
import com.sytoss.business.structure.Faculty;
import com.sytoss.business.structure.Group;
import com.sytoss.business.structure.University;
import com.sytoss.cache.CacheHolder;

public enum CacheFactory {

	INSTANCE;

	private boolean inited = false;

	private boolean progress = false;

	private CacheHolder<Faculty> facultyCache = new CacheHolder<Faculty>(Faculty.class.getName());

	private CacheHolder<Direction> directionCache = new CacheHolder<Direction>(Direction.class.getName());

	private CacheHolder<Group> groupCache = new CacheHolder<Group>(Group.class.getName());
	
	private CacheHolder<University> universityCache = new CacheHolder<University>(University.class.getName());

	public CacheHolder<Faculty> getFacultyCache() {
		return facultyCache;
	}

	public CacheHolder<Direction> getDirectionCache() {
		return directionCache;
	}

	public CacheHolder<Group> getGroupCache() {
		return groupCache;
	}

	public boolean isProgress() {
		return progress;
	}

	public void setProgress(boolean progress) {
		this.progress = progress;
	}

	public void markAsFailed() {
		inited = false;
	}

	public void markAsInited() {
		inited = true;
	}

	public boolean isInited() {
		return inited;
	}

	public CacheHolder<University> getUniversityCache() {
		return universityCache;
	}

	public void setUniversityCache(CacheHolder<University> universityCache) {
		this.universityCache = universityCache;
	}
}
