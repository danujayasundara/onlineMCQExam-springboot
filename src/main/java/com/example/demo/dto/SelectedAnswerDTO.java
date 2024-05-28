package com.example.demo.dto;


import com.example.demo.model.Exam;
import com.example.demo.model.Question;
import com.example.demo.model.User;


public class SelectedAnswerDTO {
	
	private int selected_answer;
	private Question question_id;
	private Exam examId;
	private User userId;
	
	public int getSelected_answer() {
		return selected_answer;
	}
	public void setSelected_answer(int selected_answer) {
		this.selected_answer = selected_answer;
	}
	public Question getQuestion_id() {
		return question_id;
	}
	public void setQuestion_id(Question question_id) {
		this.question_id = question_id;
	}
	public Exam getExamId() {
		return examId;
	}
	public void setExamId(Exam examId) {
		this.examId = examId;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	
	
}
