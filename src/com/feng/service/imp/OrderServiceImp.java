package com.feng.service.imp;

import java.util.List;

import javax.annotation.Resource;


import org.springframework.stereotype.Service;

import com.feng.dao.BaseDao;
import com.feng.dao.imp.BaseDaoImp;
import com.feng.model.Order;
import com.feng.service.OrderService;

@Service("orderService")
public class OrderServiceImp extends BaseServiceImp<Order> implements OrderService {
	@Resource(name="orderDao")
	public void setBaseDao(BaseDao<Order> dao) {
		// TODO Auto-generated method stub
		super.setBaseDao(dao);
	}


}
