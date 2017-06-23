package com.sytoss.cache;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import com.sytoss.business.structure.Direction;
import com.sytoss.business.structure.Faculty;
import com.sytoss.business.structure.Group;

public class CacheHolder<T extends CacheableEntity> {

	private String cacheName;

	private boolean inited = false;

	private Map<String, T> cache = new Hashtable<String, T>();

	private static final Logger log = Logger.getLogger(CacheHolder.class);

	public CacheHolder(String name) {
		this.cacheName = name;
	}

	public boolean isInited() {
		return inited;
	}

	public void markAsInited() {
		inited = true;
	}

	public boolean contains(T value) {
		return cache.values().contains(value);
	}

	public Collection<T> values() {
		return cache.values();
	}
	
	public Set<String> keys() {
		return cache.keySet();
	}

	public T getValueByKey(String key) {
		return StringUtils.isNotBlank(key) ? cache.get(key) : null;
	}
	
	public List<Direction> getDirectionByKey(Integer key, Collection<Faculty> collection) {
		ArrayList<Direction> result = new ArrayList<>();
		for(Faculty t : collection) {
			if(key.toString().equals(t.getCacheKey()))
				for(Direction dir : t.getDirectionList())
				result.add(dir);
		}
		return result;
	}
	
	public List<Group> getGroupByKey(Integer key, Collection<Direction> collection) {
		ArrayList<Group> result = new ArrayList<>();
		for(Direction t : collection) {
			if(key.toString().equals(t.getCacheKey()))
				for(Group dir : t.getGroupList())
				result.add(dir);
		}
		return result;
	}

	public void putValue(String key, T value) {
		cache.put(key, value);
	}

	public void setValues(List<T> data) {
		cache.clear();
		for (T entity : data) {
			putValue(entity.getCacheKey(), entity);
		}
	}
	
	public void setValue(T data) {
		cache.clear();
			putValue(data.getCacheKey(), data);
	}

	public boolean exists(String key) {
		return StringUtils.isNotBlank(key) && cache.containsKey(key);
	}

	public T remove(String key) {
		return cache.remove(key);
	}

	private File getCacheFile() {
		String userHome = System.getProperty("user.home");
		if (userHome == null) {
			userHome = ".";
		}
		File cacheFolder = new File(userHome, ".schedule");
		if (!cacheFolder.exists()) {
			cacheFolder.mkdirs();
		}
		return new File(cacheFolder, cacheName);
	}

	@SuppressWarnings("unchecked")
	public boolean loadFromFileSystem() {
		boolean result = false;
		if (getCacheFile().exists()) {
			try {
				ObjectInputStream ost = new ObjectInputStream(new FileInputStream(getCacheFile()));
				try {
					cache = (Map<String, T>) ost.readObject();
					result = true;
				} finally {
					ost.close();
				}
			} catch (Exception e) {
				log.error("Error while reading cache from file system!\n");
			}
		}
		return result;
	}

	public boolean saveToFileSystem() {
		try {
			ObjectOutputStream ost = new ObjectOutputStream(new FileOutputStream(getCacheFile()));
			try {
				ost.writeObject(cache);
				ost.flush();
			} finally {
				ost.close();
			}
		} catch (IOException e) {
			log.error("Error while saving cache to file system!\n");
			return false;
		}
		return true;
	}

	public void markAsFailed() {
		inited = false;
	}

}
