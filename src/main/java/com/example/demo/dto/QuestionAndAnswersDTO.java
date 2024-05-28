package com.example.demo.dto;

import java.util.List;

import com.example.demo.model.Answer;

import com.example.demo.model.Question;

public class QuestionAndAnswersDTO {
	
	private Question question;
    private List<Answer> answers;
    
    
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
    
    
    
}
