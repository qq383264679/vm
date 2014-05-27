package com.feng.service;

import java.util.List;

import com.feng.model.OrderLine;
import com.feng.model.Product;

public interface OrderLineService extends BaseService<OrderLine> {
	public void saveOrderlines(OrderLine orderLine);
	public List<OrderLine> getOrderLines(String userName, int numbers, int pages);
	public OrderLine getOrderLine(int id);
	public void deleteOrderLine(OrderLine orderLine);
	public void deleteOrderLine(int orderId);
	
	public List<OrderLine> getOrderLines(String userName);
}
