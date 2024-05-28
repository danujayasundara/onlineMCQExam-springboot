package com.example.demo.dto;

public class AnswerDtoRes {
	
	private long answerId;
	private String answer;
	private boolean isCorrectAnswer;
	
	public long getAnswerId() {
		return answerId;
	}
	public void setAnswerId(long answerId) {
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
	@Override
	public String toString() {
	    return "AnswerDtoRes{" +
	            "answerId=" + answerId +
	            ", answer='" + answer + '\'' +
	            ", isCorrectAnswer=" + isCorrectAnswer +
	            '}';
	}

}
