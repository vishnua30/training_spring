package com.training.demo.dto;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import com.training.demo.entity.User;

public class UserResponseDto {

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

	@SuppressWarnings("unchecked")
	public Object getData() {

		List<Map<String, String>> userMap = new ArrayList<Map<String, String>>();

		for (User user : (List<User>) data) {
			Map<String, String> map = new LinkedHashMap<>();
			map.put("userId", user.getUserId() + "");
			map.put("name", user.getName());
			map.put("encodedPassword", user.getEncodedPassword());
			map.put("hiddenMobileNumber", user.getHiddenMobileNumber());
			userMap.add(map);
		}
		return userMap;

	}

	public void setData(Object data) {
		this.data = data;
	}

	public enum ResponseStatus {
		SUCCESS, FAIL, no_user_found
	}

}
