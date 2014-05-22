package com.feng.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.feng.model.Survey;
import com.feng.model.User;
import com.feng.service.SurveyService;

public class SurveyAction extends BaseAction<Survey> implements SessionAware {
	private Map<String, Object> sessionMap;
	SurveyService surveyService;
	//Spring 通过自动装配 按name注入
	public void setSurveyService(SurveyService surveyService) {
		this.surveyService = surveyService;
	}

	/**
	 * json返回数据类型格式
	 * var jsonstr = '{"total":1,
	 * 			"rows":[{"id":"M000005","title":"检测设备","createTime":3}]
	 * }';  
	 */
	public void findSurveys() {
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json;charset=UTF-8");
		response.setHeader("Charset","UTF-8"); 
		
		
		User user = (User) sessionMap.get("user");
		if(user != null) {
			user = surveyService.getUser(user);
			List<Survey> my_surveys = surveyService.findAllSurveys(user);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("total", my_surveys.size());		
		    
			JSONArray array = new JSONArray();
			//将my_surveys 变成一个jsonObject
			//jsonObject.put("rows", array);
			for(Survey s : my_surveys) {
				JSONObject json = new JSONObject();
				json.put("id", s.getId());
				json.put("title", s.getTitle());
				SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
				json.put("createTime", time.format(s.getCreateTime()));
				array.add(json);
			}
			jsonObject.put("rows", array);
			System.out.println(jsonObject.toString()); 
			
			try {
				response.getWriter().write(jsonObject.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//System.out.println("yes");
	}

	@Override
	public void setSession(Map<String, Object> sessionMap) {
		// TODO Auto-generated method stub
		this.sessionMap = sessionMap;
	}
}
