package com.example.demo.dto;

import java.util.List;

public class QuesDtoRes {
	
	private long questionId;
	private String question;
	private List<AnswerDtoRes> answers;
	private AnswerDtoRes answer1;
    private AnswerDtoRes answer2;
    private AnswerDtoRes answer3;
    private AnswerDtoRes answer4;
	
	public long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(long questionId) {
		this.questionId = questionId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public List<AnswerDtoRes> getAnswers() {
		return answers;
	}
	public void setAnswers(List<AnswerDtoRes> answers) {
		this.answers = answers;
	}
	public AnswerDtoRes getAnswer1() {
		return answer1;
	}
	public void setAnswer1(AnswerDtoRes answer1) {
		this.answer1 = answer1;
	}
	public AnswerDtoRes getAnswer2() {
		return answer2;
	}
	public void setAnswer2(AnswerDtoRes answer2) {
		this.answer2 = answer2;
	}
	public AnswerDtoRes getAnswer3() {
		return answer3;
	}
	public void setAnswer3(AnswerDtoRes answer3) {
		this.answer3 = answer3;
	}
	public AnswerDtoRes getAnswer4() {
		return answer4;
	}
	public void setAnswer4(AnswerDtoRes answer4) {
		this.answer4 = answer4;
	}
	@Override
	public String toString() {
	    return "QuesDtoRes{" +
	            "questionId=" + questionId +
	            ", question='" + question + '\'' +
	            ", answers=" + answers +
	            '}';
	}
}
