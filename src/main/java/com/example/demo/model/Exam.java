package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;
//import java.util.Set;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Exam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long examId;
	private String exam_name;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime dateTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDateTime lastUpdate;
	private int duration;
	private boolean eStatus;
	private boolean endExamStatus;
	
	@OneToMany(mappedBy = "exam", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<ExamAttempt> examAttemptsExam;
	
	@OneToMany(mappedBy = "exam", fetch = FetchType.EAGER)
	@JsonIgnore
	private List<Question> questions = new ArrayList<>();

	public Exam() {
		super();
	}

	public Exam(String exam_name, LocalDateTime dateTime, int duration, boolean eStatus,
			List<ExamAttempt> examAttemptsExam, List<Question> questions) {
		super();
		this.exam_name = exam_name;
		this.dateTime = dateTime;
		this.duration = duration;
		this.eStatus = eStatus;
		this.examAttemptsExam = examAttemptsExam;
		this.questions = questions;
	}
	
	public Exam(String exam_name, LocalDateTime dateTime, int duration, boolean eStatus) {
		super();
		this.exam_name = exam_name;
		this.dateTime = dateTime;
		this.duration = duration;
		this.eStatus = eStatus;
	}
	
	public Exam(String exam_name, LocalDateTime lastUpdate, boolean eStatus) {
		super();
		this.exam_name = exam_name;
		this.lastUpdate = lastUpdate;
		this.eStatus = eStatus;
	}

	public Long getExam_id() {
		return examId;
	}

	public void setExam_id(Long exam_id) {
		this.examId = exam_id;
	}

	public String getExam_name() {
		return exam_name;
	}

	public void setExam_name(String exam_name) {
		this.exam_name = exam_name;
	}

	public int getDuration() {
		return duration;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isE_status() {
		return eStatus;
	}

	public void setE_status(boolean eStatus) {
		this.eStatus = eStatus;
	}

	public List<ExamAttempt> getExamAttemptsExam() {
		return examAttemptsExam;
	}

	public void setExamAttemptsExam(List<ExamAttempt> examAttemptsExam) {
		this.examAttemptsExam = examAttemptsExam;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	public boolean isEndExamStatus() {
		return endExamStatus;
	}

	public void setEndExamStatus(boolean endExamStatus) {
		this.endExamStatus = endExamStatus;
	}

	@Override
	public String toString() {
	    return "Exam{examId=" + examId + "}";
	}
	
	public Exam(String examId) {
        this.examId = Long.parseLong(examId);
    }

}
