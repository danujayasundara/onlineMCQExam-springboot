package com.example.demo.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Answer;
import com.example.demo.model.Question;
import com.example.demo.repositories.AnswerRepository;
import com.example.demo.repositories.QuestionRepository;

@Service
public class AnswerServiceImpl implements AnswerService{
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	
	public Answer saveAnswer(Answer answer) {
       
        return answerRepository.save(answer);
    }
	
	public List<Answer> getAnswersByQuesId(Long quesId) {
		return answerRepository.findAnswersByQuestionIdSql(quesId);
	}
	

	/*public Long getCorrectAnswerId(Question questionId) {
	    Optional<Answer> correctAnswerOptional = answerRepository.findByQuestion(questionId);
	    return correctAnswerOptional.map(Answer::getAnswer_id).orElse(null);
	}*/
	  
}
