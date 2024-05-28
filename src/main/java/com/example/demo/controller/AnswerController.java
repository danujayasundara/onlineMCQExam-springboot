package com.example.demo.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.service.AnswerService;
import com.example.demo.service.QuestionService;

@RestController
@CrossOrigin("*")
@RequestMapping("/answer")
public class AnswerController {
	
	@Autowired
	public AnswerService answerService;
	
	//@Autowired
	private QuestionService questionService;
	
	
	//

}
