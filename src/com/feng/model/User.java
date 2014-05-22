package com.feng.model;

import java.util.Date;

public class User {
	private String userName;
	private String password;
	private Date regDate = new Date();  //×¢²áÊ±¼ä
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

}
