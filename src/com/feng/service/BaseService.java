package com.feng.service;

import java.util.List;

public interface BaseService<T> {
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
}
