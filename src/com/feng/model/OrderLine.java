package com.feng.model;

public class OrderLine {
	private int orderId;
	
	private int quantity; //��������
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//���Product  --OrderLine ���һ��ϵ
	private Product product;
	
	//���Order   --orderLine  һ��һ�Ĺ���
	private Order order;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
