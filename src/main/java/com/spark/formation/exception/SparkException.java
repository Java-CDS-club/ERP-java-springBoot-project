package com.spark.formation.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public class SparkException extends RuntimeException {

	/**
	 * generated serial ID
	 */
	private static final long serialVersionUID = -1915699403055768870L;
	
	private HttpStatus httpStatus;
	private String code;
	private String message;
	private Object data;

	public SparkException(HttpStatus httpStatus, String code, String message) {
		super(message);
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
	}

	public SparkException(HttpStatus httpStatus, String code, String message, Object data) {
		super(message);
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	
}
