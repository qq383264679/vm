package com.feng.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.feng.model.Product;
import com.feng.model.User;
import com.feng.service.ProductService;
import com.feng.service.UserService;

public class RegAction extends BaseAction<User> implements SessionAware{
	private Map<String, Object> session;// sessionMAP
	private List<Product> products;  //进行request郁闷传递
	private ProductService productService;  //Spring自动注入
	private UserService userService;
	private int numbers = 2;
	private int pages = 1;
	private int totals; //总共页数
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public List<Product> getProducts() {
		return products;
	}
	public int getTotals() {
		return totals;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	//注册用户
	public String doReg() {
		products = productService.getProducts(numbers, pages);
		totals = (productService.getProducts().size() + 1) / 2;
		return "succeed";
	}
	public void validateDoReg() {
		boolean b = userService.checkName(this.user.getUserName());
		if(this.user.getUserName().trim().equals("") || this.user.getPassword().trim().equals("")) {
			this.addFieldError("error", "用户名或者密码不能为空");			
		} else if(b) {
			this.addFieldError("error", "用户名已经被注册");
		} else {
			userService.saveUser(this.user);
			session.put("user", this.user);
		}
	}
	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
}
