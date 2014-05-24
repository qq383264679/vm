package com.feng.service;

import java.util.List;

import com.feng.model.OrderLine;

public interface OrderLineService extends BaseService<OrderLine> {
	public void saveOrderlines(OrderLine orderLine);
	public List<OrderLine> getOrderLines(String userName);
	public OrderLine getOrderLine(int id);
	public void deleteOrderLine(OrderLine orderLine);
	public void deleteOrderLine(int orderId);
}
