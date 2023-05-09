package com.training.demo.dto;

import org.springframework.http.HttpStatus;

public class EmployeeResponseDto {

	ResponseStatus responseStatus;
	HttpStatus responseCode;
	int dataSize;
	Object data;

	public ResponseStatus getResponseStatus() {
		return responseStatus;
	}

	public void setResponseStatus(ResponseStatus success) {
		this.responseStatus = success;
	}

	public HttpStatus getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(HttpStatus responseCode) {
		this.responseCode = responseCode;
	}

	public int getDataSize() {
		return dataSize;
	}

	public void setDataSize(int dataSize) {
		this.dataSize = dataSize;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public enum ResponseStatus {
		SUCCESS, FAIL, no_employee_found
	}

}
