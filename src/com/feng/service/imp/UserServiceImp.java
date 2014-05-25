package com.feng.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.feng.dao.BaseDao;
import com.feng.model.User;
import com.feng.service.UserService;
/**
 * 
 * @author fengchao
 *
 */
//��Spring������ע��UserServiceImp ��
@Service("userService")
public class UserServiceImp extends BaseServiceImp<User> implements UserService{
	
	@Resource(name="userDao")
	public void setBaseDao(BaseDao<User> dao) {
		// TODO Auto-generated method stub
		super.setBaseDao(dao);
	}

	//�ж��û��Ƿ��Ѿ�ע�� ��ע�᷵��true
	public boolean checkName(String name) {
		// TODO Auto-generated method stub
		String hql = "from User as u";
		List<User> users = this.findEntityByHQL(hql);
		for(User user : users) {
			if(user.getUserName().trim().equals(name)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkUser(User u) {
		// TODO Auto-generated method stub
		String hql = "from User as u";
		List<User> users = this.findEntityByHQL(hql);
		String name = u.getUserName().trim();
		String password = u.getPassword().trim();
		for(User user : users) {
			if(user.getUserName().trim().equals(name) && user.getPassword().trim().equals(password)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void saveUser(User u) {
		this.saveEntity(u);
	}



}
