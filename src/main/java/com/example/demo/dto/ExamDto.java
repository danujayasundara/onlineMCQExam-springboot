package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExamDto {
	
	private int examId;
	private String examName;
    private int duration;
    private String dateTime;
    private String lastupdate;
    
    //private String question_content;
    ///private QuesDto question;
    private List<QuesDto> questions;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;
    
	@JsonCreator
    public ExamDto(@JsonProperty("examId") int examId,@JsonProperty("examDateTime") String dateTime, //examTimeData
            @JsonProperty("examName") String examName,
            @JsonProperty("examDuration") int duration,@JsonProperty("lastUpdateTime") String lastupdate,
            @JsonProperty("questions") List<QuesDto> questions) {
    	this.examId = examId;
		 this.dateTime = dateTime;
		 this.examName = examName;
		 this.duration = duration;
		 this.lastupdate = lastupdate;
		 this.questions = questions;	
}

	public ExamDto() {
		// TODO Auto-generated constructor stub
	}

	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	/*public String getQuestion_content() {
		return question_content;
	}

	public void setQuestion_content(String question_content) {
		this.question_content = question_content;
	}*/
	

	public List<QuesDto> getQuestion() {
		return questions;
	}

	public void setQuestion(List<QuesDto> question) {
		this.questions = question;
	}
	

	public String getAnswer1() {
		return answer1;
	}


	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}

	public String getAnswer2() {
		return answer2;
	}

	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}

	public String getAnswer3() {
		return answer3;
	}

	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}

	public String getAnswer4() {
		return answer4;
	}

	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getExamId() {
		return examId;
	}

	public void setExamId(int examId) {
		this.examId = examId;
	}

	public String getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}
	

	/*public QuesDto getQuesDto() {
		return quesDto;
	}

	public void setQuesDto(QuesDto quesDto) {
		this.quesDto = quesDto;
	}*/

}
