package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Exam;
import com.example.demo.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    
	User findByEmail (String email);

	Long getUserIdByEmail(String userEmail);

	/*@Query(value = "SELECT u.fullname FROM Users u JOIN exam_attempt e on u.id = e.user_id WHERE e.exam_id = :examId", 
		     nativeQuery = true)
	List<User> findAllById(@Param("examId") Exam examId);
	/*@Query("SELECT u FROM Users u JOIN exam_attempt e ON u.id = e.user_id WHERE e.exam_id = :exam")
	User findId(@Param("exam") Long exam);*/


}
