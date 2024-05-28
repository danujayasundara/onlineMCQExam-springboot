package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.SelectedAnswer;

@Repository
public interface SelectedAnswerRepository extends JpaRepository<SelectedAnswer, Long>{
	
	@Query(value = "SELECT * FROM selected_answer WHERE attempt_id = :attId", 
		     nativeQuery = true)
	List<SelectedAnswer> getSelectAnsByAttId(Long attId);

}
