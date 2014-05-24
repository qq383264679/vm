package com.feng.model;

public class OrderLine {
	private int orderId;
	
	private int quantity; //定勾数量
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//完成Product  --OrderLine 多对一关系
	private Product product;
	
	//完成Order   --orderLine  一对一的关联
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
