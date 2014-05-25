package com.feng.action;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.classic.Validatable;

import com.feng.model.Product;
import com.feng.model.User;
import com.feng.service.ProductService;
import com.feng.service.UserService;

public class LognAction extends BaseAction<User> implements SessionAware,Validatable {
	private Map<String, Object> session;// sessionMAP
	private UserService userService;    //UserService 已经在Spring容器中注入
	private List<Product> products;  //进行request郁闷传递
	private ProductService productService;  //Spring自动注入
	private int numbers = 2;
	private int pages = 1;
	private int totals; //总共页数
	
	public int getTotals() {
		return totals;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	//根据自动装配模式进行装配
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//到达注册界面
	public String toRegView() {
		return "regView";
	}
	//到达登陆界面
	public String toLognView() {
		//注销session
		session.clear();
		return "lognView";
	}
	
	//进行登录效应  登陆成功则调用这个方法
	public String doLogn() throws Exception {
		products = productService.getProducts(numbers, pages);
		totals = (productService.getProducts().size() + 1) / 2;
		return "succeed";
	}
	//struts2 效应方法
	/**
	 * 如果有abc() throws Exception
	 *     validateAbc()
	 *     validate()
	 * action执行顺序：    validateAbc  - validate  -abc 
	 * validate是一定会执行的
	 */
	public void validateDoLogn() {
		//System.out.println(this.user.getUserName() == null);
		boolean b = userService.checkUser(this.user);
		if(!b) {
			this.addFieldError("error", "用户名或者密码有误");
			//this.addFieldError("password", "用户名或者密码有误");	
		} else {				
			session.put("user", this.user);
		}
		
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
}
