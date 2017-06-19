package com.sytoss.services.business.exception;

public class CacheReloadInProgressException extends BusinessException {

  private static final long serialVersionUID = 1L;

  public CacheReloadInProgressException() {
    super(1, "Cache reload in progress already.");
  }
}
