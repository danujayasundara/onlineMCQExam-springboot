package com.example.demo.dto;


import com.example.demo.model.Exam;
import com.example.demo.model.User;

public class ExamAttemptDto {
	
	private Exam examId;
	private User userId;
	
	
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
