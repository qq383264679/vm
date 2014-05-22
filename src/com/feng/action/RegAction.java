package com.feng.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.feng.model.User;
import com.feng.service.UserService;
import com.feng.util.SpringUtil;
/**
 * 用户注册action
 * @author fengchao
 *
 */
public class RegAction extends BaseAction<User> {
	private UserService userService;    //UserService 已经在Spring容器中注入
	//根据自动装配模式进行装配
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//跳转到注册页面
	public String toRegView() {
		//userService = (UserService) SpringUtil.getObject("userService");
		System.out.println(userService.toString());
		System.out.println("调用了这个 Action ！");
		return "regView";
	}
	//判断注册是否成功
	public void doReg() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Charset","UTF-8"); 
		
		boolean b = userService.checkName(user.getName());
		//System.out.println(b);  //b = ture 表示 name已经注册
		JSONObject json = new JSONObject();
		if(!b) {
			json.put("success", true);
			json.put("message", "恭喜你注册成功");
			userService.saveEntity(user);  //像数据库中注册
		} else {
			json.put("success", false);
			json.put("message", "不好意思,用户名已被注册");
		}
		try {
			response.getWriter().write(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(json.toString());
	}
}
