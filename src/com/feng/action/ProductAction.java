package com.feng.action;

import java.util.List;

import com.feng.model.Product;
import com.feng.service.ProductService;

public class ProductAction extends BaseAction<Product> {
	private ProductService productService;  //Spring�Զ�ע��
	private List<Product> products;  //����request���ƴ���
	private int totals; //�ܹ�ҳ��
	
	public int getTotals() {
		return totals;
	}
	private int numbers = 2;
	private int pages = 1;
	public List<Product> getProducts() {
		return products;
	}
	public int getNumbers() {
		return numbers;
	}
	public void setNumbers(int numbers) {
		this.numbers = numbers;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	
	//��ת�� product ������   
	public String toMainView() {
		System.out.println(productService);
		totals = (productService.getProducts().size() + 1) / 2;  
		//��һ��������ʾҳ��  �ڶ���������ʾ��ǰҳ��Ĭ�ϴ�1��ʼ
		products = productService.getProducts(numbers,pages);
		System.out.println(products.size());
		return "mainView";
	}


}
