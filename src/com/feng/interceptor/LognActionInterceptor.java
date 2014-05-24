package com.feng.interceptor;

import java.util.Map;

import com.feng.action.BaseAction;
import com.feng.action.OrderAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
/**
 * 登陆拦截方法
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
		Map session = action.getInvocationContext().getSession();  //获取sessionMap
		BaseAction baseAction = (BaseAction) action.getAction();
		
		//OrderAction
		if(baseAction instanceof OrderAction) {
			if(session.get("user") == null) {
				//进行拦截
				return "interceptorIndex";  //返回该视图
			}
		}
		return action.invoke();  //不拦截拦截
	}

	/**
	 * 
	 */
/*	@Override
	public String intercept(ActionInvocation action) throws Exception {
		// TODO Auto-generated method stub
		BaseAction baseAction = (BaseAction) action.getAction();
		
		//String actionName = action.getInvocationContext().getName();  //获取action名称
		//if(actionName.equals("regAction_toRegView")) {
			//return action.invoke();   //则不拦截 直接调用你自己的action
		//}
		//如果是登陆 或者 注册action 就不拦截
		if(baseAction instanceof RegAction || baseAction instanceof LognAction) {
			return action.invoke();  //放行
		}
			
		System.out.println("拦截了你的action 请求");
		
		//返回的action视图
		return "interceptorIndex";
	}*/

}
