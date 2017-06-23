package com.sytoss.services.cache;

import com.sytoss.services.business.exception.CacheReloadException;

public interface CacheService {

	public void reload() throws CacheReloadException;
	
}
