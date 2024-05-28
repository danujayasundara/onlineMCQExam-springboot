package com.example.demo.dto;

public class ExamAttendedDto {
	
	private Long examId;
    private boolean attemptstatus;
    
	public ExamAttendedDto(Long examId, boolean attemptstatus) {
		super();
		this.examId = examId;
		this.attemptstatus = attemptstatus;
	}

	public Long getExamId() {
		return examId;
	}

	public void setExamId(Long examId) {
		this.examId = examId;
	}

	public boolean isAttended() {
		return attemptstatus;
	}

	public void setAttended(boolean attemptstatus) {
		this.attemptstatus = attemptstatus;
	}
	
	@Override
    public String toString() {
        return "ExamAttendedDto{" +
                "examId=" + examId +
                ", attemptstatus=" + attemptstatus +
                '}';
    }
    
}
