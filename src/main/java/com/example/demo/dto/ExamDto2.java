package com.example.demo.dto;

import java.util.List;

public class ExamDto2 {
	
	private String examName;
    private int duration;
    private String dateTime;
    private String lastupdate;
    private List<QuesDto> questions;
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	public String getLastupdate() {
		return lastupdate;
	}
	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}
	public List<QuesDto> getQuestions() {
		return questions;
	}
	public void setQuestions(List<QuesDto> questions) {
		this.questions = questions;
	}

}
