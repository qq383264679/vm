package com.feng.model;

import java.util.Date;

public class Order {
	private int orderId;
	private Date submitDate = new Date();  //�� �ύʱ��
	
	//���user ---order ��һ�Զ�ӳ��
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
