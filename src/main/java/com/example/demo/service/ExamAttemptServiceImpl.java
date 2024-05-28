package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Exam;
import com.example.demo.model.ExamAttempt;
import com.example.demo.model.User;
import com.example.demo.repositories.ExamAttemptRepository;
import com.example.demo.repositories.UserRepository;

@Service
public class ExamAttemptServiceImpl {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ExamAttemptRepository examAttemptRepository;
	
	public String getUserNameByUserId(User user) {
	    return user != null ? user.getFullname() : "N/A";
	}

	public ExamAttempt getAttemptStatusByExamAndUser(User userId,Exam exam) {
		return examAttemptRepository.findByUserAndExam(userId,exam);
		
	}


}
