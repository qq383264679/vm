package com.feng.service;

import com.feng.model.User;

public interface UserService extends BaseService<User>{
	//�ж��û����Ƿ��Ѿ���ע��
	public boolean checkName(String name);
	public boolean checkUser(User u);
}
