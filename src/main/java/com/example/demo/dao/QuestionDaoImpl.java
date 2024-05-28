package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class QuestionDaoImpl implements QuestionDao{

	private EntityManager entityManager;

	@Autowired
    public QuestionDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Long> findQuestionIdsByExamId(Long examId) {
        TypedQuery<Long> query = entityManager.createQuery(
        		"select q.questionId from Question q where q.exam.examId = :examId", Long.class);
        query.setParameter("examId", examId);
        System.out.println("QId in QuestionDao" + query.getResultList());
        return query.getResultList();
    }
	
	

}
