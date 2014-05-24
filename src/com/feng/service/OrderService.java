package com.feng.service;

import com.feng.model.Order;



public interface OrderService extends BaseService<Order>{
	public void saveOrer(Order order);
	public Order getOrder(int id);
}
