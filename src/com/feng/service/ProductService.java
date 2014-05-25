package com.feng.service;

import java.util.List;

import com.feng.model.Product;

public interface ProductService {
	public List<Product> getProducts();
	public List<Product> getProducts(int numbers, int pages);
	public Product getProduct(int productId);
	public void saveProduct(Product p);
}
