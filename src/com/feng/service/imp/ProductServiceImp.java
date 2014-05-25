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
	private BaseDao baseDao;
	public void setBaseDao(BaseDao<Product> dao) {
		// TODO Auto-generated method stub
		super.setBaseDao(dao);
	}

	//获取所有电影信息
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		String hql = "from Product as p";
		return baseDao.findEntityByHQL(hql);
	}

	/**
	 * 分页获取电影信息
	 * numbers 每页显示条数
	 * pages  当前页数  page从1开始起
	 */
	public List<Product> getProducts(int numbers, int pages) {
		// TODO Auto-generated method stub
		String hql = "from Product as p";
		Session session = baseDao.getSession().openSession();
		Query q = session.createQuery(hql);
		
		int nowPages = (pages-1)*numbers;
		q.setFirstResult(nowPages);   
		q.setMaxResults(numbers);
		return q.list();
	}

	/*
	 * (non-Javadoc)
	 * @see com.feng.service.ProductService#getProduct(int)
	 */
	public Product getProduct(int productId) {
		// TODO Auto-generated method stub
		return (Product) baseDao.getEntity(productId);
	}

	@Override
	public void saveProduct(Product p) {
		// TODO Auto-generated method stub
		baseDao.saveEntity(p);
	}



}
