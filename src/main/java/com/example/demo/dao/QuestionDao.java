package com.example.demo.dao;

import java.util.List;

public interface QuestionDao {
	
	List<Long> findQuestionIdsByExamId(Long examId);

}
