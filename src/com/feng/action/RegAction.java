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
 * �û�ע��action
 * @author fengchao
 *
 */
public class RegAction extends BaseAction<User> {
	private UserService userService;    //UserService �Ѿ���Spring������ע��
	//�����Զ�װ��ģʽ����װ��
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	//��ת��ע��ҳ��
	public String toRegView() {
		//userService = (UserService) SpringUtil.getObject("userService");
		System.out.println(userService.toString());
		System.out.println("��������� Action ��");
		return "regView";
	}
	//�ж�ע���Ƿ�ɹ�
	public void doReg() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Charset","UTF-8"); 
		
		boolean b = userService.checkName(user.getName());
		//System.out.println(b);  //b = ture ��ʾ name�Ѿ�ע��
		JSONObject json = new JSONObject();
		if(!b) {
			json.put("success", true);
			json.put("message", "��ϲ��ע��ɹ�");
			userService.saveEntity(user);  //�����ݿ���ע��
		} else {
			json.put("success", false);
			json.put("message", "������˼,�û����ѱ�ע��");
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
