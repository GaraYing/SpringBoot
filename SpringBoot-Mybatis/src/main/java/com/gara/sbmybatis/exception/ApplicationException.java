package com.gara.sbmybatis.exception;

import com.gara.sbmybatis.result.ResultCode;

/**
 * 应用异常
 * 
 */
public class ApplicationException extends RuntimeException{

	private static final long serialVersionUID = -2678203134198782909L;
	
	public static final String MESSAGE = "应用异常";

	protected ResultCode code = ResultCode.APPLICATION_ERROR;

	public ApplicationException() {
		super(MESSAGE);
	}

	public ApplicationException(String message) {
		super(message);
	}
	
	public ApplicationException(ResultCode code, String message) {
		super(message);
		this.code = code;
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ApplicationException(ResultCode code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public ResultCode getCode() {
		return code;
	}

	public void setCode(ResultCode code) {
		this.code = code;
	}
}
