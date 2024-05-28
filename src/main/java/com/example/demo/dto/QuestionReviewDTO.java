package com.example.demo.dto;

import com.example.demo.model.Question;

public class QuestionReviewDTO {
	
	private Question question;
	private boolean isAnswerCorrect;
	
	public QuestionReviewDTO(Question question, boolean isAnswerCorrect) {
		this.question = question;
        this.isAnswerCorrect = isAnswerCorrect;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public boolean isAnswerCorrect() {
		return isAnswerCorrect;
	}
	public void setAnswerCorrect(boolean isAnswerCorrect) {
		this.isAnswerCorrect = isAnswerCorrect;
	}
	
	

}
