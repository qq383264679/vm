package com.feng.action;

import java.lang.reflect.ParameterizedType;

import com.feng.model.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
/**
 * BaseAction是一个抽象类 用来继承
 * @author fengchao
 *
 * @param <T>
 */
public abstract class BaseAction<T> extends ActionSupport implements ModelDriven<T>, Preparable{
	public T user;
	@SuppressWarnings("unchecked")
	public BaseAction() {
		ParameterizedType genType = (ParameterizedType) this.getClass().getGenericSuperclass();  
        Class<T> clazz = (Class<T>) genType.getActualTypeArguments()[0]; 
        try {
			this.user = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T getModel() {
		return user;
	}

}
