package com.feng;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.feng.util.SpringUtil;


public class Test {
	String[] acx = {"applicationContext.xml", "dbContext.xml"};
	ApplicationContext ctx;
	//≥ı ºªØsrping
	public void init() {
		 ctx = new ClassPathXmlApplicationContext(acx);
	}
	//test sessionFactory
	public void sessionFactoryTest() {
		SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");
		System.out.println(sessionFactory);
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.init();
		t.sessionFactoryTest();

	}

}
