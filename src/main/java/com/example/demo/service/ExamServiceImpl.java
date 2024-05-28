package com.example.demo.service;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AnswerDto;
import com.example.demo.dto.AnswerDtoRes;
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
import com.example.demo.repositories.AnswerRepository;
import com.example.demo.repositories.ExamAttemptRepository;
import com.example.demo.repositories.ExamRepository;
import com.example.demo.repositories.QuestionRepository;

@Service
public class ExamServiceImpl implements ExamService{
	
	@Autowired
	private ExamRepository examRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionServiceImpl questionServiceImpl;
	
	@Autowired
	private ExamAttemptRepository examAttemptRepository;
	
	
	  @Override 
	  public List<Exam> getAllExams(){ 
		  return examRepository.findAll(); 
	  }
	  
	  
	  
	  @Override 
	  public Exam getExamById(Long id) { 
		  return examRepository.findByExamId(id); 
	  }
	  
	  @Override 
	  public void deleteExam(Long id) { 
		  examRepository.deleteById(id); 
	  }
	  
	  /*@Override 
	  public Question saveQuestion(Question question, Long examId) { 
		  Exam exam=examRepository.findById(examId).get(); 
		  if(exam != null)
			  question.setExam(exam); 
		  return questionRepository.save(question); 
	  }*/
	  
	  /*@Override 
	  public Answer saveAnswers(Answer answer, Long questionId) {
		  Question question=questionRepository.findById(questionId).get();
		  answer.setQuestion(question); 
		  return answerRepository.save(answer); 
	  }*/

	////////////////////////////////
	  public Exam saveExam(ExamDto examdto) {
		  
		  Exam response = null;
	        // Save exam details
		  if(examdto.getExamId() == -1) {
				Exam newExam = new Exam();
				newExam.setExam_name(examdto.getExamName());
				newExam.setDuration(examdto.getDuration());
				// Create a formatter
		        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

		        // Parse the string to LocalDateTime
		        LocalDateTime dateTime = LocalDateTime.parse(examdto.getDateTime(), formatter);
		        LocalDateTime lastUpdatedateTime = LocalDateTime.parse(examdto.getLastupdate(), formatter);
						
				newExam.setDateTime(dateTime);
				newExam.setLastUpdate(lastUpdatedateTime);
				Exam savedExam = examRepository.save(newExam);
				
				System.out.println("*************COME AS NEW EXAM****************");
				System.out.println(savedExam);
				
				for (QuesDto questionDto : examdto.getQuestion()) {
					Question newQues = new Question();
					newQues.setQuestion_content(questionDto.getQuestion());
					newQues.setExam(savedExam);
					
					Question savedQues = questionRepository.save(newQues);
					System.out.println("*************COME AS NEW QUESTION****************");
					System.out.println(savedQues);
					
					Answer newAns1 = new Answer();
					newAns1.setQuestion(savedQues);
					newAns1.setAnswer(questionDto.getAnswer1().getAnswer());
					newAns1.setCorrectAnswer(questionDto.getAnswer1().isCorrectAnswer());
					Answer savedAns1 = answerRepository.save(newAns1);
					
					Answer newAns2 = new Answer();
					newAns2.setQuestion(savedQues);
					newAns2.setAnswer(questionDto.getAnswer2().getAnswer());
					newAns2.setCorrectAnswer(questionDto.getAnswer2().isCorrectAnswer());
					Answer savedAns2 = answerRepository.save(newAns2);
					
					Answer newAns3 = new Answer();
					newAns3.setQuestion(savedQues);
					newAns3.setAnswer(questionDto.getAnswer3().getAnswer());
					newAns3.setCorrectAnswer(questionDto.getAnswer3().isCorrectAnswer());
					Answer savedAns3 = answerRepository.save(newAns3);
					
					Answer newAns4 = new Answer();
					newAns4.setQuestion(savedQues);
					newAns4.setAnswer(questionDto.getAnswer4().getAnswer());
					newAns4.setCorrectAnswer(questionDto.getAnswer4().isCorrectAnswer());
					Answer savedAns4 = answerRepository.save(newAns4);
				}
				
				response = savedExam;
			
				
		  	} else { //existing exam nam
		  		Long examId = (long) examdto.getExamId();
		  		System.out.println("ExamID***.....----" + examId);
	  			DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

		        // Parse the string to LocalDateTime
		        LocalDateTime dateTime = LocalDateTime.parse(examdto.getDateTime(), formatter);
		        LocalDateTime lastUpdatedateTime = LocalDateTime.parse(examdto.getLastupdate(), formatter);
				//Exam oldexam = examRepository.findById(examId).orElse(null);
		        Exam oldexam = examRepository.findByExamId(examId);
				oldexam.setDateTime(dateTime);
				oldexam.setDuration(examdto.getDuration());
				oldexam.setExam_name(examdto.getExamName());
				oldexam.setLastUpdate(lastUpdatedateTime);;
				Exam updatedExam = examRepository.save(oldexam);
				System.out.println("*************COME AS OLD EXAM****************");
				System.out.println(updatedExam);
		  		for(QuesDto questionDto2 : examdto.getQuestion()) {
			  		if(questionDto2.getQuestionId() == -1) {//new question nam
				  			Question newQues2 = new Question();
				  			newQues2.setQuestion_content(questionDto2.getQuestion());
				  			newQues2.setExam(oldexam);
							
							Question savedQues = questionRepository.save(newQues2);
							System.out.println("*************COME AS OLD EXAM , NEW QUESTION****************");
							System.out.println(savedQues);
							
							Answer newAns1 = new Answer();
							newAns1.setQuestion(savedQues);
							newAns1.setAnswer(questionDto2.getAnswer1().getAnswer());
							newAns1.setCorrectAnswer(questionDto2.getAnswer1().isCorrectAnswer());
							Answer savedAns1 = answerRepository.save(newAns1);
							
							Answer newAns2 = new Answer();
							newAns2.setQuestion(savedQues);
							newAns2.setAnswer(questionDto2.getAnswer2().getAnswer());
							newAns2.setCorrectAnswer(questionDto2.getAnswer2().isCorrectAnswer());
							Answer savedAns2 = answerRepository.save(newAns2);
							
							Answer newAns3 = new Answer();
							newAns3.setQuestion(savedQues);
							newAns3.setAnswer(questionDto2.getAnswer3().getAnswer());
							newAns3.setCorrectAnswer(questionDto2.getAnswer3().isCorrectAnswer());
							Answer savedAns3 = answerRepository.save(newAns3);
							
							Answer newAns4 = new Answer();
							newAns4.setQuestion(savedQues);
							newAns4.setAnswer(questionDto2.getAnswer4().getAnswer());
							newAns4.setCorrectAnswer(questionDto2.getAnswer4().isCorrectAnswer());
							Answer savedAns4 = answerRepository.save(newAns4);
						
					response = updatedExam;
		  			}else {
						//for (QuesDto questionDto4 : examdto.getQuestion()){
				  			Long quesId = (long) questionDto2.getQuestionId();
				  			//Question oldQues = questionRepository.findById(quesId).orElse(null);
				  			Question oldQues = questionRepository.findByQuestionId(quesId).orElse(null);
				  			System.out.println("Existing Question id = "+oldQues);
				  			oldQues.setQuestion_content(questionDto2.getQuestion());
				  			Question updatedQues = questionRepository.save(oldQues);
				  			System.out.println("*************COME AS OLD EXAM , OLD QUESTION****************");
							System.out.println(updatedQues);
				  			
				  			if(questionDto2.getAnswer1().getAnswerId() > -1) {
				  				Long ansId = (long) questionDto2.getAnswer1().getAnswerId();
				  				//Answer oldAns = answerRepository.findById(ansId).orElse(null);
				  				Answer oldAns = answerRepository.findByAnswerId(ansId).orElse(null);
				  				oldAns.setAnswer(questionDto2.getAnswer1().getAnswer());
				  				oldAns.setCorrectAnswer(questionDto2.getAnswer1().isCorrectAnswer());
				  				Answer updateAns = answerRepository.save(oldAns);
				  			}
				  			
				  			if(questionDto2.getAnswer2().getAnswerId() > -1) {
				  				Long ansId = (long) questionDto2.getAnswer2().getAnswerId();
				  				//Answer oldAns = answerRepository.findById(ansId).orElse(null);
				  				Answer oldAns = answerRepository.findByAnswerId(ansId).orElse(null);
				  				oldAns.setAnswer(questionDto2.getAnswer2().getAnswer());
				  				oldAns.setCorrectAnswer(questionDto2.getAnswer2().isCorrectAnswer());
				  				Answer updateAns = answerRepository.save(oldAns);
				  			}
				  			
				  			if(questionDto2.getAnswer3().getAnswerId() > -1) {
				  				Long ansId = (long) questionDto2.getAnswer3().getAnswerId();
				  				//Answer oldAns = answerRepository.findById(ansId).orElse(null);
				  				Answer oldAns = answerRepository.findByAnswerId(ansId).orElse(null);
				  				oldAns.setAnswer(questionDto2.getAnswer3().getAnswer());
				  				oldAns.setCorrectAnswer(questionDto2.getAnswer3().isCorrectAnswer());
				  				Answer updateAns = answerRepository.save(oldAns);
				  			}
				  			
				  			if(questionDto2.getAnswer4().getAnswerId() > -1) {
				  				Long ansId = (long) questionDto2.getAnswer4().getAnswerId();
				  				//Answer oldAns = answerRepository.findById(ansId).orElse(null);
				  				Answer oldAns = answerRepository.findByAnswerId(ansId).orElse(null);
				  				oldAns.setAnswer(questionDto2.getAnswer4().getAnswer());
				  				oldAns.setCorrectAnswer(questionDto2.getAnswer4().isCorrectAnswer());
				  				Answer updateAns = answerRepository.save(oldAns);
				  			}
						//}
			  			response = updatedExam;
			  		}
					
		  		} 
		  	}
		  	System.out.println("*************************");
	        System.out.println(response);
	        return response;
	    }
	  
	  
	  //load  data
	  /*public Exam getExamDetailsById(Long examId) {
		  
		  //Exam searchExam = examRepository.getSavedExam(examId);
		
		  
		  /*if(searchExam != null) {
			  ExamDtoRes examdtoRes = new ExamDtoRes();
			  examdtoRes.setExamId(searchExam.getExam_id());
			  examdtoRes.setExamName(searchExam.getExam_name());
			  examdtoRes.setDuration(searchExam.getDuration());
				
			  DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			  String customFormattedDate = searchExam.getDateTime().format(customFormatter);
			  examdtoRes.setDateTime(customFormattedDate);
			  
//			  List<QuesDtoRes> questionList = mapQuestions(searchExam.getQuestions());
//			  examdtoRes.setQuestion(questionList);

	            return examdtoRes;
			 
		  }else {
			  return null;
		  }*/
		  //return searchExam;
		//  return null;
	 // }*/
	  
	  /*private List<QuesDtoRes> mapQuestions(List<QuesDto> questions){
		  return questions.stream().map(this::mapQuestion).collect(Collectors.toList());
	  }
	  

	  private QuesDtoRes mapQuestion(QuesDto quesDto) {
		   QuesDtoRes quesDtoRes = new QuesDtoRes();
		   quesDtoRes.setQuestionId(quesDto.getQuestionId());
		   quesDtoRes.setQuestion(quesDto.getQuestion());

		   AnswerDtoRes answer1 = mapAnswer(quesDto.getAnswer1());
		   AnswerDtoRes answer2 = mapAnswer(quesDto.getAnswer2());
		   AnswerDtoRes answer3 = mapAnswer(quesDto.getAnswer3());
		   AnswerDtoRes answer4 = mapAnswer(quesDto.getAnswer4());
	
		   quesDtoRes.setAnswer1(answer1);
		   quesDtoRes.setAnswer2(answer2);
		   quesDtoRes.setAnswer3(answer3);
		   quesDtoRes.setAnswer4(answer4);
	
		   return quesDtoRes;
	  }
	
	  private AnswerDtoRes mapAnswer(AnswerDto answerDto) {
		  AnswerDtoRes answerDtoRes = new AnswerDtoRes();
		  answerDtoRes.setAnswerId(answerDto.getAnswerId());
		  answerDtoRes.setAnswer(answerDto.getAnswer());
		  answerDtoRes.setCorrectAnswer(answerDto.isCorrectAnswer());
	
		  return answerDtoRes;
	  }*/

	  //send data from backend to frontend
	  public ExamDtoRes getExamDetailsById(Long examId) throws NotFoundException {
	        Optional<Exam> optionalExam = examRepository.findById(examId);

	        if (optionalExam.isPresent()) {
	            
	            Exam exam = optionalExam.get();
	            ExamDtoRes examDto = new ExamDtoRes();
	            examDto.setExamId(exam.getExam_id());
	            examDto.setExamName(exam.getExam_name());
	            examDto.setDuration(exam.getDuration());
	            examDto.setDateTime(exam.getDateTime().toString()); 
	            

	            List<QuesDtoRes> questionDtoList = new ArrayList<>();
	            for (Question question : exam.getQuestions()) {
	                QuesDtoRes quesDto = new QuesDtoRes();
	                quesDto.setQuestionId(question.getQuestion_id());
	                quesDto.setQuestion(question.getQuestion_content());

	                List<AnswerDtoRes> answerDtoList = mapAnswersToDto(question.getAnswers());
	                quesDto.setAnswers(answerDtoList);

	                questionDtoList.add(quesDto);
	            }

	            examDto.setQuestion(questionDtoList);
	            
	            return examDto;
	        } else {
	            
	            throw new NotFoundException();
	        }
	    }

	    private List<AnswerDtoRes> mapAnswersToDto(List<Answer> answers) {
	        List<AnswerDtoRes> answerDtoList = new ArrayList<>();
	        for (Answer answer : answers) {
	            AnswerDtoRes answerDto = new AnswerDtoRes();
	            answerDto.setAnswerId(answer.getAnswer_id());
	            answerDto.setAnswer(answer.getAnswer());
	            answerDto.setCorrectAnswer(answer.getCorrectAnswer());

	            answerDtoList.add(answerDto);
	        }
	        return answerDtoList;
	    }
	    
	    
	public boolean updateExamStatus(Long examId, boolean status) {
		Exam examStat = examRepository.findByExamId(examId);
		System.out.println("EXAM ID" + examStat.getExam_id());
		status = true;
		examStat.setE_status(status);
		examRepository.save(examStat);
		return true;
	}
	
	 public List<Exam> getAllActiveExams() {
	        return examRepository.findByeStatus(true); 
	    }

	 //save exam Attempt status
	 public ExamAttempt saveAttemptStatus(User userId, Exam examId) {
		 ExamAttempt examAttempt = examAttemptRepository.findByUserAndExam(userId, examId);
		 examAttempt.setAttempt_status(true);
		return examAttemptRepository.save(examAttempt);
	 }



	public List<ExamAttemptDto> getAttemptsByExamId(Exam exam) {
		Long examId = exam.getExam_id();
		//return examAttemptRepository.getStatusByExam(examId);
		return Collections.emptyList();
	}
	
	//exam duration
	public Integer getExamDuration(Long examId) {
        return examRepository.findDurationByExamId(examId);
    }



	public void markExamAsEnded(Long examId) {
		Exam exam = examRepository.findByExamId(examId);
		exam.setEndExamStatus(true);
		examRepository.save(exam);
		
	}



	public List<Long> getEndedExams() {
		 List<Exam> endedExams = examRepository.findByisEndExamStatus();
	        List<Long> endedExamIds = new ArrayList<>();

	        for (Exam exam : endedExams) {
	            endedExamIds.add(exam.getExam_id());
	        }

	        return endedExamIds;
	}
	
	//attended status
	public List<ExamAttendedDto> getExamStatuses(User user) {
        List<Exam> exams = examRepository.findAll();
        return exams.stream().map(exam -> {
            boolean attended = examAttemptRepository.existsByUserAndExam(user, exam);
            return new ExamAttendedDto(exam.getExam_id(), attended);
        }).collect(Collectors.toList());
    }
	
	//attempting students
	public List<StudentStatusDto> getAttemptedStudentsForExam(Exam examId) {
		List<ExamAttempt> examAttempts = examAttemptRepository.findByExam(examId);
        List<StudentStatusDto> attemptedStudents = new ArrayList<>();
        for (ExamAttempt attempt : examAttempts) {
        	StudentStatusDto studentDto = new StudentStatusDto();
            studentDto.setFullname(attempt.getUser().getFullname());
            studentDto.setStatus(attempt.getAttempt_status());
            attemptedStudents.add(studentDto);
        }
        System.out.println("*****//////****........");
        System.out.println("Attending students"+attemptedStudents);
        return attemptedStudents;
	}


}

	

