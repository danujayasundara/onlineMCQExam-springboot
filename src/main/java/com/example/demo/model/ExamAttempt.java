package com.example.demo.model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class ExamAttempt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long attemptId;
    private Date attempt_date;
    private Time attempt_time;
    private boolean attemptstatus;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    @ManyToOne
    @JoinColumn(name = "exam_id")
    private Exam exam;
    
    @OneToMany(mappedBy = "attempt_id")
    private List<SelectedAnswer> selected_answers;

	public ExamAttempt() {
		super();
	}

	public ExamAttempt(Date attempt_date, Time attempt_time, boolean attemptstatus, User user, Exam exam,
			List<SelectedAnswer> selected_answers) {
		super();
		this.attempt_date = attempt_date;
		this.attempt_time = attempt_time;
		this.attemptstatus = attemptstatus;
		this.user = user;
		this.exam = exam;
		this.selected_answers = selected_answers;
	}

	public Long getAttempt_id() {
		return attemptId;
	}

	public void setAttempt_id(Long attemptId) {
		this.attemptId = attemptId;
	}

	public Date getAttempt_date() {
		return attempt_date;
	}

	public void setAttempt_date(Date attempt_date) {
		this.attempt_date = attempt_date;
	}

	public Time getAttempt_time() {
		return attempt_time;
	}

	public void setAttempt_time(Time attempt_time) {
		this.attempt_time = attempt_time;
	}

	public boolean getAttempt_status() {
		return attemptstatus;
	}

	public void setAttempt_status(boolean attemptstatus) {
		this.attemptstatus = attemptstatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public List<SelectedAnswer> getSelected_answers() {
		return selected_answers;
	}

	public void setSelected_answers(List<SelectedAnswer> selected_answers) {
		this.selected_answers = selected_answers;
	}
}
