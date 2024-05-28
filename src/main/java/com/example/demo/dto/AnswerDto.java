package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerDto {
	
	private int answerId;
	private String answer;
	private boolean isCorrectAnswer;
	
	
	public AnswerDto(@JsonProperty("answerId") int answerId, @JsonProperty("answer") String answer, 
			@JsonProperty("isCorrectAnswer") boolean isCorrectAnswer) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.isCorrectAnswer = isCorrectAnswer;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public boolean isCorrectAnswer() {
		return isCorrectAnswer;
	}
	public void setCorrectAnswer(boolean isCorrectAnswer) {
		this.isCorrectAnswer = isCorrectAnswer;
	}

}
