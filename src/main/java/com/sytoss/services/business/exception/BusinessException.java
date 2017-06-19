package com.sytoss.services.business.exception;

public class BusinessException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  private final int code;

  private final String message;

  public BusinessException(int code, String message) {
    super();
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    if (message != null) {
      return message;
    }
    return "Error code " + code;
  }

}
