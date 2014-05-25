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
	private UserService userService;    //UserService �Ѿ���Spring������ע��
	private List<Product> products;  //����request���ƴ���
	private ProductService productService;  //Spring�Զ�ע��
	private int numbers = 2;
	private int pages = 1;
	private int totals; //�ܹ�ҳ��
	
	public int getTotals() {
		return totals;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	//�����Զ�װ��ģʽ����װ��
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	//����ע�����
	public String toRegView() {
		return "regView";
	}
	//�����½����
	public String toLognView() {
		//ע��session
		session.clear();
		return "lognView";
	}
	
	//���е�¼ЧӦ  ��½�ɹ�������������
	public String doLogn() throws Exception {
		products = productService.getProducts(numbers, pages);
		totals = (productService.getProducts().size() + 1) / 2;
		return "succeed";
	}
	//struts2 ЧӦ����
	/**
	 * �����abc() throws Exception
	 *     validateAbc()
	 *     validate()
	 * actionִ��˳��    validateAbc  - validate  -abc 
	 * validate��һ����ִ�е�
	 */
	public void validateDoLogn() {
		//System.out.println(this.user.getUserName() == null);
		boolean b = userService.checkUser(this.user);
		if(!b) {
			this.addFieldError("error", "�û���������������");
			//this.addFieldError("password", "�û���������������");	
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
