package com.training.demo.entity;



public class User {

	private int userId;
	private String name;
	private String password;
	private String mobileNumber;

	public User(int userId, String name, String password, String mobileNumber) {
		super();
		this.userId = userId;
		this.name = name;
		this.password = password;
		this.mobileNumber = mobileNumber;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEncodedPassword() {
		return "**********";
	}

	public String getHiddenMobileNumber() {
		return mobileNumber.replaceAll("\\d(?=(?:\\D*\\d){4})", "X");
	}

	@Override
	public String toString() {
		return "userId = " + userId + ", name = " + name + ", password = " + getEncodedPassword()
				+ ", mobile number = " + getHiddenMobileNumber() + "]";
	}

	

}
