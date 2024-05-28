package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class SelectedAnswer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long selectAns_id;
	private Long selected_answer;
	
	@ManyToOne
	@JoinColumn(name = "answer_id")
	private Answer answer_id;
	
	@ManyToOne
	@JoinColumn(name = "question_id")
	private Question question_id;
	
	@ManyToOne
	@JoinColumn(name = "attempt_id")
	private ExamAttempt attempt_id;

	public SelectedAnswer() {
		super();
	}

	public SelectedAnswer(Long selected_answer, Answer answer_id, Question question_id, ExamAttempt attempt_id) {
		super();
		this.selected_answer = selected_answer;
		this.answer_id = answer_id;
		this.question_id = question_id;
		this.attempt_id = attempt_id;
	}

	public Long getSelectAns_id() {
		return selectAns_id;
	}

	public void setSelectAns_id(Long selectAns_id) {
		this.selectAns_id = selectAns_id;
	}

	public Long getSelected_answer() {
		return selected_answer;
	}

	public void setSelected_answer(Long selected_answer) {
		this.selected_answer = selected_answer;
	}

	public Answer getAnswer_id() {
		return answer_id;
	}

	public void setAnswer_id(Answer answer_id) {
		this.answer_id = answer_id;
	}

	public Question getQuestion_id() {
		return question_id;
	}

	public void setQuestion_id(Question question_id) {
		this.question_id = question_id;
	}

	public ExamAttempt getAttempt_id() {
		return attempt_id;
	}

	public void setAttempt_id(ExamAttempt attempt_id) {
		this.attempt_id = attempt_id;
	}
}
