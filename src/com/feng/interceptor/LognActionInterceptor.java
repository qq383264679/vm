package com.feng.interceptor;

import java.util.Map;

import com.feng.action.BaseAction;
import com.feng.action.OrderAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * ��½���ط���
 * @author fengchao
 *
 */
public class LognActionInterceptor  implements Interceptor{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation action) throws Exception {
		// TODO Auto-generated method stub
		Map session = action.getInvocationContext().getSession();  //��ȡsessionMap
		BaseAction baseAction = (BaseAction) action.getAction();
		
		//OrderAction
		if(baseAction instanceof OrderAction) {
			if(session.get("user") == null) {
				//��������
				return "interceptorIndex";  //���ظ���ͼ
			}
		}
		return action.invoke();  //����������
	}

	/**
	 * 
	 */
/*	@Override
	public String intercept(ActionInvocation action) throws Exception {
		// TODO Auto-generated method stub
		BaseAction baseAction = (BaseAction) action.getAction();
		
		//String actionName = action.getInvocationContext().getName();  //��ȡaction����
		//if(actionName.equals("regAction_toRegView")) {
			//return action.invoke();   //������ ֱ�ӵ������Լ���action
		//}
		//����ǵ�½ ���� ע��action �Ͳ�����
		if(baseAction instanceof RegAction || baseAction instanceof LognAction) {
			return action.invoke();  //����
		}
			
		System.out.println("���������action ����");
		
		//���ص�action��ͼ
		return "interceptorIndex";
	}*/

}
