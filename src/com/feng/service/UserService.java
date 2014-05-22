package com.feng.service;

import com.feng.model.User;

public interface UserService extends BaseService<User>{
	//判断用户名是否已经被注册
	public boolean checkName(String name);
	public boolean checkUser(User u);
}
