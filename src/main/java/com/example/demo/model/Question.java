package com.example.demo.model;

import java.util.ArrayList;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
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
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long questionId;
	private String question_content;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "exam_id")
	private Exam exam;
	
	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Answer> answers;
	
	@OneToMany(mappedBy = "question_id")
	private List<SelectedAnswer> selectedAnswer;

	public Question() {
		super();
	}
	
	public Question(Long questionId) {
        this.questionId = questionId;
    }

	/*
	 * public Question(String question_content, Exam exam_id) {
	 * this.question_content = question_content; this.exam_id = exam_id;
	 * this.answers = new ArrayList<>(); }
	 */

	public Question(String question_content, Exam exam) {
		super();
		this.question_content = question_content;
		this.exam = exam;
	}

	public Question(String question_content, Exam exam, List<Answer> answers, List<SelectedAnswer> selectedAnswer) {
		super();
		this.question_content = question_content;
		this.exam = exam;
		this.answers = answers;
		this.selectedAnswer = selectedAnswer;
	}

	public Long getQuestion_id() {
		return questionId;
	}

	public void setQuestion_id(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestion_content() {
		return question_content;
	}

	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
        for (Answer answer : answers) {
            answer.setQuestion(this); 
        }
	}

	public List<SelectedAnswer> getSelectedAnswer() {
		return selectedAnswer;
	}

	public void setSelectedAnswer(List<SelectedAnswer> selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}
	
	/*
	 * public void addAnswer(Answer answer) { if (answers == null) { answers = new
	 * ArrayList<>(); } answers.add(answer); }
	 */
}
