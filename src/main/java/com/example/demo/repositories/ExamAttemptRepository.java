package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.ExamAttemptDto;
import com.example.demo.model.Exam;
import com.example.demo.model.ExamAttempt;
import com.example.demo.model.User;

@Repository
public interface ExamAttemptRepository extends JpaRepository<ExamAttempt, Long>{

	@Query("SELECT ea FROM ExamAttempt ea WHERE ea.user = :user AND ea.exam = :exam")
    ExamAttempt findByUserAndExam(@Param("user") User user, @Param("exam") Exam exam);

	
	@Query("SELECT COUNT(ea) > 0 FROM ExamAttempt ea WHERE ea.user = :user AND ea.exam = :exam")
    boolean existsByUserAndExam(@Param("user") User user, @Param("exam") Exam exam);
	
	List<ExamAttempt> findByExam(Exam examId);
	List<ExamAttempt> findByUser(User user);
	
	/*@Query(value = "SELECT * FROM ExamAttempt WHERE attempt_status = 1 AND exam_id = :examId", 
		     nativeQuery = true)
	List<ExamAttemptDto> getStatusByExam(Exam examId);*/

	
	//ExamAttempt findByExamAndUser(@Param("examId") Exam exam, @Param("userId")  User userId);

	//List<ExamAttempt> findByUserAndExam(User userIds, Exam examId);

}
