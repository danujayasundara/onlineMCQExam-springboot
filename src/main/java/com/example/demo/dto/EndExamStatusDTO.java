package com.example.demo.dto;

public class EndExamStatusDTO {
	
	private Long examId;
    private boolean isEnded;
    
	public EndExamStatusDTO(Long examId, boolean isEnded) {
		super();
		this.examId = examId;
		this.isEnded = isEnded;
	}

	public EndExamStatusDTO() {
		
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public boolean isEnded() {
		return isEnded;
	}

	public void setEnded(boolean isEnded) {
		this.isEnded = isEnded;
	}

}
