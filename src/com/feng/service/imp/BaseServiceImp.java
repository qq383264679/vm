package com.feng.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;

import com.feng.dao.BaseDao;
import com.feng.service.BaseService;
/**
 * BaseServiceImp是一个抽象方法 用于其他service类继承
 * @author Administrator
 *
 * @param <T>
 */
public abstract class BaseServiceImp<T> implements BaseService<T> {
	private BaseDao<T> dao;
	@Resource
	public void setBaseDao(BaseDao<T> dao) {
		this.dao = dao;
	}
	@Override
	public void saveEntity(T t) {
		// TODO Auto-generated method stub
		dao.saveEntity(t);
	}

	@Override
	public void saveOrUpdateEntity(T t) {
		// TODO Auto-generated method stub
		dao.saveOrUpdateEntity(t);;
	}
	@Override
	public List<T> findEntitys(String hql,Object object, int numbers, int pages) {
		// TODO Auto-generated method stub
		return dao.findEntitys(hql, object,numbers, pages);
	}
	@Override
	public void updateEntity(T t) {
		// TODO Auto-generated method stub
		dao.updateEntity(t);
	}

	@Override
	public void deleteEntity(T t) {
		// TODO Auto-generated method stub
		dao.deleteEntity(t);
	}

	@Override
	public void batchEntityByHQL(String hql, Object... object) {
		// TODO Auto-generated method stub
		dao.batchEntityByHQL(hql, object);
	}

	@Override
	public T loadEntity(int id) {
		// TODO Auto-generated method stub
		return dao.loadEntity(id);
	}

	@Override
	public T getEntity(int id) {
		// TODO Auto-generated method stub
		return dao.getEntity(id);
	}

	@Override
	public List<T> findEntityByHQL(String hql, Object... objects) {
		// TODO Auto-generated method stub
		return dao.findEntityByHQL(hql, objects);
	}

}
