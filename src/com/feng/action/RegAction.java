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
	private List<Product> products;  //����request���ƴ���
	private ProductService productService;  //Spring�Զ�ע��
	private UserService userService;
	private int numbers = 2;
	private int pages = 1;
	private int totals; //�ܹ�ҳ��
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
	//ע���û�
	public String doReg() {
		products = productService.getProducts(numbers, pages);
		totals = (productService.getProducts().size() + 1) / 2;
		return "succeed";
	}
	public void validateDoReg() {
		boolean b = userService.checkName(this.user.getUserName());
		if(this.user.getUserName().trim().equals("") || this.user.getPassword().trim().equals("")) {
			this.addFieldError("error", "�û����������벻��Ϊ��");			
		} else if(b) {
			this.addFieldError("error", "�û����Ѿ���ע��");
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
