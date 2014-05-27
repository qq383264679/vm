package com.feng.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.feng.dao.BaseDao;
import com.feng.model.Product;
import com.feng.service.ProductService;

@Service("productService")
public class ProductServiceImp extends BaseServiceImp<Product> implements ProductService {
	@Resource(name="productDao")
	public void setBaseDao(BaseDao<Product> dao) {
		// TODO Auto-generated method stub
		super.setBaseDao(dao);
	}

	//��ȡ���е�Ӱ��Ϣ
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		String hql = "from Product as p";
		return this.findEntityByHQL(hql);
	}

	/**
	 * ��ҳ��ȡ��Ӱ��Ϣ
	 * numbers ÿҳ��ʾ����
	 * pages  ��ǰҳ��  page��1��ʼ��
	 */
	public List<Product> getProducts(int numbers, int pages) {
		// TODO Auto-generated method stub
		String hql = "from Product as p";
		return this.findEntitys(hql, null, numbers, pages);
	}

	/*
	 * (non-Javadoc)
	 * @see com.feng.service.ProductService#getProduct(int)
	 */
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return (Product) this.getEntity(productId);
	}

	@Override
	public void saveProduct(Product p) {
		// TODO Auto-generated method stub
		this.saveEntity(p);
	}



}
