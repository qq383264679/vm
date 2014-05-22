package com.feng.service;

import java.util.List;

import com.feng.model.Survey;
import com.feng.model.User;

public interface SurveyService {
	public List<Survey> findAllSurveys(User user);
	public User getUser(User user);   //��session�е���ͨuser ��Ϊ���ݵ��е�user
}
