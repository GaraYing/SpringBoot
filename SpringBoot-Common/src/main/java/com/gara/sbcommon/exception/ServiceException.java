package com.gara.sbcommon.exception;

import com.gara.sbcommon.result.ResultCode;

/**
 * 业务逻辑异常 异常如“ 账号或密码错误 ”，该异常只做INFO级别的日志记录 @see WebMvcConfigurer
 * 
 */
public class ServiceException extends ApplicationException{

	private static final long serialVersionUID = -2678203134198782909L;
	
	public static final String MESSAGE = "业务逻辑异常";
	
	public ServiceException() {
		super(MESSAGE);
	}

	public ServiceException(String message) {
		super(message);
		this.code = ResultCode.SERVICE_ERROR;
	}
	
	public ServiceException(ResultCode code, String message) {
		super(message);
		this.code = code;
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		this.code = ResultCode.SERVICE_ERROR;
	}
	
	public ServiceException(ResultCode code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public ServiceException(Throwable cause) {
		super(cause);
		this.code = ResultCode.SERVICE_ERROR;
	}
}
