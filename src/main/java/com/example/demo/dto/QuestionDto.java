package com.example.demo.dto;

import com.example.demo.model.Exam;

public class QuestionDto {
	
	private String questionContent;
	private Exam examId;
	
	public QuestionDto(String questionContent, Exam examId) {
		super();
		this.questionContent = questionContent;
		this.examId = examId;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public Exam getExamId() {
		return examId;
	}

	public void setExamId(Exam examId) {
		this.examId = examId;
	}
	
}
