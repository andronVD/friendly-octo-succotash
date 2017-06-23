package com.sytoss.business.structure;

import com.sytoss.cache.CacheableEntity;

public class Group implements CacheableEntity {

	private Integer id;
	
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getCacheKey() {
		return id.toString();
	}
}
