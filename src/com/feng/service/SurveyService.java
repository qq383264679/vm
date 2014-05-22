package com.feng.service;

import java.util.List;

import com.feng.model.Survey;
import com.feng.model.User;

public interface SurveyService {
	public List<Survey> findAllSurveys(User user);
	public User getUser(User user);   //将session中的普通user 变为数据典中的user
}
