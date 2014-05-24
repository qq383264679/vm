package com.feng.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.feng.dao.BaseDao;
import com.feng.model.Order;
import com.feng.model.OrderLine;
import com.feng.service.OrderLineService;

@Service("orderLineService")
public class OrderLineServiceImp extends BaseServiceImp<OrderLine> implements OrderLineService {
	@Resource(name="orderLineDao")
	public void setBaseDao(BaseDao<OrderLine> dao) {
		// TODO Auto-generated method stub
		super.setBaseDao(dao);
	}

	@Override
	public void saveOrderlines(OrderLine orderLine) {
		// TODO Auto-generated method stub
		this.saveEntity(orderLine);
	}

	//根据userName 来查找明细表
	public List<OrderLine> getOrderLines(String userName) {
		// TODO Auto-generated method stub
		String hql = "from OrderLine where orderId in (select orderId from Order where user.userName = ?)";
		return this.findEntityByHQL(hql, userName);
	}

	//根据id查找model
	public OrderLine getOrderLine(int id) {
		// TODO Auto-generated method stub
		return this.getEntity(id);
	}

	//删除model
	public void deleteOrderLine(OrderLine orderLine) {
		// TODO Auto-generated method stub
		this.deleteEntity(orderLine);
	}

	@Override
	public void deleteOrderLine(int orderId) {
		// TODO Auto-generated method stub
		this.deleteEntity(this.getEntity(orderId));
	}

}
