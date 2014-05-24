package com.feng;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.feng.dao.BaseDao;
import com.feng.dao.imp.UserDaoImp;
import com.feng.model.Order;
import com.feng.model.Product;
import com.feng.model.User;
import com.feng.service.ProductService;
import com.feng.service.UserService;
import com.feng.util.SpringUtil;


public class Test {
	String[] acx = {"applicationContext.xml", "dbContext.xml"};
	ApplicationContext ctx;
	SessionFactory sessionFactory;
	//��ʼ��srping
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
		//t.testProductService();
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
		
		boolean b = service.checkUser(u);
		System.out.println(b);
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
		p.setDirector("����ı");
		p.setLanguage("����");
		p.setName("�����3");
		p.setStarring("11111111111111111111111111111111111111111111");
		p.setGenre("����");
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
