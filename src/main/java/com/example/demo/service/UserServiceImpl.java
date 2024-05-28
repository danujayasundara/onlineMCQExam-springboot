package com.example.demo.service;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.StudentStatusDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Exam;
import com.example.demo.model.ExamAttempt;
import com.example.demo.model.User;
import com.example.demo.repositories.ExamAttemptRepository;
import com.example.demo.repositories.UserRepository;

import reactor.core.publisher.Flux;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ExamAttemptRepository examAttemptRepository;

	@Override
	public User save(UserDto userDto) {
		User user = new User(userDto.getEmail(), passwordEncoder.encode(userDto.getPassword()) , userDto.getRole(), userDto.getFullname());
		return userRepository.save(user);
	}
	
	public User getUserById(Long id) { 
		  return userRepository.findById(id).orElse(null); 
	  }
	
	public Long getUserIdByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return user.getId();
        }
        return null; 
    }

	/*public List<User> getStudentsById(Exam examId) {
		return userRepository.findAllById(examId);
	}*/
	
	/*public List<StudentStatusDto> getStudentsByExamId(Exam examId) {
        // Fetch exam attempt records for the specified examId
        List<ExamAttempt> examAttempts = examAttemptRepository.findByExam(examId);

        // Extract userIds from the fetched exam attempts
        List<User> userIds = examAttempts.stream()
                .map(ExamAttempt::getUser_id)
                .collect(Collectors.toList());

        // Fetch user details (names) for the extracted userIds
        List<User> users = userRepository.findById(userIds);

        // Create StudentStatusDto objects based on fetched data
        List<StudentStatusDto> studentStatusList = users.stream()
                .map(user -> new StudentStatusDto(user.getFullname(), true)) // Assuming true for attending
                .collect(Collectors.toList());

        return studentStatusList;
    }*/

}