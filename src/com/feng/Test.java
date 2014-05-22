package com.feng;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.feng.dao.BaseDao;
import com.feng.model.Order;
import com.feng.model.Product;
import com.feng.model.User;
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
		t.productTest();
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
		p.setName("红高粱");
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
