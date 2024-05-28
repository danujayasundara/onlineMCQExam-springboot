package com.example.demo.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.tomcat.util.json.JSONParser;
import org.hibernate.annotations.Any;
import org.hibernate.boot.archive.scan.spi.ClassDescriptor.Categorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AnswerDto;
import com.example.demo.dto.AnswerDtoRes;
import com.example.demo.dto.EndExamStatusDTO;
import com.example.demo.dto.ExamAttemptDto;
import com.example.demo.dto.ExamAttendedDto;
import com.example.demo.dto.ExamDto;
import com.example.demo.dto.ExamDtoRes;

import com.example.demo.dto.QuesDto;
import com.example.demo.dto.QuesDtoRes;
import com.example.demo.dto.StudentStatusDto;
import com.example.demo.model.Answer;
import com.example.demo.model.Exam;
import com.example.demo.model.ExamAttempt;
import com.example.demo.model.Question;
import com.example.demo.model.User;
import com.example.demo.repositories.ExamAttemptRepository;
import com.example.demo.repositories.ExamRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.service.AnswerServiceImpl;
import com.example.demo.service.ExamAttemptServiceImpl;
import com.example.demo.service.ExamService;
import com.example.demo.service.ExamServiceImpl;
import com.example.demo.service.QuestionServiceImpl;
import com.example.demo.service.UserServiceImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
//@RequestMapping("/exampage")
//@CrossOrigin("*")
@CrossOrigin(origins = "http://localhost:8080")
public class ExamController {

	@Autowired
	private ExamService examService;
	
	@Autowired
	private ExamServiceImpl examServiceImpl;
	
	@Autowired
	private QuestionServiceImpl questionServiceImpl;
	
	@Autowired
	private ExamRepository examRepository;
	
	@Autowired 
	private AnswerServiceImpl answerServiceImpl;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ExamAttemptRepository examAttemptRepository;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private ExamAttemptServiceImpl examAttemptServiceImpl;
	
	
	
	  @GetMapping("/exams") 
	  public String getAllExams(Model model) { 
		  List<Exam> exams = examService.getAllExams(); 
		  model.addAttribute("exams", exams);
		  return "exam"; 
	  }
	  
	  //show exam form
	  @GetMapping("/add")
	    public String showNewExamForm(Model model) {
	        model.addAttribute("exam", new Exam());
	        return "saveExam"; 
	    }
	  
	  //add new exam page
	  @GetMapping("/addnewExam")
	  public String newExamPage(Model model) {
	        model.addAttribute("exam", new Exam());
	        return "newExamTeacher";
	    }
	  
	  //save exam
	  @PostMapping("/saveExam")
	  public ResponseEntity<Map<String, Object>> saveExam(@RequestBody ExamDto exam) {
		  try {
	            System.out.println("FROM FRONTEND: " + exam);

	            System.out.println("Exam Name: " + exam.getExamName());
	            System.out.println("Date Time: " + exam.getDateTime());
	            System.out.println("Duration: " + exam.getDuration());

	            Exam savedExam = examServiceImpl.saveExam(exam);

	            List<Question> questions = savedExam.getQuestions();
	            if (questions == null) {
	                questions = new ArrayList<>();
	            }
	            List<Long> questionIds = questions.stream()
	                .map(Question::getQuestion_id)
	                .collect(Collectors.toList());

		        Map<String, Object> response = new HashMap<>();
		        response.put("status", "success");
		        response.put("examId", savedExam.getExam_id());
		        response.put("questionIds", questionIds);

		        return ResponseEntity.ok(response);

	        } catch (Exception e) {
	            e.printStackTrace();
	            Map<String, Object> response = new HashMap<>();
	            response.put("status", "error");
	            response.put("message", e.getMessage());
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	        }
	    }
	  
	  private Long getUserIdByEmail(String email) {
		  return userRepository.findByEmail(email).getId();
	  }

	  //show exams for students
	  
	  @GetMapping("/stuexam")
	  public String showExamPage() {
	      return "stuexam"; 
	  }
	  
	  // get data
	  @PostMapping("/getExamData")
	  @ResponseBody
	  public Map<String, Object> getExamData(@RequestBody Map<String, Long> requestBody) {
	      Long userId = requestBody.get("userId");
	      Map<String, Object> response = new HashMap<>();

	      List<Exam> activeExams = examServiceImpl.getAllActiveExams();
	      response.put("exams", activeExams);

	      User user = userServiceImpl.getUserById(userId);
	      System.out.println("*****#########@@@@@@@@@@Logged In User ID: " + userId);

	      List<ExamAttempt> userAttempts = examAttemptRepository.findByUser(user);

	      List<ExamAttendedDto> examAttendedDtos = new ArrayList<>();
	      Map<Long, Boolean> attemptStatusMap = new HashMap<>();
	      for (ExamAttempt attempt : userAttempts) {
	          attemptStatusMap.put(attempt.getExam().getExam_id(), attempt.getAttempt_status());
	      }

	      for (Exam exam : activeExams) {
	          Long examId = exam.getExam_id();
	          boolean attended = attemptStatusMap.getOrDefault(examId, false); 
	          ExamAttendedDto dto = new ExamAttendedDto(examId, attended);
	          examAttendedDtos.add(dto);
	      }

	      response.put("examAttemptDtos", examAttendedDtos);

	      return response;
	  }
	 
	//get exam by id
	  @GetMapping("/getData/{id}")
	  public String getExamById(@PathVariable Long id, Model model) {
		  Exam exam = examService.getExamById(id);
		  model.addAttribute("exams",exam);
		  
		  return "exam";
	  }
	  
	  @GetMapping("/exampaper") 
	  public String showExamPaperPage() {
		 questionServiceImpl.getAllQuestions();
		 return "exampaper"; 
	  }
		 
	 //save exam attempt details
	  @PostMapping("/saveAttemptData")
	    public ResponseEntity<String> saveData(@RequestBody String data) throws JsonMappingException {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        ExamAttemptDto examAtt;

	        try {
	            examAtt = mapper.readValue(data, ExamAttemptDto.class);

	            ExamAttempt existingAttempt = examAttemptRepository.findByUserAndExam(examAtt.getUserId(), examAtt.getExamId());
	            if (existingAttempt != null) {
	                existingAttempt.setAttempt_status(examAtt.isAttemptStatus());
	                examAttemptRepository.save(existingAttempt);
	                return ResponseEntity.ok("Exam attempt data updated successfully.");
	            } else {
	                ExamAttempt examAttempt = new ExamAttempt();
	                examAttempt.setExam(examAtt.getExamId());
	                User user = userRepository.findById(examAtt.getUserId().getId())
	                        .orElseThrow(() -> new IllegalArgumentException("User not found"));
	                examAttempt.setUser(user);
	                examAttempt.setAttempt_status(examAtt.isAttemptStatus());
	                examAttemptRepository.save(examAttempt);
	                return ResponseEntity.ok("New exam attempt data saved successfully.");
	            }
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error mapping/processing JSON.");
	        }
	    }

	  
	  //update attempt status
	  @PostMapping("/completeAttempt")
	    public String saveAttemptStatus(@RequestBody String data) {
	        ObjectMapper mapper = new ObjectMapper();
	        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	        ExamAttemptDto examAtt;
	        try {
	            examAtt = mapper.readValue(data, ExamAttemptDto.class);
	            User user = userRepository.findById(examAtt.getUserId().getId())
	                    .orElseThrow(() -> new IllegalArgumentException("User not found"));
	            ExamAttempt existingAttempt = examAttemptRepository.findByUserAndExam(user, examAtt.getExamId());
	            if (existingAttempt != null) {
	                existingAttempt.setAttempt_status(true); 
	                examAttemptRepository.save(existingAttempt);
	            }
	        } catch (JsonMappingException e) {
	            e.printStackTrace();
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }
	        return "sturesult";
	    }
	  
	  @GetMapping("/ongoingExam/{examId}")
	  public String displayAndHandleExam(@PathVariable Long examId, Model model) {
		  
		  Exam exam = examServiceImpl.getExamById(examId); 
		    List<ExamAttempt> examAttempts = examAttemptRepository.findByExam(exam);
		    System.out.println("Exam attmpt" +examAttempts);
		    
		    Integer duration = examServiceImpl.getExamDuration(examId);
		    System.out.println("Duration for frontend "+duration);
		    
		    List<StudentStatusDto> attemptInfos = new ArrayList<>();
		    for (ExamAttempt attempt : examAttempts) {
		        String fullName = attempt.getUser().getFullname();
		        boolean status = attempt.getAttempt_status();
		        attemptInfos.add(new StudentStatusDto(fullName, status));
		    }
		    model.addAttribute("attemptInfos", attemptInfos); 
		    model.addAttribute("examAttempts", examAttempts);
		    model.addAttribute("duration", duration);
		
		  return "handleExam";
	  }
	  
	  @PutMapping("/exams/{examId}/status")
	  public ResponseEntity<String> updateExamStatus(@PathVariable Long examId, @RequestBody Map<String, Boolean> requestBody) {
		    Boolean status = requestBody.get("status");
		    if (status != null) {
		        boolean updateSuccessful = examServiceImpl.updateExamStatus(examId, status);
		        if (updateSuccessful) {
		            return ResponseEntity.ok("Exam status updated successfully");
		        } else {
		            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update exam status");
		        }
		    } else {
		        return ResponseEntity.badRequest().body("Status parameter missing or invalid");
		    }
		}
	  
	  //send exam details
	  @GetMapping("/exam/{examId}")
	    public ResponseEntity<ExamDtoRes> getExamDetails(@PathVariable("examId") Long examId, Model model) {
	        try {
	            ExamDtoRes examDto = examServiceImpl.getExamDetailsById(examId);
	            System.out.println("Exam Details *****" +examDto);
	            System.out.println("Question Details *****" +examDto.getQuestion().get(0).getQuestionId());
	            model.addAttribute("examDto", examDto);
	            return ResponseEntity.ok(examDto);
	        } catch (NotFoundException e) {
	        	e.printStackTrace();
	        	return ResponseEntity.notFound().build();	        }
	    }
	  
	  //end exam button
	  @PostMapping("/end-exam/{examId}")
	  public ResponseEntity<Void> endExam(@PathVariable Long examId, @RequestBody EndExamStatusDTO endExamStatusDTO) {
		    examServiceImpl.markExamAsEnded(endExamStatusDTO.getExamId());
		    System.out.println("Exam ID ended: " + examId);
		    System.out.println("Exam ended successfully.");

		    return ResponseEntity.ok().build(); 
		}
	  
	  @GetMapping("/ended-exams")
	  public ResponseEntity<List<EndExamStatusDTO>> getEndedExams() {
		    List<Long> endedExamIds = examServiceImpl.getEndedExams(); 

		    List<EndExamStatusDTO> endExamStatusDTOList = new ArrayList<>();
		    for (Long examId : endedExamIds) {
		        EndExamStatusDTO dto = new EndExamStatusDTO();
		        dto.setExamId(examId);
		        dto.setEnded(true); 
		        endExamStatusDTOList.add(dto);
		    }
		    System.out.println("Ended exam list"+endExamStatusDTOList);

		    return ResponseEntity.ok(endExamStatusDTOList);
		}
	  
	  //get duration
	  @GetMapping("/getduration/{examId}")
	  public ResponseEntity<Map<String, Object>> getExamDuration(@PathVariable Long examId) {
	      Integer duration = examServiceImpl.getExamDuration(examId);
	      if (duration != null) {
	          Map<String, Object> response = new HashMap<>();
	          response.put("duration", duration);
	          System.out.println("*********duration for front*******" + duration);
	          return ResponseEntity.ok(response);
	      } else {
	          return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	      }
	  }
	  
	  
	  //get all attempting students
	  @GetMapping("/exam/{examId}/students")
	    public ResponseEntity<List<StudentStatusDto>> getAttemptedStudents(@PathVariable Long examId) {
		  Exam exam = examServiceImpl.getExamById(examId); 
		  System.out.println("Attempted Students List:");
	      List<StudentStatusDto> attemptedStudents = examServiceImpl.getAttemptedStudentsForExam(exam);
	      for (StudentStatusDto student : attemptedStudents) {
	          System.out.println(student); 
	      }
	      return ResponseEntity.ok(attemptedStudents);
	   }
	  
	  

	  //send attended status
	 /* @GetMapping("/exam-statuses")
	  public ResponseEntity<List<ExamAttendedDto>> getExamStatuses(Principal principal) {
	      try {
	          String username = principal.getName();
	          User user = userRepository.findByEmail(username);
	          List<ExamAttempt> userAttempts = examAttemptRepository.findByUser(user);

	          List<ExamAttendedDto> examAttendedDtos = new ArrayList<>();
	          for (ExamAttempt attempt : userAttempts) {
	              boolean attended = attempt.getAttempt_status(); // Check the attempt status
	              Exam exam = attempt.getExam();

	              ExamAttendedDto dto = new ExamAttendedDto(exam.getExam_id(), attempt.getAttempt_status());
	              examAttendedDtos.add(dto);
	          }

	          System.out.println("***********************************\n******************\n");
	          System.out.println("EXAM ATTEMPT" + examAttendedDtos);

	          return ResponseEntity.ok(examAttendedDtos);
	      } catch (Exception e) {
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	      }
	  }*/

	  //update teacher table
	  /*@GetMapping("/students/{examId}")
	  public String getStudentsByExamId(@PathVariable Exam examId, Model model) {
	      // Fetch students attempting the specified exam from ExamAttempt table
	      List<ExamAttemptDto> examAttempts = examServiceImpl.getAttemptsByExamId(examId); // Example method to fetch attempts by examId
	      List<User> userIds = examAttempts.stream().map(ExamAttemptDto::getUserId).collect(Collectors.toList());

	      // Fetch student names from User table using userIds
	      List<User> students = userServiceImpl.getStudentsById(userIds); // Example method to fetch students by userIds
	      model.addAttribute("students", students);

	      // Fetch attempt statuses from ExamAttempt table using userIds and examId
	      //List<ExamAttempt> statuses = examAttemptRepository.findByUserAndExam(userIds, examId); // Example method to fetch statuses
	      //model.addAttribute("statuses", statuses);

	      return "handleExam"; // Assuming "handle_result.html" is your Thymeleaf template for the teacher side
	  }*/

	  

}
