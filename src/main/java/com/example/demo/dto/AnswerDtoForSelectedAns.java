package com.example.demo.dto;

public class AnswerDtoForSelectedAns {
	
	private Long answer_id;
    private boolean correctAnswer;
    
	public Long getAnswer_id() {
		return answer_id;
	}
	public void setAnswer_id(Long answer_id) {
		this.answer_id = answer_id;
	}
	public boolean isCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
    
    

}
