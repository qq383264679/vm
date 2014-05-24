package com.feng.model;

import java.util.Date;

public class Order {
	private int orderId;
	private Date submitDate = new Date();  //表单 提交时间
	
	//完成user ---order 的一对多映射
	private User user;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
