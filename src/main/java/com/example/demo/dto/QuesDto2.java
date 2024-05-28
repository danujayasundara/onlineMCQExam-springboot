package com.example.demo.dto;

import java.util.List;

public class QuesDto2 {
	
	private String question;
	private List<AnswerDto> answers;
	 
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<AnswerDto> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerDto> answers) {
		this.answers = answers;
	}
}
