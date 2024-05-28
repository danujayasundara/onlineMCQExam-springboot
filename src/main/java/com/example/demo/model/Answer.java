package com.example.demo.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long answerId;
	private String answer;
	@Column(nullable = false, columnDefinition = "VARCHAR(255) default ''")
	private boolean correctAnswer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	private Question question;
	
	@OneToMany(mappedBy = "answer_id")
	private List<SelectedAnswer> selectedAnswer;
	
	public Answer() {
		super();
	}
	
	public Answer(String answer, boolean correctAnswer, Question question) {
		super();
		this.answer = answer;
		this.correctAnswer = correctAnswer;
		this.question = question;
	}



	public Long getAnswer_id() {
		return answerId;
	}

	public void setAnswer_id(Long answerId) {
		this.answerId = answerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	
	public boolean getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(boolean correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<SelectedAnswer> getSelectedAnswer() {
		return selectedAnswer;
	}

	public void setSelectedAnswer(List<SelectedAnswer> selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}
}
