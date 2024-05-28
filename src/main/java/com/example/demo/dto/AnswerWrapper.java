package com.example.demo.dto;

import java.util.List;

public class AnswerWrapper {
	
	private List<SelectedAnswerDTO> selectedAnswers;
    private ExamAttemptDto examAttemptDto;
    
	public List<SelectedAnswerDTO> getSelectedAnswers() {
		return selectedAnswers;
	}
	public void setSelectedAnswers(List<SelectedAnswerDTO> selectedAnswers) {
		this.selectedAnswers = selectedAnswers;
	}
	public ExamAttemptDto getExamAttemptDto() {
		return examAttemptDto;
	}
	public void setExamAttemptDto(ExamAttemptDto examAttemptDto) {
		this.examAttemptDto = examAttemptDto;
	}
}
