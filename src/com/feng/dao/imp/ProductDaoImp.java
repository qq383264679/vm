package com.feng.dao.imp;

import org.springframework.stereotype.Repository;

import com.feng.dao.BaseDao;
import com.feng.model.Product;

@Repository("productDao")
public class ProductDaoImp extends BaseDaoImp<Product> implements BaseDao<Product>{

}
