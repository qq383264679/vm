package com.feng.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Page {
	private Integer id;
	private String title = "为命名";
	private String description;  
	//完成page 到 Survey 多对一之间的隐射
	private Survey survey;
	//完成page 到question 一对多这件的隐射
	private Set<Question> questions = new HashSet<Question>();
	public Integer getId() {
		return id;
	}
	public Survey getSurvey() {
		return survey;
	}
	public void setSurvey(Survey survey) {
		this.survey = survey;
	}
	public Set<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
