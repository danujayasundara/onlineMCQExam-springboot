package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

import com.example.demo.dto.QuestionAndAnswersDTO;
import com.example.demo.model.Exam;
//import com.example.demo.dto.QuestionDto;
import com.example.demo.model.Question;

public interface QuestionService {
	
	Question createQuestion(Question question);
	List<Question> getAllQuestions();
	Optional<Question> getQuestionById(Long id);
	Question updateQuestion(Long id, Question question) throws NotFoundException;
	void deleteQuestion(Long id);
	//Question getQuestionByExamIdAndQuestionId(Long examId, Long questionId);
	
	//Long saveQuestionAndAnswers(QuestionAndAnswersDTO questionAndAnswersDTO);
	
	List<Long> getQuestionIdsByExamId(Long examId);

}
