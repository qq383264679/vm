package com.feng.dao.imp;


import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.feng.dao.BaseDao;


/**
 * BaseDaoImp是一个抽象的类 专门用来继承
 * @author Administrator
 * @param <T>
 *
 * @param <T>
 */

public abstract class BaseDaoImp<T> implements BaseDao<T> {
	Class<T> clazz;
	//注入sessionFactory
	@Resource
	private SessionFactory sf;
	@SuppressWarnings("unchecked")
	public BaseDaoImp() {
		ParameterizedType genType = (ParameterizedType) this.getClass().getGenericSuperclass();  
        this.clazz = (Class<T>)genType.getActualTypeArguments()[0];  
	}
	@Override
	public void saveEntity(T t) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().save(t);
	}

	@Override
	public void saveOrUpdateEntity(T t) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().saveOrUpdate(t);;
	}

	@Override
	public void updateEntity(T t) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().update(t);
	}

	@Override
	public void deleteEntity(T t) {
		// TODO Auto-generated method stub
		sf.getCurrentSession().delete(t);;
		
	}
	//批量处理操作
	@Override
	public void batchEntityByHQL(String hql, Object... object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T loadEntity(int id) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		T t = (T) sf.getCurrentSession().load(clazz, id);
		return t;
	}

	@Override
	public T getEntity(int id) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		T t = (T) sf.getCurrentSession().get(clazz, id);
		return t;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findEntityByHQL(String hql, Object... objects) {
		// TODO Auto-generated method stub
		Query q = sf.getCurrentSession().createQuery(hql);
		for(int i = 0; i < objects.length; i++) {
			q.setParameter(i, objects[i]);
		}
		return q.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findEntitys(String hql, Object object, int numbers, int pages) {
		// TODO Auto-generated method stub
		Query q = sf.getCurrentSession().createQuery(hql);
		if(object != null) {
			q.setParameter(0, object);
		}
		int nowPages = (pages-1)*numbers;
		q.setFirstResult(nowPages);   
		q.setMaxResults(numbers);
		return q.list();
	}

}
