package com.feng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.feng.dao.BaseDao;
import com.feng.dao.imp.UserDaoImp;
import com.feng.model.Order;
import com.feng.model.OrderLine;
import com.feng.model.Product;
import com.feng.model.User;
import com.feng.service.OrderLineService;
import com.feng.service.ProductService;
import com.feng.service.UserService;
import com.feng.util.SpringUtil;


public class Test {
	String[] acx = {"applicationContext.xml", "dbContext.xml"};
	ApplicationContext ctx;
	SessionFactory sessionFactory;
	//初始化srping
	public void init() {
		 ctx = new ClassPathXmlApplicationContext(acx);
	}
	//test sessionFactory
	public  SessionFactory sessionFactoryTest() {
		System.out.println("sssx");
		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		System.out.println(sessionFactory);
		
		return sessionFactory;
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.init();
		t.OrderLinesServiceTest();
	}
	
	
	
	
	public void OrderLinesServiceTest() {
		OrderLineService os = (OrderLineService) ctx.getBean("orderLineService");
		
/*		OrderLine ol = os.getEntity(7);
		os.deleteOrderLine(ol);*/
		

		
		
		List<OrderLine> orderLines = os.getOrderLines("feng", 3, 2);
		for(OrderLine o : orderLines) {
			System.out.println(o.getQuantity());
		}
		System.out.println(orderLines.size());



	}
	
	
	
	
	
	
	public void testProductService() {
		ProductService ps = (ProductService) ctx.getBean("productService");
		
		List<Product> p = ps.getProducts(2, 2);
		for(Product product : p) {
			
			System.out.println(product.getProductId());
		}
	}
	
	
	
	public void testUserDao() {
		UserService service =  (UserService) ctx.getBean("userService");
//		basedao.checkUser(new User());
		
		User u = new User();
		u.setUserName("feng");
		u.setPassword("111");
		
		//boolean b = service.checkUser(u);
		//service.saveUser(u);
		System.out.println(service.checkName("12d"));
	}
	
	
	
	
	
	
	
	
	
	
	
	public void userTest() {
		BaseDao baseDao = (BaseDao) ctx.getBean("userDao");
		User u = new User();
		u.setUserName("feng");
		u.setPassword("111");
		baseDao.saveEntity(u);
	}
	public void productTest() {
		BaseDao baseDao = (BaseDao) ctx.getBean("productDao");
		Product p = new Product();
		p.setDirector("张艺谋");
		p.setLanguage("国语");
		p.setName("红高粱3");
		p.setStarring("11111111111111111111111111111111111111111111");
		p.setGenre("爱情");
		p.setPoster("1.jpg");
		p.setStoryAbstract("343443");
		
		baseDao.saveEntity(p);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void saveUserAndOrderTest() {
		User u = new User();
		u.setUserName("feng");
		u.setPassword("111");
		
		sessionFactory = sessionFactoryTest();
		sessionFactory.openSession().save(u);
		
		Order order = new Order();
		order.setUser(u);
		sessionFactory.openSession().save(order);
		
	}

}
