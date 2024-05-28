package com.example.demo.dto;

import java.util.List;

public class ExamDtoRes {
	
	private long examId;
	private String examName;
    private int duration;
    private String dateTime;
    
    //private QuesDtoRes[] question;
    private List<QuesDtoRes> question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;
    
	public long getExamId() {
		return examId;
	}
	public void setExamId(long examId) {
		this.examId = examId;
	}
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
	/*public QuesDtoRes[] getQuestion() {
		return question;
	}
	public void setQuestion(QuesDtoRes[] question) {
		this.question = question;
	}*/
	public List<QuesDtoRes> getQuestion() {
		return question;
	}
	public void setQuestion(List<QuesDtoRes> question) {
		this.question = question;
	}
	
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	@Override
	public String toString() {
	    return "ExamDtoRes{" +
	            "examId=" + examId +
	            ", examName='" + examName + '\'' +
	            ", duration=" + duration +
	            ", dateTime=" + dateTime +
	            '}';
	}

}
