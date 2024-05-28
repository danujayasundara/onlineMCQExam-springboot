package com.example.demo.dto;


import com.example.demo.model.Exam;
import com.example.demo.model.User;

public class ExamAttemptDto {
	
	private Long id;
	private Exam examId;
	private User userId;
	private boolean attemptStatus;
	
	public ExamAttemptDto() {
        // Default constructor
    }
	
	public ExamAttemptDto(Long id, Exam examId, User userId, boolean attemptStatus) {
		super();
		this.id = id;
		this.examId = examId;
		this.userId = userId;
		this.attemptStatus = attemptStatus;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isAttemptStatus() {
		return attemptStatus;
	}

	public void setAttemptStatus(boolean attemptStatus) {
		this.attemptStatus = attemptStatus;
	}

	@Override
	public String toString() {
		return "ExamAttemptDto [id=" + id + ", examId=" + examId + ", userId=" + userId + ", attemptStatus="
				+ attemptStatus + "]";
	}
	
	
	
}
