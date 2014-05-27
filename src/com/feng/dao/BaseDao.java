package com.feng.dao;

import java.util.List;

import org.hibernate.SessionFactory;

public interface BaseDao<T> {
	//д����
	public void saveEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void updateEntity(T t);
	public void deleteEntity(T t);
	public void batchEntityByHQL(String hql, Object...object);
	//������
	public T loadEntity(int id);
	public T getEntity(int id);
	public List<T> findEntityByHQL(String hql, Object...objects);
	
	//��ҳ
	public List<T> findEntitys(String hql, Object object, int numbers, int pages);
	//��ȡsessionFactory
//	public SessionFactory getSession();
}
