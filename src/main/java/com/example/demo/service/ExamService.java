package com.example.demo.service;

import java.util.List;
import java.util.Set;

import com.example.demo.model.Answer;
import com.example.demo.model.Exam;
import com.example.demo.model.Question;

public interface ExamService {
	
	  List<Exam> getAllExams(); 
	  //Exam saveExam(Exam exam); 
	  Exam getExamById(Long id); 
	  void deleteExam(Long id); 
	  //public Question saveQuestion(Question question, Long examId); 
	  //Answer saveAnswers(Answer answer, Long questionId);
	//String getExamNameById(Long examId);
	  
	 
}
