package com.feng.action;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.classic.Validatable;

import com.feng.model.User;
import com.feng.service.UserService;

public class LognAction extends BaseAction<User> implements SessionAware {
	private Map<String, Object> session;// sessionMAP
	private UserService userService;    //UserService 已经在Spring容器中注入
	//根据自动装配模式进行装配
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	
	//到达登陆界面
	public String toLognView() {
		System.out.println("调用了toLognView方法");
		return "lognView";
	}
	//进行登录效应  登陆成功则调用这个方法
	public void doLogn() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Charset","UTF-8"); 
		
	    
		boolean b = userService.checkUser(this.user);
		JSONObject json = new JSONObject();
		if(!b) {
			json.put("succeed", false);
			json.put("message", "账号或者密码有误!");
			//System.out.println("zzzzzzzzzzzzzzz");

		} else {
			json.put("succeed", true);
			json.put("message", "恭喜你 登陆成功");
			//将结果存在session 域中
			
			session.put("user", this.user);
			//User u = (User)session.get("user");
			//System.out.println(u.getPassword());
		}
		try {
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	//struts2 效应方法
/*	public void validate() {
		//this.addFieldError("test", "sssssssss");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Charset","UTF-8"); 
		
	    
		boolean b = userService.checkUser(this.user);
		JSONObject json = new JSONObject();
		if(!b) {
			json.put("succeed", false);
			json.put("message", "账号或者密码有误!");
			//System.out.println("zzzzzzzzzzzzzzz");	
		} else {
			json.put("succeed", true);
			json.put("message", "恭喜你 登陆成功");
			//将结果存在session 域中
			session.put("user", this.user);
			//User u = (User)session.get("user");
			//System.out.println(u.getPassword());
		}
		try {
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/


	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = session;
	}
}
