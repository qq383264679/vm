package com.feng.action;

import java.util.List;

import com.feng.model.Product;
import com.feng.service.ProductService;

public class ProductAction extends BaseAction<Product> {
	private ProductService productService;  //Spring自动注入
	private List<Product> products;  //进行request郁闷传递
	private int totals; //总共页数
	
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
	
	//跳转到 product 主界面   
	public String toMainView() {
		System.out.println(productService);
		totals = (productService.getProducts().size() + 1) / 2;  
		//第一个参数显示页数  第二个参数显示当前页数默认从1开始
		products = productService.getProducts(numbers,pages);
		System.out.println(products.size());
		return "mainView";
	}


}
