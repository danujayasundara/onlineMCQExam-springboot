package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String email;
	private String password;
	private String role;
	private String fullname;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<ExamAttempt> examAttempts;
	
	public User() {
		super();
	}

	public User(String email, String password, String role, String fullname, List<ExamAttempt> examAttempts) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.fullname = fullname;
		this.examAttempts = examAttempts;
	}

	public User(String email, String password, String role, String fullname) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.fullname = fullname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public List<ExamAttempt> getExamAttempts() {
		return examAttempts;
	}

	public void setExamAttempts(List<ExamAttempt> examAttempts) {
		this.examAttempts = examAttempts;
	}
	
	@Override
	public String toString() {
	    return "User{id=" + id + "}";
	}
	

    // Constructor with String argument for id
    public User(String id) {
        this.id = Long.parseLong(id);
    }


}
